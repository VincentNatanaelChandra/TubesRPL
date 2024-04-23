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
public class Destination {
    private int destination_id;
    private String destination_departure;
    private String destination_arrival;
    private Date destination_departureDate;
    
    public Destination() {
        
    }
    
    public Destination(int destination_id, String destination_departure, String destination_arrival, Date destination_departureDate) {
        this.destination_id = destination_id;
        this.destination_departure = destination_departure;
        this.destination_arrival = destination_arrival;
        this.destination_departureDate = destination_departureDate;
    }

    public int getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(int destination_id) {
        this.destination_id = destination_id;
    }

    public String getDestination_departure() {
        return destination_departure;
    }

    public void setDestination_departure(String destination_departure) {
        this.destination_departure = destination_departure;
    }

    public String getDestination_arrival() {
        return destination_arrival;
    }

    public void setDestination_arrival(String destination_arrival) {
        this.destination_arrival = destination_arrival;
    }

    public Date getDestination_departureDate() {
        return destination_departureDate;
    }

    public void setDestination_departureDate(Date destination_departureDate) {
        this.destination_departureDate = destination_departureDate;
    }
}
