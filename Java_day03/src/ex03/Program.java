package ex03;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import  java.util.Scanner;

public class Program {
    private static int cntThread = 0;
    private static List<Thread> arrThread = new ArrayList<>();
    private static String PATH_TO_FILE = "Java_day03/src/ex03/files_urls.txt";
    private static String OUTPUT_DIR = "Java_day03/src/ex03";
    private static Queue<String> urlsQueue = new LinkedList<>();


    public static void createUrlsQueue() {
        try (Scanner scanner = new Scanner(new FileReader(PATH_TO_FILE))) {
            while (scanner.hasNext()) {
                String tmp = scanner.nextLine();
                tmp = tmp.substring(2);
                urlsQueue.add(tmp);
            }
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    static class FileDownloadThread implements Runnable {
        @Override
        public void run() {
            String url = "";
            while (true) {
                synchronized (urlsQueue) {
                    url = urlsQueue.poll();
                    if (url == null) break;
                }
                System.out.println(Thread.currentThread().getName() + " start download file " + url);
                Program.downloadFile(url);
            }
        }
    }

    private static void downloadFile(String fileURL) {
        try (InputStream in = new URL(fileURL).openStream()) {
            String fileName = Paths.get(new URL(fileURL).getPath()).getFileName().toString();
            Files.copy(in, Paths.get(OUTPUT_DIR + fileName), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(Thread.currentThread().getName() + " finush download file " + fileURL);
        } catch (IOException e) {
            System.err.println("Error download file " + fileURL + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createUrlsQueue();
        cntThread = 4;
        for (int i = 0; i < cntThread; i++) {
            Thread newThread = new Thread(new FileDownloadThread());
            arrThread.add(newThread);
            newThread.start();
        }

        for(Thread i : arrThread) {
            try {
                i.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
