import javax.swing.*;
import java.awt.*;

public class drawShapes extends JPanel {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel p = new myPanel();
        f.add(p);
        f.setSize(800, 600);
        f.setVisible(true);
    }


    static class myPanel extends JPanel {
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawLine(0, 50, 800, 50);
            g.drawRect(100, 100, 200, 100);
            g.fillRect(400, 100, 200, 100);
            g.drawOval(100, 300, 200, 100);
            g.fillOval(400, 300, 200, 100);
        }
    }
}

