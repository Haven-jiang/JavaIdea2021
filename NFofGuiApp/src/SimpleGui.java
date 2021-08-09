import javax.swing.*;
import java.util.Scanner;

public class SimpleGui {
    JFrame frame = new JFrame();
    JButton button = new JButton("Click me");

    public static void main(String [] args){
        Scanner inputC = new Scanner(System.in);
        SimpleGui GUI =new SimpleGui();
        GUI.changeIt(inputC.next());

        GUI.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI.frame.getContentPane().add(GUI.button);

        GUI.frame.setSize(300, 30);

        GUI.frame.setVisible(true);
    }

    public void changeIt(String text){
        button.setText(text);
    }
}
