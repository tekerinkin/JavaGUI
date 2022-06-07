package Lab2.AnimatedSprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel panel;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;


    public Player(GamePanel panel, KeyHandler keyH){
        this.panel = panel;
        this.keyH = keyH;

        screenX = panel.screenWidth/2 - (panel.tileSize/2);
        screenY = panel.screenHeight/2 - (panel.tileSize/2);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = 100;
        worldY = 100;
        speed = 4;
        direction = "up";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().
                    getResourceAsStream("/Sprite/boy_up_1.png"));
            up2 = ImageIO.read(getClass().
                    getResourceAsStream("/Sprite/boy_up_2.png"));
            down1 = ImageIO.read(getClass().
                    getResourceAsStream("/Sprite/boy_down_1.png"));
            down2 = ImageIO.read(getClass().
                    getResourceAsStream("/Sprite/boy_down_2.png"));
            left1 = ImageIO.read(getClass().
                    getResourceAsStream("/Sprite/boy_left_1.png"));
            left2 = ImageIO.read(getClass().
                    getResourceAsStream("/Sprite/boy_left_2.png"));
            right1 = ImageIO.read(getClass().
                    getResourceAsStream("/Sprite/boy_right_1.png"));
            right2 = ImageIO.read(getClass().
                    getResourceAsStream("/Sprite/boy_right_2.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.left || keyH.right
                || keyH.down || keyH.up) {
            if(keyH.up){
                direction = "up";
                worldY -= speed;
            }
            else if(keyH.down){
                direction = "down";
                worldY += speed;
            }
            else if(keyH.left){
                direction = "left";
                worldX -= speed;
            }
            else if(keyH.right){
                direction = "right";
                worldX += speed;
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1)
                    spriteNum = 2;
                else if(spriteNum == 2)
                    spriteNum = 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch(direction){
            case "up" -> {
                if(spriteNum == 1)
                    image = up1;
                else if(spriteNum == 2)
                    image = up2;
            }
            case "down" -> {
                if(spriteNum == 1)
                    image = down1;
                else if(spriteNum == 2)
                    image = down2;
            }
            case "left" -> {
                if(spriteNum == 1)
                    image = left1;
                else if(spriteNum == 2)
                    image = left2;
            }
            case "right" -> {
                if(spriteNum == 1)
                    image = right1;
                else if(spriteNum == 2)
                    image = right2;
            }
        }

        g2.drawImage(image, screenX, screenY, panel.tileSize, panel.tileSize, null);
    }
}
