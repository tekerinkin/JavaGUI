package Lab2;

import javax.swing.*;
import java.awt.*;

public class NewWindow {

    JFrame frame;
    ImageIcon icon;
    JLabel label;
    JLabel textLabel;

    NewWindow() {
        frame = new JFrame();
        //label = new JLabel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1024,1024);

        frame.setVisible(true);
    }

    void add_image()
    {
        if(label == null){
            icon = new ImageIcon("image.png");
            label = new JLabel(icon);
            label.setBounds(0,0,icon.getIconWidth(), icon.getIconHeight());
            //label.setIcon(icon);
            frame.add(label);

            frame.repaint();
        }
    }

    void move_image(int x, int y)
    {
        if(label != null){
            label.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
            label.repaint();
        }
    }

    void change_color(String color)
    {
            switch(color){
                case "red" -> frame.getContentPane().setBackground(Color.RED);
                case "blue" -> frame.getContentPane().setBackground(Color.blue);
                case "green" -> frame.getContentPane().setBackground(Color.green);
                case "yellow" -> frame.getContentPane().setBackground(Color.YELLOW);
                case "black" -> frame.getContentPane().setBackground(Color.BLACK);
                case "white" -> frame.getContentPane().setBackground(Color.WHITE);
            };

            frame.repaint();
    }

    void delete_image()
    {
        if(label != null) {
            frame.remove(label);
            label = null;
            frame.repaint();
        }
    }

    void input(String text)
    {
       if(textLabel == null)
       {
           textLabel = new JLabel(text);
           textLabel.setBounds(0,500, 1000, 40);
           textLabel.setFont(new Font("Papyrus", Font.PLAIN, 40));
           frame.add(textLabel);
       }
       else
       {
           System.out.println("textLabel else" + textLabel.getText());
           textLabel.setText(textLabel.getText() + "\t" + text);
           frame.repaint();
       }
    }
}
