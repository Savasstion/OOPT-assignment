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
<<<<<<< HEAD

=======
        FoodMenu menu = new FoodMenu();
>>>>>>> 958366ee379db849d94a4966a65294dcdc777a03
        Scanner sc = new Scanner(System.in);

        do {
            Menu.displayOptions(userInputIsValid);

            String userInput = sc.nextLine();
<<<<<<< HEAD
            if (Menu.validateOption(userInput)) {
                Menu.doMenuTask(userInput.charAt(0));
=======
            if (menu.validateOption(userInput,1)) {
                menu.doMenuTask(userInput.charAt(0));
>>>>>>> 958366ee379db849d94a4966a65294dcdc777a03
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


    

        ArrayList<Movie> movieNames = new ArrayList<Movie>();
        ArrayList<Customer> customers = new ArrayList<Customer>();



        sc.close();
    }
    
   
}
