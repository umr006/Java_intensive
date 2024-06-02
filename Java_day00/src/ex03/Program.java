package ex03;

import java.util.Scanner;

public class Program {

    public static long reverseRes(long x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }

    public static void printGraph(long MinGradeOnWeeks) {
        String MinGradeOnWeeksStr = (MinGradeOnWeeks + "");
        for(int i = 1; i <= MinGradeOnWeeksStr.length(); i++) {
            System.out.printf("%s %d", "Week", i);
            for (int j = 0; j < MinGradeOnWeeks%10; j++) {
                System.out.print("=");
            }
            MinGradeOnWeeks /= 10;
            System.out.println(">");
        }
    }

    public static void main(String[] args) {
        int maxWeek = 18;
        int testOnWeek = 5;
        long res = 0;
        int min = 9, tmp = 0;
        String line;
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= 18; ++i){
            line = in.nextLine();
            if (line.equals("42")) {
                break;
            }
            if (!line.equals("Week " + i)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            } else {
                for (int j = 0; j < 5; ++j){
                    tmp = in.nextInt();
                    if (tmp >= 1 && tmp <= 9 && tmp < min){
                        min = tmp;
                    }
                }
                res = res * 10 + min;
                min = 10;
                in.nextLine();
            }
        }
        System.out.println(res);
        res = reverseRes(res);
        printGraph(res);
    }
}