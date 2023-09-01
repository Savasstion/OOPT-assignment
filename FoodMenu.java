import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author savas
 */
public class FoodMenu extends Menu {

    public FoodMenu() {
        super();
    }

    public FoodMenu(ArrayList<String> options) {
        super(options);
    }

    @Override
    public boolean validate(Object obj) {
        String userEntered = (String)obj;
        
        if (userEntered.length() > 1) {
            return false;
        }

        setUserInput(userEntered.charAt(0));

        if (Character.isDigit(getUserInput())) {
            //convert char to ASCII decimal num then compare
            return ((int) getUserInput() - 48 <= getOptionsCount() && (int) getUserInput() - 48 > 0);
        } else {
            return false;
        }

    }

    @Override
    public void doMenuTask(char userInput) {
        switch (userInput) {
            case '1':
                System.out.println("Destroyed the world");
                break;
            case '2':
                System.out.println("Consumed souls");
                break;
            case '3':
                System.out.println("Played bingo");
                break;
        }
    }

}
