/**
 * To keep track of the grouping for each movie
 *
 * @author Yifei Yu
 */

import java.util.ArrayList;

public class Group {

    // To store a list of seat positions of a group
    private ArrayList<SeatPosition> group;

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
        String str = "[";
        for(int i = 0; i < group.size(); i++){
            if(i < group.size() - 1){
                str = str + group.get(i) + ", ";
            }
            else{
                str = str + group.get(i);
            }
        }
        str = str + "]";
        return str;
    }
}
