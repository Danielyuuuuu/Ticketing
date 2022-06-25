/**
 * To represent the movie
 *
 * @author Yifei Yu
 */

public class Movie {

    // The movie name
    private final String name;

    // The constructor, to create the movie by giving it a name
    public Movie(String name){
        this.name = name;
    }

    // Get the movie name
    public String getName(){
        return name;
    }

    // Override the toString method to return the name of the movie
    public String toString(){
        return name;
    }
}
