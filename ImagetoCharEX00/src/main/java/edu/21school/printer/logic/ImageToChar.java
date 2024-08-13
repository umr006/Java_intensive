package edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageToChar {
    private char black;
    private char white;
    private BufferedImage bufferedImage;
    //private static String PATH_TO_FILE = "/Users/new/Desktop/Java_intensive/Java_day04/src/ex01/ImagesToChar/src/resources/it.bmp";
    private static String PATH_TO_FILE = "/home/umr006/Java_intensive/Java_day04/src/ex02/ImageToChar/src/resources/it.bmp";
    public ImageToChar(char black, char white) {
        this.black = black;
        this.white = white;
    }

    public void printImage() {
//        String osName = System.getProperty("os.name").toLowerCase();
//        if (osName == "linux") {
//            PATH_TO_FILE = "/home/umr006/Java_intensive/Java_day04/src/ex02/ImageToChar/src/resources/it.bmp";
//        } else {
//            PATH_TO_FILE = "/Users/new/Desktop/Java_intensive/Java_day04/src/ex02/ImageToChar/src/resources/it.bmp";
//        }
        try {
            bufferedImage = ImageIO.read(new File(PATH_TO_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        ColoredPrinter cp = new ColoredPrinter();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color color = new Color(bufferedImage.getRGB(j, i));
                if (color.equals(Color.BLACK)) {
                    cp.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.RED);
                } else {
                    cp.print(" ", Ansi.Attribute.NONE, Ansi.FColor.NONE, Ansi.BColor.GREEN);
                }
            }
            System.out.println();
        }
    }
}