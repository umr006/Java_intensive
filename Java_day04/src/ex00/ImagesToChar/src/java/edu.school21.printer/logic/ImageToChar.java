package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageToChar {
    private char black;
    private char white;
    private BufferedImage bufferedImage;
    private static String PATH_TO_FILE = "/home/umr006/Java_intensive/Java_day04/src/ex00/it.bmp";
    public ImageToChar(char black, char white) {
        this.black = black;
        this.white = white;
    }

    public void printImage() {
        try {
            bufferedImage = ImageIO.read(new File(PATH_TO_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color color = new Color(bufferedImage.getRGB(j, i));
                if (color.equals(Color.BLACK)) {
                    System.out.print(black);
                } else {
                    System.out.print(white);
                }
            }
            System.out.println();
        }
    }
}