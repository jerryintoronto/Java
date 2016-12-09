import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d_usingCircularArray {

    static myBuffer b = new myBuffer(); //shared buffer
    static int arr[] = {0, 0, 0}; //does not have to be size 3
    static int size = 0, p = 0, g = 0;
    static ExecutorService e = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        e.execute(new Producer());
        e.execute(new Consumer());
        e.shutdown();
    }

    static class myBuffer {
        synchronized void Put(int value) throws Exception {
            while (size == arr.length) wait();
            System.out.println("Producer " + value);

            arr[p] = value;
            p = (p + 1) % arr.length; //put the next
            ++size;
            notifyAll();
        }


        public synchronized void Get() throws Exception {
            while (size == 0) wait(); //nothing to get
            System.out.println("Consumer " + arr[g]);

            g = (g + 1) % arr.length; //get the next
            --size;
            notifyAll();
        }
    }


    static class Consumer implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try { b.Get(); } catch (Exception e) { }
            }
        }
    }

    static class Producer implements Runnable {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try { b.Put(i); } catch (Exception e) { }
            }
        }
    }
}


