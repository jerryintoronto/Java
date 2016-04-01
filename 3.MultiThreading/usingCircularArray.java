package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class usingCircularArray {

    static myBuffer b = new myBuffer(); //shared buffer

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(new Producer());
        e.execute(new Consumer());
        e.shutdown();
    }

    static class myBuffer {
        static int arr[] = {0, 0, 0};
        static int i = 0, putIndex = 0, getIndex = 0;

        public synchronized void Put(int value) throws InterruptedException {

            while (i == arr.length) {
                System.out.println("full");
                wait();
            }

            System.out.println("Producer " + value);

            arr[putIndex] = value;
            putIndex = (putIndex + 1) % arr.length;
            ++i;
            notifyAll();
        }


        public synchronized void Get() throws InterruptedException {
            while (i == 0) {
                System.out.println("empty");
                wait();
            }

            System.out.println("Consumer " + arr[getIndex]);

            getIndex = (getIndex + 1) % arr.length;
            --i;
            notifyAll();
        }
    }


    static class Consumer implements Runnable {
        public void run() {
            for (int i = 1; i <= 11; i++) {
                try {
                    b.Get();
                } catch (Exception e) {
                }
            }
        }
    }

    static class Producer implements Runnable {
        public void run() {
            for (int i = 1; i <= 11; i++) {
                try {
                    b.Put(i);
                } catch (Exception e) {
                }
            }
        }
    }
}


