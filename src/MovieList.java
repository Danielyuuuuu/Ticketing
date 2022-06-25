/**
 * To represent all the movies that are currently showing in the movie theatre
 *
 * @author Yifei Yu
 */

import java.util.HashMap;
import java.util.Set;

public class MovieList {

    // A map between the movie and the theatre room
    private HashMap<Movie, TheatreRoom> movieList;

    // The constructor, to create the movie list
    public MovieList(){
        movieList = new HashMap<>();
    }

    // To add a movie to the movie list
    public void addMovie(Movie movie, TheatreRoom theatreRoom){
        movieList.put(movie, theatreRoom);
    }

    // Get all the currently showing movies
    public Set<Movie> getAllMovies(){
        return movieList.keySet();
    }

    // Print out all the currently showing movies
    public void printAllMovies(){
        for(Movie movie: getAllMovies()){
            System.out.println("* " + movie);
        }
    }

    // Get the seating map of a movie
    public TheatreRoom getSeatingMap(Movie movie){
        return movieList.get(movie);
    }

    // Reset all the currently showing movies' seating map
    public void resetMovieSeating(){
        for(TheatreRoom theatreRoom : movieList.values()){
            theatreRoom.resetSeating();
        }
    }
}
