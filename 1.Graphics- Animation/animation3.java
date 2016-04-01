import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class animation3 extends JPanel {

    static JFrame f = new JFrame();
    static myPanel p = new myPanel();
    static ArrayList<myBall> ballArr = new ArrayList<>();

    public static void main(String[] args) {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.setSize(800, 600);
        f.setVisible(true);


        ballArr.add(new myBall(100, 100));
        ballArr.add(new myBall(200, 100));

        while(true) {
            for (myBall b : ballArr)
                b.update();

            p.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }


    static class myPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (myBall b : ballArr)
                g.fillOval(b.x, b.y, 100, 100);
        }
    }


    static class myBall {

        int size = 100;
        int x;
        int y;
        boolean moveRight = true;

        public myBall(int x, int y) {
            this.x = x;
            this.y = y;
        }


        void update() {

            if (moveRight)
                x++;
            else x--;

            //hits borders
            if (x + size >= 800 || x == 0) {
                moveRight = !moveRight;
            }
        }
    }
}

