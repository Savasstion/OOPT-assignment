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
        FoodMenu menu = new FoodMenu();
        ticketMenu menu2 = new ticketMenu();
        SeatAvailMenu menu3 = new SeatAvailMenu();
        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;
        do {
            System.out.print("Enter your choice (1 to 3): ");
            if (sc.hasNextInt()) {
                menuChoice = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                if (menuChoice == 1) {
                    do {
            System.out.println(logo);
            menu.displayOptions(userInputIsValid);
            String userInput = sc.nextLine();
            if (menu.validateOption(userInput,1)) {
                menu.doMenuTask(userInput.charAt(0));
                userInputIsValid = true;
            } else {
                userInputIsValid = false;
                //try clear screen fuction
                try {
                    // Execute the command to clear the terminal
                    Process process = new ProcessBuilder("cls").inheritIO().start();
                    process.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (userInputIsValid == false);
                } else if (menuChoice == 2) {
                    do {
            System.out.println(logo);
            menu2.displayOptions(userInputIsValid);
            String userInput = sc.nextLine();
            if (menu2.validateOption(userInput,1)) {
                menu2.doMenuTask(userInput.charAt(0));
                userInputIsValid = true;
            } else {
                userInputIsValid = false;
                try {
                    Process process = new ProcessBuilder("cls").inheritIO().start();
                    process.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }}while (userInputIsValid == false);}
                 else if (menuChoice == 3) {
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
                try {
                    // Execute the command to clear the terminal
                    Process process = new ProcessBuilder("cls").inheritIO().start();
                    process.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (userInputIsValid == false);
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 3");
                sc.nextLine(); // Consume the invalid input
            }
        } while (menuChoice != 1 && menuChoice != 2 && menuChoice != 3);


        sc.close();
    }
    
   
}