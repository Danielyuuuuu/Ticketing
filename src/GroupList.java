/**
 * To keep track of all the groups
 *
 * @author Yifei Yu
 */

import java.util.ArrayList;

public class GroupList {
    private final ArrayList<Group> groups;

    // The constructor, to initialize an arraylist of Group
    public GroupList(){
        groups = new ArrayList<>();
    }

    // To add a group to the groups arraylist
    public void addGroup(Group group){
        groups.add(group);
    }

    // Override the toString method to return the groupings
    public String toString(){
        StringBuilder str = new StringBuilder("{");
        for(int i = 0; i < groups.size(); i++){
            str.append(groups.get(i));
            if(i < groups.size() - 1){
                str.append(", ");
            }
        }
        str.append("}");
        return str.toString();
    }
}
