import javax.swing.*;
import java.awt.*;

public class animation2 extends JPanel {

    static int size = 100;
    static int x = 200;
    static JFrame f = new JFrame();
    static boolean moveRight = true;

    public static void main(String[] args) {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel p = new myPanel();
        f.add(p);
        f.setSize(800, 600);
        f.setVisible(true);
        animate();
    }

    static void animate() {
        while (true) {

            if (moveRight)
                x++;
            else x--;

            //hits borders
            if (x + size == 800 || x  == 0) {
                moveRight = !moveRight;
            }

            try { Thread.sleep(10); } catch (Exception e) { }
            f.repaint();
        }
    }

    static class myPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillOval(x, 300, size, size);
        }
    }
}
