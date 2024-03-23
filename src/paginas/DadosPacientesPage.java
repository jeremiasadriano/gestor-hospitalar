package paginas;

/**
 * @author godalway
 */
import dao.AgendaDAO;
import dao.ConsultasDAO;
import dao.PacienteVacinaDAO;
import entity.AgendaEntity;
import entity.ConsultasEntity;
import entity.PacienteVacinaEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import paginas.paginasAdicionais.EditarAgendaPage;
import paginas.paginasAdicionais.EditarConsultasPage;
import paginas.paginasAdicionais.EditarPacientePage;
import paginas.paginasAdicionais.ModeloTabela;

public class DadosPacientesPage extends JFrame {

    private ImageIcon imagem, icon, logout, icone;
    private JButton DadosPacientes, RegistroVacina, ConsultasNut, AgendaEx, logou, editar1, editar2, editar3, apagar1, apagar2, apagar3, refresh1, consultasBtn, agendaBtn, vacinacaoBtn;
    private JLabel imge, titulo1, titulo2, titulo3;
    private JPanel leftScreen, rightScreen;
    private JTable tabelaPacientes, tabelaConsulta, tabelaAgenda;
    private ModeloTabela tabelaModeloPaciente, tabelaModeloConsulta, tabelaModeloAgenda;
    private JScrollPane scrollPane1, scrollPane2, scrollPane3;
    private JTextField pesquisa1, pesquisa2, pesquisa3;
    private int idSelecionadoPacientess = -1, idSelecionadoConsultas = -1, idSelecionadoAgenda = -1;

    public DadosPacientesPage() {
        super("Gestor Hospitalar");
        this.setSize(1600, 900);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.LeftScreen();
        this.RegistroVacina();
        this.vacinacaoTabela();
        this.alterarTabelas();
        this.vacinacaoBtns();
        this.pesquisaTextFieldVacina();
        this.pesquisaTextFieldConsulta();
        this.pesquisaTextFieldAgenda();

//        Background color
        getContentPane().setBackground(new Color(255, 255, 255, 255));
        getContentPane().setFont(new Font("Arial", Font.PLAIN, 24));
        getContentPane().setForeground(new Color(255, 255, 255, 255));

//        Adicionando Icon no programa
        imagem = new ImageIcon("./imgs/icon.png");
        setIconImage(imagem.getImage());
        setVisible(true);
    }

    private void LeftScreen() {
        leftScreen = new JPanel(null);
        leftScreen.setSize(1280 / 2, 1080);
        leftScreen.setBackground(new Color(40, 53, 63, 255));
        add(leftScreen);

        //        Welcome
        JLabel wel = new JLabel("Bem");
        wel.setForeground(Color.white);
        wel.setFont(new Font("Arial", Font.BOLD, 38));
        wel.setBounds(225, 250, 300, 300);
        wel.setForeground(new Color(0, 231, 163, 255));
        leftScreen.add(wel);

        JLabel come = new JLabel("Vindo");
        come.setForeground(Color.white);
        come.setFont(new Font("Arial", Font.BOLD, 38));
        come.setBounds(315, 250, 300, 300);
        leftScreen.add(come);

//        Linha horizontal
        JSeparator sep = new JSeparator();
        sep.setBackground(new Color(0, 231, 163, 255));
        sep.setBounds(222, 421, 199, 15);
        sep.setOrientation(SwingConstants.HORIZONTAL);
        leftScreen.add(sep);

        //I     Adicao de imagem
        icon = new ImageIcon("./imgs/h2(1).png");
        imge = new JLabel(icon);
        imge.setBounds(140, 60, 300, 300);
        leftScreen.add(imge);

//        JButton de direção
        RegistroVacina = new JButton("Registrar pacientes para a Vacinação contra a COVID-19");
        RegistroVacina.setBorder(null);
        RegistroVacina.setBounds(0, 500, 1280 / 2, 20);
        RegistroVacina.setFont(new Font("Arial", Font.PLAIN, 21));
        RegistroVacina.setBackground(new Color(40, 53, 63, 236));
        RegistroVacina.setForeground(Color.WHITE);
        leftScreen.add(RegistroVacina);
        RegistroVacina.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                RegistroVacina.setBackground(Color.WHITE);
                RegistroVacina.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                RegistroVacina.setBackground(new Color(40, 53, 63, 236));
                RegistroVacina.setForeground(Color.WHITE);
            }
        });
        RegistroVacina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PacientesVaciandosPage();
                dispose();
            }
        });

        ConsultasNut = new JButton("Marcar Consultas Nutricionais");
        ConsultasNut.setBorder(null);
        ConsultasNut.setBounds(0, 550, 1280 / 2, 20);
        ConsultasNut.setFont(new Font("Arial", Font.PLAIN, 21));
        ConsultasNut.setBackground(new Color(40, 53, 63, 236));
        ConsultasNut.setForeground(Color.WHITE);
        ConsultasNut.setFocusable(true);
        leftScreen.add(ConsultasNut);
        ConsultasNut.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                ConsultasNut.setBackground(Color.WHITE);
                ConsultasNut.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                ConsultasNut.setBackground(new Color(40, 53, 63, 236));
                ConsultasNut.setForeground(Color.WHITE);
            }
        });
        ConsultasNut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ConsultasPage();
                dispose();
            }
        });

        AgendaEx = new JButton("Agendamento de exame");
        AgendaEx.setBorder(null);
        AgendaEx.setBounds(0, 600, 1280 / 2, 20);
        AgendaEx.setFont(new Font("Arial", Font.PLAIN, 21));
        AgendaEx.setBackground(new Color(40, 53, 63, 236));
        AgendaEx.setForeground(Color.WHITE);
        leftScreen.add(AgendaEx);
        AgendaEx.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                AgendaEx.setBackground(Color.WHITE);
                AgendaEx.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                AgendaEx.setBackground(new Color(40, 53, 63, 236));
                AgendaEx.setForeground(Color.WHITE);
            }
        });
        AgendaEx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AgendaPage();
                dispose();
            }
        });

        DadosPacientes = new JButton("Dados dos Pacientes");
        DadosPacientes.setBorder(null);
        DadosPacientes.setBounds(0, 450, 1280 / 2, 20);
        DadosPacientes.setFont(new Font("Arial", Font.PLAIN, 21));
        DadosPacientes.setBackground(new Color(40, 53, 63, 236));
        DadosPacientes.setForeground(Color.WHITE);
        DadosPacientes.setFocusable(true);
        leftScreen.add(DadosPacientes);
        DadosPacientes.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                DadosPacientes.setBackground(Color.WHITE);
                DadosPacientes.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                DadosPacientes.setBackground(new Color(40, 53, 63, 236));
                DadosPacientes.setForeground(Color.WHITE);
            }
        });

        logout = new ImageIcon("./imgs/logout.png");
        logou = new JButton(logout);
        logou.setBounds(545, 780, 64, 64);
        logou.setBackground(new Color(40, 53, 63, 236));
        logou.setBorder(null);
        leftScreen.add(logou);
        logou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new LoginPage();
                dispose();
            }
        });
    }

    private void RegistroVacina() {
        rightScreen = new JPanel(null);
        rightScreen.setSize(960, 1080);
        rightScreen.setBounds(640, 0, 960, 1080);
        add(rightScreen);
    }

    public void vacinacaoTabela() {
        titulo1 = new JLabel("Vacinação");
        titulo1.setBounds(20, 15, 740, 45);
        titulo1.setForeground(new Color(89, 97, 103, 255));
        titulo1.setFont(new Font("Arial", Font.BOLD, 25));
        rightScreen.add(titulo1);

        tabelaModeloPaciente = new ModeloTabela();
        Object[] colunas = {"Id", "Nome", "Sobrenome", "Documento de identificação", "Data de Nascimento", "Gênero", "Telefone", "Email", "Província", "Endereço", "Plano de Saúde", "Número do plano"};
        tabelaModeloPaciente.setColumnIdentifiers(colunas);

        try {
            List<PacienteVacinaEntity> objPacienteVacinaDTOs = (List<PacienteVacinaEntity>) new PacienteVacinaDAO().verTodos();

            for (PacienteVacinaEntity pacientes : objPacienteVacinaDTOs) {
                Object[] linhas = {
                    pacientes.getId(),
                    pacientes.getNome(),
                    pacientes.getSobrenome(),
                    pacientes.getIdentificao(),
                    pacientes.getDataNascimento(),
                    pacientes.getGenero(),
                    pacientes.getTelefone(),
                    pacientes.getEmail(),
                    pacientes.getProvincia(),
                    pacientes.getEndereco(),
                    pacientes.getPlanoSaude(),
                    pacientes.getNumeroPlano()};
                tabelaModeloPaciente.addRow(linhas);
            }
            tabelaModeloPaciente.fireTableDataChanged();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        tabelaPacientes = new JTable(tabelaModeloPaciente);
        tabelaPacientes.setForeground(Color.BLACK);
        tabelaPacientes.getTableHeader().setReorderingAllowed(false);
        tabelaPacientes.setFont(new Font("Arial", Font.PLAIN, 16));

        scrollPane1 = new JScrollPane(tabelaPacientes);
        scrollPane1.setBounds(20, 55, 930, 550);
        rightScreen.add(scrollPane1);
    }

    private void vacinacaoBtns() {
        tabelaPacientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lsew) {
                if (!lsew.getValueIsAdjusting() && tabelaPacientes.getSelectedRow() != -1) {
                    idSelecionadoPacientess = (int) tabelaPacientes.getValueAt(tabelaPacientes.getSelectedRow(), 0);
                }
            }
        });

        editar1 = new JButton("Editar");
        editar1.setBounds(20, 639, 340, 45);
        editar1.setFont(new Font("Arial", Font.PLAIN, 18));
        editar1.setBackground(new Color(40, 53, 63, 255));
        editar1.setForeground(Color.WHITE);
        editar1.setBorder(null);
        rightScreen.add(editar1);
        editar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (idSelecionadoPacientess != -1) {
                    new EditarPacientePage().preencherCampos(idSelecionadoPacientess);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum Id selecionado");
                }
            }
        });

//        Icon do user desconhecido
        icone = new ImageIcon("./imgs/atualizar.png");
        refresh1 = new JButton(icone);
        refresh1.setBounds(415, 629, 60, 60);
        refresh1.setBorder(null);
        refresh1.setBackground(new Color(255, 255, 255, 10));
        rightScreen.add(refresh1);
        refresh1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new DadosPacientesPage().setVisible(true);
            }
        });

        //        Botao para submeter
        apagar1 = new JButton("Apagar");
        apagar1.setBounds(575, 639, 340, 45);
        apagar1.setFont(new Font("Arial", Font.PLAIN, 18));
        apagar1.setBackground(Color.RED);
        apagar1.setForeground(Color.WHITE);
        apagar1.setBorder(null);
        rightScreen.add(apagar1);
        apagar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    if (idSelecionadoPacientess != -1) {
                        int result = JOptionPane.showConfirmDialog(null, "Desaja apagar o " + idSelecionadoPacientess + "?", "Apagar paciente", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            new PacienteVacinaDAO().apagarPerfil(idSelecionadoPacientess);
                            dispose();
                            new DadosPacientesPage().setVisible(true);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum Id selecionado");
                    }
                } catch (ClassNotFoundException | SQLException ex) {

                }
            }
        });
    }

    private void pesquisaTextFieldVacina() {
        pesquisa1 = new JTextField();
        pesquisa1.setBounds(650, 21, 300, 25);
        pesquisa1.setFont(new Font("Arial", Font.PLAIN, 18));
        pesquisa1.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(pesquisa1);
        pesquisa1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                pesquisa1.setBorder(BorderFactory.createLineBorder(new Color(0, 231, 163, 255)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
        pesquisa1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                ModeloTabela modeloTabela = (ModeloTabela) tabelaPacientes.getModel();
                TableRowSorter<ModeloTabela> objTableRowSorter = new TableRowSorter<>(modeloTabela);
                tabelaPacientes.setRowSorter(objTableRowSorter);
                objTableRowSorter.setRowFilter(RowFilter.regexFilter(pesquisa1.getText()));

            }
        });

    }

    private void pesquisaTextFieldConsulta() {
        pesquisa2 = new JTextField();
        pesquisa2.setBounds(650, 21, 300, 25);
        pesquisa2.setFont(new Font("Arial", Font.PLAIN, 18));
        pesquisa2.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(pesquisa2);
        pesquisa2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                pesquisa2.setBorder(BorderFactory.createLineBorder(new Color(0, 231, 163, 255)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
        pesquisa2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                ModeloTabela modeloTabela1 = (ModeloTabela) tabelaConsulta.getModel();
                TableRowSorter<ModeloTabela> objTableRowSorter2 = new TableRowSorter<>(modeloTabela1);
                tabelaConsulta.setRowSorter(objTableRowSorter2);
                objTableRowSorter2.setRowFilter(RowFilter.regexFilter(pesquisa2.getText()));
            }
        });

    }

    private void pesquisaTextFieldAgenda() {
        pesquisa3 = new JTextField();
        pesquisa3.setBounds(650, 21, 300, 25);
        pesquisa3.setFont(new Font("Arial", Font.PLAIN, 18));
        pesquisa3.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(pesquisa3);
        pesquisa3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                pesquisa3.setBorder(BorderFactory.createLineBorder(new Color(0, 231, 163, 255)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
        pesquisa3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                ModeloTabela modeloTabela2 = (ModeloTabela) tabelaAgenda.getModel();
                TableRowSorter<ModeloTabela> objTableRowSorter3 = new TableRowSorter<>(modeloTabela2);
                tabelaAgenda.setRowSorter(objTableRowSorter3);
                objTableRowSorter3.setRowFilter(RowFilter.regexFilter(pesquisa3.getText()));
            }
        });

    }

    private void alterarTabelas() {
        vacinacaoBtn = new JButton("1");
        vacinacaoBtn.setBounds(20, 739, 30, 25);
        vacinacaoBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        vacinacaoBtn.setBackground(new Color(40, 53, 63, 255));
        vacinacaoBtn.setForeground(Color.WHITE);
        vacinacaoBtn.setBorder(null);
        rightScreen.add(vacinacaoBtn);
        vacinacaoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vacinacaoTabela();
                vacinacaoBtns();
                try {
                    scrollPane2.setVisible(false);
                    titulo2.setVisible(false);
                    editar2.setVisible(false);
                    apagar2.setVisible(false);
                    tabelaConsulta.setVisible(false);

                    pesquisa2.setVisible(false);
                    pesquisa3.setVisible(false);

                    scrollPane3.setVisible(false);
                    titulo3.setVisible(false);
                    editar3.setVisible(false);
                    apagar3.setVisible(false);
                    tabelaAgenda.setVisible(false);

                    scrollPane1.setVisible(true);
                    titulo1.setVisible(true);
                    editar1.setVisible(true);
                    apagar1.setVisible(true);
                    pesquisa1.setVisible(true);
                } catch (Exception e) {
                }
            }
        });
        consultasBtn = new JButton("2");
        consultasBtn.setBounds(50, 739, 30, 25);
        consultasBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        consultasBtn.setBackground(new Color(40, 53, 63, 255));
        consultasBtn.setForeground(Color.WHITE);
        consultasBtn.setBorder(null);
        rightScreen.add(consultasBtn);
        consultasBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                consultasTabela();
                consultaBtns();
                try {
                    scrollPane1.setVisible(false);
                    titulo1.setVisible(false);
                    editar1.setVisible(false);
                    apagar1.setVisible(false);
                    tabelaPacientes.setVisible(false);

                    pesquisa1.setVisible(false);
                    pesquisa3.setVisible(false);

                    scrollPane3.setVisible(false);
                    titulo3.setVisible(false);
                    editar3.setVisible(false);
                    apagar3.setVisible(false);
                    tabelaAgenda.setVisible(false);

                    scrollPane3.setVisible(false);
                    titulo3.setVisible(false);
                    editar3.setVisible(false);
                    apagar3.setVisible(false);
                    tabelaAgenda.setVisible(false);

                    scrollPane2.setVisible(true);
                    titulo2.setVisible(true);
                    editar2.setVisible(true);
                    apagar2.setVisible(true);
                    pesquisa2.setVisible(true);
                } catch (Exception e) {
                }
            }
        });
        agendaBtn = new JButton("3");
        agendaBtn.setBounds(80, 739, 30, 25);
        agendaBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        agendaBtn.setBackground(new Color(40, 53, 63, 255));
        agendaBtn.setForeground(Color.WHITE);
        agendaBtn.setBorder(null);
        rightScreen.add(agendaBtn);
        agendaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                agendaTabela();
                agendaBtn();

                try {
                    scrollPane1.setVisible(false);
                    titulo1.setVisible(false);
                    editar1.setVisible(false);
                    apagar1.setVisible(false);
                    tabelaPacientes.setVisible(false);

                    pesquisa1.setVisible(false);
                    pesquisa2.setVisible(false);

                    scrollPane2.setVisible(false);
                    titulo2.setVisible(false);
                    editar2.setVisible(false);
                    apagar2.setVisible(false);
                    tabelaConsulta.setVisible(false);

                    scrollPane3.setVisible(true);
                    titulo3.setVisible(true);
                    editar3.setVisible(true);
                    apagar3.setVisible(true);
                    pesquisa3.setVisible(true);
                } catch (Exception e) {
                }
            }
        });

    }

    public void consultasTabela() {
        titulo2 = new JLabel("Consultas");
        titulo2.setBounds(20, 15, 740, 45);
        titulo2.setForeground(new Color(89, 97, 103, 255));
        titulo2.setFont(new Font("Arial", Font.BOLD, 25));
        rightScreen.add(titulo2);
        tabelaModeloConsulta = new ModeloTabela();
        Object[] colunas = {"Id", "Nome", "Sobrenome", "Idade", "Data da consulta", "Peso", "Email", "Altura", "Metas", "Objetivos"};
        tabelaModeloConsulta.setColumnIdentifiers(colunas);

        try {
            List<ConsultasEntity> objConsultasDTOs = (List<ConsultasEntity>) new ConsultasDAO().verTodos();

            for (ConsultasEntity consultas : objConsultasDTOs) {
                Object[] linhas = {
                    consultas.getId(),
                    consultas.getNome(),
                    consultas.getSobrenome(),
                    consultas.getIdade(),
                    consultas.getData(),
                    consultas.getPeso(),
                    consultas.getEmail(),
                    consultas.getAltura(),
                    consultas.getMetas(),
                    consultas.getObjetivos()};
                tabelaModeloConsulta.addRow(linhas);
            }
            tabelaModeloConsulta.fireTableDataChanged();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        tabelaConsulta = new JTable(tabelaModeloConsulta);
        tabelaConsulta.setForeground(Color.BLACK);
        tabelaConsulta.getTableHeader().setReorderingAllowed(false);
        tabelaConsulta.setFont(new Font("Arial", Font.PLAIN, 16));

        scrollPane2 = new JScrollPane(tabelaConsulta);
        scrollPane2.setBounds(20, 55, 930, 550);
        rightScreen.add(scrollPane2);
    }

    private void consultaBtns() {
        tabelaConsulta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse1) {
                if (!lse1.getValueIsAdjusting() && tabelaConsulta.getSelectedRow() != -1) {
                    idSelecionadoConsultas = (int) tabelaConsulta.getValueAt(tabelaConsulta.getSelectedRow(), 0);
                }
            }
        });

        editar2 = new JButton("Editar");
        editar2.setBounds(20, 639, 340, 45);
        editar2.setFont(new Font("Arial", Font.PLAIN, 18));
        editar2.setBackground(new Color(40, 53, 63, 255));
        editar2.setForeground(Color.WHITE);
        editar2.setBorder(null);
        rightScreen.add(editar2);
        editar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (idSelecionadoConsultas != -1) {
                    new EditarConsultasPage().preencherCampos(idSelecionadoConsultas);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum Id selecionado");
                }
            }
        });

        //        Botao para submeter
        apagar2 = new JButton("Apagar");
        apagar2.setBounds(575, 639, 340, 45);
        apagar2.setFont(new Font("Arial", Font.PLAIN, 18));
        apagar2.setBackground(Color.RED);
        apagar2.setForeground(Color.WHITE);
        apagar2.setBorder(null);
        rightScreen.add(apagar2);
        apagar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    if (idSelecionadoConsultas != -1) {
                        int result = JOptionPane.showConfirmDialog(null, "Desaja apagar a agenda?", "Apagar Consulta", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            new ConsultasDAO().apagarPerfil(idSelecionadoConsultas);
                            dispose();
                            new DadosPacientesPage().setVisible(true);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum Id selecionado");
                    }
                } catch (ClassNotFoundException | SQLException ex) {

                }
            }
        });
    }

    private void agendaTabela() {
        titulo3 = new JLabel("Agenda");
        titulo3.setBounds(20, 15, 740, 45);
        titulo3.setForeground(new Color(89, 97, 103, 255));
        titulo3.setFont(new Font("Arial", Font.BOLD, 25));
        rightScreen.add(titulo3);
        tabelaModeloAgenda = new ModeloTabela();

        Object[] colunas = {"Id", "Nome", "Sobrenome", "Genero", "Telefone", "Data da consulta", "Nascimento", "Email", "Endereco", "Provincia", "Atendido antes", "planoSaude", "Id do plano", "FeedBack",};
        tabelaModeloAgenda.setColumnIdentifiers(colunas);

        try {
            List<AgendaEntity> objAgendaDTOs = (List<AgendaEntity>) new AgendaDAO().verTodos();

            for (AgendaEntity agendas : objAgendaDTOs) {
                Object[] linhas = {
                    agendas.getId(),
                    agendas.getNome(),
                    agendas.getSobrenome(),
                    agendas.getGenero(),
                    agendas.getTelefone(),
                    agendas.getDataConsulta(),
                    agendas.getDataNascimento(),
                    agendas.getEmail(),
                    agendas.getEndereco(),
                    agendas.getProvincia(),
                    agendas.getAtendimentoCheckBox(),
                    agendas.getPlanoSaude(),
                    agendas.getIdPlano(),
                    agendas.getFeedBackAtendimento()};
                tabelaModeloAgenda.addRow(linhas);
            }
            tabelaModeloAgenda.fireTableDataChanged();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        tabelaAgenda = new JTable(tabelaModeloAgenda);
        tabelaAgenda.setForeground(Color.BLACK);
        tabelaAgenda.getTableHeader().setReorderingAllowed(false);
        tabelaAgenda.setFont(new Font("Arial", Font.PLAIN, 16));

        scrollPane3 = new JScrollPane(tabelaAgenda);
        scrollPane3.setBounds(20, 55, 930, 550);
        rightScreen.add(scrollPane3);
    }

    private void agendaBtn() {
        tabelaAgenda.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse1) {
                if (!lse1.getValueIsAdjusting() && tabelaAgenda.getSelectedRow() != -1) {
                    idSelecionadoAgenda = (int) tabelaAgenda.getValueAt(tabelaAgenda.getSelectedRow(), 0);
                }
            }
        });

        editar3 = new JButton("Editar");
        editar3.setBounds(20, 639, 340, 45);
        editar3.setFont(new Font("Arial", Font.PLAIN, 18));
        editar3.setBackground(new Color(40, 53, 63, 255));
        editar3.setForeground(Color.WHITE);
        editar3.setBorder(null);
        rightScreen.add(editar3);
        editar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (idSelecionadoAgenda != -1) {
                    new EditarAgendaPage().preencherCampos(idSelecionadoAgenda);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum Id selecionado");
                }
            }
        });

        //        Botao para submeter
        apagar3 = new JButton("Apagar");
        apagar3.setBounds(575, 639, 340, 45);
        apagar3.setFont(new Font("Arial", Font.PLAIN, 18));
        apagar3.setBackground(Color.RED);
        apagar3.setForeground(Color.WHITE);
        apagar3.setBorder(null);
        rightScreen.add(apagar3);
        apagar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    if (idSelecionadoAgenda != -1) {
                        int result = JOptionPane.showConfirmDialog(null, "Desaja apagar o " + idSelecionadoConsultas + "?", "Apagar Agenda", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            new AgendaDAO().apagarPerfil(idSelecionadoAgenda);
                            dispose();
                            new DadosPacientesPage().setVisible(true);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum Id selecionado");
                    }
                } catch (ClassNotFoundException | SQLException ex) {

                }
            }
        });
    }

}
