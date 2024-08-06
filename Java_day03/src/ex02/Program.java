package ex02;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private static int arrLen = 0;
    private static int cntThread = 0;
    private static long sumThread = 0;
    private static int[] arr;

    public static void fillArr() {
        for (int i = 0; i < arrLen; i++) {
            arr[i] = 1;
        }
    }

    public static long takeSum(int[] arrTakeSum) {
        long res = 0;
        for (int i : arrTakeSum) {
            res += i;
        }
        return res;
    }

    static class calcThread implements Runnable {
        int startIdx, endIdx;
        long res;
        int [] array;

        public calcThread(int startIdx, int endIdx, int[] array) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
            this.array = array;
        }

        @Override
        public void run() {
            res = takeSum(array);
            sumThread += res;
        }
    }

    public static void main(String[] args) {
        int arrLen = 13;
        cntThread = 3;
        arr = new int[arrLen];
        fillArr();
        System.out.println("Sum: " + takeSum(arr));
    }
}