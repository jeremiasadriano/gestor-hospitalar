/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paginas.paginasAdicionais;

import dao.PacienteVacinaDAO;
import entity.PacienteVacinaEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author godal
 */
public class EditarPacientePage extends JFrame {

    private JTextField nome, sobrenome, emai, enderecoField, planoField;
    private MaskFormatter Numero, Data, BIM, numeroPlanoMask;
    private JFormattedTextField numberoField, Date, BIF, numeroPlanoField;
    private JRadioButton feminino, masculino;
    private JLabel nomeL, sobrenomeL, Genero, email, BI, data, numero, provincia, enderecoLabel, planoLabel, numeroPLabel;
    private JButton submit;
    private JPanel rightScreen;
    private JComboBox pronvice;
    private int id;

    public EditarPacientePage() {
        super("Gestor Hospitalar");
        this.setSize(1100, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.editar();
        this.setVisible(true);
    }

    private void editar() {
        rightScreen = new JPanel(null);
        rightScreen.setSize(1280, 900);
        rightScreen.setBounds(145, 0, 1280, 900);
        add(rightScreen);
//        Adicionadnk titulo no programa
        JLabel titulo = new JLabel("Atualizar dados do paciente");
        titulo.setBounds(40, 15, 740, 45);
        titulo.setForeground(new Color(89, 97, 103, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        rightScreen.add(titulo);

//        Nome completo jlanal e jtexfield
        nomeL = new JLabel("Nome");
        nomeL.setBounds(5, 75, 345, 45);
        nomeL.setForeground(new Color(89, 97, 103, 255));
        nomeL.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(nomeL);

        nome = new JTextField();
        nome.setBounds(5, 110, 345, 45);
        nome.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        nome.setFont(new Font("Arial", Font.PLAIN, 18));
        nome.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(nome);

//        sobrenome
        sobrenomeL = new JLabel("sobrenome");
        sobrenomeL.setBounds(425, 75, 345, 45);
        sobrenomeL.setForeground(new Color(89, 97, 103, 255));
        sobrenomeL.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(sobrenomeL);

        sobrenome = new JTextField();
        sobrenome.setBounds(425, 110, 345, 45);
        sobrenome.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        sobrenome.setFont(new Font("Arial", Font.PLAIN, 18));
        sobrenome.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(sobrenome);

        //        Documento de identificacao
        BI = new JLabel("Documento de Identificação (Code)");
        BI.setBounds(5, 165, 345, 45);
        BI.setForeground(new Color(89, 97, 103, 255));
        BI.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(BI);

        try {
            BIM = new MaskFormatter("AAAAAAAAAA");
            BIM.setPlaceholder("10 digitos");
        } catch (ParseException exception) {
        }
        BIF = new JFormattedTextField(BIM);
        BIF.setBounds(5, 200, 345, 45);
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
        data.setBounds(5, 265, 345, 45);
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
        Date.setBounds(5, 300, 345, 45);
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
        Genero.setBounds(427, 265, 345, 45);
        Genero.setForeground(new Color(89, 97, 103, 255));
        Genero.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(Genero);

        feminino = new JRadioButton("Feminino");
        feminino.setBounds(429, 300, 120, 45);
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
        masculino.setBounds(664, 300, 120, 45);
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
        email.setBounds(10, 364, 345, 45);
        email.setForeground(new Color(89, 97, 103, 255));
        email.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(email);

        emai = new JTextField(" exemplo@exemplo.com");
        emai.setBounds(5, 400, 345, 45);
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
        numero.setBounds(425, 364, 345, 45);
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
        numberoField.setBounds(425, 400, 345, 45);
        numberoField.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        numberoField.setFont(new Font("Arial", Font.PLAIN, 18));
        numberoField.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(numberoField);

//        Provincia
        provincia = new JLabel("Provincia");
        provincia.setBounds(10, 464, 345, 45);
        provincia.setForeground(new Color(89, 97, 103, 255));
        provincia.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(provincia);

        String stats[] = {"Cabo Delgado", "Niassa", "Nampula", "Zambézia", "Tete", "Manica", "Sofala", "Inhambane", "Gaza", "Maputo", "Maputo-cidade"};
        pronvice = new JComboBox<>(stats);
        pronvice.setMaximumRowCount(6);
        pronvice.setBounds(10, 502, 340, 45);
        pronvice.setForeground(new Color(89, 97, 103, 255));
        pronvice.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(pronvice);

//        enderecoField
        enderecoLabel = new JLabel("Endereço");
        enderecoLabel.setBounds(425, 464, 120, 40);
        enderecoLabel.setForeground(new Color(89, 97, 103, 255));
        enderecoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(enderecoLabel);

        enderecoField = new JTextField();
        enderecoField.setBounds(425, 502, 345, 45);
        enderecoField.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        enderecoField.setFont(new Font("Arial", Font.PLAIN, 18));
        enderecoField.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(enderecoField);

//      planoField de Saúde
        planoLabel = new JLabel("Plano de Saúde");
        planoLabel.setBounds(10, 555, 340, 45);
        planoLabel.setForeground(new Color(89, 97, 103, 255));
        planoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(planoLabel);

        planoField = new JTextField();
        planoField.setBounds(10, 589, 340, 45);
        planoField.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        planoField.setFont(new Font("Arial", Font.PLAIN, 18));
        planoField.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(planoField);

        //  Numero do planoField de Saúde
        numeroPLabel = new JLabel("Número de Identificação do Plano de Saúde");
        numeroPLabel.setBounds(425, 555, 340, 45);
        numeroPLabel.setForeground(new Color(89, 97, 103, 255));
        numeroPLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(numeroPLabel);

//      Numero plano field
        try {
            numeroPlanoMask = new MaskFormatter("######");
        } catch (ParseException exception) {
        }
        numeroPlanoField = new JFormattedTextField(numeroPlanoMask);

        numeroPlanoField.setBounds(425, 589, 340, 45);
        numeroPlanoField.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        numeroPlanoField.setFont(new Font("Arial", Font.PLAIN, 18));
        numeroPlanoField.setForeground(new Color(89, 97, 103, 255));
        rightScreen.add(numeroPlanoField);

//        Botao para submeter
        submit = new JButton("Atualizar");
        submit.setBounds(425, 689, 340, 45);
        submit.setBorder(null);
        submit.setFont(new Font("Arial", Font.PLAIN, 18));
        submit.setBackground(new Color(40, 53, 63, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                atualizar();
            }
        });
        rightScreen.add(submit);
        setVisible(true);
    }

    public void preencherCampos(int id) {
        this.id = id;
        PacienteVacinaEntity objPacienteVacinaDTO;
        try {
            objPacienteVacinaDTO = new PacienteVacinaDAO().verPerfil(id);
            nome.setText(objPacienteVacinaDTO.getNome());
            sobrenome.setText(objPacienteVacinaDTO.getSobrenome());
            emai.setText(objPacienteVacinaDTO.getEmail());
            Date.setText(objPacienteVacinaDTO.getDataNascimento());
            enderecoField.setText(objPacienteVacinaDTO.getEndereco());
            numberoField.setText(objPacienteVacinaDTO.getTelefone());
            planoField.setText(objPacienteVacinaDTO.getPlanoSaude());
            numeroPlanoField.setText(objPacienteVacinaDTO.getNumeroPlano());
            BIF.setText(objPacienteVacinaDTO.getIdentificao());

            switch (objPacienteVacinaDTO.getProvincia()) {
                case "Cabo Delgado":
                    pronvice.setSelectedIndex(0);
                    break;
                case "Niassa":
                    pronvice.setSelectedIndex(1);
                    break;
                case "Nampula":
                    pronvice.setSelectedIndex(2);
                    break;
                case "Zambézia":
                    pronvice.setSelectedIndex(3);
                    break;
                case "Tete":
                    pronvice.setSelectedIndex(4);
                    break;
                case "Manica":
                    pronvice.setSelectedIndex(5);
                    break;
                case "Sofala":
                    pronvice.setSelectedIndex(6);
                    break;
                case "Inhambane":
                    pronvice.setSelectedIndex(7);
                    break;
                case "Gaza":
                    pronvice.setSelectedIndex(8);
                    break;
                case "Maputo":
                    pronvice.setSelectedIndex(9);
                    break;
                case "Maputo-cidade":
                    pronvice.setSelectedIndex(10);
                    break;
                default:
                    throw new AssertionError();
            }

            if (objPacienteVacinaDTO.getGenero().equalsIgnoreCase("Feminino")) {
                feminino.setSelected(true);
            } else {
                masculino.setSelected(true);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void atualizar() {
        try {
            PacienteVacinaEntity objPacienteVacinaDTO = new PacienteVacinaEntity();

            objPacienteVacinaDTO.setNome(nome.getText());
            objPacienteVacinaDTO.setSobrenome(sobrenome.getText());
            objPacienteVacinaDTO.setEmail(emai.getText());
            objPacienteVacinaDTO.setDataNascimento(Date.getText());
            objPacienteVacinaDTO.setEndereco(enderecoField.getText());
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
            boolean response = objPacienteVacinaDAO.editarPerfil(id, objPacienteVacinaDTO);
            if (response) {
                JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso", "Atualizar dados do paciente", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar paciente", "Atualizar dados do paciente", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro com a base de dados:\n" + e.getMessage(), "Error Base de dados", JOptionPane.ERROR_MESSAGE);
        }
    }
}
