package ru.geekbrains.HomeWork_04;

import javax.swing.*;
import java.awt.*;

public class MyChat extends JFrame{

    public MyChat () {
        setTitle("My Chat ver 0.001");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(100,100, 500, 500));
        setLayout(new GridLayout(2, 1));

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JTextArea outputArea = new JTextArea(400, 400);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setBackground(Color.yellow);
        outputArea.setEditable(false);

        top.add(outputArea);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1, 2));
        JTextField inputField = new JTextField();
        inputField.setEditable(true);
        inputField.setBackground(Color.green);
        bottom.add(inputField);

        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.red);
        sendButton.setBounds(490,490,10,10);
        bottom.add(sendButton);

        ListenerMyChat buttonListener = new ListenerMyChat (inputField,outputArea);
        sendButton.addActionListener(buttonListener);
        inputField.addActionListener(buttonListener);

        add(top);
        add(bottom);
        setVisible(true);
    }
}

