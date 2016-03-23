package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class usingBooleanFlag {

    static myBuffer b = new myBuffer();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(new Producer());
        e.execute(new Consumer());
        e.shutdown();
    }

    static class myBuffer {
        int val = 0;
        boolean flag = false;
        public synchronized void put(int v) throws InterruptedException {
            while (flag) {
                System.out.println("Producer waits");
                wait();
            }
            val = v;
            flagPrintNotify("Producer ");
        }
        public synchronized void get() throws InterruptedException {
            while (!flag) {
                System.out.println("Consumer waits");
                wait();
            }
            flagPrintNotify("Consumer ");

        }
        void flagPrintNotify(String s) {
            flag = !flag;
            System.out.println(s + val);
            notifyAll();
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    b.get();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class Producer implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    b.put(i);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

