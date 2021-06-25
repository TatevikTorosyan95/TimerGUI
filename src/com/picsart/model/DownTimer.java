package com.picsart.model;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class DownTimer implements ActionListener {
    JFrame window;
    JLabel counterLabel;
    JLabel minuteLabel;
    JLabel secondLabel;

    JTextField minutesText;
    JTextField secondsText;

    JButton startButton;


    Font font1 = new Font("Arial", Font.PLAIN, 45);

    Timer timer;

    int second, minute;
    String ddSecond, ddMinute;

    DecimalFormat dFormat = new DecimalFormat("00");

    public DownTimer() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        counterLabel = new JLabel();
        counterLabel.setBounds(300, 230, 200, 100);
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setFont(font1);

        minuteLabel = new JLabel("Minute");
        minuteLabel.setBounds(10, 20, 80, 25);

        minutesText = new JTextField();
        minutesText.setBounds(100, 20, 165, 25);

        secondLabel = new JLabel("Second");
        secondLabel.setBounds(10, 50, 80, 25);

        secondsText = new JTextField();
        secondsText.setBounds(100, 50, 165, 25);

        startButton = new JButton("START");
        startButton.setBounds(100, 100, 100, 50);
        startButton.addActionListener(this);

        window.add(counterLabel);
        window.add(minuteLabel);
        window.add(minutesText);
        window.add(secondLabel);
        window.add(secondsText);
        window.add(startButton);
        window.setVisible(true);

    }

    public void countdownTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second--;
                ddMinute = dFormat.format(minute);
                ddSecond = dFormat.format(second);

                counterLabel.setText(ddMinute + " : " + ddSecond);

                if (second == -1) {
                    second = 59;
                    minute--;

                    ddMinute = dFormat.format(minute);
                    ddSecond = dFormat.format(second);


                    counterLabel.setText(ddMinute + " : " + ddSecond);


                }

                if (minute == 0 && second == 0) {
                    timer.stop();
                }
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            minute = Integer.parseInt(minutesText.getText());
            second = Integer.parseInt(secondsText.getText());
            ddMinute = dFormat.format(minute);
            ddSecond = dFormat.format(second);
            counterLabel.setText(ddMinute + " : " + ddSecond);
            countdownTimer();
            timer.start();
        }
    }
}
