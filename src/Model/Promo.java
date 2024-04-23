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
public class Promo {
    private int promo_id;
    private String promo_code;
    private String promo_type;
    private Date promo_expiredDate;

    public Promo(int promo_id, String promo_code, String promo_type, Date promo_expiredDate) {
        this.promo_id = promo_id;
        this.promo_code = promo_code;
        this.promo_type = promo_type;
        this.promo_expiredDate = promo_expiredDate;
    }

    public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }

    public String getPromo_code() {
        return promo_code;
    }

    public void setPromo_code(String promo_code) {
        this.promo_code = promo_code;
    }

    public String getPromo_type() {
        return promo_type;
    }

    public void setPromo_type(String promo_type) {
        this.promo_type = promo_type;
    }

    public Date getPromo_expiredDate() {
        return promo_expiredDate;
    }

    public void setPromo_expiredDate(Date promo_expiredDate) {
        this.promo_expiredDate = promo_expiredDate;
    }
            
}
