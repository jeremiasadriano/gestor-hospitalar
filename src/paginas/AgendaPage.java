/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paginas;

/**
 * @author godalway
 */
import dao.AgendaDAO;
import dto.AgendaDTO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class AgendaPage extends JFrame {

    private JTextField NomeCompleto, Sobrenome, emai, enderecoField, Plano, idPlano;
    private MaskFormatter Numero, Data, BIM;
    private JFormattedTextField Number, Date, agendamentoExame;
    private JRadioButton Feminino, Masculino, simFeedback, naoFeedback;
    private JLabel NomeCompletoL, SobrenomeL, Genero, email, imge, BI, data, numero, provincia, endereco, plano, NumeroP, feedbackAtendimento;
    private JButton DadosPacientes, RegistroVacina, ConsultasNut, PacientesInt, AgendaEx, logou, submit;
    private JPanel leftScreen, rightScreen;
    private ImageIcon imagem, icon, logout;
    private JComboBox pronvice;
    private JTextArea feedBackTextArea;

    public AgendaPage() {
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

        //I     Adicao de imagem
        icon = new ImageIcon("./imgs/h2(1).png");
        imge = new JLabel(icon);
        imge.setBounds(140, 60, 300, 300);
        leftScreen.add(imge);
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

//        JButton de direção
        RegistroVacina = new JButton("Registrar pacientes para a Vacinação contra a COVID-19");
        RegistroVacina.setBorder(null);
        RegistroVacina.setBounds(0, 550, 1280 / 2, 20);
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
        ConsultasNut.setBounds(0, 600, 1280 / 2, 20);
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
        AgendaEx.setBounds(0, 450, 1280 / 2, 20);
        AgendaEx.setFont(new Font("Arial", Font.PLAIN, 21));
        AgendaEx.setBackground(new Color(40, 53, 63, 236));
        AgendaEx.setForeground(Color.WHITE);
        AgendaEx.setFocusable(true);
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

        DadosPacientes = new JButton("Dados dos Pacientes");
        DadosPacientes.setBorder(null);
        DadosPacientes.setBounds(0, 500, 1280 / 2, 20);
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
        rightScreen.setSize(960, 1080);
        rightScreen.setBounds(640, 0, 960, 1080);
        add(rightScreen);
//        Adicionadnk titulo no programa
        JLabel titulo = new JLabel("Agendamento de Consulta Médica");
        titulo.setBounds(130, 15, 740, 45);
        titulo.setForeground(new Color(89, 97, 103, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        rightScreen.add(titulo);

//        Nome completo jlanal e jtexfield
        NomeCompletoL = new JLabel("Nome");
        NomeCompletoL.setBounds(75, 75, 345, 45);
        NomeCompletoL.setForeground(new Color(89, 97, 103, 255));
        NomeCompletoL.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(NomeCompletoL);

        NomeCompleto = new JTextField();
        NomeCompleto.setBounds(75, 110, 345, 45);
        NomeCompleto.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        NomeCompleto.setFont(new Font("Arial", Font.PLAIN, 18));
        NomeCompleto.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(NomeCompleto);

//        Sobrenome
        SobrenomeL = new JLabel("Sobrenome");
        SobrenomeL.setBounds(495, 75, 345, 45);
        SobrenomeL.setForeground(new Color(89, 97, 103, 255));
        SobrenomeL.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(SobrenomeL);

        Sobrenome = new JTextField();
        Sobrenome.setBounds(495, 110, 345, 45);
        Sobrenome.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        Sobrenome.setFont(new Font("Arial", Font.PLAIN, 18));
        Sobrenome.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(Sobrenome);

        //        Documento de identificacao
        BI = new JLabel("Agendamento de exame");
        BI.setBounds(75, 165, 345, 45);
        BI.setForeground(new Color(89, 97, 103, 255));
        BI.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(BI);

        try {
            BIM = new MaskFormatter("##-##-####");
            BIM.setPlaceholder("DD-MM-YYYY");
        } catch (ParseException exception) {
        }
        agendamentoExame = new JFormattedTextField(BIM);
        agendamentoExame.setBounds(75, 200, 345, 45);
        agendamentoExame.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        agendamentoExame.setFont(new Font("Arial", Font.PLAIN, 18));
        agendamentoExame.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(agendamentoExame);
        agendamentoExame.addFocusListener(new FocusListener() { //Usando o Focus para limpar o DD-MM-YYYY
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (agendamentoExame.getText().equals("DD-MM-YYYY")) {
                    agendamentoExame.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
            }
        });

//Data de nascimento
        data = new JLabel("Data de Nascimento");
        data.setBounds(75, 265, 345, 45);
        data.setForeground(new Color(89, 97, 103, 255));
        data.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(data);

//      Usando o MaskFormatter para definir o formato e os carateres aceites no campo de Data
        try {
            Data = new MaskFormatter("##-##-####");
            Data.setPlaceholder("DD-MM-YYYY");
        } catch (ParseException exception) {
        }
        Date = new JFormattedTextField(Data);
        Date.setBounds(75, 300, 345, 45);
        Date.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        Date.setFont(new Font("Arial", Font.PLAIN, 18));
        Date.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(Date);
        Date.addFocusListener(new FocusListener() { //Usando o Focus para limpar o DD-MM-YYYY
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (Date.getText().equals("DD-MM-YYYY")) {
                    Date.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
            }
        });

//        Definindo o genero do paciente
        Genero = new JLabel("Gênero");
        Genero.setBounds(497, 165, 345, 45);
        Genero.setForeground(new Color(89, 97, 103, 255));
        Genero.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(Genero);

        Feminino = new JRadioButton("Feminino");
        Feminino.setBounds(499, 200, 120, 45);
        Feminino.setFont(new Font("Arial", Font.PLAIN, 18));
        Feminino.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(Feminino);
        Feminino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Feminino.isSelected() == true) {
                    Masculino.setSelected(false);
                }
            }
        });

        Masculino = new JRadioButton("Masculino");
        Masculino.setBounds(634, 200, 120, 45);
        Masculino.setFont(new Font("Arial", Font.PLAIN, 18));
        Masculino.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(Masculino);
        Masculino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Masculino.isSelected() == true) {
                    Feminino.setSelected(false);
                }
            }
        });

//        Email
        email = new JLabel("E-mail");
        email.setBounds(80, 364, 345, 45);
        email.setForeground(new Color(89, 97, 103, 255));
        email.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(email);

        emai = new JTextField(" exemplo@exemplo.com");
        emai.setBounds(75, 400, 345, 45);
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

//        Jlabel do numero
        numero = new JLabel("Telefone");
        numero.setBounds(495, 265, 345, 45);
        numero.setForeground(new Color(89, 97, 103, 255));
        numero.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(numero);

//      Usando o MaskFormatter para definir o formato e os carateres aceites no campo de numero
        try {
            Numero = new MaskFormatter("### ## ### ####");
            Numero.setPlaceholder("258");
        } catch (ParseException exception) {
        }
        Number = new JFormattedTextField(Numero);
        Number.setBounds(495, 300, 345, 45);
        Number.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        Number.setFont(new Font("Arial", Font.PLAIN, 18));
        Number.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(Number);

//        Provincia
        provincia = new JLabel("Provincia");
        provincia.setBounds(80, 464, 345, 45);
        provincia.setForeground(new Color(89, 97, 103, 255));
        provincia.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(provincia);

        String stats[] = {"Cabo Delgado", "Niassa", "Nampula", "Zambézia", "Tete", "Manica", "Sofala", "Inhambane", "Gaza", "Maputo", "Maputo-cidade"};
        pronvice = new JComboBox<>(stats);
        pronvice.setMaximumRowCount(6);
        pronvice.setBounds(80, 502, 340, 45);
        pronvice.setForeground(new Color(89, 97, 103, 255));
        pronvice.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(pronvice);

//        enderecoField
        endereco = new JLabel("Endereço");
        endereco.setBounds(495, 364, 120, 40);
        endereco.setForeground(new Color(89, 97, 103, 255));
        endereco.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(endereco);

        enderecoField = new JTextField();
        enderecoField.setBounds(495, 400, 345, 45);
        enderecoField.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        enderecoField.setFont(new Font("Arial", Font.PLAIN, 18));
        enderecoField.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(enderecoField);

//      Plano de Saúde
        plano = new JLabel("Plano de Saúde");
        plano.setBounds(495, 464, 340, 45);
        plano.setForeground(new Color(89, 97, 103, 255));
        plano.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(plano);

        Plano = new JTextField();
        Plano.setBounds(495, 502, 340, 45);
        Plano.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        Plano.setFont(new Font("Arial", Font.PLAIN, 18));
        Plano.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(Plano);

        //  Numero do Plano de Saúde
        NumeroP = new JLabel("Número de Identificação do Plano");
        NumeroP.setBounds(495, 555, 340, 45);
        NumeroP.setForeground(new Color(89, 97, 103, 255));
        NumeroP.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(NumeroP);

        idPlano = new JTextField();
        idPlano.setBounds(495, 589, 340, 45);
        idPlano.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        idPlano.setFont(new Font("Arial", Font.PLAIN, 18));
        idPlano.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(idPlano);

        //Você já foi atendido anteriormente nas nossas instalações?
        feedbackAtendimento = new JLabel("Você já foi atendido anteriormente ?");
        feedbackAtendimento.setBounds(80, 555, 500, 45);
        feedbackAtendimento.setForeground(new Color(89, 97, 103, 255));
        feedbackAtendimento.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(feedbackAtendimento);

//        radios Button
        simFeedback = new JRadioButton("Sim");
        simFeedback.setBounds(80, 600, 100, 45);
        simFeedback.setFont(new Font("Arial", Font.PLAIN, 18));
        simFeedback.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(simFeedback);
        simFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (simFeedback.isSelected()) {
                    naoFeedback.setSelected(false);
                }
            }
        });

        naoFeedback = new JRadioButton("Não");
        naoFeedback.setBounds(180, 600, 100, 45);
        naoFeedback.setFont(new Font("Arial", Font.PLAIN, 18));
        naoFeedback.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(naoFeedback);
        naoFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (naoFeedback.isSelected()) {
                    simFeedback.setSelected(false);
                }
            }
        });

        JLabel caso = new JLabel("Caso sim, diga em que condição e quando?");
        caso.setBounds(80, 740, 350, 150);
        caso.setFont(new Font("Arial", Font.PLAIN, 16));
        caso.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(caso);

//        Deixe o seu comparecer
        feedBackTextArea = new JTextArea(20, 10);
        feedBackTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
        feedBackTextArea.setForeground(new Color(89, 97, 103, 255));
        feedBackTextArea.setLineWrap(true);
        feedBackTextArea.setWrapStyleWord(true);

        JScrollPane rolagem = new JScrollPane(feedBackTextArea);
        rolagem.setBounds(80, 650, 350, 150);
        rolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        rolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        rightScreen.add(rolagem);

        //        Botao para submeter
        submit = new JButton("Submeter");
        submit.setBounds(495, 689, 340, 45);
        submit.setBorder(null);
        submit.setFont(new Font("Arial", Font.PLAIN, 18));
        submit.setBackground(new Color(40, 53, 63, 255));
        submit.setForeground(Color.WHITE);
        rightScreen.add(submit);
        submit.addActionListener(e -> registrar());
    }

    private void registrar() {
        AgendaDTO objAgendaDTO = new AgendaDTO();

        objAgendaDTO.setNome(NomeCompleto.getText());
        objAgendaDTO.setSobrenome(Sobrenome.getText());
        objAgendaDTO.setTelefone(Number.getText());
        objAgendaDTO.setData_nascimento(Date.getText());
        objAgendaDTO.setEmail(emai.getText());
        objAgendaDTO.setEndereco(enderecoField.getText());
        objAgendaDTO.setPlanoSaude(Plano.getText());
        objAgendaDTO.setDataConsulta(agendamentoExame.getText());
        objAgendaDTO.setIdPlano(idPlano.getText());
        objAgendaDTO.setFeedBackAtendimento(feedBackTextArea.getText());

        switch (pronvice.getSelectedIndex()) {
            case 0:
                objAgendaDTO.setProvincia("Cabo Delgado");
                break;
            case 1:
                objAgendaDTO.setProvincia("Niassa");
                break;
            case 2:
                objAgendaDTO.setProvincia("Nampula");
                break;
            case 3:
                objAgendaDTO.setProvincia("Zambézia");
                break;
            case 4:
                objAgendaDTO.setProvincia("Tete");
                break;
            case 5:
                objAgendaDTO.setProvincia("Manica");
                break;
            case 6:
                objAgendaDTO.setProvincia("Sofala");
                break;
            case 7:
                objAgendaDTO.setProvincia("Inhambane");
                break;
            case 8:
                objAgendaDTO.setProvincia("Gaza");
                break;
            case 9:
                objAgendaDTO.setProvincia("Maputo");
                break;
            case 10:
                objAgendaDTO.setProvincia("Maputo-cidade");
                break;
            default:
                throw new AssertionError();
        }
        if (simFeedback.isSelected()) {
            objAgendaDTO.setAtendimentoCheckBox("Sim");
        } else {
            objAgendaDTO.setAtendimentoCheckBox("Não");
        }

        if (Feminino.isSelected()) {
            objAgendaDTO.setGenero("Feminino");
        } else {
            objAgendaDTO.setGenero("Masculino");
        }

        try {
            AgendaDAO objAgendaDAO = new AgendaDAO();
            if (objAgendaDAO.registrar(objAgendaDTO)) {
                JOptionPane.showMessageDialog(null, "Agenda adicionada com sucesso", "Adição de paciente", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }
}
