package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.Controller;

public class RescheduleConfirm {

    private JFrame frame;
    private int admin_id;
    private String name;
    private int reschedule_id;
    
    public RescheduleConfirm(int admin_id, String name, int reschedule_id) {
        this.admin_id = admin_id;
        this.name = name;
        this.reschedule_id = reschedule_id;
    }

    private void createRescheduleConfirmWindow(int admin_id, String name, int rescheduleId) {
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelTicketId = new JLabel("Ticket ID :");
        labelTicketId.setBounds(20, 20, 150, 30);
        frame.add(labelTicketId);
        
        JTextField idTicket = new JTextField();
        idTicket.setText((String) Controller.getInstance().getTicketIdRechedule(rescheduleId));
        idTicket.setEditable(false);
        idTicket.setBounds(150, 25, 150, 30);
        frame.add(idTicket);
        
        JLabel labelRescheduleReason = new JLabel("Alasan Reschedule :");
        labelRescheduleReason.setBounds(20, 75, 150, 30);
        frame.add(labelRescheduleReason);
        
        JTextField rescheduleReason = new JTextField(Controller.getInstance().getRescheduleReason(rescheduleId));
        rescheduleReason.setEditable(false);
        rescheduleReason.setBounds(150, 75, 150, 30);
        frame.add(rescheduleReason);
        
        JLabel labelRescheduleDate = new JLabel("Tanggal Reschedule :");
        labelRescheduleDate.setBounds(20, 125, 150, 30);
        frame.add(labelRescheduleDate);
        
        JTextField rescheduleDate = new JTextField(Controller.getInstance().getRescheduleDate(rescheduleId));
        rescheduleDate.setEditable(false);
        rescheduleDate.setBounds(150, 125, 150, 30);
        frame.add(rescheduleDate);
        
        JLabel labelRescheduleSeat = new JLabel("Seat :");
        labelRescheduleSeat.setBounds(20, 175, 150, 30);
        frame.add(labelRescheduleSeat);
        
        JTextField rescheduleSeat = new JTextField(Controller.getInstance().getRescheduleSeat(rescheduleId));
        rescheduleSeat.setEditable(false);
        rescheduleSeat.setBounds(150, 175, 150, 30);
        frame.add(rescheduleSeat);
        
        JButton acceptButton = new JButton("Terima");
        acceptButton.setBounds(50, 225, 100, 30);
        frame.add(acceptButton);

        JButton rejectButton = new JButton("Tolak");
        rejectButton.setBounds(200, 225, 100, 30);
        frame.add(rejectButton);

        // Event listener untuk tombol "Terima"
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean rescheduleStatus = Controller.getInstance().updateReschedule(reschedule_id);
                if (rescheduleStatus) {
                    frame.dispose();
                    new MainMenuAdmin(admin_id, name);
                }
            }
        });
        
        // Event listener untuk tombol "Tolak"
        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenuAdmin(admin_id, name);
            }
        });
        JButton backButton = new JButton("Back");
        backButton.setBounds(125, 275, 100, 30);
        backButton.addActionListener(e -> {
            frame.dispose(); // Menutup jendela RescheduleConfirm
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(admin_id, name); // Kembali ke Main Menu Admin
        });
        frame.add(backButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showRescheduleConfirmWindow(boolean visible) {
        if (visible) {
            createRescheduleConfirmWindow(admin_id,  name, reschedule_id);
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }
}
