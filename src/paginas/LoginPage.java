/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paginas;

/**
 * @author godalway
 */
import dao.FuncionarioDAO;
import dto.FuncionarioDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import javax.swing.*;

public class LoginPage extends JFrame {

    private JButton loginBtn, registerBtn;
    private JTextField username;
    private JPasswordField password;
    private JLabel img, imge, OR;
    private ImageIcon icon, imagem, icone, Or;

    public LoginPage() {
//      Definir a interface do programa
        super("Gestor Hospitalar");
        this.setSize(1280, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        components();
    }

    private void components() {
//        Background color
        getContentPane().setBackground(new Color(40, 53, 63, 255));
        getContentPane().setFont(new Font("Arial", Font.PLAIN, 24));
        getContentPane().setForeground(new Color(255, 255, 255, 255));

//        Adicionando Icon no programa
        imagem = new ImageIcon("./imgs/icon.png");
        setIconImage(imagem.getImage());

//        Icon do user desconhecido
        icone = new ImageIcon("./imgs/user.png");
        img = new JLabel(icone);
        img.setBounds(955, 180, 80, 80);
        img.setFocusable(true);
        add(img);

        // criando o separador
        JSeparator sep = new JSeparator();

        // criando a linha vertical
        sep.setBackground(new Color(73, 84, 92, 255));
        sep.setBounds(730, 180, 80, 400);
        sep.setOrientation(SwingConstants.VERTICAL);
        add(sep);

//I     Adicao de imagem
        icon = new ImageIcon("./imgs/h2.png");
        imge = new JLabel(icon);
        imge.setBounds(84, 120, 500, 500);
        add(imge);

//        TextField
        username = new JTextField(" Username");
        username.setBounds(825, 303, 340, 55);
        username.setBackground(new Color(40, 53, 63, 255));
        username.setForeground(new Color(255, 255, 255, 255));
        username.setFont(new Font("Arial", Font.PLAIN, 18));
        username.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                username.setBorder(BorderFactory.createLineBorder(new Color(0, 231, 163, 255)));
                if (username.getText().equalsIgnoreCase(" Username")) {
                    username.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                username.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
                if (username.getText().equals("")) {
                    username.setText(" Username");
                }
            }
        });
        add(username);

        password = new JPasswordField("Password");
        password.setBounds(825, 378, 340, 55);
        password.setBackground(new Color(40, 53, 63, 255));
        password.setForeground(new Color(255, 255, 255, 255));
        password.setFont(new Font("Arial", Font.PLAIN, 18));
        password.setEchoChar('*');
        password.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                password.setBorder(BorderFactory.createLineBorder(new Color(0, 231, 163, 255)));
                if (password.getText().equalsIgnoreCase("Password")) {
                    password.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                password.setBorder(BorderFactory.createLineBorder(new Color(73, 84, 92, 255)));
                if (password.getText().equals("")) {
                    password.setText("Password");
                }
            }
        });
        add(password);

//        Adicionando Button
        loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(0, 231, 163, 255));
        loginBtn.setForeground(new Color(255, 255, 255, 255));
        loginBtn.setBounds(825, 462, 340, 55);
        loginBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        add(loginBtn);
        getRootPane().setDefaultButton(loginBtn);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
                    objFuncionarioDTO.setNomeFunc(username.getText());
                    objFuncionarioDTO.setSenhaFunc(password.getText());

                    FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
                    if (objFuncionarioDAO.login(objFuncionarioDTO)) {
                        dispose();
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });

//        Or
        Or = new ImageIcon("./imgs/or.png");
        OR = new JLabel(Or);
        OR.setBounds(980, 535, 24, 24);
        add(OR);

        registerBtn = new JButton("Sign In");
        registerBtn.setBounds(950, 565, 80, 30);
        registerBtn.setBackground(new Color(40, 53, 63, 255));
        registerBtn.setForeground(new Color(89, 97, 103, 255));
        registerBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        registerBtn.setBorder(null);
        add(registerBtn);

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Desculpa! Nenhum funcionário pode se registrar,\n queira por favor comunicar-se com um administrador", "Registrar", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.setVisible(true);
    }

}
