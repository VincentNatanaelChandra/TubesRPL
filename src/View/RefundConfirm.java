package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.Controller;

public class RefundConfirm {

    private JFrame frame;
    private int admin_id;
    private String name;
    private int refund_id;
    
    public RefundConfirm(int admin_id, String name, int refund_id) {
        this.admin_id = admin_id;
        this.name = name;
        this.refund_id = refund_id;
    }

    private void createRefundConfirmWindow(int admin_id, String name, int refund_id) {
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelTicketId = new JLabel("Ticket ID :");
        labelTicketId.setBounds(20, 20, 150, 30);
        frame.add(labelTicketId);
        
        JTextField idTicket = new JTextField();
        idTicket.setText((String) Controller.getInstance().getTicketIdRefund(refund_id));
        idTicket.setEditable(false);
        idTicket.setBounds(150, 25, 150, 30);
        frame.add(idTicket);
        
        JLabel labelRefundReason = new JLabel("Alasan Refund :");
        labelRefundReason.setBounds(20, 75, 150, 30);
        frame.add(labelRefundReason);
        
        JTextField refundReason = new JTextField(Controller.getInstance().getRefundReason(refund_id));
        refundReason.setEditable(false);
        refundReason.setBounds(150, 75, 150, 30);
        frame.add(refundReason);
        
        JLabel labelRefundTotal = new JLabel("Total Refund :");
        labelRefundTotal.setBounds(20, 125, 150, 30);
        frame.add(labelRefundTotal);
        
        JTextField refundTotal = new JTextField(Controller.getInstance().getRefundTotal(refund_id));
        refundTotal.setEditable(false);
        refundTotal.setBounds(150, 125, 150, 30);
        frame.add(refundTotal);

        JButton acceptButton = new JButton("Terima");
        acceptButton.setBounds(50, 175, 100, 30);
        frame.add(acceptButton);

        JButton rejectButton = new JButton("Tolak");
        rejectButton.setBounds(200, 175, 100, 30);
        frame.add(rejectButton);

        // Event listener untuk tombol "Terima"
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean refundStatus = Controller.getInstance().updateRefund(refund_id);
                if (refundStatus) {
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
            frame.dispose(); // Menutup jendela RefundConfirm
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(admin_id, name); // Kembali ke Main Menu Admin
        });
        frame.add(backButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showRefundConfirmWindow(boolean visible) {
        if (visible) {
            createRefundConfirmWindow(admin_id,  name, refund_id);
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }

}
