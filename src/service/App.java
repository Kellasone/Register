package service;

import javax.swing.*;
import java.awt.*;

public class App {


    public static  void main(String[] args)
    {
        JFrame frame = new JFrame("Cash Register");
        JPanel panel = new JPanel();
        frame.setResizable(false);


        frame.setSize(270,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JTextField usernameTextField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField( 15);
        JButton submitButton = new JButton("LOG IN");

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        c.gridy = 0;
        panel.add(usernameTextField,c);
        c.gridy = 1;
        panel.add(passwordField,c);
        c.gridy = 2;
        panel.add(submitButton,c);

        frame.add(panel);
        frame.setVisible(true);



    }
}
