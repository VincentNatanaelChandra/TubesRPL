package View;
import Controller.Controller;
import Controller.DateLabelFormatter;
import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.Properties;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class UpdateDestinasi {
    private JFrame frame;
    private JComboBox<String> comboBoxFlightID;
    private int selectedDestinationID;
    private int admin_id;
    private String name;

    public UpdateDestinasi(int selectedDestinationID, int admin_id, String name) {
        this.selectedDestinationID = selectedDestinationID;
        this.admin_id = admin_id;
        this.name = name;
    }

    private void createUpdateDestinasiWindow() {
        frame = new JFrame("Update Destination Menu");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // Ubah tata letak menjadi 6 baris, 2 kolom

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        panel.add(new JLabel("Destination Departure:"));
        panel.add(field1);
        panel.add(new JLabel("Destination Arrival:"));
        panel.add(field2);
        panel.add(new JLabel("Destination Date:"));
        panel.add(datePicker);

        // Tambahkan label dan combo box untuk Flight ID
        panel.add(new JLabel("Destination ID:"));
        String destinationId = String.valueOf(selectedDestinationID);
        comboBoxFlightID = new JComboBox<>();
        comboBoxFlightID.addItem(destinationId); // Set nilai awal Flight ID
        comboBoxFlightID.setEnabled(false); // Agar tidak bisa diubah
        panel.add(comboBoxFlightID);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {
            String code = field1.getText();
            String airline = field2.getText();
            Date date = (java.sql.Date) datePicker.getModel().getValue();
            Controller.getInstance().updateDestination(selectedDestinationID, code, airline, date);
            JOptionPane.showMessageDialog(frame, "Data has been updated", "Notification", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose(); // Menutup jendela UpdateDestinasi
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(admin_id, name);
        });
        panel.add(backButton);

        frame.add(panel);
    }

    // Method untuk membuat Spinner tanggal

    // Method untuk menampilkan atau menyembunyikan frame
    public void showUpdateDestinasiWindow(boolean visible) {
        if (visible) {
            createUpdateDestinasiWindow();
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }
}
