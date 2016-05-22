import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class test {
    static MyFrame frame;
    static Clock clock;
    static Stop stop;
    static Timer timer;
    static SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new MyFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Tick();
                    }
                });
                timer.start();
            }
        });
    }
    static class Stop extends JButton{
        public Stop(){
            setSize(60,60);
            setLocation(100,100);
            setText("Stop");
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (stop.getText().equals("Stop")){
                        stop.setText("Start");
                        timer.stop();
                    }
                    else {
                        stop.setText("Stop");
                        timer.start();
                    }
                    frame.repaint();
                }
            });
        }
    }
    static void Tick(){
        frame.repaint();
    }
    static class MyFrame extends JFrame{
        public MyFrame(){
            setTitle("Test");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

            clock = new Clock(200,200);
            stop = new Stop();
            //stop.setLocation(300,200);
            clock.add(stop);
            getContentPane().add(clock);
            setLocationRelativeTo(null);
            setVisible(true);
        }
        public static final int DEFAULT_WIDTH = 600;
        public static final int DEFAULT_HEIGHT = 300;
    }
    static class Clock extends JPanel{
        public Clock(int x, int y){
            setLayout(null);
            setSize(600,300);
            x_Location=x;
            y_Location=y;
            now = new GregorianCalendar(Locale.US);
        }
        @Override
        public void paintComponent(Graphics gr){
            gr.setColor(Color.BLACK);
            gr.drawOval(x_Location, y_Location, DEFAULT_RADIUS+1, DEFAULT_RADIUS+1);
            gr.setColor(Color.WHITE);
            gr.fillOval(x_Location, y_Location, DEFAULT_RADIUS, DEFAULT_RADIUS);
            String time = df.format(now.getTime());
            gr.setColor(Color.BLACK);
            gr.drawString(time, x_Location+7, y_Location+35);
            now.add(Calendar.SECOND, 1);
        }
        private int x_Location;
        private int y_Location;
        private static int DEFAULT_RADIUS=60;
        private GregorianCalendar now;
    }
}
