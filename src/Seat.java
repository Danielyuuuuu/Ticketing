public class Seat {

    private Boolean isOccupied;

    public Seat(){
        isOccupied = false;
    }

    public Boolean getIsOccupied(){
        return isOccupied;
    }

    public void setIsOccupiedTrue(){
        isOccupied = true;
    }

    public void setIsOccupiedFalse(){
        isOccupied = false;
    }

}
