import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        // sample data define

        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";
        String reset = "\u001B[0m";
        final String logo = "  _____ _                            \n" +
        " / ____(_)                           \n" +
        "| |     _ _ __   ___ _ __ ___   __ _ \n" +
        "| |    | | '_ \\ / _ \\ '_ ` _ \\ / _` |\n" +
        "| |____| | | | |  __/ | | | | | (_| |\n" +
        " \\_____|_|_| |_|\\___|_| |_| |_|\\__,_|\n";
        boolean userInputIsValid = true;
        ticketMenu menu2 = new ticketMenu();
        SeatAvailMenu menu3 = new SeatAvailMenu();
        MemberMenu menu = new MemberMenu();
        
        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;
        do {
                        System.out.println(logo);
                        System.out.println(blue+"*~~~~~~~~~~~~~~~~~~MAIN*MENU~~~~~~~~~~~~~~~~~~~*"+reset);            
            System.out.println("1) Staff login");
            System.out.println("2) Main Menu");
            System.out.println("Enter Your Choice:");
            if (sc.hasNextInt()) {
                menuChoice = sc.nextInt();
                sc.nextLine(); 
                    if (menuChoice == 1) {
                    do { //Staff login by Ethan, ID and password assumed to be only 1 type.
                    Staff staff = new Staff("admin", "password" );
                    boolean loggedIn = false;
                   
                  while(!loggedIn){
                    System.out.println("");
                    System.out.println("+===================================+");
                    System.out.println("|            Staff Login            |");
                    System.out.println("+===================================+");
                    System.out.print("Enter staff ID :");
                    String inloginid = sc.nextLine();
                    System.out.print("Enter password :");
                    String inpsw = sc.nextLine();
                    
                    if(staff.login(inloginid, inpsw)){
                        System.out.println("");
                        System.out.println("LOGIN SUCCESSFUL!!");
                        System.out.println("");
                        staff.staffMenu();
                        loggedIn = true;
                    }else{
                        System.out.println("");
                        System.out.println("LOGIN UNSUCCESSFUL, Staff ID or Password is INCORRECT!!");
                    }
                    userInputIsValid = true;
            }

            }while (userInputIsValid == false);}
                 else if (menuChoice == 2) {
                                        do {

        menu3.getHallArr()[0].getSeatArr()[0][0].setSeatAssigned(true);

do {
    do{
            System.out.println(logo);
            menu.displayOptions(userInputIsValid);
            String userInput = sc.nextLine();
            if (menu.validateOption(userInput,1)) {
                menu.doMenuTask(userInput.charAt(0));
                userInputIsValid = true;
            } else {
                userInputIsValid = false;
                clearScreen();
            }}while (userInputIsValid == false);
clearScreen();
                    userInputIsValid = true;


            menu3.displayOptions(userInputIsValid);

            menu.setUserInput(sc.nextLine().charAt(0));
            //make sure do userInput 1 then 2 first
            //if userInput == 1, obj will be hallNum
            //if userInput == 2, obj will be seatID string
            
            if (menu.getUserInput() == '1') {
                System.out.println(green+"*~~~~~~~~~~~~~~SEAT*AVAILABLE~~~~~~~~~~~~~~~~~~~*"+reset);
                System.out.println("Which hall would you like to access?");
                int hall = sc.nextInt();
                if (menu.validateOption(hall, 1)) {
                    menu.doMenuTask(hall);
                    userInputIsValid = true;
                } else {
                    System.out.println("Failed validation");
                    userInputIsValid = false;
                    clearScreen();
                }
            } else if (menu.getUserInput() == '2') {
                System.out.println("Which seat will you buy? (format: hallNum + row + col)");
                String halls = sc.next();
                if (menu.validateOption(halls, 2)) {
                    menu.doMenuTask(halls);
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
            else {
                System.out.println("Invalid input. Please enter a number between 1 and 2");
                sc.nextLine(); 
            }
            // redirect to ticket Menu
            clearScreen();
            System.out.println(red+"*~~~~~~~~~~~~~~~~TICKET*MENU~~~~~~~~~~~~~~~~~~~~*"+reset);
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
            }}while (userInputIsValid == false);
        }} while (menuChoice != 1 && menuChoice != 2 && menuChoice != 3);

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
