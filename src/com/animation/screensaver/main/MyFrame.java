package com.animation.screensaver.main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MyFrame extends JFrame {
    MyPane myPane = new MyPane();

    public MyFrame() {
        Arrays.stream(myPane.getPanelArray()).forEach(value -> this.add((JPanel) value));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new GridLayout(4, 10));
        this.setTitle("Screensaver");
        this.setSize(500,500);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.pack();
    }
}
