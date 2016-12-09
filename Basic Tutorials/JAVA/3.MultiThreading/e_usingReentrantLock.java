import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class e_usingReentrantLock {

    static myBuffer b = new myBuffer();
    static ExecutorService e = Executors.newCachedThreadPool();
    static final Lock myLock = new java.util.concurrent.locks.ReentrantLock();
    static final Condition p = myLock.newCondition();
    static final Condition g = myLock.newCondition();
    static int val = 0;
    static boolean f = false;

    public static void main(String[] args) {
        e.execute(new Producer());
        e.execute(new Consumer());
        e.shutdown();
    }

    static class myBuffer {
        public void put(int v) throws Exception {
            myLock.lock();
            try {
                while (f)  p.await();
                val = v;
                f = true;
                System.out.println("Producer " + val);
                g.signalAll();
            } finally { myLock.unlock(); }
        }

        public void get() throws Exception {
            myLock.lock();
            try {
                while (!f) g.await();
                f = false;
                System.out.println("Consumer " + val);
                p.signalAll();
            } finally { myLock.unlock(); }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try { b.get(); } catch (Exception e) { }
            }
        }
    }

    static class Producer implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try { b.put(i); } catch (Exception exception) { }
            }
        }
    }

}
