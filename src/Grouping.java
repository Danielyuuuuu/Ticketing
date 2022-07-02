import java.util.ArrayList;

public class Grouping {

    private ArrayList<ArrayList<SeatPosition>> grouping;

    public Grouping(){
        grouping = new ArrayList<>();
    }

    public void addGrouping(ArrayList<SeatPosition> seatPositions){
        grouping.add(seatPositions);
    }

    public String toString(){
        String str = "{";
        for(int i = 0; i < grouping.size(); i++){
            str = str + "[";
            for(SeatPosition seatPosition: grouping.get(i)){
                str = str + seatPosition + " ";
            }
            if(i == grouping.size() - 1){
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
