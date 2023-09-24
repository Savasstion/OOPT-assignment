
import java.util.Scanner;


public class Test {
    public static void main(String[] args)  {
        boolean userInputIsValid = true;

        MemberMenu menu = new MemberMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println(menu.getMemberArr().size());
        
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
