/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paginas.paginasAdicionais;

import dao.ConsultasDAO;
import entity.ConsultasEntity;
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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author godal
 */
public class EditarConsultasPage extends JFrame {

    private JScrollPane rolagem, otherRolagem;
    private JPanel rightScreen;
    private JTextField NomeCompleto, Sobrenome, emai, altur, pes, idad;
    private MaskFormatter BIM;
    private JFormattedTextField BIF;
    private JRadioButton GanhoMus, PerdaPeso, GanhoFor, Desempenho, outro;
    private JLabel NomeCompletoL, SobrenomeL, email, BI, endereco, altura, peso, idade;
    private JButton submit;
    private JTextArea texto, other;
    private int id;

    public EditarConsultasPage() {
        super("Gestor Hospitalar");
        this.setSize(1100, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.editar();
        this.preencherCampos(id);
        this.setVisible(true);
    }

    private void editar() {
        rightScreen = new JPanel(null);
        rightScreen.setSize(1280, 900);
        rightScreen.setBounds(145, 0, 1280, 900);
        add(rightScreen);
        JLabel titulo = new JLabel("Consulta Nutricional");
        titulo.setBounds(335, 15, 740, 45);
        titulo.setForeground(new Color(89, 97, 103, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        rightScreen.add(titulo);

//             //        Agendamento da consulta   Nutricional
        BI = new JLabel("Data para a consulta");
        BI.setBounds(75, 75, 345, 45);
        BI.setForeground(new Color(89, 97, 103, 255));
        BI.setFont(new Font("Arial", Font.PLAIN, 18));
        rightScreen.add(BI);
        try {
            BIM = new MaskFormatter("##-##-####");
            BIM.setPlaceholder("DD-MM-YYYY");
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

        altur = new JTextField("");
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

        pes = new JTextField();
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

        idad = new JTextField();
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
        otherRolagem = new JScrollPane(other);
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
        submit.setBounds(515, 709, 340, 45);
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
    }

    public void preencherCampos(int id) {
        this.id = id;
        try {
            ConsultasEntity objConsultasDTO = new ConsultasDAO().verPerfil(id);
            NomeCompleto.setText(objConsultasDTO.getNome());
            Sobrenome.setText(objConsultasDTO.getSobrenome());
            emai.setText(objConsultasDTO.getEmail());
            BIF.setText(objConsultasDTO.getData());
            pes.setText(String.valueOf(objConsultasDTO.getPeso()));
            altur.setText(String.valueOf(objConsultasDTO.getAltura()));
            idad.setText(String.valueOf(objConsultasDTO.getIdade()));
            texto.setText(objConsultasDTO.getMetas());

            if (objConsultasDTO.getObjetivos() != null) {

                if (objConsultasDTO.getObjetivos().equalsIgnoreCase("Perder Peso")) {
                    PerdaPeso.setSelected(true);
                } else if (objConsultasDTO.getObjetivos().equalsIgnoreCase("Ganhar Musculos")) {
                    GanhoMus.setSelected(true);
                } else if (objConsultasDTO.getObjetivos().equalsIgnoreCase("Ganhar Força")) {
                    GanhoFor.setSelected(true);
                } else {
                    outro.setSelected(true);
                    otherRolagem.setVisible(true);
                    other.setText(objConsultasDTO.getObjetivos().trim());
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    private void atualizar() {
        try {
            ConsultasEntity objConsultasDTO = new ConsultasEntity();

            objConsultasDTO.setNome(NomeCompleto.getText());
            objConsultasDTO.setSobrenome(Sobrenome.getText());
            objConsultasDTO.setEmail(emai.getText());
            objConsultasDTO.setData(BIF.getText());
            objConsultasDTO.setPeso(Double.parseDouble(pes.getText()));
            objConsultasDTO.setAltura(Double.parseDouble(altur.getText()));
            objConsultasDTO.setIdade(Integer.parseInt(idad.getText()));
            objConsultasDTO.setMetas(texto.getText());

            if (PerdaPeso.isSelected()) {
                objConsultasDTO.setObjetivos("Perder Peso");
            } else if (GanhoMus.isSelected()) {
                objConsultasDTO.setObjetivos("Ganhar Musculos");
            } else if (GanhoFor.isSelected()) {
                objConsultasDTO.setObjetivos("Ganhar Força");
            } else if (Desempenho.isSelected()) {
                objConsultasDTO.setObjetivos("Desempenho atlético");
            } else {
                objConsultasDTO.setObjetivos(other.getText());
            }

            ConsultasDAO objConsultasDAO = new ConsultasDAO();

            if (objConsultasDAO.editarPerfil(id, objConsultasDTO)) {
                JOptionPane.showMessageDialog(null, "Consulta atualizada com sucesso", "Atualizar de Consulta", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro com a base de dados:\n" + e.getMessage(), "Error Base de dados", JOptionPane.ERROR_MESSAGE);
        }
    }
}
