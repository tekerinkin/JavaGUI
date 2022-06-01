package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

class DrawCircle implements Runnable {
    int MAX_X, MAX_Y;

    Graphics g;
    JPanel panel;

    ArrayList<Color> colors = new ArrayList<Color>(Arrays.asList(Color.RED, Color.BLUE,
            Color.GREEN, Color.CYAN, Color.YELLOW));

    Random ranX = new Random();
    Random ranY = new Random();
    Random r = new Random();

    DrawCircle(JPanel panel) {
        super();
        this.panel = panel;
        g = panel.getGraphics();
        MAX_X = panel.getX() + panel.getWidth();
        MAX_Y = panel.getY() + panel.getHeight();
    }

    @Override
    public void run() {
        while (true) {
            int x = ranX.nextInt(MAX_X-100);
            int y = ranY.nextInt(MAX_Y-100);
            int i = r.nextInt(colors.size());

            g.setColor(colors.get(i));
            g.fillOval(x, y, 50, 50);

            try {
                Thread.sleep(500);
                panel.repaint();
                Thread.sleep(5);
            } catch (Exception e) {
                System.err.println("" + e.getMessage());
            }
        }
    }
}

public class AnimationForm implements ActionListener {

    Graphics g;
    Thread animationThread;
    JPanel panel;
    JButton btnStart;
    JButton btnStop;
    JFrame frame;

    AnimationForm() {
        initComponents();

        g = panel.getGraphics();
        panel.paintComponents(g);
    }

    private void initComponents() {
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1024, 1024);
        frame.setResizable(false);

        btnStart = new JButton("Start");
        btnStart.setFocusable(false);
        btnStart.setFont(new Font("Times", Font.PLAIN, 20));
        btnStart.setBounds(287, 100, 200, 100);
        btnStart.addActionListener(this);

        btnStop = new JButton("Stop");
        btnStop.setFocusable(false);
        btnStop.setFont(new Font("Times", Font.PLAIN, 20));
        btnStop.setBounds(537, 100, 200, 100);
        btnStop.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(200, 300, 624, 600);
        panel.setBackground(Color.white);

        frame.add(btnStart);
        frame.add(btnStop);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            animationThread = new Thread(new DrawCircle(panel));
            animationThread.start();
        } else if (e.getSource() == btnStop) {
            animationThread.stop();
            panel.repaint();
        }
    }

}
