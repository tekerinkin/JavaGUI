package Labels;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
        public MyFrame() {
            this.setTitle("Title");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(420,420);
            this.setLayout(null);
            this.setVisible(true);
            this.getContentPane().setBackground(new Color(255,255,255));
        }

        public MyFrame(int width, int height) {
            this.setTitle("Title");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(width,height);
            this.setLayout(null);
            this.setVisible(true);
            this.getContentPane().setBackground(new Color(255,255,255));
        }

        public MyFrame(int width, int height, Color color)
        {
            this.setTitle("Title");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(width,height);
            this.setVisible(true);
            this.setLayout(null);
            this.getContentPane().setBackground(color);
        }
}
