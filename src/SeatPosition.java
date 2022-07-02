public class SeatPosition {
    private int row;
    private int col;

    public SeatPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

    public String toString(){
        String str = "(" + row + ", " + col + ")";
        return str;
    }
}
