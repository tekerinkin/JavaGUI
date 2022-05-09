package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameButton extends JFrame implements ActionListener {

    JButton button;
    JLabel label;

    FrameButton() {

        ImageIcon icon = new ImageIcon("smile.jpg");
        label = new JLabel();
        label.setIcon(icon);
        label.setBounds(100,200,700,700);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(100, 100, 100, 80);
        button.addActionListener(this);
        button.setText("Click!");
        button.setFont(new Font("Papyrus", Font.BOLD, 25));
        //button.setFocusable(false);
        button.setForeground(Color.RED);
        button.setBackground(Color.CYAN);
        //button.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 1024);
        this.setLayout(null);
        this.add(button);
        this.setVisible(true);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("Poo");
            button.setEnabled(false);
            label.setVisible(true);
        }
    }

}
