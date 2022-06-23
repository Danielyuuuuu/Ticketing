import java.util.Scanner;

public class TicketOffice {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MovieList movieList = new MovieList();
        State currentState = State.INITIAL_STATE;
        Movie currentSelectedMovie = null;
        String input;

        movieList.addMovie(new Movie("Iron Man", 120), new SeatingMap(5, 5));
        movieList.addMovie(new Movie("Avengers", 130), new SeatingMap(4, 6));
        movieList.addMovie(new Movie("Doctor Strange", 110), new SeatingMap(7, 6));

        while(true){
            switch(currentState){
                case INITIAL_STATE:
                    System.out.println("Please select the following options (Enter option 1 or 2): \n1. Reset the movie seating. \n2. Get the movie listing.");
                    input = scanner.nextLine().trim();
                    if(input.equals("1")){
                        System.out.println("Resetting the movie seating");
                    }
                    else if(input.equals("2")){
                        currentState = State.SELECT_MOVIE;
                    }
                    else{
                        System.out.println("Error! The option \"" + input + "\" is invalid");
                    }
                    break;
                case SELECT_MOVIE:
                    System.out.println("Please select the following movies (or enter \"0\" to go back):");
                    movieList.printAllMovies();
                    input = scanner.nextLine().trim();
                    if(input.equals("0")){
                        currentState = State.INITIAL_STATE;
                        break;
                    }
                    for(Movie movie: movieList.getAllMovies()){
                        if(input.equals(movie.getName())){
                            currentSelectedMovie = movie;
                            currentState = State.SELECT_SEAT;
                            break;
                        }
                    }
                    System.out.println("Error! The movie \"" + input +"\" is not found");
                    break;
                case SELECT_SEAT:
                    System.out.println("The movie seating map (A means available, / means occupied).");
                    movieList.getSeatingMap(currentSelectedMovie).getAvailableSeats();
                    System.out.println("Please select your seat (enter <row number>, <column number>):");
                    input = scanner.nextLine().trim();
                    break;
            }
            System.out.println("---------------------------------------------------");
        }
    }

}
