package Panels;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args)
    {
        JLabel label = new JLabel();
        label.setText("Hi");
        label.setForeground(Color.CYAN);
        label.setFont(new Font("Papyrus", Font.BOLD, 48));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(262,262,250,250);
        redPanel.setLayout(new BorderLayout());

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(262,512,250,250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(512,262,250,250);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);
        yellowPanel.setBounds(512,512,250,250);

        JFrame frame = new JFrame();
        frame.setSize(1024,1024);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
        frame.add(yellowPanel);
        redPanel.add(label);
        frame.setVisible(true);
    }
}
