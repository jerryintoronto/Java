package MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class usingArrayBlockingQueue {

    static myBuffer b = new myBuffer(); //shared by Consumer and Producer

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(new Producer());
        e.execute(new Consumer());
        e.shutdown();
    }

    static class myBuffer {
        final ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue(1); //put and take

        public void put(int value) throws InterruptedException {
            System.out.println("                blockingPut: " + value);
            abq.put(value);
        }

        public void get() throws InterruptedException {
            System.out.println("blockingGet: " + abq.take());
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    b.get();
                } catch (Exception e) {
                }
            }
        }
    }

    static class Producer implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    b.put(i);
                } catch (Exception e) {
                }
            }
        }
    }
}
