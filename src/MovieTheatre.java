/**
 * The top-level component of the movie theatre.
 *
 * It is responsible for:
 *  - creating all the components of the system;
 *  - handling command line inputs;
 *
 * @author Yifei Yu
 */

import java.util.Scanner;
import static java.lang.System.exit;

public class MovieTheatre {

    // The scanner to take the user inputs
    private static final Scanner scanner = new Scanner(System.in);

    // To store the user input temporarily
    private static String input;

    // The currently showing movie list
    private static final MovieList movieList = new MovieList();

    // The current state of the program
    private static State currentState = State.INITIAL_STATE;

    //The currently selected movie
    private static Movie currentSelectedMovie = null;

    // The driver of the movie theatre system
    public static void main(String[] args){

        // Initialize the movie list with three movies
        movieList.addMovie(new Movie("Iron Man"), new TheatreRoom(5, 5));
        movieList.addMovie(new Movie("Avengers"), new TheatreRoom(4, 6));
        movieList.addMovie(new Movie("Doctor Strange"), new TheatreRoom(7, 6));

        // Continuously ask for the command line input and perform actions according to that
        while(true){
            switch(currentState){
                // The initial state where the user can choose between resetting the movie seating and getting the movie listing
                case INITIAL_STATE:
                    handleInitialState();
                    break;
                // The select move state where the user can choose from the available movies
                case SELECT_MOVIE:
                    handleSelectMovieState();
                    break;
                // The select seat state where the user can choose the seat for the selected movie
                case SELECT_SEAT:
                    handleSelectSeatState();
                    break;
                // Terminate the program if the current state is unknown
                default:
                    System.out.println("Incorrect current state!");
                    exit(1);
                    break;
            }
            System.out.println("---------------------------------------------------");
        }
    }

    // To handle the initial state where the user can choose between resetting the movie seating and getting the movie listing
    private static void handleInitialState(){
        System.out.println("Welcome to the movie theater! Please select the following options (Enter option 1 or 2): \n1. Reset the movie seating. \n2. Get the movie listing.");
        input = scanner.nextLine().trim();

        // Reset the movie seating
        if(input.equals("1")){
            movieList.resetMovieSeating();
            System.out.println("The movie seating has been reset");
        }
        // Get the movie listing
        else if(input.equals("2")){
            currentState = State.SELECT_MOVIE;
        }
        // Invalid option selected
        else{
            System.out.println("Error! The option \"" + input + "\" is invalid");
        }
    }

    // To handle the select move state where the user can choose from the available movies
    private static void handleSelectMovieState(){
        System.out.println("Please select from the following movies (or enter \"0\" to go back):");
        movieList.printAllMovies();
        input = scanner.nextLine().trim();

        // Go back to the initial state
        if(input.equals("0")){
            currentState = State.INITIAL_STATE;
            return;
        }

        // Find the movie by the movie name
        currentSelectedMovie = movieList.findMovieByName(input);

        // Go to the select seat state if the movie is found
        if(currentSelectedMovie != null){
            currentState = State.SELECT_SEAT;
        }
        // Print out the error message if the movie is not found
        else{
            System.out.println("Error! The movie \"" + input +"\" is not found");
        }
    }

    // To handle the select seat state where the user can choose the seat for the selected movie
    private static void handleSelectSeatState(){
        System.out.println("The seating map for the movie \"" + currentSelectedMovie + "\" (A means available, / means occupied).");
        movieList.getSeatingMap(currentSelectedMovie).getSeatingMap();

        System.out.println("Please select your seat by entering the row number:");
        int rowSelected = Integer.parseInt(scanner.nextLine());

        System.out.println("Please select your seat by entering the column number:");
        int colSelected = Integer.parseInt(scanner.nextLine());

        // Go to the initial state if the movie seat is selected successfully
        if(movieList.selectMovieSeat(currentSelectedMovie, rowSelected, colSelected)){
            System.out.println("Seat (" + rowSelected + ", " + colSelected + ") selected successfully!");
            currentState = State.INITIAL_STATE;
        }
        // Print out the error message if the movie seat entered is either occupied or invalid
        else{
            System.out.println("Error! Seat (" + rowSelected + ", " + colSelected + ") you entered is either occupied or invalid!");
        }
    }


}
