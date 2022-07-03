/**
 * To represent a group
 *
 * @author Yifei Yu
 */

import java.util.ArrayList;

public class Group {

    // To store a list of seat positions of a group
    private final ArrayList<SeatPosition> group;

    // The constructor, to initialize the group arraylist
    public Group(){
        group = new ArrayList<>();
    }

    // To add a seat position to the group
    public void addNewSeatPosition(SeatPosition seatPosition){
        group.add(seatPosition);
    }

    // Override the toString method to return the grouping
    public String toString(){
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < group.size(); i++){
            if(i < group.size() - 1){
                str.append(group.get(i));
                str.append(", ");
            }
            else{
                str.append(group.get(i));
            }
        }
        str.append("]");
        return str.toString();
    }
}
