/**
 * To represent all the movies that are currently showing in the movie theatre
 *
 * @author Yifei Yu
 */

import java.util.HashMap;

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

    // Print out all the currently showing movies
    public void printAllMovies(){
        for(Movie movie: movieList.keySet()){
            System.out.println("* " + movie);
        }
    }

    // Find the movie by the movie name
    public Movie findMovieByName(String name){
        for(Movie movie: movieList.keySet()){
            if(name.equalsIgnoreCase(movie.getName())){
                return movie;
            }
        }
        return null;
    }

    // Get the seating map of a movie
    public TheatreRoom getTheatreRoom(Movie movie){
        return movieList.get(movie);
    }

    // To select the seat of a movie
    public Boolean selectMovieSeat(Movie movie, int rowSelected, int colSelected){
        return getTheatreRoom(movie).selectSeat(rowSelected, colSelected);
    }

    // Reset all the currently showing movies' seating map
    public void resetMovieSeating(){
        for(TheatreRoom theatreRoom : movieList.values()){
            theatreRoom.resetSeating();
        }
    }
}
