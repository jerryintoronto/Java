import javax.swing.*;
import java.awt.*;

public class animation extends JPanel {

    static int size = 100;
    static JFrame f = new JFrame();

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
            size++;
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            f.repaint();
        }
    }

    static class myPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillOval(400, 300, size, size);
        }
    }
}
