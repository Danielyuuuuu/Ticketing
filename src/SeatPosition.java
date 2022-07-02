/**
 * To represent the position of the seats in the theatre room
 *
 * @author Yifei Yu
 */

public class SeatPosition {
    // The row and column position of the seat
    private int row;
    private int col;

    // The constructor, to create a seat position
    public SeatPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

    // Override the toString method to return the row and column of the seat position
    public String toString(){
        String str = "(" + row + ", " + col + ")";
        return str;
    }
}
