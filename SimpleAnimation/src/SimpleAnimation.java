import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleAnimation {
    private int x = 70;
    private int y = 70;

    MyDrawPanel panel;
    JButton button;
    buttonListener bonLis;
    JFrame frame;

    public static void main(String[] args){
        SimpleAnimation Gui = new SimpleAnimation();
        Gui.start();
    }

    public void start(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button =new JButton();
        panel = new MyDrawPanel();
        button.setText("click me!");
        button.addActionListener(bonLis = new buttonListener());

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }

    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent AE) {
            for (int i = 0; i < 500; i++) {
                x++;
                y++;
                
                panel.update(panel.getGraphics());

                try {
                    Thread.sleep(3);
                } catch (Exception ex) {
                    System.out.println("error!");
                }
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
