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

    public void printAllMovies(){
        for(Movie movie: getAllMovies()){
            System.out.println("* " + movie);
        }
    }

    public SeatingMap getSeatingMap(Movie movie){
        return movieList.get(movie);
    }

    public void resetMovieSeating(){
        for(SeatingMap seatingMap: movieList.values()){
            seatingMap.resetSeating();
        }
    }
}
