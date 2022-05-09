package application;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
        MyFrame() {
            this.setTitle("Title");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(420,420);
            this.setVisible(true);

            this.getContentPane().setBackground(new Color(123,50,250));
        }
}
