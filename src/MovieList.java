import java.util.HashMap;
import java.util.Set;

public class MovieList {
    private HashMap<Movie, SeatingMap> movieList;

    public MovieList(){
        movieList = new HashMap<>();
    }

    public void addMovie(Movie movie, SeatingMap seatingMap){
        movieList.put(movie, seatingMap);
    }

    public Set<Movie> getAllMovies(){
        return movieList.keySet();
    }

    public SeatingMap getSeatingMap(Movie movie){
        return movieList.get(movie);
    }
}
