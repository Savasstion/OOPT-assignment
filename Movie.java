import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static int movieID = 0;
    private String movieName;
    private int ageRating;
    private static List<Movie> movies = new ArrayList<>();
    
    public Movie() {
    }

    public Movie(String movieName, int ageRating) {
        movieID = movieID++;
        this.movieName = movieName;
        this.ageRating = ageRating;
    }

    public static void listMovies() {
        System.out.println("Movie List:");
        for (Movie movie : movies) {
            System.out.println("Movie Name: " + movie.getMovieName());
            System.out.println("Age Rating: " + movie.getAgeRating());
            System.out.println("-------------");
        }
    }
    

    public static List<Movie> getMovies() {
        return movies;
    }

    public static void addMovie(List<Movie> movies,String movieName, int ageRating) {
        /* To use this, first define an arrayList List<Movie> movieList = new ArrayList<>();
         * and then addMovie(movieList, movieID, movieName, ageRating) 
         * I want this arrayList so that I can list them later in display :) (Leng Zjet added)
         */
        movies.add(new Movie(movieName, ageRating));
    }
    
    public int getMovieID() {
        return movieID;
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
