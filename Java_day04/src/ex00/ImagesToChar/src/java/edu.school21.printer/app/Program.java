package edu.school21.printer.app;
import edu.school21.printer.logic.ImageToChar;

public class Program {
    public static void main(String[] args) {
        String path = args[0];
        ImageToChar imageToChar = new ImageToChar('0', '.', path);
        imageToChar.printImage();
    }
}