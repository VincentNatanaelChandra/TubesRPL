/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Devid L Manurung
 */
public class FoodAndBeverages {
    private int fnb_id;
    private String fnb_menu;
    private double fnb_price;
    private int fnb_quantity;

    public FoodAndBeverages(int fnb_id, String fnb_menu, double fnb_price, int fnb_quantity) {
        this.fnb_id = fnb_id;
        this.fnb_menu = fnb_menu;
        this.fnb_price = fnb_price;
        this.fnb_quantity = fnb_quantity;
    }

    public int getFnb_id() {
        return fnb_id;
    }

    public void setFnb_id(int fnb_id) {
        this.fnb_id = fnb_id;
    }

    public String getFnb_menu() {
        return fnb_menu;
    }

    public void setFnb_menu(String fnb_menu) {
        this.fnb_menu = fnb_menu;
    }

    public double getFnb_price() {
        return fnb_price;
    }

    public void setFnb_price(double fnb_price) {
        this.fnb_price = fnb_price;
    }

    public int getFnb_quantity() {
        return fnb_quantity;
    }

    public void setFnb_quantity(int fnb_quantity) {
        this.fnb_quantity = fnb_quantity;
    }
}
