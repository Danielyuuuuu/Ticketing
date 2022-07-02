/**
 * To keep track of the grouping for each movie
 *
 * @author Yifei Yu
 */

import java.util.ArrayList;

public class Grouping {

    // To store a list of groups by the seat position
    private ArrayList<ArrayList<SeatPosition>> groups;

    // The constructor, to initialize the groups arraylist
    public Grouping(){
        groups = new ArrayList<>();
    }

    // To add a group to the groups arraylist
    public void addGroup(ArrayList<SeatPosition> group){
        groups.add(group);
    }

    // Override the toString method to return the grouping
    public String toString(){
        String str = "{";
        for(int i = 0; i < groups.size(); i++){
            str = str + "[";
            ArrayList<SeatPosition> group = groups.get(i);
            for(int j = 0; j < group.size(); j++){
                if(j < group.size() - 1){
                    str = str + group.get(j) + ", ";
                }
                else{
                    str = str + group.get(j);
                }
            }

            if(i == groups.size() - 1){
                str = str + "]";
            }
            else{
                str = str + "], ";
            }
        }
        str = str + "}";
        return str;
    }
}
