/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paginas;

/**
 * @author godalway
 */
import dao.ConsultasDAO;
import entity.ConsultasEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class ConsultasPage extends JFrame {

    JScrollPane rolagem, rolagemPainel;
    private ImageIcon imagem, icon, logout;
    private JPanel leftScreen, rightScreen;
    private JTextField NomeCompleto, Sobrenome, emai;
    private MaskFormatter Numero, Data, BIM, alturaMask;
    private JFormattedTextField BIF, idad, altur, pes;
    private JRadioButton GanhoMus, PerdaPeso, GanhoFor, Desempenho, outro;
    private JLabel NomeCompletoL, SobrenomeL, Genero, email, imge, BI, data, numero, provincia, endereco, plano, NumeroP, altura, peso, idade;
    private JButton DadosPacientes, RegistroVacina, ConsultasNut, PacientesInt, AgendaEx, logou, submit;
    private JTextArea texto, other;

    public ConsultasPage() {
        super("Gestor Hospitalar");
        this.setSize(1600, 900);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.LeftScreen();
        this.RegistroVacina();

        //        getRootPane().setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(40,53,63,255)));
        //        Background color
        getContentPane().setBackground(new Color(255, 255, 255, 255));
        getContentPane().setFont(new Font("Arial", Font.PLAIN, 24));
        getContentPane().setForeground(new Color(255, 255, 255, 255));

        //        Adicionando Icon no programa
        imagem = new ImageIcon("./imgs/icon.png");
        setIconImage(imagem.getImage());
        setVisible(true);
    }

    public void LeftScreen() {
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
        RegistroVacina.setBounds(0, 600, 1280 / 2, 20);
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
        ConsultasNut.setBounds(0, 450, 1280 / 2, 20);
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

        AgendaEx = new JButton("Agendamento de exame");
        AgendaEx.setBorder(null);
        AgendaEx.setBounds(0, 500, 1280 / 2, 20);
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
        DadosPacientes.setBounds(0, 550, 1280 / 2, 20);
        DadosPacientes.setFont(new Font("Arial", Font.PLAIN, 21));
        DadosPacientes.setBackground(new Color(40, 53, 63, 236));
        DadosPacientes.setForeground(Color.WHITE);
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
        DadosPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new DadosPacientesPage();
                dispose();
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

    public void RegistroVacina() {
        rightScreen = new JPanel(null);
        rightScreen.setBounds(640, 0, 960, 1080);
        rolagemPainel = new JScrollPane(rightScreen);
        rolagemPainel.setBounds(640, 0, 960, 3200);
        add(rolagemPainel);

        //        Adicionadnk titulo no programa
        JLabel titulo = new JLabel("Consulta Nutricional");
        titulo.setBounds(375, 15, 740, 45);
        titulo.setForeground(new Color(89, 97, 103, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        rightScreen.add(titulo);

        //        Agendamento da consulta   Nutricional
        BI = new JLabel("Data para a consulta");
        BI.setBounds(75, 75, 345, 45);
        BI.setForeground(new Color(89, 97, 103, 255));
        BI.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(BI);

        try {
            BIM = new MaskFormatter("##-##-####");
            BIM.setPlaceholder("DD-MM-YYYY");

            Numero = new MaskFormatter("##");
            Data = new MaskFormatter("##.#");
            alturaMask = new MaskFormatter("#.##");
        } catch (ParseException exception) {
        }

        BIF = new JFormattedTextField(BIM);
        BIF.setBounds(75, 110, 345, 45);
        BIF.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        BIF.setFont(new Font("Arial", Font.PLAIN, 18));
        BIF.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(BIF);
        BIF.addFocusListener(new FocusListener() { //Usando o Focus para limpar o DD-MM-YYYY
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (BIF.getText().equals("DD-MM-YYYY")) {
                    BIF.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
            }
        });

        //        Nome completo jlanal e jtexfield
        NomeCompletoL = new JLabel("Nome");
        NomeCompletoL.setBounds(75, 165, 345, 45);
        NomeCompletoL.setForeground(new Color(89, 97, 103, 255));
        NomeCompletoL.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(NomeCompletoL);

        NomeCompleto = new JTextField();
        NomeCompleto.setBounds(75, 200, 345, 45);
        NomeCompleto.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        NomeCompleto.setFont(new Font("Arial", Font.PLAIN, 18));
        NomeCompleto.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(NomeCompleto);

        //        Sobrenome
        SobrenomeL = new JLabel("Sobrenome");
        SobrenomeL.setBounds(495, 165, 345, 45);
        SobrenomeL.setForeground(new Color(89, 97, 103, 255));
        SobrenomeL.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(SobrenomeL);

        Sobrenome = new JTextField();
        Sobrenome.setBounds(495, 200, 345, 45);
        Sobrenome.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        Sobrenome.setFont(new Font("Arial", Font.PLAIN, 18));
        Sobrenome.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(Sobrenome);

        //        Email
        email = new JLabel("E-mail");
        email.setBounds(80, 265, 345, 45);
        email.setForeground(new Color(89, 97, 103, 255));
        email.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(email);

        emai = new JTextField(" exemplo@exemplo.com");
        emai.setBounds(75, 300, 345, 45);
        emai.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        emai.setFont(new Font("Arial", Font.PLAIN, 18));
        emai.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(emai);
        emai.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (emai.getText().equals(" exemplo@exemplo.com")) {
                    emai.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (emai.getText().equals("")) {
                    emai.setText(" exemplo@exemplo.com");
                }
            }
        });

        //        altura
        altura = new JLabel("Altura (cm)");
        altura.setBounds(80, 364, 345, 45);
        altura.setForeground(new Color(89, 97, 103, 255));
        altura.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(altura);

        altur = new JFormattedTextField(alturaMask);
        altur.setBounds(75, 400, 345, 45);
        altur.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        altur.setFont(new Font("Arial", Font.PLAIN, 18));
        altur.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(altur);

        //        Jlabel do numero
        peso = new JLabel("Peso (kg)");
        peso.setBounds(495, 364, 345, 45);
        peso.setForeground(new Color(89, 97, 103, 255));
        peso.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(peso);

        pes = new JFormattedTextField(Data);
        pes.setBounds(495, 400, 345, 45);
        pes.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        pes.setFont(new Font("Arial", Font.PLAIN, 18));
        pes.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(pes);

        //Idade
        idade = new JLabel("Idade (Anos)");
        idade.setBounds(75, 464, 345, 45);
        idade.setForeground(new Color(89, 97, 103, 255));
        idade.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(idade);

        idad = new JFormattedTextField(Numero);
        idad.setBounds(75, 502, 345, 45);
        idad.setForeground(new Color(89, 97, 103, 255));
        idad.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(idad);

        //        TexArea do Button radion outro
        other = new JTextArea(20, 10);
        other.setLineWrap(true);
        other.setWrapStyleWord(true);
        other.setFont(new Font("Arial", Font.PLAIN, 18));
        other.setForeground(new Color(89, 97, 103, 255));
        JScrollPane otherRolagem = new JScrollPane(other);
        otherRolagem.setBounds(502, 640, 400, 50);
        rightScreen.add(otherRolagem);
        otherRolagem.setVisible(false);

        //        Meus principais objetivos são focados em
        endereco = new JLabel("O meu principal objetivo é :");
        endereco.setBounds(495, 464, 345, 40);
        endereco.setForeground(new Color(89, 97, 103, 255));
        endereco.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(endereco);

        PerdaPeso = new JRadioButton("Perda de Peso");
        PerdaPeso.setBounds(495, 502, 150, 45);
        PerdaPeso.setForeground(new Color(89, 97, 103, 255));
        PerdaPeso.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(PerdaPeso);//
        PerdaPeso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (PerdaPeso.isSelected()) {
                    GanhoMus.setSelected(false);
                    GanhoFor.setSelected(false);
                    Desempenho.setSelected(false);
                    outro.setSelected(false);
                    otherRolagem.setVisible(false);
                }
            }
        });
        GanhoMus = new JRadioButton("Ganho Muscular");
        GanhoMus.setBounds(495, 542, 180, 45);
        GanhoMus.setForeground(new Color(89, 97, 103, 255));
        GanhoMus.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(GanhoMus);
        GanhoMus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (GanhoMus.isSelected()) {
                    PerdaPeso.setSelected(false);
                    GanhoFor.setSelected(false);
                    Desempenho.setSelected(false);
                    outro.setSelected(false);
                    otherRolagem.setVisible(false);
                }
            }
        });

        GanhoFor = new JRadioButton("Ganho de Força");
        GanhoFor.setBounds(680, 502, 180, 45);
        GanhoFor.setForeground(new Color(89, 97, 103, 255));
        GanhoFor.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(GanhoFor);
        GanhoFor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (GanhoFor.isSelected()) {
                    PerdaPeso.setSelected(false);
                    GanhoMus.setSelected(false);
                    Desempenho.setSelected(false);
                    outro.setSelected(false);
                    otherRolagem.setVisible(false);
                }
            }
        });

        Desempenho = new JRadioButton("Desempenho Atlético");
        Desempenho.setBounds(680, 542, 280, 45);
        Desempenho.setForeground(new Color(89, 97, 103, 255));
        Desempenho.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(Desempenho);
        Desempenho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Desempenho.isSelected()) {
                    PerdaPeso.setSelected(false);
                    GanhoMus.setSelected(false);
                    GanhoFor.setSelected(false);
                    outro.setSelected(false);
                    otherRolagem.setVisible(false);
                }
            }
        });

        outro = new JRadioButton("Outro");
        outro.setBounds(495, 582, 180, 45);
        outro.setForeground(new Color(89, 97, 103, 255));
        outro.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(outro);

        outro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (outro.isSelected()) {
                    PerdaPeso.setSelected(false);
                    GanhoMus.setSelected(false);
                    GanhoFor.setSelected(false);
                    Desempenho.setSelected(false);
                    otherRolagem.setVisible(true);
                }
            }
        });

        //      Liste três objetivos
        JLabel caso = new JLabel("Liste três metas em ordem de importância");
        caso.setBounds(80, 505, 380, 150);
        caso.setFont(new Font("Arial", Font.PLAIN, 16));
        caso.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(caso);

        texto = new JTextArea(20, 10);
        texto.setFont(new Font("Arial", Font.PLAIN, 18));
        texto.setForeground(new Color(89, 97, 103, 255));
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);

        rolagem = new JScrollPane(texto);
        rolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        rolagem.setBounds(80, 595, 350, 150);
        rightScreen.add(rolagem);

        //        Botao para submeter
        submit = new JButton("Submeter");
        submit.setBounds(500, 700, 340, 45);
        submit.setBorder(null);
        submit.setFont(new Font("Arial", Font.PLAIN, 18));
        submit.setBackground(new Color(40, 53, 63, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                registrar();
            }
        });
        rightScreen.add(submit);

    }

    private void registrar() {
        try {
            ConsultasEntity consultasEntity = new ConsultasEntity();

            
            
            consultasEntity.setNome(NomeCompleto.getText());
            consultasEntity.setSobrenome(Sobrenome.getText());
            consultasEntity.setEmail(emai.getText());
            consultasEntity.setData(BIF.getText());
            consultasEntity.setPeso(Double.parseDouble(pes.getText()));
            consultasEntity.setAltura(Double.parseDouble(altur.getText()));
            consultasEntity.setIdade(Integer.parseInt(idad.getText()));
            consultasEntity.setMetas(texto.getText());

            if (PerdaPeso.isSelected()) {
                consultasEntity.setObjetivos("Perder Peso");
            } else if (GanhoMus.isSelected()) {
                consultasEntity.setObjetivos("Ganhar Musculos");
            } else if (GanhoFor.isSelected()) {
                consultasEntity.setObjetivos("Ganhar Força");
            } else if (Desempenho.isSelected()) {
                consultasEntity.setObjetivos("Desempenho atlético");
            } else {
                consultasEntity.setObjetivos(other.getText());
            }

            ConsultasDAO objConsultasDAO = new ConsultasDAO();

            if (objConsultasDAO.registrar(consultasEntity)) {
                JOptionPane.showMessageDialog(null, "Consulta adicionado com sucesso", "Adição de Consulta", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro com a base de dados:\n" + e.getMessage(), "Error Base de dados", JOptionPane.ERROR_MESSAGE);
        }
    }
}
