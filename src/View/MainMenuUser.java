/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.Controller;

public class MainMenuUser {

    public MainMenuUser(int member_id, String name) {
        MenuUser(member_id, name);
    }

    private void MenuUser(int member_id, String name) {
        JFrame formMenuUser = new JFrame("Menu User ");
        formMenuUser.setSize(320, 300);
        formMenuUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formMenuUser.setLocationRelativeTo(null);
        formMenuUser.setLayout(null);

        JLabel labelTitle = new JLabel("MENU USER");
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(110, 5, 100, 30);
        formMenuUser.add(labelTitle);
        JLabel welcome = new JLabel("Welcome, ");
        Font welcomeFont = new Font("Mont", Font.PLAIN, 12);
        welcome.setFont(welcomeFont);
        welcome.setBounds(35, 29, 400, 30);
        formMenuUser.add(welcome);

        JLabel nametext = new JLabel(name);
        Font nameFont = new Font("Mont", Font.BOLD, 20);
        nametext.setFont(nameFont);
        nametext.setBounds(35, 45, 400, 30);
        formMenuUser.add(nametext);

        JButton buttonTransaction = new JButton("Transaction");
        buttonTransaction.setBounds(30, 80, 250, 30);
        formMenuUser.add(buttonTransaction);
        buttonTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formMenuUser.dispose();
                new bookTicket(member_id, name);
            }
        });

        JButton buttonRefund = new JButton("Refund");
        buttonRefund.setBounds(30, 115, 250, 30);
        formMenuUser.add(buttonRefund);

        buttonRefund.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formMenuUser.dispose();
                new Refund(member_id, name);
            }
        });

        JButton buttonReschedule = new JButton("Reschedule");
        buttonReschedule.setBounds(30, 150, 250, 30);
        formMenuUser.add(buttonReschedule);

        buttonReschedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formMenuUser.dispose();
                new Reschedule(member_id, name);
            }
        });

        JButton buttonBacktoLogin = new JButton("⬅");
        buttonBacktoLogin.setBounds(30, 5, 50, 30); // Menempatkan tombol "Back" di pojok kiri atas
        formMenuUser.add(buttonBacktoLogin);
        Font fontback = new Font("Mont", Font.BOLD, 16);
        buttonBacktoLogin.setFont(fontback);

        buttonBacktoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formMenuUser.dispose();
                new Login();
            }
        });

        JButton buttonViewHistory = new JButton("🎟");
        int formWidth = formMenuUser.getWidth();
        buttonViewHistory.setBounds(formWidth - 90, 5, 50, 30); // Menempatkan tombol "View History" di pojok kanan atas
        Font fonttiket = new Font("Mont", Font.BOLD, 16);
        buttonViewHistory.setFont(fonttiket);
        buttonViewHistory.addActionListener(new ActionListener() {
            ViewHistoryMember historyFrame = new ViewHistoryMember(member_id, name);

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Controller.getInstance().getAllTransactionsByMemberId(member_id) != null) {
                    formMenuUser.dispose();
                    historyFrame.showViewHistoryWindow(true);
                } else {
                    JOptionPane.showMessageDialog(formMenuUser, "Anda belum Pernah melakukan Transaksi", "Pesan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        formMenuUser.add(buttonViewHistory);

        formMenuUser.setVisible(true);
    }
}
