package ex04;

public class Program {
    public static void main(String[] args) {
        String inputText = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42";
        performFrequencyAnalysis(inputText);
        char[] chars = inputText.toCharArray();
//        int cnt = 0;
//        for (int i = 0; res[i][1] != '\n'; i++) {
//            if (res[i][1] > 0) {
//                System.out.println("Frequency " + res[i][1] + " Char " + (char) res[i][0]);
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
    }
    public static void printGraph(int[][] Array) {
        int max = 10;
        int x = Array[0][0] / 10;
        for (int i = 0; i < 10; i++) {
            System.out.print((char)Array[i][0]);
            System.out.print(" ");
            for (int j = 0; j < max; j++) {
                System.out.print("#");
            }
            System.out.print(" ");
            System.out.println(Array[i][1]);
            max = Array[i][1] / x;
        }

    }
    public static int[][] alphabetSort(int[][] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j][0] > array[j+1][0] && array[j][1] == array[j+1][1]) {
                    // Обмен значениями
                    int temp = array[j][1];
                    int chtemp = array[j][0];
                    array[j][1] = array[j+1][1];
                    array[j][0] = array[j+1][0];
                    array[j+1][0] = chtemp;
                    array[j+1][1] = temp;
                }
            }
        }
        return array;
    }

    public static int[][] bubbleSort(int[][] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j][1] < array[j+1][1]) {
                    // Обмен значениями
                    int temp = array[j][1];
                    int chtemp = array[j][0];
                    array[j][1] = array[j+1][1];
                    array[j][0] = array[j+1][0];
                    array[j+1][0] = chtemp;
                    array[j+1][1] = temp;
                }
            }
        }
        return array;
    }

    public static int[][] sort(int[][] frequency, int size) {
        int[][] mass = new int[size][size];
        for(int i = 0; frequency[i][0] != '\n'; i++) {
            if (frequency[i][1] > 0) {
                mass[i][1] = frequency[i][1];
                mass[i][0] = frequency[i][0];
            }
        }
        mass = bubbleSort(mass);
        mass = alphabetSort(mass);
        return mass;
    }

    public static void performFrequencyAnalysis(String text) {
        int[][] frequency = new int[1000][2];
        frequency[0][0] = '\n';
        char[] chars = text.toCharArray();
        int cntChars = 0;
        for (char ch : text.toCharArray()) {
            for (int i = 0; ; i++) {
                if (frequency[i][0] == ch) {
                    frequency[i][1]++;
                    break;
                } else if (frequency[i][0] == '\n') {
                    frequency[i][0] = ch;
                    frequency[i][1] = 1;
                    frequency[i + 1][0] = '\n';
                    cntChars++;
                    break;
                }
            }
        }
        frequency = sort(frequency, cntChars);
        printGraph(frequency);
        //return frequency;
    }
}



