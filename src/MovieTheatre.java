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

    private static final Scanner scanner = new Scanner(System.in);
    private static final MovieList movieList = new MovieList();
    private static State currentState = State.INITIAL_STATE;
    private static Movie currentSelectedMovie = null;
    private static String input;

    // The driver of the movie theatre system
    public static void main(String[] args){

        // Initialize the movie list with three movies
        movieList.addMovie(new Movie("Iron Man"), new TheatreRoom(5, 5));
        movieList.addMovie(new Movie("Avengers"), new TheatreRoom(4, 6));
        movieList.addMovie(new Movie("Doctor Strange"), new TheatreRoom(7, 6));

        // Continuously ask for the command line input and perform actions according to that
        while(true){
            switch(currentState){
                case INITIAL_STATE:
                    handleInitialState();
                    break;
                case SELECT_MOVIE:
                    handleSelectMovieState();
                    break;
                case SELECT_SEAT:
                    handleSelectSeatState();
                    break;
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
        if(input.equals("1")){
            movieList.resetMovieSeating();
            System.out.println("The movie seating has been reset");
        }
        else if(input.equals("2")){
            currentState = State.SELECT_MOVIE;
        }
        else{
            System.out.println("Error! The option \"" + input + "\" is invalid");
        }
    }

    // To handle the select move state where the user can choose from the available movies
    private static void handleSelectMovieState(){
        System.out.println("Please select from the following movies (or enter \"0\" to go back):");
        movieList.printAllMovies();
        input = scanner.nextLine().trim();
        if(input.equals("0")){
            currentState = State.INITIAL_STATE;
            return;
        }
        boolean isSuccessful = false;
        for(Movie movie: movieList.getAllMovies()){
            if(input.equalsIgnoreCase(movie.getName())){
                currentSelectedMovie = movie;
                currentState = State.SELECT_SEAT;
                isSuccessful = true;
                break;
            }
        }
        if(!isSuccessful){
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

        if(movieList.getSeatingMap(currentSelectedMovie).selectSeat(rowSelected, colSelected)){
            System.out.println("Seat (" + rowSelected + ", " + colSelected + ") selected successfully!");
            currentState = State.INITIAL_STATE;
        }
        else{
            System.out.println("Error! Seat (" + rowSelected + ", " + colSelected + ") you entered is either occupied or invalid!");
        }
    }


}
