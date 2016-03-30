import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class animation4 extends JPanel {

    static JFrame f = new JFrame();
    static myPanel p = new myPanel();
    static ArrayList<myBall> ballArr = new ArrayList<>();

    public static void main(String[] args) {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.setSize(800, 600);
        f.setVisible(true);


        ballArr.add(new myBall());

        while (true) {
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

        public myPanel()
        {
            addMouseListener(
                    new MouseAdapter() {
                        public void mouseReleased(MouseEvent e) {
                            System.out.println(getX());
                            ballArr.add(new myBall());
                        }
                    });
        }


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
    Random random = new Random();
    public myBall() {
        x = random.nextInt(600);
        y = random.nextInt(600);
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

