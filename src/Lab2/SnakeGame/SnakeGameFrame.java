package Lab2.SnakeGame;

import javax.swing.*;

public class GameFrame extends JFrame{

    GamePanel panel;

    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
