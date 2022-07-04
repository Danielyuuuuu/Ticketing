/**
 * To represent all the movies that are currently showing in the movie theatre
 *
 * @author Yifei Yu
 */

import java.util.HashMap;

public class MovieList {

    // A map between the movie and the theatre room
    private final HashMap<Movie, TheatreRoom> movieList;

    // The constructor, to initialize the movie list
    public MovieList(){
        movieList = new HashMap<>();
    }

    // To add a movie, and it's corresponding theatre room to the movie list
    public void addMovie(Movie movie, TheatreRoom theatreRoom){
        movieList.put(movie, theatreRoom);
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

    // Reset all the currently showing movies' seating map and grouping
    public void resetMovieSeatingAndGrouping(){
        for(TheatreRoom theatreRoom : movieList.values()){
            theatreRoom.resetSeatingAndGrouping();
        }
    }

    // Override the toString method to print out all the currently showing movies
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Movie movie: movieList.keySet()){
            str.append("* ");
            str.append(movie);
            str.append("\n");
        }
        return str.toString().trim();
    }
}
