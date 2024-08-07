package ex02;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private static int arrLen = 0;
    private static int cntThread = 0;
    private static long sumThread = 0;
    private static int[] arr;
    private static List<Thread> threadList = new ArrayList<>();

    public static void fillArr() {
        for (int i = 0, j = 1; i < arrLen; i++) {
            arr[i] = j++;
        }
    }

    public static long takeSum(int startIdx, int endIdx) {
        long res = 0;
        for (int i = startIdx; i < endIdx; i++) {
            res += arr[i];
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
            res = takeSum(startIdx, endIdx);
            sumThread += res;
            System.out.println(Thread.currentThread().getName() + ": from " + startIdx + " to " + endIdx + " sum is " + res);
        }
    }


    public static void threadStart() {
        int startIdx = 0, endIdx = 0;
        int step = arrLen / cntThread;

        for (int i = 0; i < cntThread; i++) {
            endIdx = (i == cntThread - 1 ? arrLen : startIdx + step);
            Thread newThread = new Thread(new calcThread(startIdx, endIdx, arr));
            threadList.add(newThread);
            startIdx = endIdx;
        }
    }

    public static void main(String[] args) {
        arrLen = 13;
        cntThread = 3;
        arr = new int[arrLen];
        fillArr();
        System.out.println("Sum: " + takeSum(0, arrLen));
        threadStart();
        for (Thread i : threadList) {
            i.start();
        }
        for (Thread i : threadList) {
            try {
                i.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Sum by Threads: " + sumThread);
    }
}