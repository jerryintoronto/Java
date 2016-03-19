package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class usingReentrantLock {

    static myBuffer b = new myBuffer();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(new Producer());
        e.execute(new Consumer());
        e.shutdown();
    }

    static class myBuffer {
        final Lock myLock = new java.util.concurrent.locks.ReentrantLock();
        final Condition canPut = myLock.newCondition();
        final Condition canGet = myLock.newCondition();
        int val = 0;
        boolean occupied = false;

        public void put(int value) throws InterruptedException {
            myLock.lock();
            try {
                while (occupied) {
                    System.out.println("full");
                    canPut.await();
                }

                val = value;
                occupied = true;
                System.out.println("Producer " + val);
                canGet.signalAll();
            } finally {
                myLock.unlock();
            }
        }

        public void get() throws InterruptedException {
            myLock.lock();
            try {
                while (!occupied) {
                    System.out.println("empty");
                    canGet.await();
                }

                occupied = false;
                System.out.println("Consumer gets " + val);

                canPut.signalAll();
            } finally {
                myLock.unlock();
            }
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
                } catch (InterruptedException exception) {
                }
            }
        }
    }

}
