import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args)  {
        final String logo = "  _____ _                            \n" +
        " / ____(_)                           \n" +
        "| |     _ _ __   ___ _ __ ___   __ _ \n" +
        "| |    | | '_ \\ / _ \\ '_ ` _ \\ / _` |\n" +
        "| |____| | | | |  __/ | | | | | (_| |\n" +
        " \\_____|_|_| |_|\\___|_| |_| |_|\\__,_|\n";
        boolean userInputIsValid = true;
        String command = "cls";
        FoodMenu menu = new FoodMenu();
        Scanner sc = new Scanner(System.in);

        do {
            menu.displayOptions(userInputIsValid);

            String userInput = sc.nextLine();
            if (menu.validateOption(userInput)) {
                menu.doMenuTask(userInput.charAt(0));
                userInputIsValid = true;
            } else {
                userInputIsValid = false;
                //clear screen fuction, (need help in this to clear terminal)
                try {
                    // Execute the command to clear the terminal
                    Process process = new ProcessBuilder(command).inheritIO().start();
                    process.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (userInputIsValid == false);


    
        int option = 0;
        ArrayList<movie> movieNames = new ArrayList<movie>();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Scanner select = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);

        do {
            System.out.println("------------------------------------");
            System.out.println(logo);
            System.out.println("------------------------------------\n");
            System.out.println("Please Enter 1 to Display movieNames");
            System.out.println("Please Enter 2 to Buy Tickets");
            System.out.println("Please Enter 3 to Cancel Tickets");
            System.out.println("Please Enter 4 to Exit\n");

            System.out.print("Enter Option: ");
            option = select.nextInt();

            if (option == 1) {
                // Display movieNames
                System.out.println("DISPLAY movieNameS Selected");
                System.out.println("-------------------------\n");
                for (int i = 0; i < movieNames.size(); i++) {
                    int movieNameNumber = i + 1;
                    System.out.println("movieName Number: " + movieNameNumber);
                    System.out.println("movieName Name: " + movieNames.get(i).getmovieNameName());
                    System.out.println("movieName Date: " + movieNames.get(i).getmovieNameDate());
                    System.out.println("\n");
                }
                System.out.println("End of movieName List.\n");
            }

            if (option == 2) {
                // Buy Tickets
                System.out.println("BUY TICKETS Selected");
                System.out.println("-------------------------\n");
                Random rnd = new Random();
                int costumerId = rnd.nextInt(999);
                Customer customer = new Customer(costumerId);
                customers.add(customer);

                for (int i = 0; i < movieNames.size(); i++) {
                    int movieNameNumber = i + 1;
                    System.out.println("movieName Number: " + movieNameNumber);
                    System.out.println("movieName Name:   " + movieNames.get(i).getmovieNameName());
                    System.out.println("movieName Date:   " + movieNames.get(i).getmovieNameDate());
                    System.out.print("\n");
                }

                System.out.println("-------------------------");
                System.out.print("Enter the movieName number: ");
                int movieNameNumber = choice.nextInt();
                int repeat = 0;
                System.out.println();
                do {
                    movieNames.get(movieNameNumber - 1).getTheatre().printSeatPlan();
                    System.out.print("Enter the row: ");
                    int selectedRow = choice.nextInt();
                    System.out.print("Enter the seat: ");
                    int selectedSeat = choice.nextInt();
                    System.out.println();
                    Booking booking = new Booking(customer, movieNames.get(movieNameNumber - 1));
                    if (booking.reserveSeat(selectedRow - 1, selectedSeat - 1)) {
                        System.out.println("The seat is now reserved for you.");
                    } else {
                        System.out.println("Sorry, the seat is already reserved.");
                    }
                    System.out.println();
                    System.out.print("Enter 1 to reserve another seat or 2 to check out: ");
                    repeat = choice.nextInt();
                } while (repeat == 1);

                System.out.println();
                System.out.println("Your Bill");
                System.out.println("-------------------------");
                int totalCost = 0;
                for (Booking booking : customers.get(customers.size() - 1).getBookings()) {
                    totalCost += booking.getCost();
                }
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Total costs: " + totalCost + " Euro");
                System.out.println();
            }

            if (option == 3) {
                // Cancel Tickets
                System.out.println("CANCEL TICKETS Selected");
                System.out.println("-------------------------\n");
                System.out.print("Enter the customer ID: ");
                int customerId = choice.nextInt();
                for (Customer customer : customers) {
                    if (customer.getId() == customerId) {
                        for (Booking booking : customer.getBookings()) {
                            if (booking.unreserveSeat()) {
                                System.out.println("Your reservation has been canceled!");
                            } else {
                                System.out.println("Sorry, we couldn't cancel your reservation.");
                            }
                        }
                    }
                }
                System.out.println();
            }

            if (option == 4) {
                System.exit(0);
            }
        } while (true);

    

        sc.close();
    }
    
   
}
