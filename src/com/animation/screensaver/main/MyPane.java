package com.animation.screensaver.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class MyPane extends JPanel implements ActionListener {
    Timer timer = new Timer(1000, this);
    Object[] resultArray = new Object[4];
    Random random = new Random();
    Map<Integer, ImageIcon> imageMap;

    JPanel row1;
    JPanel row2;
    JPanel row3;
    JPanel row4;

    int x = 1;
    int y = 1;
    int randomX = 0;
    int randomY = 0;

    public MyPane() {
        row1 = new JPanel();
        row2 = new JPanel();
        row3 = new JPanel();
        row4 = new JPanel();
        imageMap = new Images().collectAllImages();
        timer.start();
    }

    // Returns an array of JPanels containing 10 images per pane
    public Object[] getPanelArray() {
        IntStream.rangeClosed(1,10).boxed().forEach(integer -> {
            JLabel label = new JLabel(imageMap.get(getRandomInteger(60,1)));
            label.setSize(100,100);
            row1.add(label);
            resultArray[0] = row1;
        });

        IntStream.rangeClosed(11,20).boxed().forEach(integer -> {
            JLabel label = new JLabel(imageMap.get(getRandomInteger(60,1)));
            label.setSize(100,100);
            row2.add(label);
            resultArray[1] = row2;
        });

        IntStream.rangeClosed(21,30).boxed().forEach(integer -> {
            JLabel label = new JLabel(imageMap.get(getRandomInteger(60,1)));
            label.setSize(100,100);
            row3.add(label);
            resultArray[2] = row3;
        });

        IntStream.rangeClosed(31,40).boxed().parallel().forEach(integer -> {
            JLabel label = new JLabel(imageMap.get(getRandomInteger(60,1)));
            label.setSize(100,100);
            row4.add(label);
            resultArray[3] = row4;
        });
        return resultArray;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x>=500 || x <= 0) {
            randomX = -randomX;
        }

        if (y>=500 || y <= 0) {
            randomY = -randomY;
        }

        randomX = random.nextInt(51) - 25;
        randomY = random.nextInt(51) - 25;
        x = x + randomX;
        y = y + randomY;
        repaint();

        row1.setLocation(x,y);
        row2.setLocation(x, y + 200);
        row3.setLocation(x, y + 400);
        row4.setLocation(x, y + 600);
    }

    // Returns random integer between minimum and maximum range
    public int getRandomInteger(int maximum, int minimum) {
        return random.ints(1, minimum, maximum).boxed().findFirst().get();
    }
}
