package ex00;

public class Program {
    public static class threadPrint implements Runnable {

        private int cnt = 0;
        private String str = "";

        public threadPrint(String str, int cnt) {
            this.cnt = cnt;
            this.str = str;
        }

        public static void print(String str, int cnt) {
            for (int i = 0; i < cnt; i++) {
                System.out.println(str);
            }
        }

        @Override
        public void run() {
            print(str, cnt);
        }
    }

    public static void main(String[] args) {
        //int cnt = Integer.parseInt(args[0].substring(8));
        int cnt = 50;
        Thread egg = new Thread(new threadPrint("Egg", cnt));
        Thread hen = new Thread(new threadPrint("Hen", cnt));

        egg.start();
        hen.start();

        threadPrint.print("Human", cnt);

    }
}
