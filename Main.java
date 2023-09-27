import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        final String logo = "  _____ _                            \n" +
        " / ____(_)                           \n" +
        "| |     _ _ __   ___ _ __ ___   __ _ \n" +
        "| |    | | '_ \\ / _ \\ '_ ` _ \\ / _` |\n" +
        "| |____| | | | |  __/ | | | | | (_| |\n" +
        " \\_____|_|_| |_|\\___|_| |_| |_|\\__,_|\n";
        boolean userInputIsValid = true;
        ticketMenu menu2 = new ticketMenu();
        SeatAvailMenu menu3 = new SeatAvailMenu();
        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;
        do {
            System.out.println("1) Buy Tickets");
            System.out.println("2) Check Seat Availability");

            System.out.println("Enter Your Choice:");
            if (sc.hasNextInt()) {
                menuChoice = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                    if (menuChoice == 1) {
                    do {
            System.out.println(logo);
            menu2.displayOptions(userInputIsValid);
            String userInput = sc.nextLine();
            if (menu2.validateOption(userInput,1)) {
                menu2.doMenuTask(userInput.charAt(0));
                userInputIsValid = true;
            } else {
                userInputIsValid = false;
                clearScreen();
            }}while (userInputIsValid == false);}
                 else if (menuChoice == 2) {
                                        do {
            System.out.println(logo);
            menu3.displayOptions(userInputIsValid);
            String userInput = sc.nextLine();
            if (menu3.validateOption(userInput,1)) {
                menu3.doMenuTask(userInput.charAt(0));
                userInputIsValid = true;
            } else {
                userInputIsValid = false;
                //try clear screen fuction
                clearScreen();
            }
        } while (userInputIsValid == false);
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 2");
                sc.nextLine(); // Consume the invalid input
            }
        } while (menuChoice != 1 && menuChoice != 2 && menuChoice != 3);


        sc.close();
    }
    
    public static void clearScreen() {
        try {
            // Execute the command to clear the terminal
            Process process = new ProcessBuilder("cls").inheritIO().start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
