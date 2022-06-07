package Lab2.SnakeGame;

import javax.swing.*;

public class SnakeGameFrame extends JFrame{

    GamePanel panel;

    public SnakeGameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
