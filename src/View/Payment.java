/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Payment {

    private JFrame formPayment;
    private JFrame formPinpay;
    private JFrame ticket;
    private JPasswordField pinField;
    private int member_id;
    private String name;
    private String departureCity;
    private String arrivalCity;
    private Date dateFlight;
    private String airlines;
    private String classSeat;
    private String seatNum;
    private String preference;
    private String fnb;
    private int ticketPrice;
    private int promoDisc;
    private int flightId;
    private String method;
    private int finalPrice;
    private int promo_id;

    public Payment(int id, String name, String departureCity, String arrivalCity, Date dateFlight, String airlines, String classSeat, String seatNum, String preference, String fnb, int ticketPrice, int promo_id, int promoDisc, int flightId) {
        this.member_id = id;
        this.name = name;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.dateFlight = dateFlight;
        this.airlines = airlines;
        this.classSeat = classSeat;
        this.seatNum = seatNum;
        this.preference = preference;
        this.fnb = fnb;
        this.ticketPrice = ticketPrice;
        this.promo_id = promo_id;
        this.promoDisc = promoDisc;
        this.flightId = flightId;
        Payment();
    }

    private void Payment() {
        //=============BAGIAN CONTAINER================
        formPayment = new JFrame("Payment Menu");
        formPayment.setSize(650, 400);
        formPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formPayment.setLocationRelativeTo(null);
        formPayment.setLayout(null);
        //================END CONTAINER=================

        JLabel labelTitle = new JLabel("Order Confirmation");
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(20, 5, 300, 30);
        formPayment.add(labelTitle);

        JLabel labelName = new JLabel("Customer : " + name);
        labelName.setBounds(20, 40, 200, 30);
        formPayment.add(labelName);

        Object[][] dataTicket = {
            {departureCity, arrivalCity, dateFlight, airlines, preference, fnb, classSeat, seatNum, ticketPrice}
        };

        String[] columnNames = {"Departure", "Arrival", "Date", "Arilines", "Preference", "Food", "Class", "Seat", "Price"};

        DefaultTableModel model = new DefaultTableModel(dataTicket, columnNames);

        JTable tablePurchase = new JTable(model);
        JScrollPane scrollPanel = new JScrollPane(tablePurchase);
        scrollPanel.setBounds(20, 75, 600, 95);
        formPayment.getContentPane().add(scrollPanel);

        //Payment Method
        JLabel labelpaymentMethod = new JLabel("Choose your Payment Method :");
        labelpaymentMethod.setBounds(20, 175, 250, 30);
        formPayment.add(labelpaymentMethod);
        //ComboBox payment Method
        String paymentMethod[] = {"Debit Mastercard", "Virtual Account"};
        JComboBox comboBoxPaymentMethod = new JComboBox(paymentMethod);
        comboBoxPaymentMethod.setBounds(210, 175, 150, 30);
        formPayment.add(comboBoxPaymentMethod);
        
        method = (String) comboBoxPaymentMethod.getSelectedItem();

        //Promo Code
        JLabel labelPromoCode = new JLabel("Promo Code :");
        labelPromoCode.setBounds(20, 210, 100, 30);
        formPayment.add(labelPromoCode);
        JTextField textPromo = new JTextField();
        textPromo.setBounds(115, 210, 150, 30);
        formPayment.add(textPromo);
        //Button Promo Code
        JButton buttonPromo = new JButton("Redeem Code");
        buttonPromo.setBounds(270, 215, 130, 20);
        formPayment.add(buttonPromo);

        buttonPromo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String promoCode = textPromo.getText();
                boolean found = Controller.getInstance().getPromo(promoCode);
                
                if (found) {
                    int promo_id = Controller.getInstance().getPromoId(promoCode);
                    double discount = Controller.getInstance().getPromoPercent(promoCode);
                    double totalPromo = ticketPrice * discount;
                    int promo = (int) totalPromo;
                    formPayment.dispose();
                    new Payment(member_id, name, departureCity, arrivalCity, dateFlight, airlines, classSeat, seatNum, preference, fnb, ticketPrice, promo_id, promo, flightId);
                } else {
                    JOptionPane.showMessageDialog(formPayment, "Promo Not Found!", "WARNING", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JLabel line = new JLabel("___________________________"
                + "__________________________");
        Font fontLine = new Font("Arial", Font.BOLD, 20);
        line.setFont(fontLine);
        line.setBounds(20, 220, 650, 30);
        formPayment.add(line);

        JLabel harga = new JLabel("Ticket Price : " + ticketPrice);
        harga.setBounds(450, 245, 200, 20);
        formPayment.add(harga);

        JLabel hargaPromo = new JLabel("Promo : " + promoDisc);
        hargaPromo.setBounds(450, 265, 100, 20);
        formPayment.add(hargaPromo);

        finalPrice = ticketPrice - promoDisc;
        JLabel hargaAfter = new JLabel("Total Payment : " + (ticketPrice - promoDisc));
        hargaAfter.setBounds(450, 285, 200, 20);
        formPayment.add(hargaAfter);

        JButton buttonConfirmPayment = new JButton("Confirmation Payment");
        buttonConfirmPayment.setBounds(110, 315, 400, 25);
        formPayment.add(buttonConfirmPayment);

        buttonConfirmPayment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PinEntryGUI();
                formPinpay.setVisible(true);
            }
        });

        //Controller Inser Data
        formPayment.setVisible(true);
    }

    private void PinEntryGUI() {
        formPinpay = new JFrame("PIN Entry");
        formPinpay.setSize(300, 400);

        pinField = new JPasswordField();
        pinField.setFont(new Font("Arial", Font.PLAIN, 20));
        pinField.setEditable(false); // Set to false to prevent manual input
        pinField.setEchoChar('*'); // Set echo character to '*'

        JPanel buttonPanel = createButtonPanel();

        // Set layout and add components
        formPinpay.setLayout(new BorderLayout());
        formPinpay.add(pinField, BorderLayout.NORTH);
        formPinpay.add(buttonPanel, BorderLayout.CENTER);

    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 3)); // 4 rows, 3 columns

        // Add buttons for numbers 1-9 and 0
        for (int i = 1; i <= 9; i++) {
            addButton(panel, String.valueOf(i));
        }

        addButton(panel, "0"); // Add button for number 0

        return panel;
    }

    private void addButton(JPanel panel, String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] currentPin = pinField.getPassword();
                pinField.setText(new String(currentPin) + label);

                // Check PIN if it has reached 6 digits
                if (pinField.getPassword().length == 6) {
                    checkPin();
                }
            }
        });
        panel.add(button);
    }

    private void checkPin() {
        char[] enteredPin = pinField.getPassword();
        // Convert char array to String for further processing
        String pinString = new String(enteredPin);
        String memberPin = Controller.getInstance().getPinpayMember(member_id);

        if (pinString == null ? memberPin == null : pinString.equals(memberPin)) {
            formPinpay.dispose();
            formPayment.dispose();
            insertTicket();
        } else {
            JOptionPane.showMessageDialog(formPinpay, "Wrong Pinpay!", "WARNING", JOptionPane.WARNING_MESSAGE);
            pinField.setText("");
        }
    }

    private void insertTicket() {

        
        //Generate Ticker Code
        String ticketCode = String.valueOf((int) (Math.random() * 10000));
        
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
        
        //Insert Data
        Controller.getInstance().registerTicket(flightId, ticketCode, sqlDate, preference);
        int ticket_id = Controller.getInstance().getTicketIdInt(ticketCode);
        System.out.println(ticket_id);
        Controller.getInstance().registerTransaction(ticket_id, method, ticketPrice, promoDisc, finalPrice, promo_id, member_id);
        
        JOptionPane.showMessageDialog(formPayment, "Done", "Done ga bang?", JOptionPane.PLAIN_MESSAGE);
        new MainMenuUser(member_id, name);
    }
}
