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
public class Flight {
    private int flight_id;
    private String flight_planeCode;
    private String flight_company;
    private String flight_type;
    private String flight_planeType;
    private int flight_totalSeat;
    private ArrayList<Seat> listSeat;
    private ArrayList<FoodAndBeverages> listFoodAndBeverages;
    private ArrayList<Destination> listDestination;

    public Flight(int flight_id, String flight_planeCode, String flight_company, String flight_type, String flight_planeType, int flight_totalSeat, ArrayList<Seat> listSeat, ArrayList<FoodAndBeverages> listFoodAndBeverages, ArrayList<Destination> listDestination) {
        this.flight_id = flight_id;
        this.flight_planeCode = flight_planeCode;
        this.flight_company = flight_company;
        this.flight_type = flight_type;
        this.flight_planeType = flight_planeType;
        this.flight_totalSeat = flight_totalSeat;
        this.listSeat = listSeat;
        this.listFoodAndBeverages = listFoodAndBeverages;
        this.listDestination = listDestination;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_planeCode() {
        return flight_planeCode;
    }

    public void setFlight_planeCode(String flight_planeCode) {
        this.flight_planeCode = flight_planeCode;
    }

    public String getFlight_company() {
        return flight_company;
    }

    public void setFlight_company(String flight_company) {
        this.flight_company = flight_company;
    }

    public String getFlight_type() {
        return flight_type;
    }

    public void setFlight_type(String flight_type) {
        this.flight_type = flight_type;
    }

    public String getFlight_planeType() {
        return flight_planeType;
    }

    public void setFlight_planeType(String flight_planeType) {
        this.flight_planeType = flight_planeType;
    }

    public int getFlight_totalSeat() {
        return flight_totalSeat;
    }

    public void setFlight_totalSeat(int flight_totalSeat) {
        this.flight_totalSeat = flight_totalSeat;
    }

    public ArrayList<Seat> getListSeat() {
        return listSeat;
    }

    public void setListSeat(ArrayList<Seat> listSeat) {
        this.listSeat = listSeat;
    }

    public ArrayList<FoodAndBeverages> getListFoodAndBeverages() {
        return listFoodAndBeverages;
    }

    public void setListFoodAndBeverages(ArrayList<FoodAndBeverages> listFoodAndBeverages) {
        this.listFoodAndBeverages = listFoodAndBeverages;
    }

    public ArrayList<Destination> getListDestination() {
        return listDestination;
    }

    public void setListDestination(ArrayList<Destination> listDestination) {
        this.listDestination = listDestination;
    }

   
}
