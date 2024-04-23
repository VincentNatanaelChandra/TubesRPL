/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Devid L Manurung
 */
public class Reschedule {
    private int reschedule_id;
    private String reschedule_reason;
    private RescheduleEnum reschedule_status;
    private Date reschedule_date;
    private String reschedule_seat;
    private int ticket_id;
    
    public Reschedule(){
        
    }
    
    public Reschedule(int reschedule_id, int ticket_id, String reschedule_reason, RescheduleEnum reschedule_status, Date reschedule_date, String reschedule_seat) {
        this.reschedule_id = reschedule_id;
        this.ticket_id = ticket_id;
        this.reschedule_reason = reschedule_reason;
        this.reschedule_status = reschedule_status;
        this.reschedule_date = reschedule_date;
        this.reschedule_seat = reschedule_seat;
    }

    public int getReschedule_id() {
        return reschedule_id;
    }

    public void setReschedule_id(int reschedule_id) {
        this.reschedule_id = reschedule_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }
    
    
    public String getReschedule_reason() {
        return reschedule_reason;
    }

    public void setReschedule_reason(String reschedule_reason) {
        this.reschedule_reason = reschedule_reason;
    }

    public RescheduleEnum getReschedule_status() {
        return reschedule_status;
    }

    public void setReschedule_status(RescheduleEnum reschedule_status) {
        this.reschedule_status = reschedule_status;
    }

    public Date getReschedule_date() {
        return reschedule_date;
    }

    public void setReschedule_date(Date reschedule_date) {
        this.reschedule_date = reschedule_date;
    }

    public String getReschedule_seat() {
        return reschedule_seat;
    }

    public void setReschedule_seat(String reschedule_seat) {
        this.reschedule_seat = reschedule_seat;
    }

   
}
