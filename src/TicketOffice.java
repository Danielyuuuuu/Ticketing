import java.util.Scanner;

public class TicketOffice {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        MovieList movieList = new MovieList();
        State currentState = State.INITIAL_STATE;
        String input;

        movieList.addMovie(new Movie("Iron Man", 120), new SeatingMap(5, 5));
//        movieList.addMovie(new Movie("Avengers", 130), new SeatingMap(4, 6));
//        movieList.addMovie(new Movie("Doctor Strange", 110), new SeatingMap(7, 6));

        for(Movie movie: movieList.getAllMovies()){
            System.out.println(movie.getName());
            movieList.getSeatingMap(movie).getAvailableSeats();
        }

        while(true){
            switch(currentState){
                case INITIAL_STATE:
                    System.out.println("Please select the following options (Enter option 1 or 2): \n1. Reset the movie seating. \n2. Get the movie listing.");
                    input = scanner.nextLine();
                    System.out.println("Selected: " + input);
                    break;
                case SELECT_MOVIE:
                    System.out.println("SELECT_MOVIE");
                    break;
                case SELECT_SEAT:
                    System.out.println("SELECT_SEAT");
                    break;
            }
        }
    }

}
