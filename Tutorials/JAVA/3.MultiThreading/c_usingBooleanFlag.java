import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c_usingBooleanFlag {

    static myBuffer b = new myBuffer();
    static int val = 0;
    static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(new Producer());
        e.execute(new Consumer());
        e.shutdown();
    }

    static class myBuffer {
        synchronized void put(int v) throws Exception {
            while (flag) wait(); //wait if flag == true
            val = v; //updates val
            f("Producer "); //change flag, output, notify
        }
        synchronized void get() throws Exception {
            while (!flag) wait();
            f("Consumer ");
        }

        void f(String s) {
            flag = !flag;
            System.out.println(s + val);
            notifyAll();
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
                try { b.put(i); } catch (Exception e) { }
            }
        }
    }
}

