package Lab2;

import Lab2.PingPong.GameFrame;
import Lab2.SnakeGame.SnakeGameFrame;
import Lab2.TicTacToe.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.HashSet;
import java.io.File;


public class MyFrame extends JFrame implements ActionListener {

    JFrame frame;
    JButton button;
    JButton button1;
    JTextField textField;
    JTextArea textArea;
    NewWindow window;
    AnimationForm aniForm;
    GameFrame gameFrame;
    SnakeGameFrame snakeGameFrame;
    TicTacToe ticTacGame;

    HashSet<String> valid_commands = new HashSet<String>(Arrays.asList("move", "add",
            "input", "change_color", "delete", "change_font",
            "move_font", "paint", "start_animation", "rotate", "start_game"));

    MyFrame() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 1024);
        frame.setResizable(false);

        button = new JButton("Clean");
        button.setFocusable(false);
        button.setFont(new Font("Papyrus", Font.PLAIN, 20));
        button.setBounds(402, 924, 100, 80);
        button.addActionListener(this);

        button1 = new JButton("Submit");
        button1.setFocusable(false);
        button1.setFont(new Font("Papyrus", Font.PLAIN, 20));
        button1.setBounds(522, 924, 100, 80);
        button1.addActionListener(this);

        textField = new JTextField();
        textField.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        textField.setBounds(262, 834, 500, 80);

        textArea = new JTextArea();
        textArea.setFont(new Font("Fira Code", Font.PLAIN, 20));
        textArea.setBounds(20, 20, 984, 710);


        frame.add(button);
        frame.add(button1);
        frame.add(textField);
        frame.add(textArea);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            textArea.setText(null);
        }

        if (e.getSource() == button1) {
            String[] ops = textField.getText().split(" ");

            if (!valid_commands.contains(ops[0])) {
                textArea.append("Incorrect command\n");
                textField.setText(null);
            } else {
                    textArea.append(textField.getText() + "\n");
                    switch (ops[0]) {
                        case "add" -> addSomething(ops[1], ops[2]);
                        case "move" -> moveImage(Integer.parseInt(ops[1]),
                                Integer.parseInt(ops[2]));
                        case "change_color" -> changeColor(ops[1]);
                        case "delete" -> deleteImage();
                        case "input" -> inputText(ops[1]);
                        case "change_font" -> changeFont(ops[1],
                                Integer.parseInt(ops[2]), Integer.parseInt(ops[3]));
                        case "move_font" -> moveFont(Integer.parseInt(ops[1]),
                                Integer.parseInt(ops[2]));
                        case "start_animation" -> startAnimation();
                        case "rotate" -> rotate(Integer.parseInt(ops[1]));
                        case "start_game" -> startGame(ops[1]);
                    }
                }
                }
                textField.setText(null);
            }

    public void addSomething(String item, String filename) {
        File image = new File(filename + ".png");
        if (image.exists()) {
            if (Objects.equals(item, "image")) {
                window.addImage(filename + ".png");
                System.out.println("add image");
            }
        } else {
            System.out.println("No such file");
        }
    }

    public void moveImage(int x, int y){
        if(window == null)
            window = new NewWindow();
        window.moveImage(x, y);
    }

    public void changeColor(String color){
        if(window == null)
            window = new NewWindow();
        window.changeColor(color);
    }

    public void deleteImage(){
        if(window == null)
            window = new NewWindow();
        window.deleteImage();
    }

    public void inputText(String text){
        if(window == null)
            window = new NewWindow();
        window.input(text);
    }

    public void changeFont(String name, int size, int smt){
        if(window == null)
            window = new NewWindow();
        window.setFont(name, size, smt);
    }

    public void moveFont(int x, int y){
        if(window == null)
            window = new NewWindow();
        window.moveFont(x, y);
    }

    public void startAnimation(){
        if(aniForm == null)
        {
            aniForm = new AnimationForm();
        }
    }

    void rotate(int angle)
    {
        window.setAngle(angle);
        window.repaint();
    }

    void startGame(String name){
        switch (name.toLowerCase(Locale.ROOT)) {
            case "ping" -> gameFrame = new GameFrame();
            case "snake" -> snakeGameFrame = new SnakeGameFrame();
            case "tictac" -> ticTacGame = new TicTacToe();
        }
    }
}
