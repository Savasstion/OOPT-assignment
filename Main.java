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
            System.out.println("1) Staff login");
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

        boolean exit = false;

        menu3.getHallArr()[0].getSeatArr()[0][0].setSeatAssigned(true);
        
        do {
            menu3.displayOptions(userInputIsValid);

            menu3.setUserInput(sc.nextLine().charAt(0));
            //make sure do userInput 1 then 2 first
            //if userInput == 1, obj will be hallNum
            //if userInput == 2, obj will be seatID string
            
            if (menu3.getUserInput() == '1') {
                System.out.println("Which hall would you like to access?");
                int hall = sc.nextInt();
                if (menu3.validateOption(hall, 1)) {
                    menu3.doMenuTask(hall);
                    userInputIsValid = true;
                } else {
                    System.out.println("Failed validation");
                    userInputIsValid = false;
                    clearScreen();
                }
            } else if (menu3.getUserInput() == '2') {
                System.out.println("Which seat will you buy? (format: hallNum + row + col)");
                String halls = sc.next();
                if (menu3.validateOption(halls, 2)) {
                    menu3.doMenuTask(halls);
                    userInputIsValid = true;
                } else {
                    System.out.println("Failed validation");
                    userInputIsValid = false;
                    clearScreen();
                }
            }
             else if (menu3.getUserInput() == '3') {
                userInputIsValid = true;
                menu3.setExit(true);
                

            } else {
                userInputIsValid = false;
            }
        } while (!menu3.isExit());
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
