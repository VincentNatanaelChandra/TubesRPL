/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Devid L Manurung
 */
public class Refund {
    private int refund_id;
    private RefundEnum refund_status;
    private double refund_total;
    private String refund_reason;
    private int ticket_id;

    public Refund(){
        
    }

    public Refund(int refund_id, RefundEnum refund_status, double refund_total, String refund_reason, int ticket_id) {
        this.refund_id = refund_id;
        this.refund_status = refund_status;
        this.refund_total = refund_total;
        this.refund_reason = refund_reason;
        this.ticket_id = ticket_id;
    }

    public int getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(int refund_id) {
        this.refund_id = refund_id;
    }

    public RefundEnum getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(RefundEnum refund_status) {
        this.refund_status = refund_status;
    }

    public double getRefund_total() {
        return refund_total;
    }

    public void setRefund_total(double refund_total) {
        this.refund_total = refund_total;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }
    
    
   
}
