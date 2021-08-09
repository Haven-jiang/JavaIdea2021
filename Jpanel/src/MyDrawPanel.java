import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class MyDrawPanel implements ActionListener {

    JButton colorButton;
    JButton labelButton;
    JFrame frame;
    JLabel label;

    int iCount = 0;
    Color GColor = Color.green;
    Color BColor = Color.blue;
    Color RColor = Color.red;
    ArrayList<Color> RandomColors = new ArrayList<Color>(10);

    public MyDrawPanel(){
        for(int i=0; i <10; i++) {
            int blue = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int red = (int) (Math.random() * 255);

            RandomColors.add(new Color(red, green, blue));
        }
    }

    public static void main(String[] args){
        MyDrawPanel panel = new MyDrawPanel();
        panel.start();
    }

    public void start(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        colorButton = new JButton("Click me!");
        labelButton = new JButton("Change Label");
        colorButton.addActionListener(this);
        labelButton.addActionListener(this);

        label = new JLabel();
        label.setText("It was Changed " + this.iCount + " 's");

        MyDrawPanelTwo drawPanel = new MyDrawPanelTwo();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        label.setSize(150, 150);
        frame.setSize(1500, 1500);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == colorButton) frame.repaint();
        if (event.getSource() == labelButton) label.setText("It was Changed " + iCount++ +  " 's");
    }

    class MyDrawPanelTwo extends JPanel {
        public void paintComponent(Graphics g) {
            int INT = (int) (Math.random() * 4);

            if (INT == 1) {
                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gradient = new GradientPaint(30, 30, RandomColors.get((int) (Math.random() * 9)),
                        1500, 1500, RandomColors.get((int) (Math.random() * 9)));

                g2d.setPaint(gradient);

                g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

            }else if(INT == 2){

                g.setColor(BColor);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());

            }else if(INT == 3){

                Image image = new ImageIcon("/home/collapsed/图片/image.jpg").getImage();

                g.drawImage(image, 0, 0, this);
            }else {
                g.fillRect(0, 0, this.getWidth(), this.getHeight());

                g.setColor(RandomColors.get((int)(Math.random() * 9)));
                g.fillOval(0, 0, this.getWidth(), this.getHeight());
            }
        }
    }
}