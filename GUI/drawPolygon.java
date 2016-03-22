import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class drawPolygon extends JPanel {

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

            Random r= new Random();
            Polygon p= new Polygon();
            for (int i = 0; i < 200; i++)
                p.addPoint(r.nextInt(getWidth()), r.nextInt(getHeight()));

            g.drawPolygon(p);
        }
    }
}

