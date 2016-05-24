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
        text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setLocation(400,350);
        text.setSize(200,100);
        clock.add(text);
        ImagePanel therm = new ImagePanel("./img/thermometer.jpg", 155, 20);
        clock.add(Garden_bed.temperature);
        getContentPane().add(therm);
        getContentPane().add(Garden_bed.garden);
        getContentPane().add(Watering_machine.machine);
        getContentPane().add(clock);
        setVisible(true);
    }
    private static final int DEFAULT_WIDTH = 900;
    private static final int DEFAULT_HEIGHT = 600;
}
