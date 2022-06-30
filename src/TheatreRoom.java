/**
 * To represent the theatre room in a movie theatre.
 * Is responsible to keep track of it's seating map.
 *
 * @author Yifei Yu
 */

public class TheatreRoom {

    // The seating map of the theatre room
    private Seat[][] seatingMap;

    // Number of rows and columns the theatre room has
    private final int rows;
    private final int cols;

    private int numberOfAvailableSeats;

    // The constructor, to create a theatre room by specifying the number of rows and columns it has
    public TheatreRoom(int rows, int cols){
        seatingMap = new Seat[rows][cols];
        this.rows = rows;
        this.cols = cols;
        numberOfAvailableSeats = rows * cols;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                seatingMap[i][j] = new Seat();
            }
        }
    }

    // Print out the seating map (A means available, / means occupied)
    public void getSeatingMap(){
        System.out.println("row: " + rows);
        System.out.println("col: " + cols);
        for(int i = 0; i < rows; i++){
            if(i == 0){
                System.out.print("*");
                System.out.print("\t");
                for (int c = 0; c < cols; c++){
                    System.out.print(c);
                    System.out.print("\t");
                }
                System.out.println("\n");
            }

            System.out.print(i);
            System.out.print("\t");

            for(int j = 0; j < cols; j++){
                if(seatingMap[i][j].getIsOccupied()){
                    System.out.print("/");
                }
                else{
                    System.out.print("A");
                }
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }

    // Handle selecting a seat. Return true if the seat is selected successfully.
    // Return false if the seat is either occupied or is invalid
    public Boolean selectSeat(int rowSelected, int colSelected){
        if (rowSelected < 0 || rowSelected >= rows || colSelected < 0 || colSelected >= cols){
            return false;
        }
        if(seatingMap[rowSelected][colSelected].getIsOccupied()){
            return false;
        }
        seatingMap[rowSelected][colSelected].setIsOccupiedTrue();
        numberOfAvailableSeats--;
        return true;
    }

    // Reset the seating map so that all the seats are available
    public void resetSeating(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                seatingMap[i][j].setIsOccupiedFalse();
            }
        }
        numberOfAvailableSeats = rows * cols;
    }

    public int getNumberOfAvailableSeats(){
        return numberOfAvailableSeats;
    }
}
