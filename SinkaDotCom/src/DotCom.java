import java.util.*;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setName(String Name){
        this.name = Name;
    }
    public void setLocationCells(ArrayList<String> loc){
        this.locationCells = loc;
    }
    public String checkYourself(String userInput){
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if(index >= 0){
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + "  : ( ");
            }else {
                result = "hit";
            }
        }
        return result;
    }
}