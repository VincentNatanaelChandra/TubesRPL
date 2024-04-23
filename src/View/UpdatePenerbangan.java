package View;

import javax.swing.*;
import java.awt.*;
import Controller.Controller;

public class UpdatePenerbangan {
    private JFrame frame;
    private JComboBox<String> comboBoxFlightID;
    private String selectedFlightID;
    private int admin_id;
    private String name;
   
    public UpdatePenerbangan(String selectedFlightID, int admin_id, String name) {
        this.selectedFlightID = selectedFlightID;
        this.admin_id = admin_id;
        this.name = name;
    }
    
    private void createUpdatePenerbanganWindow() {
        frame = new JFrame("Update Flight Menu");
        frame.setSize(400, 290);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1, 10, 10)); // Ubah jumlah baris

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JTextField field3 = new JTextField(10);
        JTextField field4 = new JTextField(10);
        JTextField field5 = new JTextField(10);

        panel.add(new JLabel("Plane Code:"));
        panel.add(field1);
        panel.add(new JLabel("Company:"));
        panel.add(field2);
        panel.add(new JLabel("Type:"));
        panel.add(field3);
        panel.add(new JLabel("Plane Type:"));
        panel.add(field4);
        panel.add(new JLabel("Total Seat:"));
        panel.add(field5);

        // Tambahkan label dan combo box untuk Flight ID
        panel.add(new JLabel("Plane Code:"));
        JComboBox<String> comboBoxFlightID = new JComboBox<>();
        comboBoxFlightID.addItem(selectedFlightID);
        comboBoxFlightID.setEnabled(false);
        panel.add(comboBoxFlightID);

        JButton updateButton = new JButton("Update");
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateButton.addActionListener(e -> {
            String code = field1.getText();
            String airline = field2.getText();
            String type = field3.getText();
            String planeType = field4.getText();
            int input5 = Integer.parseInt(field5.getText());
            int id =Controller.getInstance().getFlightIdFromPlane(selectedFlightID);
            Controller.getInstance().updateFlight(id, code, airline, type, planeType, input5);
            JOptionPane.showMessageDialog(frame, "Data has been updated", "Information", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose();
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(admin_id, name);
        });
        panel.add(backButton);

        frame.add(panel);
    }

   public void showUpdatePenerbanganWindow(boolean visible) {
        if (visible) {
            createUpdatePenerbanganWindow();
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }
}
