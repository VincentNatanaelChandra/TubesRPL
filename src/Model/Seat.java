/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Devid L Manurung
 */
public class Seat {
    private int seat_id;
    private String seat_class;
    private String seat_number;
    private int seat_state;

    public Seat(int seat_id, String seat_class, String seat_number, int seat_state) {
        this.seat_id = seat_id;
        this.seat_class = seat_class;
        this.seat_number = seat_number;
        this.seat_state = seat_state;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_class() {
        return seat_class;
    }

    public void setSeat_class(String seat_class) {
        this.seat_class = seat_class;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public int getSeat_state() {
        return seat_state;
    }

    public void setSeat_state(int seat_state) {
        this.seat_state = seat_state;
    }
}
