import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {
    public Form(String title) {
        setTitle(title);
        setBounds(50, 30, 300, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(200, 232,214));
        setLayout(new GridLayout(3, 1));

        JTextField inputField = new JTextField();
        inputField.setEditable(false);
        JPanel inputPanel = new JPanel(new GridLayout(1,1));
        inputPanel.add(inputField,BorderLayout.NORTH);

        ButtonListener buttonListener = new ButtonListener(inputField);

        JPanel buttonPanel = new JPanel(new GridLayout(4,3 ));
        for (int i = 0; i <= 9; i++) {
            JButton digit = new JButton(String.valueOf(i));
            digit.addActionListener(buttonListener);
            buttonPanel.add(digit);
        }
        JButton clear = new JButton("C");
        JButton submit = new JButton("=");
        buttonPanel.add(clear);
        buttonPanel.add(submit);

        JPanel operationPanel = new JPanel(new GridLayout(1,1 ));
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiple = new JButton("*");
        JButton delenie = new JButton("/");

        plus.addActionListener(buttonListener);
        minus.addActionListener(buttonListener);
        multiple.addActionListener(buttonListener);
        delenie.addActionListener(buttonListener);

        operationPanel.add(plus);
        operationPanel.add(minus);
        operationPanel.add(multiple);
        operationPanel.add(delenie);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double rez = 0;
                String rezString = inputField.getText();
                try {
                    if (rezString.contains("+")) {
                        String[] splitted = rezString.split("\\+");
                        rez = Double.valueOf(splitted[0]) + Double.valueOf(splitted[1]);
                    }
                    if (rezString.contains("-")) {
                        String[] splitted = rezString.split("\\-");
                        rez = Double.valueOf(splitted[0]) - Double.valueOf(splitted[1]);
                    }
                    if (rezString.contains("*")) {
                        String[] splitted = rezString.split("\\*");
                        rez = Double.valueOf(splitted[0]) * Double.valueOf(splitted[1]);
                    }
                    if (rezString.contains("/")) {
                        String[] splitted = rezString.split("\\/");
                        rez = Double.valueOf(splitted[0]) / Double.valueOf(splitted[1]);
                    }
                    inputField.setText(Double.toString(rez));

                } catch (Exception ee) {
                    inputField.setText("wrong primer");
                }
            }
        });

        add(inputPanel);
        add(buttonPanel);
        add(operationPanel);
        setVisible(true);

    }


}