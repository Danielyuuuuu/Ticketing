public class Movie {
    private final String name;
    private final int duration;

    public Movie(String name, int duration){
        this.name = name;
        this.duration = duration;
    }

    public String getName(){
        return name;
    }

    public int getDuration(){
        return duration;
    }

    public String toString(){
        return name;
    }
}
