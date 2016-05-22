package pack;

import javax.swing.*;

import static pack.Gardener1.*;

class MyFrame extends JFrame {

    MyFrame(){
        setTitle("Gardener");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        clock = new Clock();
        stop = new Stop();
        clock.add(stop);
        ImagePanel garden = new ImagePanel("./img/garden_bed.jpg", 50, 20);
        ImagePanel therm = new ImagePanel("./img/thermometer.jpg", 155, 20);
        JLabel temp = new JLabel(String.valueOf(garden_bed.getThemperature()));
        temp.setLocation(155,85);
        temp.setSize(100,50);
        clock.add(temp);
        getContentPane().add(therm);        //2 чая тому, кто объяснит,
        getContentPane().add(garden);       //почему, если поменять эти 3 строчки
        getContentPane().add(clock);        //последний добавленный элемент будет в точке (0.0)
        setVisible(true);
    }
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 600;
}
