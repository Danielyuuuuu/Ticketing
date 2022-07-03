/**
 * To represent the theatre room in a movie theatre.
 * Is responsible to keep track of it's seating map.
 *
 * @author Yifei Yu
 */

public class TheatreRoom {

    // The seating map of the theatre room
    private final Seat[][] seatingMap;

    // The grouping
    private GroupList groupList;

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

        groupList = new GroupList();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                seatingMap[i][j] = new Seat();
            }
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

    // Add a group to the group list
    public void addGroup(Group group){
        groupList.addGroup(group);
    }

    // Reset the seating map so that all the seats are available
    public void resetSeating(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                seatingMap[i][j].setIsOccupiedFalse();
            }
        }
        numberOfAvailableSeats = rows * cols;

        groupList = new GroupList();
    }

    // Get the number of available seats in a theatre room
    public int getNumberOfAvailableSeats(){
        return numberOfAvailableSeats;
    }

    // Override the toString method to return the seating map and the groupings
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < rows; i++){
            if(i == 0){
                str.append("*\t");
                for (int c = 0; c < cols; c++){
                    str.append(c);
                    str.append("\t");
                }
                str.append("\n");
            }
                str.append(i);
                str.append("\t");
            for(int j = 0; j < cols; j++){
                if(seatingMap[i][j].getIsOccupied()){
                    str.append("/");
                }
                else{
                    str.append("A");
                }
                str.append("\t");
            }
            str.append("\n");
        }
        str.append("Groupings:\n");
        str.append(groupList);
        return str.toString();
    }
}
