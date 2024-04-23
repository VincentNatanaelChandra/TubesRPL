/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Controller.DateLabelFormatter;
import Model.RefundEnum;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Refund {

    public Refund(int member_id, String name) {
        refund(member_id, name);
    }

    public void refund(int member_id, String name) {

        JFrame formRefund = new JFrame("Airplane Ticket Refund Menu");
        formRefund.setSize(350, 290);
        formRefund.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formRefund.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        Font fontTitle = new Font("Arial", Font.BOLD, 18);
        JLabel labelTitle = new JLabel("REFUND TIKET");
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(100, 10, 200, 30);

        //Ticket Number
        JLabel nomorTiketLabel = new JLabel("Tiket Number:");
        nomorTiketLabel.setBounds(20, 50, 100, 25);

        Integer ticketId[] = Controller.getInstance().getTicketMemberIdInt(member_id).toArray(new Integer[Controller.getInstance().getTicketMemberIdInt(member_id).size()]);
        JComboBox nomorTiketField = new JComboBox(ticketId);
        nomorTiketField.setBounds(120, 50, 100, 25);

        //Refund Reason
        JLabel reasonNameLabel = new JLabel("Refund Reason:");
        reasonNameLabel.setBounds(20, 90, 150, 25);

        JTextField reasonNameField = new JTextField(20);
        reasonNameField.setBounds(120, 90, 190, 70);


        //Refund Terms
        
        Font fontTerms = new Font("Arial", Font.PLAIN, 10);
        
        JCheckBox agreeCheckBox = new JCheckBox("Check");
        agreeCheckBox.setFont(fontTerms);
        agreeCheckBox.setBounds(20, 170, 55, 25);

        JLabel labelTerms1 = new JLabel("<html><u>Terms Refund </u></html>");
        labelTerms1.setFont(fontTerms);
        labelTerms1.setForeground(Color.BLUE);
        labelTerms1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelTerms1.setBounds(72, 167, 70, 30);

        JLabel labelTerms2 = new JLabel("before you Request Refund");
        labelTerms2.setFont(fontTerms);
        labelTerms2.setBounds(140, 167, 130, 30);

        JButton buttonBack = new JButton("Go Back");
        buttonBack.setBounds(60, 200, 100, 30);
        
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                formRefund.dispose();
                new MainMenuUser(member_id, name);
            }
        });
        
        JButton buttonRefund = new JButton("Refund");
        buttonRefund.setBounds(180, 200, 100, 30);

        buttonRefund.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (agreeCheckBox.isSelected()) {
                    int ticket = (Integer) nomorTiketField.getSelectedItem();
                    String reason = reasonNameField.getText();
                        formRefund.dispose();
                        int ticket_id =ticket;
                        double price =(double) Controller.getInstance().getTotalPrice(ticket_id);
                        System.out.println(price);
                        double payBack = price * 0.8;
                        Controller.getInstance().requestRefund(ticket_id, RefundEnum.REFUNDDENIED, payBack, reason);
                        formRefund.dispose();
                        new MainMenuUser(member_id, name);
                } else {
                    JOptionPane.showMessageDialog(null, "Please agree to our Refund Terms, to continue your Refund");
                }
            }
        });

        panel.setLayout(null);
        panel.add(labelTitle);
        panel.add(nomorTiketLabel);
        panel.add(nomorTiketField);
        panel.add(reasonNameLabel);
        panel.add(reasonNameField);
        panel.add(labelTerms1);
        panel.add(labelTerms2);
        panel.add(agreeCheckBox);
        panel.add(buttonRefund);
        panel.add(buttonBack);
        formRefund.add(panel);

        labelTerms1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel syaratPanel = new JPanel();
                syaratPanel.setLayout(new BoxLayout(syaratPanel, BoxLayout.Y_AXIS));

                JLabel biayaLabel = new JLabel();
                biayaLabel.setText("<html>&#8226; Refund amount is only 80%</html>");
                panel.add(biayaLabel);

                JLabel tiketLabel = new JLabel();
                tiketLabel.setText("<html>&#8226; Refunded tickets cannot be reused</html>");
                panel.add(tiketLabel);

                JLabel jamKerjaLabel = new JLabel();
                jamKerjaLabel.setText("<html>&#8226; Refund transactions are carried out during working hours</html>");
                panel.add(jamKerjaLabel);
                
                syaratPanel.add(biayaLabel);
                syaratPanel.add(tiketLabel);
                syaratPanel.add(jamKerjaLabel);

                JOptionPane.showConfirmDialog(null, syaratPanel, "Refund Terms",JOptionPane.PLAIN_MESSAGE);
            }
        });

        formRefund.setVisible(true);
    }
}
