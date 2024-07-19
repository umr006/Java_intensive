package ex00;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Map<String, String> signatures = new HashMap<>();
    private static List<String> matchSignatures = new ArrayList<>();

    public static String fileType(String pathToFile) {
        String hex = "";
        try (FileInputStream fis = new FileInputStream(pathToFile)) {
            byte[] buffer = new byte[4];
            fis.read(buffer, 0, 4);
            String tmp = "";
            for (byte i : buffer) {
                tmp = Integer.toHexString(0xFF & i);
                if (tmp.length() == 2)
                    hex += " " + tmp;
                else
                    hex += " " + "0" + tmp;
            }
            hex = hex.toUpperCase();
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
        return hex;
    }

    public static void fileTypeToMap() {
        String tmpLine = "";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream("Java_day02/src/ex00/signatures.txt");
            isr = new InputStreamReader(fis);
            int ch;
            while ((ch = isr.read()) != -1) {
                tmpLine += (char)ch;
                if ((char)ch == '\n') {
                    String[] tmpArr =  tmpLine.split(",");
                    signatures.put(tmpArr[0], tmpArr[1]);
                    tmpLine = "";
                }
            }
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        } finally {
            try {
                fis.close();
                isr.close();
            } catch (IOException e) {
                System.out.println(e.fillInStackTrace());
            }

        }
    }

    public static void checkMatchSignatures(String fileSignatures) {
        String st1 = " 25 50 44 46 2D";
//        System.out.println(st1.replaceAll("[^a-zA-Z1-9]", "").toLowerCase());
        fileSignatures = fileSignatures.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        fileSignatures = fileSignatures.substring(0, 4);
        for(Map.Entry<String, String> entry : signatures.entrySet()) {
            if(entry.getValue().replaceAll("[^a-zA-Z0-9]", "").toLowerCase().substring(0, 4).equals(fileSignatures)) {
                matchSignatures.add(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pathToFile = in.next();
        while (!pathToFile.equals("42")) {
            String fileType = fileType(pathToFile);
            fileTypeToMap();
            checkMatchSignatures(fileType);
            System.out.println("PROCESSED");
            pathToFile = in.next();
        }
        System.out.println(matchSignatures);
    }
}
