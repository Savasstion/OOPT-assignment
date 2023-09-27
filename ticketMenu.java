import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author savas
 */
public class ticketMenu extends Menu {

    public ticketMenu() {
        super(new ArrayList<>() {
            {
                add("Display Movies Shown");
                add("Buy Tickets");
                add("Cancel Tickets");
                add("Exit");
            }
        });
    }

    @Override
    public boolean validateOption(Object obj, int validationStage) {
        //no need optionStage cuz only one type of validation
        String userEntered = (String)obj;
        
        if (userEntered.length() > 1) {
            return false;
        }

        setUserInput(userEntered.charAt(0));

        if (Character.isDigit(getUserInput())) {
            //convert char to ASCII int values then by minusing 48 to get raw value (refer ASCII table)
            //To a teammate who wants to implement this but still dont understand this,
            //you can just Character.getNumericValue('1'), this example will result to returning int 1
            return ((int) getUserInput() - 48 <= getOptionsCount() && (int) getUserInput() - 48 > 0);
        } else {
            return false;
        }

    }




    @Override
    public void doMenuTask(Object userInput) {

        switch ((Character)userInput) {
            case '1':
                Movie.listMovies(Movie.getMovies());
                break;
            case '2':
                ticket.purchaseTicket();
                break;
            case '3':
                ticket.cancelTicket();
                break;
            case '4':
                setExit(true);
                break;
        }
    }




}
