/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Devid L Manurung
 */
public enum RescheduleEnum {
    RESCHEDULESUCCESS{
        @Override
        public String toString() {
            return "RESCHEDULESUCCESS";
        }
    },
    RESCHEDULEDENIED{
        @Override
        public String toString() {
            return "RESCHEDULEDENIED";
        }
    }
}
