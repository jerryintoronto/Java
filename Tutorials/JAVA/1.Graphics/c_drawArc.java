import javax.swing.*;
import java.awt.*;

public class c_drawArc extends JPanel {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel p = new myPanel();
        f.add(p);
        f.setSize(1400, 600);
        f.setVisible(true);
    }


    static class myPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)

            for (int i = 0; i< 7 ; i++) {
                g.drawArc(200 * i, 50, 150, 150, 0, 60 + i*60);
                g.fillArc(200 * i, 300, 150, 150, 0, -60 +  -1 * i * 60);
            }
        }
    }
}

