package View;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

public class ViewHistory {
    private JTable table;
    private JPanel panel;
    private JFrame frame;
    private int admin_id;
    private String name;
    
    public ViewHistory(int admin_id, String name) {
        this.admin_id = admin_id;
        this.name = name;
    }   

    private void createViewHistory(int admin_id, String name) {
        frame = new JFrame();
        frame.setTitle("Ticket Information");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columns = {
                "ID Transaksi",
                "ID Pelanggan",
                "Nama Pelanggan",
                "Tanggal Penerbangan",
                "Maskapai",
                "Tipe penerbangan",
                "Harga perkusi",
                "Diskon Promosi",
                "Total Biaya"
        };

        String[][] data = Controller.getInstance().getAllTransactions();

        String[] columnNames = { "Departure", "Arrival", "Date", "Arilines", "Preference", "Food", "Class", "Seat",
                "Price" };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Membuat JTable
        table = new JTable(data, columns);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Mengatur tampilan JScrollPane agar tabel dapat di-scroll jika data melebihi
        // ruang tampilan
        JScrollPane scrollPane = new JScrollPane(table);

        // Membuat panel baru dan menambahkan komponen-komponen di dalamnya
        panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose(); // Menutup jendela ViewHistory
            new MainMenuAdmin(admin_id, name); // Menampilkan kembali Main Menu Admin
        });
        panel.add(backButton, BorderLayout.SOUTH);

        frame.add(panel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void showViewHistoryWindow(boolean visible) {
        if (visible) {
            System.out.println("Rescedule Confirm Window");
            createViewHistory(admin_id,  name);
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }

}
