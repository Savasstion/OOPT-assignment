import java.util.ArrayList;
import java.util.Scanner;

public class ticket {
    private String seatID;
    private static int ticketID = 0;
    private int seatBookedNum;
    private double ticketPrice;
    Customer customer;
            ArrayList<ticket> tickets;

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

    public Customer getCustomer() {
        return customer;
    }

    public void removeTicket(int ticketID) {
        for (ticket ticket : tickets) {
            if (ticket.getTicketID() == ticketID) {
                tickets.remove(ticket);
                return; // Exit the loop once the ticket is removed.
            }}
        }

        public void cancelTicket() {
        System.out.print("Enter the Ticket ID to cancel: ");
        Scanner sc = new Scanner(System.in);
        int ticketIDs = sc.nextInt();
        boolean canceled = false;
        for (ticket ticket : tickets) {
            if (ticket.getTicketID() == ticketIDs) {
                ticket.removeTicket(ticketIDs);
                canceled = true;
                System.out.println("Ticket ID " + ticketIDs + " has been canceled.");
                break;
            }
        }
        if (!canceled)
        System.out.println("Ticket ID " + ticketIDs + " could not be found, try again.");
            sc.close();
    }

    @Override
    public String toString() {
        return "Ticket ID: " + String.format("%04d", ticketID) +
               "\nSeat ID: " + seatID +
               "\nSeats Booked: " + seatBookedNum +
               "\nTicket Price: $" + ticketPrice;
    }
}





