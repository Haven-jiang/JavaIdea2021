import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MiniMusicPlayer3 {
    static JFrame frame = new JFrame("My First Music Video");
    static MyDrawPanel ml;

    public static void main(String[] args){
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.start();
    }

    public void setUpGui(){
        ml = new MyDrawPanel();
        frame.setContentPane(ml);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void start(){
        setUpGui();

        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            sequencer.addControllerEventListener(ml, new int[]{127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i += 4){
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i+2));
            }
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        }catch(Exception EX){
            EX.printStackTrace();
        }
    }

    public MidiEvent makeEvent (int comd,int chan, int one, int two, int tick){
        MidiEvent event = null;

        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        }catch (Exception Ex){
            System.out.println("Error!");
        }
        return event;
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener{
        boolean msg = false;

        public void controlChange(ShortMessage event){
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics Gra){
            if (msg){
               Graphics2D G2D = (Graphics2D) Gra;
               int Red = (int) (Math.random() * 250);
               int Green = (int) (Math.random() * 250);
               int Blue = (int) (Math.random() * 250);

               Gra.setColor(new Color(Red, Green, Blue));

               int High = (int) ((Math.random() * 120) + 10);
               int Width = (int) ((Math.random() * 120) + 10);

               int X = (int) ((Math.random() * 40) + 10);
               int Y = (int) ((Math.random() * 40) + 10);

               Gra.fillRect(X, Y, Width, High);
               msg = false;
            }
        }
    }
}
