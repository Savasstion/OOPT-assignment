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
        FoodMenu menu = new FoodMenu();
        Scanner sc = new Scanner(System.in);

        do {
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


    
       

    

        sc.close();
    }
    
   
}