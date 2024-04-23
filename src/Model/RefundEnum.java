/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Devid L Manurung
 */
public enum RefundEnum {
    REFUNDSUCCESS{
        @Override
        public String toString() {
            return "REFUNDSUCCESS";
        }
    },
    REFUNDDENIED{
        @Override
        public String toString() {
            return "REFUNDDENIED";
        }
    }
}
