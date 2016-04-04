package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class finalPanel extends JPanel {
    myPoint shapes[];
    int n = 0;
    int size = 6;

    public finalPanel() {
        shapes = new myPoint[10000];
        setBackground(Color.white);
        addMouseMotionListener(new myMouseEvents());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < n; i++) {
            myPoint s = shapes[i];
            g.fillRect(s.x, s.y, size, size);
        }
    }

    void clearLastShape() {
        if (n >= 10)
            n-=10;
        else clearDrawing();
        repaint();
    }

    void clearDrawing() {
        n = 0;
        repaint();
    }

    class myPoint {
        int x, y;
        public myPoint(int a, int b) {
            x = a;
            y = b;
        }
    }

    class myMouseEvents extends MouseAdapter {
        public void mouseDragged(MouseEvent e) {
            shapes[n] = new myPoint(e.getX(), e.getY());
            repaint();
            n++;
        }
    }
}
