/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Controller.DateLabelFormatter;
import Model.RescheduleEnum;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

/**
 *
 * @author ASUS
 */
public class nextReschedule {

    public nextReschedule(int member_id, String name, String ticket, String reasonReschedule) {
        nextReschedule(member_id, name, ticket, reasonReschedule);
    }

    private void nextReschedule(int member_id, String name, String ticketKode, String reason) {


        //=============BAGIAN CONTAINER================
        JFrame formReschedule = new JFrame("Form Reschedule");
        formReschedule.setSize(330, 280);
        formReschedule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formReschedule.setLocationRelativeTo(null);
        formReschedule.setLayout(null);
        //================END CONTAINER=================

        //==================COMPONENT===================
        //Judul Form
        JLabel labelTitle = new JLabel("Fill your new Schedule!!");
        Font fontTitle = new Font("Mont", Font.BOLD, 18);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(10, 5, 400, 30);
        formReschedule.add(labelTitle);

        JLabel newLabelDateFlight = new JLabel("Date Flight : ");
        newLabelDateFlight.setBounds(10, 40, 80, 30);
        formReschedule.add(newLabelDateFlight);

        //Isian Tanggal Berangkat
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(150, 40, 150, 30);
        formReschedule.add(datePicker);

        int flightId = Controller.getInstance().getFlightId(ticketKode);

        //Seat Number
        JLabel labelSeatClass = new JLabel("Seat :");
        labelSeatClass.setBounds(10, 75, 150, 30);
        formReschedule.add(labelSeatClass);
        //ComboBox Class
        String seatPlane[] = Controller.getInstance().getSeatNumber(flightId).toArray(new String[Controller.getInstance().getSeatClass().size()]);
        JComboBox cbSeat = new JComboBox(seatPlane);
        cbSeat.setBounds(150, 75, 150, 30);
        formReschedule.add(cbSeat);

        JButton buttonReqReschedule = new JButton("Request Reschedule");
        buttonReqReschedule.setBounds(70, 110, 180, 30);
        formReschedule.add(buttonReqReschedule);

        int ticket_id = Controller.getInstance().getTicketId(ticketKode);

        buttonReqReschedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date newDateFlight = (Date) datePicker.getModel().getValue();

                // Convert java.util.Date to java.sql.Date
                java.sql.Date sqlDate = new java.sql.Date(newDateFlight.getTime());
                String newSeatNum = (String) cbSeat.getSelectedItem();
                Controller.getInstance().requestReshcedule(ticket_id, RescheduleEnum.RESCHEDULEDENIED, reason, sqlDate, newSeatNum);
                JOptionPane.showMessageDialog(formReschedule, "Reschedule Request Successful, Waiting for Confirmation.", "Reschedule Menu", JOptionPane.PLAIN_MESSAGE);
                
                formReschedule.dispose();
                new MainMenuUser(member_id, name);
            }
        });

        formReschedule.setVisible(true);
    }
}
