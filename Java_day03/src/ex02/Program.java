package ex02;

public class Program {

    private static int sum = 0;
    private static int arrSize = 13;
    private static int threadCnt = 3;
    private static int[] arr;

    public static void fillingTheArr() {
        for (int i = 0, y = 1; i < arrSize; i++, y++) {
            arr[i] = y;
        }
    }

    public static int arrSumSt() {
        int res = 0;
        for(int i : arr) {
            res += i;
        }
        return res;
    }

    public static int arrSum(int startIndx, int endIndx) {
        int res = 0;
        for (int i = startIndx; i < endIndx; i++) {
            res += arr[i];
            System.out.println("arr[i] = " + arr[i] + " i = " + i);
            System.out.println("res = " + res);
        }
        return res;
    }

    public static int[] startThread(int e) {
        int zero = 0;
        int[] mass = new int[threadCnt];
        for (int i = 0; i < threadCnt; i++) {
            mass[i] = arrSum(zero, zero + e);
            zero += (i + 1 == threadCnt - 1) ? e + 1 : e;
            //zero += e;
            System.out.println("zero = " + zero);
        }
        return mass;
    }

    public static void main(String[] args) {
        arr = new int[arrSize];
        fillingTheArr();
        System.out.println("arrSumSt = " + arrSumSt());
        int e = arrSize / threadCnt;
        int[] mass = startThread(e);
        System.out.println(mass[0]);
        System.out.println(mass[1]);
        System.out.println(mass[2]);
        System.out.printf("massSum = %d\n", mass[0] + mass[1] + mass[2]);
    }
}
