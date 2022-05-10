package OptionPane;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        //JOptionPane.showMessageDialog(null,"Information!!",
               //"title", JOptionPane.PLAIN_MESSAGE);
       //JOptionPane.showMessageDialog(null,"Information!!",
               // "title", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null,"Information!!",
                //"title", JOptionPane.QUESTION_MESSAGE);
       // JOptionPane.showMessageDialog(null,"Information!!",
                //"title", JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null,"Information!!",
              // "title", JOptionPane.ERROR_MESSAGE);

        //System.out.println(JOptionPane.showConfirmDialog(null,"You're human?",
                //"title", JOptionPane.YES_NO_CANCEL_OPTION));

        String name = JOptionPane.showInputDialog("What is your name?");
        System.out.println(name);
    }
}
