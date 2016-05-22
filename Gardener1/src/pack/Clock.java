package pack;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

class Clock extends JPanel {
    Clock(){
        setLayout(null);
        setSize(900,600);
        x_Location=450;
        y_Location=460;
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
        setVisible(true);
    }
    private static SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
    private int x_Location;
    private int y_Location;
    private static int DEFAULT_RADIUS=60;
    private GregorianCalendar now;
}