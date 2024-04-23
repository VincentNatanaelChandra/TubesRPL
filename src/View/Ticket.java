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

import Controller.Controller;

/**
 *
 * @author ASUS
 */
public class Ticket {

    public Ticket(int member_id, String name, int flight_id, String ticket_code, int ticket_id, String classSeat, String seatNum) {
        Ticket(member_id, name, flight_id, ticket_code, ticket_id, classSeat, seatNum);
    }

    private void Ticket(int member_id, String name, int flight_id, String ticket_code, int ticket_id, String classSeat, String seatNum) {


        //=============BAGIAN CONTAINER================
        JFrame ticket = new JFrame("TICKET");
        ticket.setSize(300, 380);
        ticket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticket.setLocationRelativeTo(null);
        ticket.setLayout(null);
        //================END CONTAINER=================

        JLabel labelTitle = new JLabel("--- Success BookTicket ---");
        Font fontTitle = new Font("Arial", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(45, 5, 500, 50);
        ticket.add(labelTitle);

        JLabel lineTicket1 = new JLabel("_________________");
        lineTicket1.setBounds(82, 32, 150, 30);
        ticket.add(lineTicket1);

        JLabel labelKodeTicket = new JLabel("| No. Ticket   : ");
        labelKodeTicket.setBounds(80, 45, 90, 30);
        ticket.add(labelKodeTicket);

        JLabel kodeTicket = new JLabel(ticket_code + " |");
        kodeTicket.setBounds(165, 45, 80, 30);
        ticket.add(kodeTicket);

        JLabel lineTicket2 = new JLabel("_________________");
        lineTicket2.setBounds(82, 47, 150, 30);
        ticket.add(lineTicket2);

        JLabel labelPlaneCode = new JLabel("PLANE CODE");
        labelPlaneCode.setFont(fontTitle);
        labelPlaneCode.setBounds(10, 70, 110, 30);
        ticket.add(labelPlaneCode);

        String planeCode = Controller.getInstance().getPlaneCode(flight_id);

        JLabel planeCodeValue = new JLabel(planeCode);
        Font fontPlaneCode = new Font("Arial", Font.BOLD, 30);
        planeCodeValue.setFont(fontPlaneCode);
        planeCodeValue.setBounds(80, 90, 200, 50);
        ticket.add(planeCodeValue);

        Font fontTitleAtribute = new Font("Arial", Font.PLAIN, 13);
        Font fontAtribute = new Font("Arial", Font.BOLD, 17);
        int formWidth = ticket.getWidth();

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(10, 130, 100, 30);
        labelName.setFont(fontTitleAtribute);
        ticket.add(labelName);

        JLabel nameValue = new JLabel(name);
        nameValue.setFont(fontAtribute);
        nameValue.setBounds(10, 150, 100, 30);
        ticket.add(nameValue);

        JLabel labelClass = new JLabel("Class");
        labelClass.setBounds(10, 180, 100, 30);
        labelClass.setFont(fontTitleAtribute);
        ticket.add(labelClass);

        JLabel lClass = new JLabel(classSeat);
        lClass.setBounds(10, 200, 100, 30);
        lClass.setFont(fontAtribute);
        ticket.add(lClass);

        JLabel labelId = new JLabel("ID");
        labelId.setBounds(formWidth - 42, 130, 50, 30);
        labelId.setFont(fontTitleAtribute);
        ticket.add(labelId);

        JLabel idValue = new JLabel(member_id + "");
        idValue.setFont(fontAtribute);
        idValue.setBounds(formWidth - 40, 150, 100, 30);
        ticket.add(idValue);

        JLabel labelSeat = new JLabel("Seat");
        labelSeat.setBounds(formWidth - 55, 180, 100, 30);
        labelSeat.setFont(fontTitleAtribute);
        ticket.add(labelSeat);

        JLabel seat = new JLabel(seatNum);
        seat.setBounds(formWidth - 50, 200, 100, 30);
        seat.setFont(fontAtribute);
        ticket.add(seat);

        JButton buttonPrintTicket = new JButton("Print Ticket");
        buttonPrintTicket.setBounds(15, 245, 255, 30);
        ticket.add(buttonPrintTicket);

        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(15, 285, 255, 30);
        ticket.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ticket.dispose();
                new MainMenuUser(member_id, name);
            }
        });
        ticket.setVisible(true);
    }
}
