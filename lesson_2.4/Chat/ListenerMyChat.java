package ru.geekbrains.HomeWork_04;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenerMyChat implements ActionListener {
    private final JTextField inputField;
    private final JTextArea outputField;
    protected StringBuilder sb = new StringBuilder();

    public ListenerMyChat(JTextField inputField, JTextArea outputField) {
        this.inputField = inputField;
        this.outputField = outputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       inputField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent eKey) {
            }
            public void keyPressed(KeyEvent eKey) {
                if (eKey.getKeyCode() == KeyEvent.VK_ENTER) {
                }
            }
            public void keyReleased(KeyEvent eKey) {
            }
       });
       addTextToChat();
    }

    public void addTextToChat() {
        sb.append(inputField.getText()).append("\n").append(outputField.getText());
        outputField.setText(sb.toString());
        inputField.setText("");
        sb.setLength(0);
    }
}