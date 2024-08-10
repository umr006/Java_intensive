package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ImageToChar {
    private char black;
    private char white;
    private BufferedImage bufferedImage;
    private static String PATH_TO_FILE = "";
    public ImageToChar(char black, char white, String path) {
        this.black = black;
        this.white = white;
        PATH_TO_FILE = path;
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