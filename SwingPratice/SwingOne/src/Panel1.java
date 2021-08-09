import javax.swing.*;
import java.awt.*;

public class Panel1 {

    public static void main(String [] args){
        Panel1 Gui = new Panel1();
        Gui.start();
    }

    public void start(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button1 = new JButton("这是一个按钮");
        JButton button2 = new JButton("这也是");
//        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        panel.add(button1);
        panel.add(button2);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
