package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class NewWindow extends JFrame {

    JLabel textLabel;
    DragArea area;
    JLabel label;
    ImageIcon icon;
    int angle;

    NewWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1024, 1024);
        this.setResizable(false);


        this.setVisible(true);

    }

    void addImage(String filename) {
        if (label == null) {
            icon = new ImageIcon(filename);
            label = new JLabel(icon);
            label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
            label.setVisible(true);
            this.add(label);
            this.revalidate();
        }
    }

    void moveImage(int x, int y) {
        if (label != null) {
            label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
            label.repaint();
        }
    }

    void changeColor(String color) {
        switch (color) {
            case "red" -> this.getContentPane().setBackground(Color.RED);
            case "blue" -> this.getContentPane().setBackground(Color.blue);
            case "green" -> this.getContentPane().setBackground(Color.green);
            case "yellow" -> this.getContentPane().setBackground(Color.YELLOW);
            case "black" -> this.getContentPane().setBackground(Color.BLACK);
            case "white" -> this.getContentPane().setBackground(Color.WHITE);
        }
        ;

        repaint();
    }

    void deleteImage() {
        if (label != null) {
            this.remove(label);
            label = null;
            repaint();
        }
    }

    void input(String text) {
        if (textLabel == null) {
            textLabel = new JLabel(text);
            textLabel.setBounds(0, 500, 1000, 40);
            textLabel.setFont(new Font("Papyrus", Font.PLAIN, 40));
            this.add(textLabel);
            repaint();
        } else {
            //System.out.println("textLabel else" + textLabel.getText());
            textLabel.setText(textLabel.getText() + "\t" + text);
            repaint();
        }
    }

    void setFont(String name, int size, int smt) {
        textLabel.setFont(new Font(name, size, smt));
        textLabel.repaint();
        repaint();
    }

    void moveFont(int x, int y) {
        textLabel.setBounds(x, y,
                textLabel.getWidth(), textLabel.getHeight());
        textLabel.repaint();
        repaint();
    }

    void addDragImage(String filename) {
        area = new DragArea(filename + ".png");
        this.add(area);
        repaint();
    }

    public void paint(Graphics g){
        if(label != null){
            Graphics2D g2D = (Graphics2D) g;
            AffineTransform at = g2D.getTransform();
            at.rotate(Math.toRadians(angle), label.getX() + label.getWidth()/2,
                    label.getY() + label.getHeight()/2);
            g2D.setTransform(at);
            g2D.drawImage(icon.getImage(), label.getX(), label.getY(), null);
            super.paint(g);
        }
    }

    void setAngle(int angle)
    {
        this.angle += angle;
    }

}
