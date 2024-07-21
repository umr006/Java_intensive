package ex01;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {

    static List<String> dictionary = new ArrayList<>();
    static Vector<String> file1 = new Vector<>();
    static Vector<String> file2 = new Vector<>();

    static Vector<Integer> vectorCnt1 = new Vector<>();
    static Vector<Integer> vectorCnt2 = new Vector<>();


    public static Vector<String> createDictionary(String pathToFile) {
        Vector<String> file = new Vector<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(pathToFile)))) {
            while (scanner.hasNext()) {
                String tmp = scanner.next();
                file.add(tmp);
                boolean isFound = false;
                for (String i : dictionary) {
                    if (tmp.equals(i)) {
                        isFound = true;
                    }
                }
                if (!isFound) {
                    dictionary.add(tmp);
                }
                Collections.sort(dictionary);
            }
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
        return file;
    }

    public static void createTwoVectors() {
        int cntFile1, cntFile2;
        for (String i : dictionary) {
            cntFile1 = 0;
            cntFile2 = 0;
            for (String j : file1) {
                if (i.equals(j)) {
                    cntFile1++;
                }
            }
            for (String k : file2) {
                if (i.equals(k)) {
                    cntFile2++;
                }
            }
            vectorCnt1.add(cntFile1);
            vectorCnt2.add(cntFile2);
        }
    }

    public static int calculateNumenator() {
        int numenator = 0;
        for (int i = 0; i < vectorCnt1.size(); i++) {
            numenator += vectorCnt1.elementAt(i) * vectorCnt2.elementAt(i);
        }

        return numenator;
    }

    public static double calculateDenominator() {
        double denominator = 0;
        double firstFile = 0;
        double secondFile = 0;
        for (int i = 0; i < vectorCnt1.size(); i++) {
            firstFile += vectorCnt1.elementAt(i) * vectorCnt1.elementAt(i);
            secondFile += vectorCnt2.elementAt(i) * vectorCnt2.elementAt(i);
        }
        return Math.sqrt(firstFile) * Math.sqrt(secondFile);
    }

    public static void main(String[] args) {
//        String path1 = "Java_day02/src/ex01/1.txt";
//        String path2 = "Java_day02/src/ex01/2.txt";
        String path1 = args[0];
        String path2 = args[1];
        file1 = createDictionary(path1);
        file2 = createDictionary(path2);
//        System.out.println(file1);
//        System.out.println(file2);
//        System.out.println(dictionary);
        createTwoVectors();
//        System.out.println(vectorCnt1);
//        System.out.println(vectorCnt2);

        System.out.println("Similarity = " + calculateNumenator() / calculateDenominator());
    }
}
