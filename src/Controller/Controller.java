package Controller;

import java.sql.Date;
import java.sql.Types;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Destination;
import Model.Refund;
import Model.RefundEnum;
import Model.Reschedule;
import Model.RescheduleEnum;
import Model.Transaction;


/**
 *
 * @author Vincent
 */
public class Controller {

    private static Controller instance;

    public static synchronized Controller getInstance() {
        if (instance == null) // Lazy instantiation
        {
            instance = new Controller();
        }
        return instance;
    }

    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean getUser(String username, String password) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE cust_name = '" + username + "' AND cust_password = '" + password + "'";
        boolean exists = false;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public String[][] getAllTransactions() {
        ArrayList<ArrayList<String>> arrTrans = new ArrayList<>();
        String query = "SELECT tr.transaction_id, c.cust_id, c.cust_name,d.destination_departureDate, f.flight_company, f.flight_type, tr.transaction_seatPrice, tr.transation_promoDiscount, tr.transaction_totalPrice FROM transaction tr JOIN member m ON tr.member_id = m.member_id JOIN ticket t ON tr.ticket_id = t.ticket_id JOIN flight f ON t.flight_id = f.flight_id JOIN destination d ON f.destination_id = d.destination_id JOIN promo p ON tr.promo_id = p.promo_id JOIN customer c ON m.cust_id = c.cust_id;";

        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int count = 0;
            while (resultSet.next()) {
                arrTrans.add(new ArrayList<>());
                arrTrans.get(count).add(resultSet.getString("transaction_id"));
                arrTrans.get(count).add(resultSet.getString("cust_id"));
                arrTrans.get(count).add(resultSet.getString("cust_name"));
                arrTrans.get(count).add(resultSet.getString("destination_departureDate"));
                arrTrans.get(count).add(resultSet.getString("flight_company"));
                arrTrans.get(count).add(resultSet.getString("flight_type"));
                arrTrans.get(count).add(resultSet.getString("transaction_seatPrice"));
                arrTrans.get(count).add(resultSet.getString("transation_promoDiscount"));
                arrTrans.get(count).add(resultSet.getString("transaction_totalPrice"));
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (arrTrans.size() == 0) {
            return null;
        }

        String[][] transactions = new String[arrTrans.size()][arrTrans.get(0).size()];
        for (int i = 0; i < arrTrans.size(); i++) {
            for (int j = 0; j < arrTrans.get(i).size(); j++) {
                transactions[i][j] = arrTrans.get(i).get(j);
            }
        }
        return transactions;
    }

    public String[][] getAllTransactionsByMemberId(int id) {
        ArrayList<ArrayList<String>> arrTrans = new ArrayList<>();
        String query = "SELECT tr.transaction_id, c.cust_id, c.cust_name,d.destination_departureDate, f.flight_company, f.flight_type, tr.transaction_seatPrice, tr.transation_promoDiscount, tr.transaction_totalPrice FROM transaction tr JOIN member m ON tr.member_id = m.member_id JOIN ticket t ON tr.ticket_id = t.ticket_id JOIN flight f ON t.flight_id = f.flight_id JOIN destination d ON f.destination_id = d.destination_id JOIN promo p ON tr.promo_id = p.promo_id JOIN customer c ON m.cust_id = c.cust_id WHERE m.member_id=" + id +";";

        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int count = 0;
            while (resultSet.next()) {
                arrTrans.add(new ArrayList<>());
                arrTrans.get(count).add(resultSet.getString("transaction_id"));
                arrTrans.get(count).add(resultSet.getString("cust_id"));
                arrTrans.get(count).add(resultSet.getString("cust_name"));
                arrTrans.get(count).add(resultSet.getString("destination_departureDate"));
                arrTrans.get(count).add(resultSet.getString("flight_company"));
                arrTrans.get(count).add(resultSet.getString("flight_type"));
                arrTrans.get(count).add(resultSet.getString("transaction_seatPrice"));
                arrTrans.get(count).add(resultSet.getString("transation_promoDiscount"));
                arrTrans.get(count).add(resultSet.getString("transaction_totalPrice"));
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (arrTrans.size() == 0) {
            return null;
        }

        String[][] transactions = new String[arrTrans.size()][arrTrans.get(0).size()];
        for (int i = 0; i < arrTrans.size(); i++) {
            for (int j = 0; j < arrTrans.get(i).size(); j++) {
                transactions[i][j] = arrTrans.get(i).get(j);
            }
        }
        return transactions;
    }

    public boolean RegisterCustomerData(String username, String password) {
        conn.connect();
        String query = "INSERT INTO customer (cust_name, cust_password) VALUES (?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean RegisterMemberData(String email, String pinPay, int id) {
        conn.connect();
        String query = "INSERT INTO member (member_email, member_pinPay, cust_id) VALUES (?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, pinPay);
            statement.setInt(3, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getIdUser(String username) {
        conn.connect();
        String query = "SELECT cust_id FROM customer WHERE cust_name = '" + username + "'";
        int id = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = (resultSet.getInt("cust_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }

    public boolean getCustomer(String username) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE cust_name = '" + username + "'";
        boolean exists = false;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public static boolean getUserAdmin(String username, String password) {
        conn.connect();
        String query = "SELECT * FROM customer c JOIN admin a on c.cust_id = a.cust_id WHERE "
                + "cust_name = '" + username + "' AND cust_password = '" + password + "'";
        boolean exists = false;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public boolean getRefund() {
        conn.connect();
        String query = "SELECT * FROM refund";

        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // reschedule
    public boolean getReschedule() {
        conn.connect();
        String query = "SELECT * FROM reschedule";

        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public int getIdMember(String username) {
        conn.connect();
        String query = "SELECT m.member_id FROM member m JOIN customer c ON m.cust_id = c.cust_id WHERE c.cust_name = '" + username + "'";
        int id = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = (resultSet.getInt("member_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }

    public boolean getFlight(int flight_id) {
        conn.connect();
        String query = "SELECT * FROM flight WHERE flight_id = '" + flight_id + "'";
        boolean exists = false;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public boolean getDestination(int destination_id) {
        conn.connect();
        String query = "SELECT * FROM destination WHERE destination_id = '" + destination_id + "'";
        boolean exists = false;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public boolean getPromo(String promo_kode) {
        conn.connect();
        String query = "SELECT * FROM promo WHERE promo_code = '" + promo_kode + "'";
        boolean exists = false;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public boolean updateDestination(int destinationInput, int destination_id, String destination_departure, String destination_arrival, Date destination_departureDate) {
        conn.connect();
        String query = "UPDATE destination"
                + " SET destination_id='" + destination_id + "',"
                + "destination_departure='" + destination_departure + "',"
                + "destination_arrival='" + destination_arrival + "',"
                + "destination_departureDate='" + destination_departureDate + "',"
                + "WHERE destination_id = " + destinationInput;
        PreparedStatement stm;
        try {
            stm = conn.con.prepareStatement(query);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> getDeparture() {
        ArrayList<String> listDeparture = new ArrayList<>();
        conn.connect();
        String query = "SELECT DISTINCT destination_departure FROM destination";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listDeparture.add(resultSet.getString("destination_departure"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listDeparture);
    }

    public ArrayList<String> getArrival() {
        ArrayList<String> listArrival = new ArrayList<>();
        conn.connect();
        String query = "SELECT DISTINCT destination_arrival FROM destination";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listArrival.add(resultSet.getString("destination_arrival"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listArrival);
    }

    public ArrayList<String> getAirline() {
        ArrayList<String> listAirline = new ArrayList<>();
        conn.connect();
        String query = "SELECT DISTINCT flight_company FROM flight";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listAirline.add(resultSet.getString("flight_company"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listAirline);
    }

    public ArrayList<Destination> getInsertDestination() {
        conn.connect();
        String query = "SELECT * FROM destination";
        ArrayList<Destination> destinations = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Destination destination = new Destination();
                destination.setDestination_departure(resultSet.getString("destination_departure"));
                destination.setDestination_arrival(resultSet.getString("destination_arrival"));
                destination.setDestination_departureDate(resultSet.getDate("destination_departureDate"));
                destinations.add(destination);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (destinations);
    }

    public String getUsernameMember(int id) {
        conn.connect();
        String query = "SELECT cust_name FROM customer c WHERE cust_id = '" + id + "'";
        String username = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                username = (resultSet.getString("cust_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (username);
    }

    public ArrayList<String> getSeatClass() {
        ArrayList<String> listClass = new ArrayList<>();
        conn.connect();
        String query = "SELECT Class_name FROM classes";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listClass.add(resultSet.getString("Class_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listClass);
    }

    public ArrayList<String> getSeatNumber(int id) {
        ArrayList<String> listSeat = new ArrayList<>();
        conn.connect();
        String query = "SELECT seat_number FROM planeseat WHERE seat_state = 0 && flight_id = " + id + "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listSeat.add(resultSet.getString("seat_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listSeat);
    }

    public boolean requestRefund(int ticket_id, RefundEnum refund_status, double refund_total, String refund_reason) {
        conn.connect();
        String query = "INSERT INTO refund (ticket_id, refund_status, refund_total, refund_reason) VALUES (?, ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.setInt(1, ticket_id);
            statement.setString(2, refund_status.toString());
            statement.setDouble(3, refund_total);
            statement.setString(4, refund_reason);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean requestReshcedule(int ticket_id, RescheduleEnum reschedule_status, String reschedule_reason, Date reschedule_date, String reschedule_seat) {
        conn.connect();
        String query = "INSERT INTO reschedule (ticket_id, reschedule_status, reschedule_reason, reschedule_date, reschedule_seat) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.setInt(1, ticket_id);
            statement.setString(2, reschedule_status.toString());
            statement.setString(3, reschedule_reason);
            statement.setDate(4, reschedule_date);
            statement.setString(5, reschedule_seat);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public double getPromoPercent(String code) {
        conn.connect();
        String query = "SELECT promo_percent FROM promo WHERE promo_code = '" + code + "'";
        double promo = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                promo = (resultSet.getDouble("promo_percent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return promo;
    }

    public int getSeatPrice(String classes) {
        conn.connect();
        String query = "SELECT Class_price FROM classes WHERE Class_name = '" + classes + "'";
        int price = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                price = (resultSet.getInt("Class_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (price);
    }

    public int getFlightId(String company, String departure, String arrival) {
        conn.connect();
        String query = "SELECT f.flight_id FROM flight f JOIN destination d ON f.destination_id = d.destination_id WHERE f.flight_company = '" + company + "' && d.destination_departure = '" + departure + "' && d.destination_arrival = '" + arrival + "'";
        int id = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = (resultSet.getInt("flight_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }

    public boolean registerTicket(int flight, String ticket, Date dateTicket, String preference) {
        conn.connect();
        String query = "INSERT INTO ticket (flight_id, ticket_code, ticket_date, ticket_preference) VALUES (?, ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.setInt(1, flight);
            statement.setString(2, ticket);
            statement.setDate(3, dateTicket);
            statement.setString(4, preference);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean registerTransaction(int ticket, String method, int seatPrice, int promo, int total, int promoId, int memberId) {
        conn.connect();
        String query = "INSERT INTO transaction (ticket_id, transaction_payMethod, transaction_seatPrice, transation_promoDiscount, transaction_totalPrice, promo_id, member_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.setInt(1, ticket);
            statement.setString(2, method);
            statement.setInt(3, seatPrice);
            statement.setInt(4, promo);
            statement.setInt(5, total);
            if (promoId == 0) {
                statement.setNull(6, Types.INTEGER);
            } else {
                statement.setInt(6, promoId);
            }
            statement.setInt(7, memberId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPinpayMember(int id) {
        conn.connect();
        String query = "SELECT member_pinPay FROM member WHERE member_id = '" + id + "'";
        String pinpay = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                pinpay = (resultSet.getString("member_pinPay"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (pinpay);
    }

    public ArrayList<Transaction> getHistoryMember1(int member_id) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM transaction WHERE member_id ='" + member_id + "'";
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Transaction trans = new Transaction();
                trans.setTransaction_id(resultSet.getInt("transaction_id"));
                trans.setTransaction_payMethod(resultSet.getString("transaction_payMethod"));
                trans.setTransaction_seatPrice(resultSet.getDouble("transaction_seatPrice"));
                trans.setTransaction_mealPrice(resultSet.getDouble("transaction_mealPrice"));
                trans.setTransaction_promoDiscount(resultSet.getDouble("transaction_promoDiscount"));
                trans.setTransaction_totalPrice(resultSet.getDouble("transaction_totalPrice"));

                transactions.add(trans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (transactions);
    }

    public ArrayList<Transaction> getHistoryAdmin() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM transaction";
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Transaction trans = new Transaction();
                trans.setTransaction_id(resultSet.getInt("transaction_id"));
                trans.setTransaction_payMethod(resultSet.getString("transaction_payMethod"));
                trans.setTransaction_seatPrice(resultSet.getDouble("transaction_seatPrice"));
                trans.setTransaction_mealPrice(resultSet.getDouble("transaction_mealPrice"));
                trans.setTransaction_promoDiscount(resultSet.getDouble("transaction_promoDiscount"));
                trans.setTransaction_totalPrice(resultSet.getDouble("transaction_totalPrice"));

                transactions.add(trans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (transactions);
    }

    public int getTicketId(String ticket) {
        conn.connect();
        String query = "SELECT ticket_id FROM ticket WHERE ticket_code = '" + ticket + "'";
        int id = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getInt("ticket_id");
            }
            ticket = String.valueOf((int) (Math.random() * 10000));
            System.out.println(ticket);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return id;
    }

    public int getPromoId(String promo_kode) {
        conn.connect();
        String query = "SELECT promo_id FROM promo WHERE promo_code = '" + promo_kode + "'";
        int id = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getInt("promo_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return id;
    }

    public int getTicketIdInt(String ticket) {
        conn.connect();
        String query = "SELECT ticket_id FROM ticket WHERE ticket_code = '" + ticket + "'";
        int id = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = (resultSet.getInt("ticket_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return id;
    }

    public boolean updateFlight(int flight, String plane, String airline, String type, String planetype, int totalSeat) {
        conn.connect();
        String query = "UPDATE flight"
                + " SET flight_planeCode='" + plane + "',"
                + "flight_company='" + airline + "',"
                + "flight_type='" + type + "',"
                + "flight_planeType='" + planetype + "',"
                + "flight_totalSeat='" + totalSeat + "' "
                + "WHERE flight_id = " + flight;
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDestination(int destination, String departure, String arrival, Date destinationDate) {
        conn.connect();
        String query = "UPDATE destination"
                + " SET destination_departure='" + departure + "',"
                + "destination_arrival='" + arrival + "',"
                + "destination_departureDate='" + destinationDate + "' "
                + "WHERE destination_id = " + destination;
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePromo(int promo, String code, String type, Date expired, double percent) {
        conn.connect();
        String query = "UPDATE promo"
                + " SET promo_code='" + code + "',"
                + "promo_type='" + type + "',"
                + "promo_expiredDate='" + expired + "',"
                + "promo_percent='" + percent + "' "
                + "WHERE promo_id = " + promo;
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getFlightDate(String departure, String arrival) {
        conn.connect();
        String query = "SELECT destination_departureDate FROM destination WHERE destination_departure = '" + departure + "' AND destination_arrival = '" + arrival + "'";
        String dateFlight = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                dateFlight = (resultSet.getString("destination_departureDate"));
            }
        } catch (SQLException e) {
            return null;
        }
        return dateFlight;
    }
    
    public Date getFlightDate2(String departure, String arrival) {
        conn.connect();
        String query = "SELECT destination_departureDate FROM destination WHERE destination_departure = '" + departure + "' AND destination_arrival = '" + arrival + "'";
        Date dateFlight = null;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                dateFlight = (resultSet.getDate("destination_departureDate"));
            }
        } catch (SQLException e) {
            return null;
        }
        return dateFlight;
    }

    public boolean updateSeat(String seat) {
        conn.connect();
        String query = "UPDATE planeseat"
                + " SET seat_state= " + 1 + " "
                + "WHERE seat_number = '" + seat + "'";
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getFlightId(String ticket) {
        conn.connect();
        String query = "SELECT flight_id FROM ticket WHERE ticket_code = '" + ticket + "'";
        int id = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = (resultSet.getInt("flight_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return id;
    }

    public boolean getTicket(String ticket) {
        conn.connect();
        String query = "SELECT ticket_code FROM ticket WHERE ticket_code = '" + ticket + "'";
        boolean exists = false;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public ArrayList<Refund> getViewRefund() {
        ArrayList<Refund> refund = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM refund";
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String refundStatusString = resultSet.getString("refund_status");
            RefundEnum refundStatus = RefundEnum.valueOf(refundStatusString);
            while (resultSet.next()) {
                Refund refunds = new Refund();
                refunds.setRefund_id(resultSet.getInt("refund_id"));
                refunds.setTicket_id(resultSet.getInt("ticket_id"));
                refunds.setRefund_status(refundStatus);
                refunds.setRefund_total(resultSet.getInt("refund_total"));
                refunds.setRefund_reason(resultSet.getString("refund_reason"));

                refund.add(refunds);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (refund);
    }

    public ArrayList<Reschedule> getViewReschedule() {
        ArrayList<Reschedule> reschedules = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM reschedule";
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String rescheduleStatusString = resultSet.getString("reschedule_status");
            RescheduleEnum rescheduleStatus = RescheduleEnum.valueOf(rescheduleStatusString);
            while (resultSet.next()) {
                Reschedule listReschedules = new Reschedule();
                listReschedules.setReschedule_id(resultSet.getInt("reschedule_id"));
                listReschedules.setTicket_id(resultSet.getInt("ticket_id"));
                listReschedules.setReschedule_status(rescheduleStatus);
                listReschedules.setReschedule_reason(resultSet.getString("reschedule_reason"));
                listReschedules.setReschedule_date(resultSet.getDate("reschedule_date"));
                listReschedules.setReschedule_seat(resultSet.getString("reschedule_Seat"));

                reschedules.add(listReschedules);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (reschedules);
    }

    public boolean updateRefund(int refund_id) {
        conn.connect();
        String query = "UPDATE refund"
                + " SET refund_status= 'REFUNDSUCCESS' "
                + "WHERE refund_id   = '" + refund_id + "'";
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateReschedule(int reschedule_id) {
        conn.connect();
        String query = "UPDATE reschedule"
                + " SET reschedule_status= 'RESCHEDULESUCCESS' "
                + "WHERE reschedule_id = '" + reschedule_id + "'";
        PreparedStatement statement;
        try {
            statement = conn.con.prepareStatement(query);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Object> getHistory() {
        ArrayList<Object> histories = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT c.cust_name, m.member_id, tck.ticket_id, tck.ticket_code, tck.ticket_date, tck.ticket_preference, t.transaction_id, t.transaction_payMethod, "
                    + "t.transaction_seatPrice, t.transation_promoDiscount, t.transaction_totalPrice, p.promo_id, p.promo_code "
                    + "FROM customer c JOIN member m ON c.cust_id = m.member_id "
                    + "JOIN transaction t ON m.member_id = t.member_id "
                    + "JOIN ticket tck ON t.ticket_id = tck.ticket_id "
                    + "JOIN promo p ON t.promo_id = p.promo_id";
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                histories.add(resultSet.getString("cust_name"));
                histories.add(resultSet.getInt("member_id"));
                histories.add(resultSet.getInt("ticket_id"));
                histories.add(resultSet.getString("ticket_code"));
                histories.add(resultSet.getDate("ticket_date"));
                histories.add(resultSet.getString("ticket_preference"));
                histories.add(resultSet.getInt("transaction_id"));
                histories.add(resultSet.getString("transaction_payMethod"));
                histories.add(resultSet.getInt("transaction_seatPrice"));
                histories.add(resultSet.getInt("transation_promoDiscount"));
                histories.add(resultSet.getInt("transaction_totalPrice"));
                histories.add(resultSet.getInt("promo_id"));
                histories.add(resultSet.getInt("promo_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (histories);
    }

    public ArrayList<Object> getHistoryMember(int member_id) {
        ArrayList<Object> histories = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT c.cust_name, m.member_id, tck.ticket_id, tck.ticket_code, tck.ticket_date, tck.ticket_preference, t.transaction_id, t.transaction_payMethod, "
                    + "t.transaction_seatPrice, t.transation_promoDiscount, t.transaction_totalPrice, p.promo_id, p.promo_code "
                    + "FROM customer c JOIN member m ON c.cust_id = m.member_id "
                    + "JOIN transaction t ON m.member_id = t.member_id "
                    + "JOIN ticket tck ON t.ticket_id = tck.ticket_id "
                    + "JOIN promo p ON t.promo_id = p.promo_id WHERE m.member_id = " + member_id + "";
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                histories.add(resultSet.getString("cust_name"));
                histories.add(resultSet.getInt("member_id"));
                histories.add(resultSet.getInt("ticket_id"));
                histories.add(resultSet.getString("ticket_code"));
                histories.add(resultSet.getDate("ticket_date"));
                histories.add(resultSet.getString("ticket_preference"));
                histories.add(resultSet.getInt("transaction_id"));
                histories.add(resultSet.getString("transaction_payMethod"));
                histories.add(resultSet.getInt("transaction_seatPrice"));
                histories.add(resultSet.getInt("transation_promoDiscount"));
                histories.add(resultSet.getInt("transaction_totalPrice"));
                histories.add(resultSet.getInt("promo_id"));
                histories.add(resultSet.getInt("promo_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (histories);
    }

    public int getTotalPrice(int ticket) {
        conn.connect();
        String query = "SELECT transaction_totalPrice FROM transaction WHERE ticket_id = '" + ticket + "'";
        int price = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                price = (resultSet.getInt("transaction_totalPrice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (price);
    }

    public ArrayList<String> getAllFlightCode() {
        conn.connect();
        String query = "SELECT flight_planeCode FROM flight";
        ArrayList<String> codes = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                codes.add(resultSet.getString("flight_planeCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (codes);
    }

    public int getFlightIdFromPlane(String plane) {
        conn.connect();
        String query = "SELECT flight_id FROM flight WHERE flight_planeCode = '" + plane + "'";
        int id = 0;
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = (resultSet.getInt("flight_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return id;
    }

    public ArrayList<Integer> getDestinationId() {
        conn.connect();
        String query = "SELECT destination_id FROM destination ";
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ids.add(resultSet.getInt("destination_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return ids;
    }

    public ArrayList<Integer> getPromoId() {
        conn.connect();
        String query = "SELECT promo_id FROM promo ";
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ids.add(resultSet.getInt("promo_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return ids;
    }

    public String getPlaneCode(int id) {
        conn.connect();
        String query = "SELECT flight_planeCode FROM flight WHERE flight_id = '" + id + "'";
        String code = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                code = (resultSet.getString("flight_planeCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (code);
    }
    
    public ArrayList<Integer> getTicketMemberIdInt(int member_id) {
        ArrayList<Integer> listTicket = new ArrayList<>();
        conn.connect();
        String query = "SELECT ticket_id FROM transaction WHERE member_id = '" + member_id + "'";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listTicket.add(resultSet.getInt("ticket_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listTicket);
    }
    
    public String getTicketKode(int ticketId) {
        conn.connect();
        String query = "SELECT ticket_code FROM ticket WHERE ticket_id = '" + ticketId + "'";
        String kode = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                kode = resultSet.getString("ticket_code");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return kode;
    }
    
    public ArrayList<Integer> getRescheduleId() {
        ArrayList<Integer> listReschedule = new ArrayList<>();
        conn.connect();
        String query = "SELECT reschedule_id FROM reschedule";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listReschedule.add(resultSet.getInt("reschedule_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listReschedule);
    }
    
    public ArrayList<Integer> getRefundId() {
        ArrayList<Integer> listRefund = new ArrayList<>();
        conn.connect();
        String query = "SELECT refund_id FROM refund";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                listRefund.add(resultSet.getInt("refund_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listRefund);
    }
    
    public String getRescheduleDate(int rescheduleId) {
        conn.connect();
        String query = "SELECT reschedule_date FROM reschedule WHERE reschedule_id = '" + rescheduleId + "'";
        String dateFlight = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                dateFlight = (resultSet.getString("reschedule_date"));
            }
        } catch (SQLException e) {
            return null;
        }
        return dateFlight;
    }
    
    public String getTicketIdRechedule(int rescheduleId) {
        conn.connect();
        String query = "SELECT ticket_id FROM reschedule WHERE reschedule_id = '" + rescheduleId + "'";
        String id = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getString("ticket_id");
                System.out.println("id = " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return id;
    }
    
    public String getRescheduleReason(int rescheduleId) {
        conn.connect();
        String query = "SELECT reschedule_reason FROM reschedule WHERE reschedule_id = '" + rescheduleId + "'";
        String rescheduleReason = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                rescheduleReason = (resultSet.getString("reschedule_reason"));
            }
        } catch (SQLException e) {
            return null;
        }
        return rescheduleReason;
    }
    
    public String getRescheduleSeat(int rescheduleId) {
        conn.connect();
        String query = "SELECT reschedule_seat FROM reschedule WHERE reschedule_id = '" + rescheduleId + "'";
        String rescheduleSeat = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                rescheduleSeat = (resultSet.getString("reschedule_seat"));
            }
        } catch (SQLException e) {
            return null;
        }
        return rescheduleSeat;
    }
    
    public String getTicketIdRefund(int refundId) {
        conn.connect();
        String query = "SELECT ticket_id FROM refund WHERE refund_id = '" + refundId + "'";
        String id = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getString("ticket_id");
                System.out.println("id = " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return id;
    }
    
    public String getRefundReason(int refundId) {
        conn.connect();
        String query = "SELECT refund_reason FROM refund WHERE refund_id = '" + refundId + "'";
        String refundReason = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                refundReason = (resultSet.getString("refund_reason"));
            }
        } catch (SQLException e) {
            return null;
        }
        return refundReason;
    }
    
    public String getRefundTotal(int refundId) {
        conn.connect();
        String query = "SELECT refund_total FROM refund WHERE refund_id = '" + refundId + "'";
        String refundTotal = "";
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                refundTotal = (resultSet.getString("refund_total"));
            }
        } catch (SQLException e) {
            return null;
        }
        return refundTotal;
    }
    
    
}


