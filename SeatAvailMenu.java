
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author savas
 */
public class SeatAvailMenu extends Menu {

    private static int totalCinemaHalls = 9;
    private CinemaHall[] hallArr = new CinemaHall[totalCinemaHalls];

    private int userHallInput = 0;

    public SeatAvailMenu() {
        super(new ArrayList<>() {
            {
                add("Show seat availability");
                add("Book seat");
                add("Exit");
            }
        });
        //default movie is Barbenheimer
        for (int i = 0; i < totalCinemaHalls; i++) {
            this.hallArr[i] = new CinemaHall(i + 1, new Movie(1, "Barbenheimer", 18));
        }
    }

    //use if got existing callArr
    public SeatAvailMenu(CinemaHall[] hallArr) {
        super(new ArrayList<>() {
            {
                add("Show seat availability");
                add("Book seat");
            }
        });
        this.hallArr = hallArr;
    }

    public static int getTotalCinemaHalls() {
        return totalCinemaHalls;
    }

    public static void setTotalCinemaHalls(int totalCinemaHalls) {
        SeatAvailMenu.totalCinemaHalls = totalCinemaHalls;
    }

    public CinemaHall[] getHallArr() {
        return hallArr;
    }

    public void setHallArr(CinemaHall[] hallArr) {
        this.hallArr = hallArr;
    }

    public int getUserHallInput() {
        return userHallInput;
    }

    public void setUserHallInput(int userHallInput) {
        this.userHallInput = userHallInput;
    }

    @Override
    public boolean validateOption(Object obj, int userInput) {
        if (userInput == 1) {
            //input hallNum
            userHallInput = (Integer) obj;
            if (userHallInput > 0 && userHallInput <= CinemaHall.getTotalHalls()) {
                return true;
            } else {
                return false;
            }

        } else if (userInput == 2) {
            //input seat
            String userSeatInput = (String) obj;
            if (userSeatInput.length() > 4) {
                System.out.println("String count too high");
                return false;
            }
            int userHallInput = Character.getNumericValue(userSeatInput.charAt(0)) - 1;
            char rowChar = userSeatInput.charAt(1);
            int colInt = Integer.parseInt(userSeatInput.substring(2, 4));
            if (rowChar >= 'A' && rowChar <= ('A' + (CinemaHall.getTotalSeatRows() - 1))) {
                //System.out.println("Succeeded rowChar");
                if (colInt > 0 && colInt <= CinemaHall.getTotalSeatCols()) {
                    //System.out.println("Succeeded colInt");
                    if (hallArr[userHallInput].getSeatArr()[rowChar - 65][colInt - 1].getSeatID().equals((Integer.toString(userHallInput + 1)) + (Character.toString(rowChar)) + (Integer.toString(colInt)))) {
                        hallArr[userHallInput].getSeatArr()[rowChar - 65][colInt - 1].setSeatAssigned(true);
                        return true;
                    } else if (hallArr[userHallInput].getSeatArr()[rowChar - 65][colInt - 1].getSeatID().equals((Integer.toString(userHallInput + 1)) + (Character.toString(rowChar)) + Character.toString('0') + (Integer.toString(colInt)))) {
                        hallArr[userHallInput].getSeatArr()[rowChar - 65][colInt - 1].setSeatAssigned(true);
                        return true;
                    } else {
                        System.out.println("Failed to find seatID");
                        return false;
                    }
                } else {
                    System.out.println("colInt not in range");
                    return false;
                }

            } else {
                System.out.println("rowChar not within range");
                return false;
            }

        } else if (userInput == 3) {
            return true;
            
        } else {
            System.out.println("Error invalid optionStage!");
            return false;
        }

    }

    @Override
    //this menu's task to display which seats are available in a cinema hall
    public void doMenuTask(Object hallNum) {
        int index = (Integer) hallNum - 1;

        for (int i = 0; i < (CinemaHall.getTotalSeatCols() * 2); i++) {
            System.out.print('*');
        }
        System.out.print("\n");

        for (int i = 0; i < ((CinemaHall.getTotalSeatCols() * 2 + 1) / 2 - 3); i++) {
            System.out.print('*');
        }

        System.out.print("SCREEN");

        for (int i = 0; i < ((CinemaHall.getTotalSeatCols() * 2 + 1) / 2 - 3); i++) {
            System.out.print('*');
        }
        System.out.print("\n\n");

        for (int i = 0; i < CinemaHall.getTotalSeatRows(); i++) {
            for (int j = 0; j < CinemaHall.getTotalSeatCols(); j++) {
                System.out.print("|");
                System.out.print(hallArr[index].getSeatArr()[i][j].displayAvail());
            }
            System.out.println("|");

            for (int k = 0; k < (CinemaHall.getTotalSeatCols() * 2 + 1); k++) {
                System.out.print('=');
            }
            System.out.print("\n");
        }

    }

}
