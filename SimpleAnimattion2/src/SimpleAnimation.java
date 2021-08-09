import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    private int x = 70;
    private int y = 70;

    MyDrawPanel panel;
    JFrame frame;

    public static void main(String[] args){
        SimpleAnimation Gui = new SimpleAnimation();
        Gui.start();
    }

    public void start(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        for (int i = 0; i < 500; i++) {
            x++;
            y++;

            panel.repaint();
            try {
                Thread.sleep(300);
            } catch (Exception ex) {
                System.out.println("error!");
            }
        }
    }

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics Gra){
            Gra.setColor(Color.white);
            Gra.fillRect(0, 0, this.getWidth(), this.getHeight());

            Gra.setColor(Color.orange);
            Gra.fillOval(x, y, 40, 40);

        }
    }
}