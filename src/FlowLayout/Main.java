package FlowLayout;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250,250));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());

        panel.add(new Button("1"));
        panel.add(new Button("2"));
        panel.add(new Button("3"));
        panel.add(new Button("4"));
        panel.add(new Button("5"));
        panel.add(new Button("6"));
        panel.add(new Button("7"));
        panel.add(new Button("8"));
        panel.add(new Button("9"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
