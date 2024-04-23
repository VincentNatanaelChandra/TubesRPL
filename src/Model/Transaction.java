/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Devid L Manurung
 */
public class Transaction {
    private int transaction_id;
    private String transaction_payMethod;
    private double transaction_seatPrice;
    private double transaction_mealPrice;
    private double transaction_promoDiscount;
    private double transaction_totalPrice;
    private ArrayList<Ticket> listTiket;

    public Transaction(int transaction_id, String transaction_payMethod, double transaction_seatPrice, double transaction_mealPrice, double transaction_promoDiscount, double transaction_totalPrice, ArrayList<Ticket> listTiket) {
        this.transaction_id = transaction_id;
        this.transaction_payMethod = transaction_payMethod;
        this.transaction_seatPrice = transaction_seatPrice;
        this.transaction_mealPrice = transaction_mealPrice;
        this.transaction_promoDiscount = transaction_promoDiscount;
        this.transaction_totalPrice = transaction_totalPrice;
        this.listTiket = listTiket;
    }

    public Transaction() {
        
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_payMethod() {
        return transaction_payMethod;
    }

    public void setTransaction_payMethod(String transaction_payMethod) {
        this.transaction_payMethod = transaction_payMethod;
    }

    public double getTransaction_seatPrice() {
        return transaction_seatPrice;
    }

    public void setTransaction_seatPrice(double transaction_seatPrice) {
        this.transaction_seatPrice = transaction_seatPrice;
    }

    public double getTransaction_mealPrice() {
        return transaction_mealPrice;
    }

    public void setTransaction_mealPrice(double transaction_mealPrice) {
        this.transaction_mealPrice = transaction_mealPrice;
    }

    public double getTransaction_promoDiscount() {
        return transaction_promoDiscount;
    }

    public void setTransaction_promoDiscount(double transaction_promoDiscount) {
        this.transaction_promoDiscount = transaction_promoDiscount;
    }

    public double getTransaction_totalPrice() {
        return transaction_totalPrice;
    }

    public void setTransaction_totalPrice(double transaction_totalPrice) {
        this.transaction_totalPrice = transaction_totalPrice;
    }

    public ArrayList<Ticket> getListTiket() {
        return listTiket;
    }

    public void setListTiket(ArrayList<Ticket> listTiket) {
        this.listTiket = listTiket;
    }
}
