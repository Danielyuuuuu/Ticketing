import java.util.ArrayList;

public class GroupList {
    private ArrayList<Group> groups;

    // The constructor, to initialize an arraylist of Group
    public GroupList(){
        groups = new ArrayList<>();
    }

    // To add a group to the groups arraylist
    public void addGroup(Group group){
        groups.add(group);
    }

    // Override the toString method to return the grouping
    public String toString(){
        String str = "{";
        for(int i = 0; i < groups.size(); i++){
            str = str + groups.get(i);
            if(i < groups.size() - 1){
                str = str + ", ";
            }
        }
        str = str + "}";
        return str;
    }
}
