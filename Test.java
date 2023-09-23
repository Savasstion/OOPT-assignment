/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author savas
 */
public class Test {
    public static void main(String[] args){
    SeatAvailMenu menu = new SeatAvailMenu();
    String userSeatInput = "1A01";
    
    
        System.out.println((Integer.parseInt(userSeatInput.substring(2, 4))));
        //System.out.println(Integer.toString(1) + Character.toString('A') + Character.toString('0') + Integer.toString(1));
    }
}
