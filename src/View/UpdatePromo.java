package View;

import Controller.DateLabelFormatter;
import javax.swing.*;
import java.awt.*;
import Controller.Controller;
import java.util.Calendar;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Properties;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class UpdatePromo {
    private JFrame frame;
    private JComboBox<String> comboBoxFlightID;
    private int selectedPromoID;
    private int admin_id;
    private String name;
    
    public UpdatePromo(int selectedPromoID, int admin_id, String name) {
        this.selectedPromoID = selectedPromoID;
        this.admin_id = admin_id;
        this.name = name;
    }

    private void createUpdatePromoWindow() {
        frame = new JFrame("Update Promo Menu");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        panel.add(new JLabel("Promo Code :"));
        panel.add(field1);
        panel.add(new JLabel("Promo Type :"));
        panel.add(field2);
        panel.add(new JLabel("Expired Date:"));
        panel.add(datePicker);

        JTextField field5 = new JFormattedTextField(NumberFormat.getNumberInstance()); // Menggunakan JFormattedTextField
        panel.add(new JLabel("Persen Promo"));
        panel.add(field5);

        panel.add(Box.createVerticalGlue());

        JButton updateButton = new JButton("Update");
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateButton.addActionListener(e -> {
            String promoCode = field1.getText();
            String promoType = field2.getText();
            Date expiredDate = (Date) (java.sql.Date) datePicker.getModel().getValue();
            double percentPromo = 0.0; // Inisialisasi variabel untuk persen promo
            try {
                percentPromo = Double.parseDouble(field5.getText()); // Mengambil nilai dari field "Persen Promo"
            } catch (NumberFormatException ex) {
                // Penanganan jika input tidak valid (bukan angka)
                JOptionPane.showMessageDialog(frame, "Invalid input for percent promo", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Keluar dari actionPerformed jika input tidak valid
            }
            Controller.getInstance().updatePromo(selectedPromoID, promoCode, promoType, expiredDate, percentPromo);
            // Lakukan sesuatu dengan nilai percentPromo

            JOptionPane.showMessageDialog(frame, "Data has been updated", "Notification", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose(); // Menutup jendela UpdatePromo
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(admin_id, name); // Menampilkan kembali Main Menu Admin
        });
        panel.add(backButton);

        frame.add(panel);
    }

    public void showUpdatePromoWindow(boolean visible) {
        if (visible) {
            createUpdatePromoWindow();
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }
}
