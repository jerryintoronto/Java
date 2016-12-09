import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class g_keyListener {
    static int x = 100;
    static int y = 100;


    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.add(new MyPanel());
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


    static class MyPanel extends JPanel implements KeyListener {
        private char c = 'e';

        public MyPanel() {
            addKeyListener(this);
        }

        public void addNotify() {
            super.addNotify();
            requestFocus();
        }

        public void paintComponent(Graphics g) {
            g.clearRect(0, 0, getWidth(), getHeight());
            g.drawString("the key that pressed is " + c, 100, 250);
            g.drawString("move left: h, move down: j, move up: k, move right: l", 100, 300);
            g.fillOval(Math.max(0, Math.min(getWidth(),x)), Math.max(0,Math.min(getWidth(), y)), 50, 50);

        }

        public void keyPressed(KeyEvent e) { }
        public void keyReleased(KeyEvent e) { }

        public void keyTyped(KeyEvent e) {
            c = e.getKeyChar();
            repaint();

            if (c == 'h') {
                x-=25;
            } else if (c == 'l') {
                x+=25;
            } else if (c == 'k') {
                y-=25;
            } else if (c == 'j') {
                y+=25;
            }

        }


    }

}
