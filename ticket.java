import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ticket {
    private int ticketID = 0;
    private int seatBookedNum;
    private double ticketPrice;
    Customer customer;
    private List<String> seatIDs;
    private static List<ticket> tickets = new ArrayList<>();
    
    public ticket(List<String> seatIDs, int seatBookedNum, double ticketPrice, Customer customer) {
        this.seatIDs = seatIDs;
        this.ticketID = tickets.size() + 1; // Assign a unique ticket ID
        this.seatBookedNum = seatIDs.size();
        this.ticketPrice = ticketPrice;
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
        

    public static void purchaseTicket() {
        Scanner scanner = new Scanner(System.in);
        boolean continueBooking = true;
        
        while (continueBooking) {
            System.out.println("1. Purchase Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                     System.out.println("Available Halls:");
        // Display available halls logic
        
        System.out.print("Enter the Hall number you want to purchase a ticket for: ");
        int hallNum = scanner.nextInt();
        
        // Display available seats logic (loop through the cinema hall)
        CinemaHall hall = CinemaHall.getCinemaHall(hallNum);
        hall.printSeatPlan();
        
        List<String> selectedSeats = new ArrayList<>();
        boolean selectingSeats = true;
        
        while (selectingSeats) {
            System.out.print("Enter the seat ID you want to purchase (or 'N' to stop): ");
            String seatID = scanner.next();
            
            if (seatID.equalsIgnoreCase("N")) {
                selectingSeats = false;
            } else {
                Seat seat = hall.getSeatBySeatID(seatID);
                
                if (seat != null && !seat.isSeatAssigned()) {
                    selectedSeats.add(seatID);
                    System.out.println("Seat " + seatID + " added to your selection.");
                } else {
                    System.out.println("Seat " + seatID + " is not available or does not exist.");
                }
            }
        }
        
        if (!selectedSeats.isEmpty()) {
            System.out.print("Enter your name: ");
            String customerName = scanner.next();
            System.out.print("Enter your age: ");
            int customerAge = scanner.nextInt();
            System.out.print("Are you a member? (true/false): ");
            boolean isMember = scanner.nextBoolean();
            System.out.print("Enter your password: ");
            String password = scanner.next();
            
            // Create a Customer object
            Customer customer = new Customer(customerAge, isMember, customerName, password);
            
            // Calculate ticket price (you may need to add appropriate logic)
            double ticketPrice = calculateTotalTicketPrice(hall, selectedSeats);
            
            // Create a new ticket
            ticket newTicket = new ticket(selectedSeats, selectedSeats.size(), ticketPrice, customer);
            
            // Add the ticket to the list
            tickets.add(newTicket);
            
            // Mark selected seats as assigned
            for (String seatID : selectedSeats) {
                Seat seat = hall.getSeatBySeatID(seatID);
                seat.setSeatAssigned(true);
            }
            
            System.out.println("Ticket(s) purchased successfully!");
        } else {
            System.out.println("No seats selected for purchase.");
        }
    
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    continueBooking = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }}
            scanner.close();
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

    public static double calculateTotalTicketPrice(CinemaHall hall, List<String> selectedSeats) {
        // Implement your ticket price calculation logic here
        double totalTicketPrice = 0.0;
        
        // You should calculate the price for each seat and add it to totalTicketPrice
        
        return totalTicketPrice;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + String.format("%04d", ticketID) +
               "\nSeat ID: " + seatIDs +
               "\nSeats Booked: " + seatBookedNum +
               "\nTicket Price: $" + ticketPrice;
    }

}
