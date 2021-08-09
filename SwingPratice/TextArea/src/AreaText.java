import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaText {
    JTextArea text;

    public static void main(String[] args){
        AreaText Gui = new AreaText();
        Gui.start();
    }

    public void start(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton();
        button.addActionListener(new butListen());
        text.setLineWrap(true);

        JScrollPane scroller = new JScrollPane();
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(650, 450);
        frame.setVisible(true);
    }

    class butListen implements ActionListener{
        public void actionPerformed(ActionEvent Ac){
            text.append("button clicked \n");
        }
    }
}
