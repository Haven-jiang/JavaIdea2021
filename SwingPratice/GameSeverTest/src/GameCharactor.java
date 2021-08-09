import java.io.*;

public class GameCharactor implements Serializable{
    int power;
    String type;
    String[] weapons;

    public GameCharactor(int p, String t, String[] w){
        power = p;
        type = t;
        weapons = w;
    }

    public int getPower(){
        return power;
    }

    public String getType(){return type;}

    public String getWeapons(){
        String weaponList = "";

        for (int i = 0; i < weapons.length; i++){
            weaponList += weapons[i] + " ";
        }
        return weaponList;
    }
}