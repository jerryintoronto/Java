import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class animation6 extends JPanel {

    static myPanel p = new myPanel();
    static ArrayList<myBall> ballArr = new ArrayList(30);

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.add(p);
        f.setSize(800, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ballArr.add(new myBall()); //start with one ball, click to add more
        multithreading(); //using ExecutorService
    }

    static void multithreading() {
        ExecutorService e = Executors.newFixedThreadPool(2);
        e.execute(new threadOne());
        e.execute(new threadTwo());
    }

    static class threadOne implements Runnable {
        public void run(){
            while (true) {
                ballArr.forEach(e -> e.update());
                try {
                    Thread.sleep(10);
                } catch (Exception e) { }
            }
        }
    }
    static class threadTwo implements Runnable {
        public void run(){
            while (true) {
                p.repaint();
                try {
                    Thread.sleep(10);
                } catch (Exception e) { }
            }
        }
    }

    //adds mouseListener and overwrites paintComponent
    static class myPanel extends JPanel {

        public myPanel() {
            addMouseListener(
                    new MouseAdapter() {
                        public void mouseReleased(MouseEvent e) {
                            ballArr.add(new myBall());
                        }
                    });
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (myBall b : ballArr) {
                g.setColor(b.color);
                g.fillOval(b.x, b.y, 100, 100);
            }
        }
    }

    //all data of the balls stored here
    static class myBall {
        int size = 100;
        int x, y;
        boolean moveRight = true;
        boolean moveUp = true;
        Random random = new Random();
        Color color;

        public myBall() {
            x = random.nextInt(600);
            y = random.nextInt(600);
            color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }

        void update() {

            //increment x/y positions
            if (moveRight) x++;
            else x--;
            if (moveUp) y++;
            else y--;

            //hits borders reverse direction
            if (x + size >= 800 || x == 0) moveRight = !moveRight;
            if (y + size >= 600 || y == 0) moveUp = !moveUp;

        }
    }
}

