
public class CinemaHall {

    private static int totalHalls = 10;
    private static int totalSeatRows = 10;
    private static int totalSeatCols = 10;
    private int hallNum;
    private Seat[][] seatArr = new Seat[totalSeatRows][totalSeatCols];
    private Movie movieAired;

    public CinemaHall() {
        
    }

    //used when seatArr is stored in database or etc and need to reconstruct the cinemaHall again
    public CinemaHall(int hallNum, Movie movieAired, Seat[][] seatArr) {
        this.hallNum = hallNum;
        this.movieAired = movieAired;
        this.seatArr = seatArr;
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

    public static int getTotalHalls() {
        return totalHalls;
    }

    public static void setTotalHalls(int totalHalls) {
        CinemaHall.totalHalls = totalHalls;
    }

    public Seat[][] getSeatArr() {
        return seatArr;
    }

    public void setSeatArr(Seat[][] seatArr) {
        this.seatArr = seatArr;
    }

}
