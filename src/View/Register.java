/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author ASUS
 */
public class Register {

    public Register() {
        newRegister();
    }

    private void newRegister() {
        
        
        //=============BAGIAN CONTAINER================
        JFrame formRegister = new JFrame("Register Menu");
        formRegister.setSize(320, 270);
        formRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formRegister.setLocationRelativeTo(null);
        formRegister.setLayout(null);
        //================END CONTAINER=================

        JLabel labelTitle = new JLabel("Welcome New User!!!");
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(80, 5, 250, 30);
        formRegister.add(labelTitle);

        //Register: Username
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(15, 40, 100, 30);
        formRegister.add(labelUsername);
        JTextField textUsername = new JTextField();
        textUsername.setBounds(85, 40, 150, 30);
        formRegister.add(textUsername);

        //Register: Email
        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setBounds(15, 75, 100, 30);
        formRegister.add(labelEmail);
        JTextField textEmail = new JTextField();
        textEmail.setBounds(85, 75, 150, 30);
        formRegister.add(textEmail);

        //Register: Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 110, 100, 30);
        formRegister.add(labelPassword);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(85, 110, 150, 30);
        formRegister.add(passwordField);

        //Register: PinPay
        JLabel labelPinPay = new JLabel("PinPay :");
        labelPinPay.setBounds(15, 145, 100, 30);
        formRegister.add(labelPinPay);
        JPasswordField pinPayField = new JPasswordField();
        pinPayField.setColumns(6);

        // Menerapkan DocumentFilter
        ((AbstractDocument) pinPayField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (isNumeric(string) && fb.getDocument().getLength() + string.length() <= 6) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isNumeric(text) && fb.getDocument().getLength() - length + text.length() <= 6) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isNumeric(String str) {
                return str.matches("\\d+");
            }
        });

        JButton showPasswordButton = new JButton("Show PinPay 👁️");
        showPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password = pinPayField.getPassword();
                JOptionPane.showMessageDialog(formRegister, "Entered Password: " + String.valueOf(password));
            }
        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Menggunakan FlowLayout
        panel.setBounds(85, 145, 350, 40);
        panel.add(pinPayField);
        panel.add(showPasswordButton);
        formRegister.add(panel);

        //ButtonBack
        JButton buttonBack = new JButton("← Back");
        buttonBack.setBounds(35, 190, 100, 20);
        formRegister.add(buttonBack);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formRegister.dispose();
                new Login();
            }
        });

        //Register: Button
        JButton buttonRegister = new JButton("Register");
        buttonRegister.setBounds(170, 190, 100, 20);
        formRegister.add(buttonRegister);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                String pinPay = String.valueOf(pinPayField.getPassword());
                boolean found = Controller.getInstance().getCustomer(textUsername.getText());
                if (found) {
                    JOptionPane.showMessageDialog(formRegister, "User's Data Already Registered", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean insert = Controller.getInstance().RegisterCustomerData(textUsername.getText(),password);
                    int id = Controller.getInstance().getIdUser(textUsername.getText());
                    System.out.println("id = " + id);
                    boolean insert2 = Controller.getInstance().RegisterMemberData(textEmail.getText(), pinPay, id);
                    if (insert2) {
                        JOptionPane.showMessageDialog(formRegister, "New User's Data Registered", "Inputting Data...", JOptionPane.INFORMATION_MESSAGE);
                        new Login();
                        formRegister.dispose();
                    } else {
                    JOptionPane.showMessageDialog(formRegister, "User Input Failed", "Error", JOptionPane.WARNING_MESSAGE);
                    new Login();
                    formRegister.dispose();
                    }
                }
            }
        });

        formRegister.setVisible(true);
    }
}

