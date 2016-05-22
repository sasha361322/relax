package pack;

import javax.swing.*;
import java.awt.*;

    class ImagePanel extends JPanel {
        ImagePanel(String img, int x, int y) {
            this(new ImageIcon(img).getImage());
            setLayout(null);
            setLocation(x,y);
        }
        private ImagePanel(Image img) {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
        }
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
        private Image img;
    }

