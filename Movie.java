import java.util.List;

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

    public static void listMovies(List<Movie> movies) {
        System.out.println("Movie List:");
        for (Movie movie : movies) {
            System.out.println("Movie Name: " + movie.getMovieName());
            System.out.println("Age Rating: " + movie.getAgeRating());
            System.out.println("-------------");
        }
    }

    public static void addMovie(List<Movie> movies, int movieID, String movieName, int ageRating) {
        /* To use this, first define an arrayList List<Movie> movieList = new ArrayList<>();
         * and then addMovie(movieList, movieID, movieName, ageRating) 
         * I want this arrayList so that I can list them later in display :)
         */
        movies.add(new Movie(movieID, movieName, ageRating));
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
