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
    } while (userInputIsValid == false);
        sc.close();
    
    
    }

    public static void clearScreen() {
        try {
            // Execute the command to clear the terminal
            Process process = new ProcessBuilder("cls").inheritIO().start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Could Not Clear Screen, proceeding with code...");
            for (int i = 0; i < 8; i++) {
                System.out.println();
            }
        }
        }
    }
