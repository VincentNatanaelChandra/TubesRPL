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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MainMenuAdmin {

    public MainMenuAdmin(int admin_id, String name) {
        MenuAdmin(admin_id, name);
    }

    private void MenuAdmin(int admin_id, String name) {
        //=============BAGIAN CONTAINER================
        JFrame formMenuAdmin = new JFrame("Menu Admin");
        formMenuAdmin.setSize(320, 330);
        formMenuAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formMenuAdmin.setLocationRelativeTo(null);
        formMenuAdmin.setLayout(null);
        //================END CONTAINER=================

        JLabel labelTitle = new JLabel("Welcome Back, Admin " + name);
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(10, 5, 400, 30);
        formMenuAdmin.add(labelTitle);

        JButton buttonUpdateDestination = new JButton("Update Destination");
        buttonUpdateDestination.setBounds(30, 40, 250, 30);
        formMenuAdmin.add(buttonUpdateDestination);

        buttonUpdateDestination.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menutup tampilan saat ini (MainMenuAdmin)
                formMenuAdmin.setVisible(false);

                Integer destination[] = Controller.getInstance().getDestinationId().toArray(new Integer[Controller.getInstance().getDestinationId().size()]);

                if (destination.length > 0) {
                    // Tampilkan JOptionPane untuk memilih Flight ID
                    int selectedDestinationID = (int) JOptionPane.showInputDialog(
                            null,
                            "Choose a Destination ID:",
                            "Select Destination ID",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            destination,
                            destination[0]); // Pilihan default (opsional)

                    if (selectedDestinationID != 0) { // Jika pengguna memilih Flight ID
                        UpdateDestinasi updateDestinasi = new UpdateDestinasi(selectedDestinationID, admin_id, name);
                        updateDestinasi.showUpdateDestinasiWindow(true);
                        formMenuAdmin.setVisible(false); // Menutup formMenuAdmin saat menampilkan UpdateDestinasi
                    } else {
                        formMenuAdmin.setVisible(true);
                    }
                } else {
                    // Tampilkan pesan jika tidak ada Flight ID yang tersedia
                    JOptionPane.showMessageDialog(null, "No Destination IDs available", "No Data", JOptionPane.WARNING_MESSAGE);
                    formMenuAdmin.setVisible(true);
                }
            }
        });

        JButton buttonUpdateFlight = new JButton("Update Flight");
        buttonUpdateFlight.setBounds(30, 75, 250, 30);
        formMenuAdmin.add(buttonUpdateFlight);

        buttonUpdateFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menutup tampilan saat ini (MainMenuAdmin)
                formMenuAdmin.setVisible(false);

                String flight[] = Controller.getInstance().getAllFlightCode().toArray(new String[Controller.getInstance().getAllFlightCode().size()]);

                if (flight.length > 0) {
                    // Tampilkan JOptionPane untuk memilih Flight ID
                    String selectedFlightID = (String) JOptionPane.showInputDialog(
                            null,
                            "Choose a Flight ID:",
                            "Select Flight ID",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            flight,
                            flight[0]); // Pilihan default (opsional)

                    if (selectedFlightID != null) { // Jika pengguna memilih Flight ID
                        UpdatePenerbangan updatePenerbangan = new UpdatePenerbangan(selectedFlightID, admin_id, name);
                        updatePenerbangan.showUpdatePenerbanganWindow(true);
                        formMenuAdmin.setVisible(false); // Menutup formMenuAdmin saat menampilkan UpdatePenerbangan
                    } else {
                        formMenuAdmin.setVisible(true);
                    }
                } else {
                    // Tampilkan pesan jika tidak ada Flight ID yang tersedia
                    JOptionPane.showMessageDialog(null, "No Flight IDs available", "No Data", JOptionPane.WARNING_MESSAGE);
                    formMenuAdmin.setVisible(true);
                }
            }
        });

        JButton buttonUpdatePromo = new JButton("Update Promo");
        buttonUpdatePromo.setBounds(30, 110, 250, 30);
        formMenuAdmin.add(buttonUpdatePromo);

        buttonUpdatePromo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menutup tampilan saat ini (MainMenuAdmin)
                formMenuAdmin.setVisible(false);

                Integer promo[] = Controller.getInstance().getPromoId().toArray(new Integer[Controller.getInstance().getPromoId().size()]);

                if (promo.length > 0) {
                    // Tampilkan JOptionPane untuk memilih Promo ID
                    int selectedPromoID = (int) JOptionPane.showInputDialog(
                            null,
                            "Choose a Promo ID:",
                            "Select Promo ID",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            promo,
                            promo[0]); // Pilihan default (opsional)

                    if (selectedPromoID != 0) { // Jika pengguna memilih Promo ID
                        UpdatePromo updatePromo = new UpdatePromo(selectedPromoID, admin_id, name);
                        updatePromo.showUpdatePromoWindow(true);
                        formMenuAdmin.setVisible(false); // Menutup formMenuAdmin saat menampilkan UpdatePromo
                    } else {
                        new MainMenuAdmin(admin_id, name);
                    }
                } else {
                    // Tampilkan pesan jika tidak ada Promo ID yang tersedia
                    JOptionPane.showMessageDialog(null, "No Promo IDs available", "No Data", JOptionPane.WARNING_MESSAGE);
                    formMenuAdmin.setVisible(true);
                }
            }
        });

        JButton buttonConfirmationReschedule = new JButton("Reschedule Confirmation");
        buttonConfirmationReschedule.setBounds(30, 145, 250, 30);
        formMenuAdmin.add(buttonConfirmationReschedule);

        buttonConfirmationReschedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formMenuAdmin.setVisible(false); // Menutup tampilan saat ini (MainMenuAdmin)
                Integer reschedule[] = Controller.getInstance().getRescheduleId().toArray(new Integer[Controller.getInstance().getRescheduleId().size()]);

                if (reschedule.length > 0) {
                    // Tampilkan JOptionPane untuk memilih Reschedule ID
                    int selectedRescheduleID = (int) JOptionPane.showInputDialog(
                            null,
                            "Choose a reschedule ID:",
                            "Select reschedule ID",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            reschedule,
                            reschedule[0]); // Pilihan default (opsional)

                    if (selectedRescheduleID != 0) { // Jika pengguna memilih Reschedule ID
                        RescheduleConfirm confirmReschedule = new RescheduleConfirm(admin_id, name, selectedRescheduleID);
                        confirmReschedule.showRescheduleConfirmWindow(true);
                        formMenuAdmin.setVisible(false); // Menutup formMenuAdmin saat menampilkan RescheduleConfirm
                    } else {
                        new MainMenuAdmin(admin_id, name);
                    }
                } else {
                    // Tampilkan pesan jika tidak ada Reschedule ID yang tersedia
                    JOptionPane.showMessageDialog(null, "No Reschedule IDs available", "No Data", JOptionPane.WARNING_MESSAGE);
                    formMenuAdmin.setVisible(true);
                }
            }
        });

        JButton buttonConfirmationRefund = new JButton("Refund Confirmation");
        buttonConfirmationRefund.setBounds(30, 180, 250, 30);
        formMenuAdmin.add(buttonConfirmationRefund);
       

        buttonConfirmationRefund.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formMenuAdmin.setVisible(false); // Menutup tampilan saat ini (MainMenuAdmin)
                Integer refund[] = Controller.getInstance().getRefundId().toArray(new Integer[Controller.getInstance().getRefundId().size()]);

                if (refund.length > 0) {
                    // Tampilkan JOptionPane untuk memilih Refund ID
                    int selectedRefundID = (int) JOptionPane.showInputDialog(
                            null,
                            "Choose a refund ID:",
                            "Select refund ID",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            refund,
                            refund[0]); // Pilihan default (opsional)

                    if (selectedRefundID != 0) { // Jika pengguna memilih Refund ID
                        RefundConfirm confirmRefund = new RefundConfirm(admin_id, name, selectedRefundID);
                        confirmRefund.showRefundConfirmWindow(true);
                        formMenuAdmin.setVisible(false); // Menutup formMenuAdmin saat menampilkan RefundConfirm
                    } else {
                        new MainMenuAdmin(admin_id, name);
                    }
                } else {
                    // Tampilkan pesan jika tidak ada Refund ID yang tersedia
                    JOptionPane.showMessageDialog(null, "No Refund IDs available", "No Data", JOptionPane.WARNING_MESSAGE);
                    formMenuAdmin.setVisible(true);
                }
            }
        });

        JButton buttonHistory = new JButton("View History");
        buttonHistory.setBounds(30, 215, 250, 30);
        formMenuAdmin.add(buttonHistory);

        ViewHistory viewhistory = new ViewHistory(admin_id, name);
        buttonHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewhistory.showViewHistoryWindow(true);
                formMenuAdmin.setVisible(false); // Menutup tampilan saat ini (MainMenuAdmin)
            }
        });

        JButton buttonBacktoLogin = new JButton("Back");
        buttonBacktoLogin.setBounds(30, 250, 250, 30);
        formMenuAdmin.add(buttonBacktoLogin);

        buttonBacktoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formMenuAdmin.dispose();
                new Login();
            }
        });

        formMenuAdmin.setVisible(true);

    }

}
