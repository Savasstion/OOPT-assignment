import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)  {
        boolean userInputIsValid = true;

        Menu menu = new FoodMenu(new ArrayList() {
            {
                add("Destroy the world");
                add("Consume souls");
                add("Play bingo");
            }
        });
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
               
            }
        } while (userInputIsValid == false);
    }
    
   
}
