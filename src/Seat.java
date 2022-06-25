/**
 * To represent the seat in a theatre room
 *
 * @author Yifei Yu
 */

public class Seat {

    // To identify if the seat is occupied
    private Boolean isOccupied = false;

    // Return if the seat is occupied
    public Boolean getIsOccupied(){
        return isOccupied;
    }

    // Set the seat to be occupied
    public void setIsOccupiedTrue(){
        isOccupied = true;
    }

    // Set the seat to be available
    public void setIsOccupiedFalse(){
        isOccupied = false;
    }

}
