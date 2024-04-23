/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

public class Member extends User{
    private int member_id;
    private String member_email;
    private int member_pinPay;
    private ArrayList<Transaction> listTransaction;
    private ArrayList<Refund> listRefund;
    private ArrayList<Reschedule> listReschedule;

    public Member(int member_id, String member_email, int member_pinPay, ArrayList<Transaction> listTransaction, ArrayList<Refund> listRefund, ArrayList<Reschedule> listReschedule, int user_id, String user_name, String user_password) {
        super(user_id, user_name, user_password);
        this.member_id = member_id;
        this.member_email = member_email;
        this.member_pinPay = member_pinPay;
        this.listTransaction = listTransaction;
        this.listRefund = listRefund;
        this.listReschedule = listReschedule;
    }

    

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public int getMember_pinPay() {
        return member_pinPay;
    }

    public void setMember_pinPay(int member_pinPay) {
        this.member_pinPay = member_pinPay;
    }

    public ArrayList<Transaction> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(ArrayList<Transaction> listTransaction) {
        this.listTransaction = listTransaction;
    }

    public ArrayList<Refund> getListRefund() {
        return listRefund;
    }

    public void setListRefund(ArrayList<Refund> listRefund) {
        this.listRefund = listRefund;
    }

    public ArrayList<Reschedule> getListReschedule() {
        return listReschedule;
    }

    public void setListReschedule(ArrayList<Reschedule> listReschedule) {
        this.listReschedule = listReschedule;
    }
}
