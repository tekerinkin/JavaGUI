package Lab2.PingPong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    Thread thread;
    Image img;
    Graphics graphics;
    Random rnd;
    Paddle padd1;
    Paddle padd2;
    Ball ball;
    Score score;

    GamePanel() {
        newPaddle();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new Al());
        this.setPreferredSize(SCREEN_SIZE);

        thread = new Thread(this);
        thread.start();
    }

    public void newBall() {
        rnd = new Random();
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2),
                rnd.nextInt(GAME_HEIGHT - BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddle() {
        padd1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
                PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        padd2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2),
                PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }

    public void paint(Graphics g) {
        img = createImage(getWidth(), getHeight());
        graphics = img.getGraphics();
        draw(graphics);
        g.drawImage(img, 0, 0, this);
    }

    public void draw(Graphics g) {
        padd1.draw(g);
        padd2.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void move() {
        padd1.move();
        padd2.move();
        ball.move();
    }

    public void checkCollision() {
        if (ball.y <= 0)
            ball.setYDirection(-ball.yVelocity);
        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER)
            ball.setYDirection(-ball.yVelocity);

        if (ball.intersects(padd1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (ball.intersects(padd2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (padd1.y <= 0)
            padd1.y = 0;
        if (padd1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            padd1.y = GAME_HEIGHT - PADDLE_HEIGHT;

        if (padd2.y <= 0)
            padd2.y = 0;
        if (padd2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            padd2.y = GAME_HEIGHT - PADDLE_HEIGHT;

        if (ball.x <= 0) {
            score.player2++;
            newPaddle();
            newBall();
            System.out.println("Player 2: " + score.player2);
        }

        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player1++;
            newPaddle();
            newBall();
            System.out.println("Player 1: " + score.player1);
        }
    }

    public void run() {
        double FPS = 60.0;

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (true) {
            move();
            checkCollision();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0)
                    remainingTime = 0;

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (Exception e) {
                System.err.println(" " + e.getMessage());
            }
        }
    }

    public class Al extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            padd1.keyPressed(e);
            padd2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            padd1.keyReleased(e);
            padd2.keyReleased(e);
        }
    }

    public Dimension getScreenSize() {
        return SCREEN_SIZE;
    }
}
