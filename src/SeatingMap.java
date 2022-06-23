import java.util.ArrayList;

public class SeatingMap {
    private Seat[][] seatingMap;
    private final int rows;
    private final int cols;

    public SeatingMap(int rows, int cols){
        seatingMap = new Seat[rows][cols];
        this.rows = rows;
        this.cols = cols;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                seatingMap[i][j] = new Seat();
            }
        }
    }

    public void getAvailableSeats(){
        System.out.println("row: " + rows);
        System.out.println("col: " + cols);
        for(int i = 0; i < rows; i++){
            if(i == 0){
                System.out.print("*");
                System.out.print("\t");
                for (int c = 0; c < cols; c++){
                    System.out.print(c);
                    System.out.print("\t");
                }
                System.out.println("\n");
            }

            System.out.print(i);
            System.out.print("\t");

            for(int j = 0; j < cols; j++){
                if(seatingMap[i][j].getIsOccupied()){
                    System.out.print("/");
                }
                else{
                    System.out.print("A");
                }
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }

    public Boolean selectSeat(int rowSelected, int colSelected){
        if (rowSelected < 0 || rowSelected >= rows || colSelected < 0 || colSelected >= cols){
            return false;
        }
        if(seatingMap[rowSelected][colSelected].getIsOccupied()){
            return false;
        }
        seatingMap[rowSelected][colSelected].setIsOccupiedTrue();
        return true;
    }
}
