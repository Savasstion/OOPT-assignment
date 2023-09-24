import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author savas
 */
public class ticketMenu extends Menu {
Movie movie = new Movie();

    public static void listMovies(List<Movie> movies) {
        //Option 1
        System.out.println("Movies List:");
        for (Movie movie : movies) {
            System.out.println("Movie Name: " + movie.getMovieName());
            System.out.println("Age Rating: " + movie.getAgeRating());
            System.out.println("---------------------------------");
        }
    }

    public ticketMenu() {
        super(new ArrayList<>() {
            {
                add("Please Enter 1 to Display movieNames");
                add("Please Enter 2 to Buy Tickets");
                add("Please Enter 3 to Cancel Tickets");
                add("Please Enter 4 to Exit\n");
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
                listMovie(Movie);
                break;
            case '2':
                System.out.println("Consumed souls");
                break;
            case '3':
                System.out.println("Played bingo");
                break;
            case '4':
                setExit(true);
                break;
        }
    }

}
