package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class App {
    private JButton buttonMsg;
    private JPanel panelMain;
    private JTextArea jt;
    private JTextArea speed;

    public static int rate = 50; //default autoclicker speed

    public App() {
        buttonMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String input = jt.getText();
                    try {
                        rate = Integer.parseInt(speed.getText());
                        if (rate < 20) {
                            rate = 50;
                            JOptionPane.showMessageDialog(null, "The number you specified was too small to accurately process, or is deprecated. The rate has been set to the default time of 50 milliseconds.");
                        }
                    } catch (NumberFormatException e) {};

                JOptionPane.showMessageDialog(null, "You have specified that you want " + input + " clicks. Please click OK to continue.");
                int clicks = Integer.parseInt(input);
                try {
                    Robot macro = new Robot();
                    macro.mouseMove(275, 450);
                    for(int i = 0; i < clicks; i++){
                        try{
                            Thread.sleep(rate);
                            macro.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                            macro.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        } catch (InterruptedException ex) {}


                    }
                } catch(AWTException e) {}
            }
        });
        jt.addFocusListener(new FocusAdapter() { // Placeholder code for clicks text area
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(jt.getText().equals("Number of Clicks")) {
                    jt.setText("");
                }
            }
        });
        jt.addFocusListener(new FocusAdapter() { // Placeholder code for clicks text area
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(jt.getText().equals("")){
                    jt.setText("Number of Clicks");
                }
            }
        });
        speed.addFocusListener(new FocusAdapter() { // Placeholder code for speed text area
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(speed.getText().equals("Speed of Clicker")){
                    speed.setText("");
                }
            }
        });
        speed.addFocusListener(new FocusAdapter() { // Placeholder code for speed text area
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(speed.getText().equals("")){
                    speed.setText("Speed of Clicker");
                }
            }
        });
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame("Supreme Autoclicker");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
