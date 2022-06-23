import java.util.Scanner;

public class TicketOffice {

    private static Scanner scanner = new Scanner(System.in);
    private static MovieList movieList = new MovieList();
    private static State currentState = State.INITIAL_STATE;
    private static Movie currentSelectedMovie = null;
    private static String input;

    public static void main(String[] args){

        movieList.addMovie(new Movie("Iron Man", 120), new SeatingMap(5, 5));
        movieList.addMovie(new Movie("Avengers", 130), new SeatingMap(4, 6));
        movieList.addMovie(new Movie("Doctor Strange", 110), new SeatingMap(7, 6));

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
            }
            System.out.println("---------------------------------------------------");
        }
    }

    private static void handleInitialState(){
        System.out.println("Please select the following options (Enter option 1 or 2): \n1. Reset the movie seating. \n2. Get the movie listing.");
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

    private static void handleSelectMovieState(){
        System.out.println("Please select the following movies (or enter \"0\" to go back):");
        movieList.printAllMovies();
        input = scanner.nextLine().trim();
        if(input.equals("0")){
            currentState = State.INITIAL_STATE;
            return;
        }
        Boolean isSuccessful = false;
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

    private static void handleSelectSeatState(){
        System.out.println("The seating map for the movie \"" + currentSelectedMovie + "\" (A means available, / means occupied).");
        movieList.getSeatingMap(currentSelectedMovie).getAvailableSeats();
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
