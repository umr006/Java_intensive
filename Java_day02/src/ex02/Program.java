package ex02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Program {
    private static Scanner in = new Scanner(System.in);
    private static String currentFolder = "";
    private static String currentCommand = "";

    public static void main(String[] args) {
        currentFolder = args[0].substring(17);
        System.out.println(currentFolder);
        while(!(currentCommand = in.nextLine()).equals("exit")) {
            try {
                if(currentCommand.length() >= 2) {
                    switch (currentCommand.substring(0, 2)){
                        case "ls":
                            commandLS();
                            break;
                        case "mv":
                            commandMV();
                            break;
                        case "cd":
                            commandCD();
                            break;
                        default:
                            System.out.println("Unknown command");
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void commandCD() throws IOException {
        String[] currentCommandSplit = currentCommand.split(" ");
        String newCurrentFolder = currentFolder + "/" + currentCommandSplit[1];
        File newCurrentFolderFile = new File(newCurrentFolder);
        if (newCurrentFolderFile.isDirectory() && newCurrentFolderFile.exists()) {
            currentFolder = newCurrentFolder;
        } else {
            throw new IOException("cd: no such file or directory");
        }
    }
    public static void commandMV() throws IOException {
        String[] currentCommandSplit = currentCommand.split(" ");
        String sourcePath = currentCommandSplit[1];
        String distanationPath = currentCommandSplit[2];

        File sourceFile = new File(sourcePath);
        File distanationFile = new File(distanationPath);

        if ((sourceFile.isFile() || sourceFile.isDirectory()) && sourceFile.exists()) {
            if (!sourceFile.renameTo(distanationFile)) throw new IOException("mv: Failed with an error");
        } else {
            throw new IOException("mv: No such file or directory");
        }
    }

    public static void commandLS() throws IOException {
        File folder = new File(currentFolder);
        if(folder.isDirectory() && folder.exists()) {
            for (File file : folder.listFiles()) {
                System.out.println(file.getName() + " " + file.length() / 1024 + " KB");
            }
        } else {
            throw new IOException("ls: No such file or directory");
        }
    }
}
