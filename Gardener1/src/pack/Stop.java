package pack;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static pack.Gardener1.*;

class Stop extends JButton {
    Stop(){
        setBounds(440, 520, 80, 40);
        setText("Stop");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getText().equals("Stop")){
                    setText("Start");
                    timer.stop();
                }
                else {
                    setText("Stop");
                    timer.start();
                }
                frame.repaint();
            }
        });
    }
}
