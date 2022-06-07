package Lab2.AnimatedSprite;

import javax.swing.*;

public class SpriteFrame extends JFrame {
    GamePanel panel;

    public SpriteFrame(){
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Animation");

        panel = new GamePanel();
        this.add(panel);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
