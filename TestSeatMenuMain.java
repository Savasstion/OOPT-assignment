
import java.util.Scanner;

public class TestSeatMenuMain {

    public static void main(String[] args) {
        SeatAvailMenu menu = new SeatAvailMenu();
        boolean userInputIsValid = true;
        boolean exit = false;

        Scanner sc = new Scanner(System.in);

        menu.getHallArr()[0].getSeatArr()[0][0].setSeatAssigned(true);
        
        do {
            menu.displayOptions(userInputIsValid);

            menu.setUserInput(sc.nextLine().charAt(0));
            //make sure do userInput 1 then 2 first
            //if userInput == 1, obj will be hallNum
            //if userInput == 2, obj will be seatID string

            
            if (menu.getUserInput() == '1') {
                if (menu.validateOption(1, 1)) {
                    menu.doMenuTask(1);
                    userInputIsValid = true;
                } else {
                    System.out.println("failed validation");
                    userInputIsValid = false;
                    //clear screen fuction, (need help in this to clear terminal)

                }
            } else if (menu.getUserInput() == '2') {
                //test

                if (menu.validateOption("1C10", 2)) {
                    
                    menu.doMenuTask(1);
                    userInputIsValid = true;
                } else {
                    System.out.println("failed validation");
                    userInputIsValid = false;
                    //clear screen fuction, (need help in this to clear terminal)

                }
            } else if (menu.getUserInput() == '3') {
                userInputIsValid = true;
                menu.setExit(true);
                

            } else {
                userInputIsValid = false;
            }
        } while (!menu.isExit());
    }

}
