package Lab2;

import javax.swing.*;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragArea extends JPanel {
    ImageIcon image;
    Point imageCorner;
    Point prevPt;
    int imageWidth;
    int imageHeight;

    DragArea(String filename) {
        image = new ImageIcon(filename);
        imageWidth = image.getIconWidth();
        imageHeight = image.getIconHeight();
        imageCorner = new Point(0,0);
        ClickListner clickListner = new ClickListner();
        DragListner dragListner = new DragListner();
        this.setBounds(100,100,imageWidth, imageHeight);
        this.addMouseListener(clickListner);
        this.addMouseMotionListener(dragListner);
        this.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        image.paintIcon(this, g, (int)imageCorner.getX(),
                (int)imageCorner.getY());

    }

    private class ClickListner extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            prevPt = e.getPoint();
        }
    }

    private class DragListner extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            Point currentPt = e.getPoint();
            imageCorner.translate(
                    (int)(currentPt.getX() - prevPt.getX()),
                    (int)(currentPt.getY() - prevPt.getY())
            );
            prevPt = currentPt;
            repaint();
        }
    }

}
