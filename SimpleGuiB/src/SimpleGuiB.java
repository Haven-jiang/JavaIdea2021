import javax.swing.*;
import java.awt.event.*;

public class SimpleGuiB implements ActionListener{
    private JButton button;

    public static void main(String[] args){
        SimpleGuiB Gui = new SimpleGuiB();
        Gui.start();
    }

    public void start(){
        JFrame frame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 90);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        button.setText("I've been clicked!!!");
    }
}