/**
 *
 * @author Ethan PC
 */
import java.util.Scanner;

public class Staff {
    private String loginID;
    private String password;
    private Scanner scanner;

    public Staff(String loginID, String password) {
        this.loginID = loginID;
        this.password = password;
        scanner = new Scanner(System.in);
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
            System.out.println("|    2. Insert Cinema Halls         |");
            System.out.println("|    3. Access Ticket Sales Report  |");
            System.out.println("|    4. Exit                        |");
            System.out.println("+===================================+");

            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        InsertMovies();
                        break;
                    case 2:
                        Halls();
                        break;
                    case 3:
                        SalesReport();
                        break;
                    case 4:
                        System.out.println("You have exit the staff menu");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select only (1-4).");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.next();
            }
        }
    }

    public void InsertMovies() {
        System.out.println("You have Selected 'Insert Movie'");

    }

    public void Halls() {
        System.out.println("You have Selected 'Insert Cinema Halls'");
    }

    public void SalesReport() {
        System.out.println("You have Selected 'Access Ticket Sales Report'");
    }
}