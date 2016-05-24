package pack;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static pack.Gardener1.df;

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
        now.add(Calendar.MILLISECOND, 1550);
        setVisible(true);
    }
    Date getTime(){
        return now.getTime();
    }
    private int x_Location;
    private int y_Location;
    private static int DEFAULT_RADIUS=60;
    private GregorianCalendar now;
}