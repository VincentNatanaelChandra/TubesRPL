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
public class Ticket {
    private int ticket_id;
    private String ticket_code;
    private ArrayList<Promo> listPromo;
    private FlightPreferenceEnum flighPreference;

    public Ticket(int ticket_id, String ticket_code, ArrayList<Promo> listPromo, FlightPreferenceEnum flighPreference) {
        this.ticket_id = ticket_id;
        this.ticket_code = ticket_code;
        this.listPromo = listPromo;
        this.flighPreference = flighPreference;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTicket_code() {
        return ticket_code;
    }

    public void setTicket_code(String ticket_code) {
        this.ticket_code = ticket_code;
    }

    public ArrayList<Promo> getListPromo() {
        return listPromo;
    }

    public void setListPromo(ArrayList<Promo> listPromo) {
        this.listPromo = listPromo;
    }

    public FlightPreferenceEnum getFlighPreference() {
        return flighPreference;
    }

    public void setFlighPreference(FlightPreferenceEnum flighPreference) {
        this.flighPreference = flighPreference;
    }
}
