import java.io.*;

public class GameSaverTest{
    public static void main(String[] args){
        GameCharactor one = new GameCharactor(50, "Elf", new String[] {"bow", "sword", "dust"});
        GameCharactor two = new GameCharactor(200, "Troll", new String[] {"bare hands", "big ax"});
        GameCharactor three = new GameCharactor(120, "Magician", new String[] {"spells", "invisibility"});
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            oos.writeObject(one);
            oos.writeObject(two);
            oos.writeObject(three);
            oos.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        one = null;
        two = null;
        three = null;

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharactor oneRestore = (GameCharactor) ois.readObject();
            GameCharactor twoRestore = (GameCharactor) ois.readObject();
            GameCharactor threeRestore = (GameCharactor) ois.readObject();

            System.out.println("one's type: " + oneRestore.getType());
            System.out.println("two's type: " + twoRestore.getType());
            System.out.println("three's type: " + threeRestore.getType());

            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}