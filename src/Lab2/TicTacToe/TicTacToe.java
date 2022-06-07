package Lab2.TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {

    Random rnd;
    JPanel title_panel;
    JPanel button_panel;
    JLabel textLabel;
    JButton[] buttons;
    boolean player1_turn;

    public TicTacToe() {
        super();
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        textLabel.setBackground(new Color(25, 25, 25));
        textLabel.setForeground(new Color(25, 255, 0));
        textLabel.setFont(new Font("Ink Free", Font.BOLD, 75));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; ++i) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textLabel);
        this.add(title_panel, BorderLayout.NORTH);
        this.add(button_panel);

        firstTurn();
    }

    public void init() {
        rnd = new Random();
        title_panel = new JPanel();
        button_panel = new JPanel();
        textLabel = new JLabel();
        buttons = new JButton[9];
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; ++i) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textLabel.setText("O turn");
                        check();
                    }
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textLabel.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (rnd.nextInt(2) == 0) {
            player1_turn = true;
            textLabel.setText("X turn");
        } else {
            player1_turn = false;
            textLabel.setText("O turn");
        }
    }

    public void check() {

        if (
                (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[1].getText(), "X")) &&
                        (Objects.equals(buttons[2].getText(), "X"))
        ) {
            xWins(0, 1, 2);
        }

        if (
                (Objects.equals(buttons[3].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[5].getText(), "X"))
        ) {
            xWins(3, 4, 5);
        }

        if (
                (Objects.equals(buttons[6].getText(), "X")) &&
                        (Objects.equals(buttons[7].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(6, 7, 8);
        }

        if (
                (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[3].getText(), "X")) &&
                        (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWins(0, 3, 6);
        }

        if (
                (Objects.equals(buttons[1].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[7].getText(), "X"))
        ) {
            xWins(1, 4, 7);
        }

        if (
                (Objects.equals(buttons[2].getText(), "X")) &&
                        (Objects.equals(buttons[5].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(2, 5, 8);
        }

        if (
                (Objects.equals(buttons[0].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[8].getText(), "X"))
        ) {
            xWins(0, 4, 8);
        }

        if (
                (Objects.equals(buttons[2].getText(), "X")) &&
                        (Objects.equals(buttons[4].getText(), "X")) &&
                        (Objects.equals(buttons[6].getText(), "X"))
        ) {
            xWins(2, 4, 6);
        }

        if (
                (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[1].getText(), "O")) &&
                        (Objects.equals(buttons[2].getText(), "O"))
        ) {
            oWins(0, 1, 2);
        }
        if (
                (Objects.equals(buttons[3].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[5].getText(), "O"))
        ) {
            oWins(3, 4, 5);
        }

        if (
                (Objects.equals(buttons[6].getText(), "O")) &&
                        (Objects.equals(buttons[7].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(6, 7, 8);
        }

        if (
                (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[3].getText(), "O")) &&
                        (Objects.equals(buttons[6].getText(), "O"))
        ) {
            oWins(0, 3, 6);
        }

        if (
                (Objects.equals(buttons[1].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[7].getText(), "O"))
        ) {
            oWins(1, 4, 7);
        }

        if (
                (Objects.equals(buttons[2].getText(), "O")) &&
                        (Objects.equals(buttons[5].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(2, 5, 8);
        }

        if
        (
                (Objects.equals(buttons[0].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[8].getText(), "O"))
        ) {
            oWins(0, 4, 8);
        }

        if (
                (Objects.equals(buttons[2].getText(), "O")) &&
                        (Objects.equals(buttons[4].getText(), "O")) &&
                        (Objects.equals(buttons[6].getText(), "O"))
        ) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textLabel.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textLabel.setText("O wins");
    }


}
