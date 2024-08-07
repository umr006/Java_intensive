package ex02;

public class Main2 {
    public static void main(String[] args) {
        final Object monitor = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (monitor) {
                System.out.println("Thread 1: Going to sleep...");
                try {
                    Thread.sleep(2); // Sleep for 5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Awake!");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (monitor) {
                System.out.println("Thread 2: Running...");
            }
        });

        thread1.start();
        thread2.start();
    }
}
