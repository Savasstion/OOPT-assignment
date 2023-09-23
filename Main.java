import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)  {
        boolean userInputIsValid = true;

        FoodMenu menu = new FoodMenu();
        Scanner sc = new Scanner(System.in);

        do {
            menu.displayOptions(userInputIsValid);

            String userInput = sc.nextLine();
            //only 1 options needed to be validated so optionSatge = 1 in function parameter
            if (menu.validateOption(userInput,1)) {
                menu.doMenuTask(userInput.charAt(0));
                userInputIsValid = true;
            } else {
                userInputIsValid = false;
                //clear screen fuction, (need help in this to clear terminal)
               
            }
        } while (!menu.isExit());
    }
    
   
}
