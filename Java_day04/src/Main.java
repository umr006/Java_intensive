import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    private char black;
    private char white;
    private BufferedImage bufferedImage;

    private static String PATH_TO_FILE = "Java_day04/src/it.bmp";

    public Main(char black, char white) {
        this.black = black;
        this.white = white;
        try {
            this.bufferedImage = ImageIO.read(new File(PATH_TO_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printImage() {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color color = new Color(bufferedImage.getRGB(j, i));
                if (color.equals(Color.WHITE)) {
                    System.out.print(white);
                } else if (color.equals(Color.BLACK)) {
                    System.out.print(black);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main ex = new Main('0', '.');
        ex.printImage();
    }
}