package Lab2.PingPong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle{

    Random rnd;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;
    Ball(int x, int y, int width, int height){
        super(x, y, width, height);
        rnd = new Random();

        int rndXDirection = rnd.nextInt(2);
        if(rndXDirection == 0)
            rndXDirection--;
        setXDirection(rndXDirection * initialSpeed);

        int rndYDirection = rnd.nextInt(2);
        if(rndYDirection == 0)
            rndYDirection--;
        setYDirection(rndYDirection * initialSpeed);
    }

    public void setXDirection(int randomXDirection){
        xVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection){
        yVelocity = randomYDirection;
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }

    public void move(){
        x += xVelocity;
        y += yVelocity;
    }

}
