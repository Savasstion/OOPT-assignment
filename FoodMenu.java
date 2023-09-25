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
        super(new ArrayList<>() {
            {
                add("Destroy the world");
                add("Consume souls");
                add("Play bingo");
                add("Exit");
            }
        });
    }

    

    @Override
    public void doMenuTask(Object userInput) {

        switch ((Character)userInput) {
            case '1':
                System.out.println("Destroyed the world");
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
