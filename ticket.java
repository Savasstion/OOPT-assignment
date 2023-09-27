import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ticket {
    private int ticketID = 0;
    private int seatBookedNum;
    private static double ticketPrice;
    Customer customer;
    private List<String> seatIDs;
    private static List<ticket> tickets = new ArrayList<>();
    public ticket(List<String> seatIDs, int seatBookedNum, double ticketPrice, Customer customer) {
        this.seatIDs = seatIDs;
        this.ticketID = tickets.size() + 1; // Assign a unique ticket ID
        this.seatBookedNum = seatIDs.size();
        this.customer = customer;
        // Add the ticket to the list of tickets
        tickets.add(this);
    }

    public List<String> getSeatID() {
        return seatIDs;
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
       

    public static void cancelTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Ticket ID to cancel: ");
        int ticketID = scanner.nextInt();
        boolean canceled = false;
        
        for (ticket ticket : tickets) {
            if (ticket.getTicketID() == ticketID) {
                // Remove the ticket from the list
                tickets.remove(ticket);
                
                // Unmark the seats as assigned
                for (String seatID : ticket.getSeatID()) {
                    CinemaHall hall = CinemaHall.getCinemaHall(Integer.parseInt(seatID.substring(0, 1)));
                    Seat seat = hall.getSeatBySeatID(seatID);
                    seat.setSeatAssigned(false);
                }
                
                canceled = true;
                System.out.println("Ticket ID " + ticketID + " has been canceled.");
                break;
            }
        }
        
        if (!canceled) {
            System.out.println("Ticket ID " + ticketID + " could not be found, try again.");
        }
        scanner.close();
    }

    public static void calculateTotalTicketPrice(int seats) {
        Consumable consume;
        double foodprice = consume.getFoodTotal();
        double totalSeatPrice = (seats * Seat.getSeatPrice()) + foodprice;
        ticketPrice = totalSeatPrice;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + String.format("%04d", ticketID) +
               "\nSeat ID(s): " + seatIDs +
               "\nSeats Booked: " + seatBookedNum +
               "\nTicket Price: $" + ticketPrice;
    }

}
