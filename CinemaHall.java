
public class CinemaHall {

    private static CinemaHall[] halls = new CinemaHall[10];
    private static int totalCinemaHalls = 10;
    private static int totalSeatRows = 10;
    private static int totalSeatCols = 10;
    private int hallNum;
    private Seat[][] seatArr = new Seat[totalSeatRows][totalSeatCols];
    private Movie movieAired;

    public CinemaHall() {
    }
        // Getter for totalCinemaHalls
        public static int getCinemaHalls() {
            return totalCinemaHalls;
        }
    
        // Setter for totalCinemaHalls
        public static void setCinemaHalls(int totalCinemaHalls) {
            CinemaHall.totalCinemaHalls = totalCinemaHalls;
        }
    //used when seatArr is stored in database or etc and need to reconstruct the cinemaHall again
    public CinemaHall(int hallNum, Movie movieAired, Seat[][] seatArr) {
        if (hallNum >= 1 && hallNum <= 10) {
            this.hallNum = hallNum;
            this.movieAired = movieAired;
            this.seatArr = seatArr;
            CinemaHall.halls[hallNum - 1] = this; // -1 to convert hallNum to an array index
        } else {
            System.out.println("Invalid hall number. Hall number must be between 1 and 10.");
        }
    }

    public CinemaHall(int hallNum, Movie movieAired) {
        this.hallNum = hallNum;
        this.movieAired = movieAired;

        for (int i = 0; i < totalSeatRows; i++) {
            char rowChar = 'A';
            for (int j = 0; j < totalSeatCols; j++) {
                if ((j + 1) >= 10) {
                    seatArr[i][j]
                            = new Seat((String.valueOf(hallNum) + (Character.toString(rowChar + i)) + String.valueOf(j + 1)), false);
                } else {
                    seatArr[i][j]
                            = new Seat((String.valueOf(hallNum) + (Character.toString(rowChar + i)) + '0' + String.valueOf(j + 1)), false);
                }
            }
        }
    }

    public static int getTotalSeatRows() {
        return totalSeatRows;
    }

    public static void setTotalSeatRows(int totalSeatRows) {
        CinemaHall.totalSeatRows = totalSeatRows;
    }

    public static int getTotalSeatCols() {
        return totalSeatCols;
    }

    public static void setTotalSeatCols(int totalSeatCols) {
        CinemaHall.totalSeatCols = totalSeatCols;
    }

    public int getHallNum() {
        return hallNum;
    }

    public void setHallNum(int hallNum) {
        this.hallNum = hallNum;
    }

    public Movie getMovieAired() {
        return movieAired;
    }

    public void setMovieAired(Movie movieAired) {
        this.movieAired = movieAired;
    }

    public Seat[][] getSeatArr() {
        return seatArr;
    }

    public void setSeatArr(Seat[][] seatArr) {
        this.seatArr = seatArr;
    }

    public Seat getSeatBySeatID(String seatID) {
        for (int i = 0; i < totalSeatRows; i++) {
            for (int j = 0; j < totalSeatCols; j++) {
                if (seatArr[i][j].getSeatID().equals(seatID)) {
                    return seatArr[i][j];
                }
            }
        }
        return null; 
    }

    public static CinemaHall getCinemaHall(int hallNum) {
        if (hallNum >= 1 && hallNum <= 10) {
            return halls[hallNum - 1]; // -1 to convert hallNum to an array index
        } else {
            return null; // Invalid hallNum
        }
    }

    // Method to print the seat plan
    public void printSeatPlan() {
        for (int i = 0; i < totalSeatRows; i++) {
            for (int j = 0; j < totalSeatCols; j++) {
                System.out.print(seatArr[i][j].displayAvail() + " ");
            }
            System.out.println();
        }
    }

}
