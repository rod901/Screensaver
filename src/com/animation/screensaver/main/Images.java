package com.animation.screensaver.main;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// This class is intended to be used for all image associated tasks
public class Images extends JPanel {
    private final String IMAGE_DIR = "/com/animation/screensaver/resources/images-";
    private final String JPG = ".jpg";

    // Returns all images stored in resources folder
    public Map<Integer, ImageIcon> collectAllImages() {
        Map<Integer, ImageIcon> map = new HashMap();
        return IntStream.rangeClosed(0, 60).filter(i -> i > 0).filter(i -> i <= 60).boxed().collect(Collectors.toMap(Function.identity(), i -> collectSingleImage(i)));
    }

    // Returns a single image based on the image number
    private ImageIcon collectSingleImage(int num) {
        Objects.requireNonNull(num);
        if (num <= 0) {
            System.out.println("Image Number does not exist. Returning random image.");
            num = 1;
        }
        return new ImageIcon(getClass().getResource(IMAGE_DIR + num + JPG));
    }
}
