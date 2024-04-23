/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Reschedule {

    public Reschedule(int member_id, String name) {
        reschedule(member_id, name);
    }

    private void reschedule(int member_id, String name) {


        //=============BAGIAN CONTAINER================
        JFrame formReschedule = new JFrame("Reschedule Menu");
        formReschedule.setSize(300, 300);
        formReschedule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formReschedule.setLocationRelativeTo(null);
        formReschedule.setLayout(null);
        //================END CONTAINER=================

        //Judul Form
        JLabel labelTitle = new JLabel("Form Reschedule");
        Font fontTitle = new Font("Mont", Font.BOLD, 20);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(20, 5, 250, 30);
        formReschedule.add(labelTitle);

        //Kode Ticket
        JLabel labelTicketCode = new JLabel("Kode Ticket :");
        labelTicketCode.setBounds(20, 40, 100, 30);
        formReschedule.add(labelTicketCode);
        Integer ticketId[] = Controller.getInstance().getTicketMemberIdInt(member_id).toArray(new Integer[Controller.getInstance().getTicketMemberIdInt(member_id).size()]);
        JComboBox nomorTiketField = new JComboBox(ticketId);
        nomorTiketField.setBounds(100, 40, 100, 25);
        formReschedule.add(nomorTiketField);

        //Alasan Reschedule
        JLabel labelReason = new JLabel("Alasan Reschedule :");
        labelReason.setBounds(20, 75, 200, 30);
        formReschedule.add(labelReason);
        JTextField textReason = new JTextField();
        textReason.setBounds(20, 110, 250, 70);
        formReschedule.add(textReason);

        Font fontLabelCheck = new Font("Mont", Font.PLAIN, 10);
        JLabel labelCheck = new JLabel("Apakah anda yakin ingin melakukan Reschedule? ");
        labelCheck.setFont(fontLabelCheck);
        labelCheck.setBounds(20, 185, 250, 20);
        JCheckBox checkAcc = new JCheckBox();
        checkAcc.setBounds(235, 185, 50, 20);
        formReschedule.add(labelCheck);
        formReschedule.add(checkAcc);

        JButton buttonBack = new JButton("Back to Menu");
        buttonBack.setBounds(20, 215, 130, 30);
        formReschedule.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formReschedule.dispose();
                new MainMenuUser(member_id, name);
            }
        });

        JButton buttonSubmit = new JButton("Next Page");
        buttonSubmit.setBounds(160, 215, 100, 30);
        formReschedule.add(buttonSubmit);
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ticketId = (Integer) nomorTiketField.getSelectedItem();
                String ticket = Controller.getInstance().getTicketKode(ticketId);
                String reason = textReason.getText();
                    formReschedule.dispose();
                    new nextReschedule(member_id, name, ticket, reason);
            }
        });

        formReschedule.setVisible(true);
    }
}
