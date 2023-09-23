
public class Movie {
    private int movieID;
    private String movieName;
    private int ageRating;

    
    
    
    
    public Movie() {
    }

    public Movie(int movieID, String movieName, int ageRating) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.ageRating = ageRating;
    }
    
    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }
    
    
    
}
