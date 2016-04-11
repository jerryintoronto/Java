import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a_unSynchronizedBuffer {

    /*

OUTPUT(it is random)
Producer puts 1
Producer puts 2
Producer puts 3
Producer puts 4
Producer puts 5
Producer puts 6
Producer puts 7
Producer puts 8
Producer puts 9
Producer puts 10
Consumer gets 10
Consumer gets 10
Consumer gets 10
Consumer gets 10
Consumer gets 10
Consumer gets 10
Consumer gets 10
Consumer gets 10
Consumer gets 10
Consumer gets 10


EXPECTED (what we want):
Producer 1
Consumer 1
Producer 2
Consumer 2
Producer 3
Consumer 3
Producer 4
Consumer 4
Producer 5
Consumer 5
Producer 6
Consumer 6
Producer 7
Consumer 7
Producer 8
Consumer 8
Producer 9
Consumer 9
Producer 10
Consumer 10



     */

    static myBuffer b = new myBuffer();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(new Producer());
        e.execute(new Consumer());
        e.shutdown();
    }

    static class myBuffer {
        int val = 0;
        public void put(int v) throws InterruptedException {
            val = v;
            System.out.println("Producer puts " + v);
        }

        public void get() throws InterruptedException {
            System.out.println("Consumer gets " + val);
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

