/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paginas;

/**
 * @author godalway
 */
import dao.PacienteVacinaDAO;
import entity.PacienteVacinaEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class PacientesVaciandosPage extends JFrame {

    private JTextField nome, sobrenome, emai, enderecoField, planoField;
    private MaskFormatter Numero, Data, BIM, numeroPlanoMask;
    private JFormattedTextField numberoField, Date, BIF, numeroPlanoField;
    private JRadioButton feminino, masculino;
    private JLabel nomeL, sobrenomeL, Genero, email, imge, BI, data, numero, provincia, enderecoLabel, planoLabel, numeroPLabel;
    private JButton DadosPacientes, RegistroVacina, ConsultasNut, PacientesInt, AgendaEx, logou, submit;
    private JPanel leftScreen, rightScreen;
    private ImageIcon imagem, icon, logout;
    private JComboBox pronvice;

    public PacientesVaciandosPage() {
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
        RegistroVacina.setBounds(0, 450, 1280 / 2, 20);
        RegistroVacina.setFont(new Font("Arial", Font.PLAIN, 21));
        RegistroVacina.setBackground(new Color(40, 53, 63, 236));
        RegistroVacina.setForeground(Color.WHITE);
        RegistroVacina.setFocusable(true);
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

        ConsultasNut = new JButton("Marcar Consultas Nutricionais");
        ConsultasNut.setBorder(null);
        ConsultasNut.setBounds(0, 500, 1280 / 2, 20);
        ConsultasNut.setFont(new Font("Arial", Font.PLAIN, 21));
        ConsultasNut.setBackground(new Color(40, 53, 63, 236));
        ConsultasNut.setForeground(Color.WHITE);
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
        AgendaEx.setBounds(0, 550, 1280 / 2, 20);
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
        DadosPacientes.setBounds(0, 600, 1280 / 2, 20);
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

    private void RegistroVacina() {
        rightScreen = new JPanel(null);
        rightScreen.setSize(960, 1080);
        rightScreen.setBounds(640, 0, 960, 1080);
        add(rightScreen);
//        Adicionadnk titulo no programa
        JLabel titulo = new JLabel("Registrar pacientes para a Vacinação contra a COVID-19");
        titulo.setBounds(130, 15, 740, 45);
        titulo.setForeground(new Color(89, 97, 103, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        rightScreen.add(titulo);

//        Nome completo jlanal e jtexfield
        nomeL = new JLabel("Nome");
        nomeL.setBounds(75, 75, 345, 45);
        nomeL.setForeground(new Color(89, 97, 103, 255));
        nomeL.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(nomeL);

        nome = new JTextField();
        nome.setBounds(75, 110, 345, 45);
        nome.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        nome.setFont(new Font("Arial", Font.PLAIN, 18));
        nome.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(nome);

//        sobrenome
        sobrenomeL = new JLabel("sobrenome");
        sobrenomeL.setBounds(495, 75, 345, 45);
        sobrenomeL.setForeground(new Color(89, 97, 103, 255));
        sobrenomeL.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(sobrenomeL);

        sobrenome = new JTextField();
        sobrenome.setBounds(495, 110, 345, 45);
        sobrenome.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        sobrenome.setFont(new Font("Arial", Font.PLAIN, 18));
        sobrenome.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(sobrenome);

        //        Documento de identificacao
        BI = new JLabel("Documento de Identificação (Code)");
        BI.setBounds(75, 165, 345, 45);
        BI.setForeground(new Color(89, 97, 103, 255));
        BI.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(BI);

        try {
            BIM = new MaskFormatter("AAAAAAAAAA");
            BIM.setPlaceholder("10 digitos");
        } catch (ParseException exception) {
        }
        BIF = new JFormattedTextField(BIM);
        BIF.setBounds(75, 200, 345, 45);
        BIF.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        BIF.setFont(new Font("Arial", Font.PLAIN, 18));
        BIF.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(BIF);
        BIF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if (BIF.getText().equals("10 digitos")) {
                    BIF.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (BIF.getText().equals("")) {
                    BIF.setText("10 digitos");
                }
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
        Genero.setBounds(497, 265, 345, 45);
        Genero.setForeground(new Color(89, 97, 103, 255));
        Genero.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(Genero);

        feminino = new JRadioButton("Feminino");
        feminino.setBounds(499, 300, 120, 45);
        feminino.setFont(new Font("Arial", Font.PLAIN, 18));
        feminino.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(feminino);
        feminino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (feminino.isSelected() == true) {
                    masculino.setSelected(false);
                }
            }
        });

        masculino = new JRadioButton("Masculino");
        masculino.setBounds(634, 300, 120, 45);
        masculino.setFont(new Font("Arial", Font.PLAIN, 18));
        masculino.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(masculino);
        masculino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (masculino.isSelected() == true) {
                    feminino.setSelected(false);
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
        numero.setBounds(495, 364, 345, 45);
        numero.setForeground(new Color(89, 97, 103, 255));
        numero.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(numero);

//      Usando o MaskFormatter para definir o formato e os carateres aceites no campo de numero
        try {
            Numero = new MaskFormatter("### ## ### ####");
            Numero.setPlaceholder("258");
        } catch (ParseException exception) {
        }
        numberoField = new JFormattedTextField(Numero);
        numberoField.setBounds(495, 400, 345, 45);
        numberoField.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        numberoField.setFont(new Font("Arial", Font.PLAIN, 18));
        numberoField.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(numberoField);

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
        enderecoLabel = new JLabel("Endereço");
        enderecoLabel.setBounds(495, 464, 120, 40);
        enderecoLabel.setForeground(new Color(89, 97, 103, 255));
        enderecoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(enderecoLabel);

        enderecoField = new JTextField();
        enderecoField.setBounds(495, 502, 345, 45);
        enderecoField.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        enderecoField.setFont(new Font("Arial", Font.PLAIN, 18));
        enderecoField.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(enderecoField);

//      planoField de Saúde
        planoLabel = new JLabel("Plano de Saúde");
        planoLabel.setBounds(80, 555, 340, 45);
        planoLabel.setForeground(new Color(89, 97, 103, 255));
        planoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(planoLabel);

        planoField = new JTextField();
        planoField.setBounds(80, 589, 340, 45);
        planoField.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        planoField.setFont(new Font("Arial", Font.PLAIN, 18));
        planoField.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(planoField);

        //  Numero do planoField de Saúde
        numeroPLabel = new JLabel("Número de Identificação do Plano de Saúde");
        numeroPLabel.setBounds(495, 555, 340, 45);
        numeroPLabel.setForeground(new Color(89, 97, 103, 255));
        numeroPLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(numeroPLabel);

//      Numero plano field
        try {
            numeroPlanoMask = new MaskFormatter("######");
        } catch (ParseException exception) {
        }
        numeroPlanoField = new JFormattedTextField(numeroPlanoMask);

        numeroPlanoField.setBounds(495, 589, 340, 45);
        numeroPlanoField.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        numeroPlanoField.setFont(new Font("Arial", Font.PLAIN, 18));
        numeroPlanoField.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(numeroPlanoField);

//        Botao para submeter
        submit = new JButton("Submeter");
        submit.setBounds(495, 689, 340, 45);
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
            PacienteVacinaEntity objPacienteVacinaDTO = new PacienteVacinaEntity();

            objPacienteVacinaDTO.setNome(nome.getText());
            objPacienteVacinaDTO.setSobrenome(sobrenome.getText());
            objPacienteVacinaDTO.setEmail(emai.getText());
            objPacienteVacinaDTO.setDataNascimento(Date.getText());
            objPacienteVacinaDTO.setEndereco(enderecoLabel.getText());
            objPacienteVacinaDTO.setTelefone(String.valueOf(numberoField.getText()));
            objPacienteVacinaDTO.setPlanoSaude(planoField.getText());
            objPacienteVacinaDTO.setNumeroPlano(numeroPlanoField.getText().trim());
            objPacienteVacinaDTO.setIdentificao(BIF.getText());

            switch (pronvice.getSelectedIndex()) {
                case 0:
                    objPacienteVacinaDTO.setProvincia("Cabo Delgado");
                    break;
                case 1:
                    objPacienteVacinaDTO.setProvincia("Niassa");
                    break;
                case 2:
                    objPacienteVacinaDTO.setProvincia("Nampula");
                    break;
                case 3:
                    objPacienteVacinaDTO.setProvincia("Zambézia");
                    break;
                case 4:
                    objPacienteVacinaDTO.setProvincia("Tete");
                    break;
                case 5:
                    objPacienteVacinaDTO.setProvincia("Manica");
                    break;
                case 6:
                    objPacienteVacinaDTO.setProvincia("Sofala");
                    break;
                case 7:
                    objPacienteVacinaDTO.setProvincia("Inhambane");
                    break;
                case 8:
                    objPacienteVacinaDTO.setProvincia("Gaza");
                    break;
                case 9:
                    objPacienteVacinaDTO.setProvincia("Maputo");
                    break;
                case 10:
                    objPacienteVacinaDTO.setProvincia("Maputo-cidade");
                    break;
                default:
                    throw new AssertionError();
            }

            if (feminino.isSelected()) {
                objPacienteVacinaDTO.setGenero("Feminino");
            } else {
                objPacienteVacinaDTO.setGenero("Masculino");
            }

            PacienteVacinaDAO objPacienteVacinaDAO = new PacienteVacinaDAO();

            if (objPacienteVacinaDAO.registrar(objPacienteVacinaDTO)) {
                JOptionPane.showMessageDialog(null, "Paciente adicionado com sucesso", "Adição de paciente", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro com a base de dados:\n" + e.getMessage(), "Error Base de dados", JOptionPane.ERROR_MESSAGE);
        }
    }
}
