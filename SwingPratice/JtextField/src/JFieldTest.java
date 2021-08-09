import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFieldTest {

    JFrame frame;
    JTextField field;
    JLabel label;
    JLabel label2;
    JPanel panel;
    String aText;

    public static void main(String[] args){
        JFieldTest Gui = new JFieldTest();
        Gui.start();
    }

    void start(){
        label2 =new JLabel();
        JButton button = new JButton("Click it");
        frame = new JFrame("First Frame");
        field = new JTextField(20);
        label = new JLabel("Name(N): ");
        panel = new JPanel();

        field.addActionListener(new fieldListen());
        button.addActionListener(new fieldListen());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        panel.add(label);
        panel.add(field);
        panel.add(label2);
        frame.setSize(600, 600);
        frame.setVisible(true);

    }

    class fieldListen implements ActionListener{
        public void actionPerformed(ActionEvent Ac){
            label2.setText("已保存！");
            aText = field.getText();
            field.requestFocus();
        }
    }
}
