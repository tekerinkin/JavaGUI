package application;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;

import application.MyFrame;


public class Main {

    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("image.png");
        Border border = BorderFactory.createLineBorder(Color.green,3);

        JLabel label = new JLabel();
        label.setText("Hello World!");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setForeground(Color.GREEN);
        label.setFont(new Font("Papyrus", Font.PLAIN,20));
        label.setIconTextGap(100);
        label.setBackground(new Color(0xFFFFFF));
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0,0,500,500);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024,1024);
        frame.setLayout(null);
        frame.add(label);
        frame.setVisible(true);
    }
}
