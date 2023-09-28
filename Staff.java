/**
 *
 * @author Ethan PC
 */
import java.util.Scanner;

public class Staff {
    private String loginID;
    private String password;
      Scanner scanner = new Scanner(System.in);

    public Staff(String loginID, String password) {
        this.loginID = loginID;
        this.password = password;
    }

    public boolean login(String inloginid, String inpsw) {
        return loginID.equals(inloginid) && password.equals(inpsw);
    }

    public void staffMenu() {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n+===================================+");
            System.out.println("|            Staff Menu             |");
            System.out.println("+===================================+");
            System.out.println("|    1. Insert Movies               |");
            System.out.println("|    2. Access Ticket Sales Report  |");
            System.out.println("|    3. Exit                        |");
            System.out.println("+===================================+");

            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        InsertMovies();
                        break;
                    case 2:
                        SalesReport();
                        break;
                    case 3:
                        System.out.println("You have exit the staff menu");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select only (1-3).");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.next();
            }
        }
    }

    public void InsertMovies() {
     /*
      *     public Movie(String movieName, int ageRating) 
      */

      System.out.println("Enter the movie name: ");
      String movieName = scanner.nextLine();
      scanner.nextLine();
      System.out.println("Enter the age rating: ");
      int ageRating = scanner.nextInt();
      scanner.nextLine();
      Movie movi = new Movie(movieName, ageRating);
      System.out.println("Enter the cinema hall this movie will be airing: ");
      int hall = scanner.nextInt();
      new CinemaHall(hall,movi);
    }

    public void SalesReport() {
        ticket.printAllTickets();
    }
}