/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Login {
    
    
    private JFrame formLogin;
    
    public Login() {
        newLogin();
    }
    
    private void newLogin() {
        
        
        //=============BAGIAN CONTAINER================
        formLogin = new JFrame("Flight Apps Harapan Bangsa");
        formLogin.setSize(420, 280);
        formLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formLogin.setLocationRelativeTo(null);
        formLogin.setLayout(null);
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Vincent\\Documents\\NetBeansProjects\\Tubes_PBO\\src\\pswt.png"); // Ganti dengan path gambar Anda
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 420, 280);
        //================END CONTAINER=================
        
        //==================COMPONENT===================
        //Judul Form
        JLabel labelTitle = new JLabel("Welcome to, Flight Apps Harapan Bangsa!!!");
        Font fontTitle = new Font("Mont", Font.BOLD, 17);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(30, 5, 400, 30);
        formLogin.add(labelTitle);
        
        //Login
        JLabel labelLogin = new JLabel("Login to your Account");
        labelLogin.setBounds(140, 40, 350, 30);
        formLogin.add(labelLogin);
        
        //Login: Username
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(100, 85, 100, 30);
        formLogin.add(labelUsername);
        JTextField textUsername = new JTextField();
        textUsername.setBounds(170, 85, 150, 30);
        formLogin.add(textUsername);
        
        //Login: Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(100, 115, 100, 30);
        formLogin.add(labelPassword);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(170, 115, 150, 30);
        formLogin.add(passwordField);
        //Login: Button
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(170, 150, 80, 30);
        formLogin.add(buttonLogin);
        
        //Register
        JLabel labelRegister = new JLabel("Doesn't have any account?");
        labelRegister.setBounds(100, 185,160, 30);
        formLogin.add(labelRegister);
        
        JLabel linkLabel = new JLabel("<html><u>Register</u></html>");
        linkLabel.setForeground(Color.BLUE); // Mengubah warna teks menjadi biru
        linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mengubah kursor saat mengarah ke hyperlink
        linkLabel.setBounds(260, 185, 250, 30);
        formLogin.add(linkLabel);
        
        linkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Register();
                formLogin.dispose();
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                boolean found = Controller.getInstance().getUser(textUsername.getText(), password);
                int id = Controller.getInstance().getIdUser(textUsername.getText());
                int memberId = Controller.getInstance().getIdMember(textUsername.getText());
                boolean found2 = Controller.getInstance().getUserAdmin(textUsername.getText(), password);
                if (found2) {
                    formLogin.dispose();
                    new MainMenuAdmin(id, textUsername.getText());
                } else if (found) {
                     formLogin.dispose();
                     new MainMenuUser(memberId, textUsername.getText());
                } else {
                    JOptionPane.showMessageDialog(formLogin, "User Not Found", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        
        formLogin.add(backgroundLabel);
        formLogin.setVisible(true);
    }
     public JFrame getFormLogin() {
        return formLogin;
    }
}
