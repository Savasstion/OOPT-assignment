
public class ticket {
    private String seatID;
    private static int ticketID = 0;
    private int seatBookedNum;
    private double ticketPrice;
    Customer customer;

        //format is "hallNum + row + col".
        //"1A01" means hall 1,A means row 1, 01 mean column 1
        
    public ticket(String seatID, int seatBookedNum, double ticketPrice, Customer customer) {
        this.seatID = seatID;
        ticketID = ticketID++;
        this.seatBookedNum = seatBookedNum;
        this.ticketPrice = ticketPrice;
        this.customer = customer;
    }

    public String getSeatID() {
        return seatID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public int getSeatBookedNum() {
        return seatBookedNum;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }


    @Override
    public String toString() {
        return "Ticket ID: " + String.format("%04d", ticketID) +
               "\nSeat ID: " + seatID +
               "\nSeats Booked: " + seatBookedNum +
               "\nTicket Price: $" + ticketPrice;
    }
}





