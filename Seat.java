/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author savas
 */
public class Seat {

    private String seatID;
    private boolean seatAssigned;
    private static double seatPrice = 12.0;

    public Seat() {

    }

    public Seat(String seatID, boolean seatAssigned) {
        this.seatID = seatID;
        this.seatAssigned = seatAssigned;
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(int hallNum, char row, int col) {
        //format is "hallNum + row + col".
        //"1A01" means hall 1,A means row 1, 01 mean column 1
        row = Character.toUpperCase(row);
        if (row >= 'A' && row < ('A' + (CinemaHall.getTotalHalls() - 1))) {
            if (col > 0 && col <= CinemaHall.getTotalSeatCols() && col < 10) {
                this.seatID = Integer.toString(hallNum) + Character.toString((char)row) + Character.toString('0') + Integer.toString(col);
            } else if (col >= 10 && col <= CinemaHall.getTotalSeatCols()) {
                this.seatID = Integer.toString(hallNum) + Character.toString((char)row) + Integer.toString(col);
            } else {
                System.out.println("Invalid parameter!");
            }
        }
    }

    public void setSeatID(int hallNum, int row, int col) {
        //format is "hallNum + row + col".
        //"1A01" means hall 1,A means row 1, 01 mean column 1

        //plus 64 to at least get 'A'
        row += 64;
        char rowChar = (char) row;
        if (rowChar >= 'A' && rowChar < ('A' + (CinemaHall.getTotalHalls() - 1))) {
            if (col > 0 && col <= CinemaHall.getTotalSeatCols()) {
                this.seatID = Integer.toString(hallNum) + row + '0' + Integer.toString(hallNum);
            } else if (col >= 10 && col <= CinemaHall.getTotalSeatCols()) {
                this.seatID = Integer.toString(hallNum) + row + Integer.toString(hallNum);
            } else {
                System.out.println("Invalid parameter!");
            }
        }
    }

    public boolean isSeatAssigned() {
        return seatAssigned;
    }

    public void setSeatAssigned(boolean seatAssigned) {
        this.seatAssigned = seatAssigned;
    }

    public static double getSeatPrice() {
        return seatPrice;
    }

    public static void setSeatPrice(double seatPrice) {
        Seat.seatPrice = seatPrice;
    }

    public char displayAvail() {
        if (seatAssigned) {
            return 'X';
        } else {
            return ' ';
        }
    }

}
