package ex01;

public class Program {

    private static final Object monitor = new Object();
    private static int turn = 0;
    public static class threadPrint implements Runnable {

        private int cnt = 0;
        private String str = "";
        private int myTurn = 0;

        public threadPrint(String str, int cnt, int myTurn) {
            this.cnt = cnt;
            this.str = str;
            this.myTurn = myTurn;
        }


        public static void print(String str, int cnt, int myTurn) {
            synchronized (monitor) {
                for (int i = 0; i < cnt; i++) {
                    try {
                        while (myTurn != turn) {
                            monitor.wait();
                        }
                        System.out.println(str);
                        turn = (turn + 1) % 2;
                        monitor.notify();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        @Override
        public void run() {
            print(str, cnt, myTurn);
        }
    }

    public static void main(String[] args) {
        //int cnt = Integer.parseInt(args[0].substring(8));
        int cnt = 50;
        Thread egg = new Thread(new threadPrint("Egg", cnt, 0));
        Thread hen = new Thread(new threadPrint("Hen", cnt, 1));

        egg.start();
        hen.start();

        //threadPrint.print("Human", cnt);

    }
}
