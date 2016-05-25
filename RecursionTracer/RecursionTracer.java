package PersonalProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecursionTracer {

    static int x = 200;
    static int y = 200;
    static JFrame f = new JFrame();
    static myPanel p = new myPanel();
    static int width = 300;
    static boolean stop = false;
    static String title = "f(10);\n\n\n\n";
    static String str =
            "String f(int n)                                    {\n" +
                    "        if (n == 0)  return \"\";\n" +
                    "        return f(n - 1) + \" \" +  n;        }\n";


    static String arr[] = str.split("\n");
    static String output = "";
    static int n = 10;
    static sidePanel s = new sidePanel();
    static String pause = "PAUSE";
    static boolean done = false;


    public static void main(String[] args) {

        JScrollPane scroll = new JScrollPane(s);
        scroll.setPreferredSize(new Dimension(width, 500));
        f.add(scroll, BorderLayout.SOUTH);


        p.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                //pause button
                if (x >= 450 && x <= 650 && y >= 300 && y <= 500 && !done) {
                    stop = !stop;
                    pause = (pause == "RESUME") ? "PAUSE" : "RESUME";
                    p.repaint();
                }

                //restart button
                else if (x >= 650 && x <= 850 && y >= 300 && y <= 500) {
                    done = false;
                    n = 10;
                    s.setText("Stack parameter\n");
                    output = "";
                    if (stop) {
                        stop = false;
                    }
                    pause = "PAUSE";
                }

                //help button
                else if (true) {

                }
            }
        });

        f.add(p);
        f.setSize(1200, 1200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paint();
    }

    static void paint() {

        while (true) {
            if (!stop) {

                p.repaint();
                x++;
                if (x % 10 == 0) {
                    y++;
                }

                if (x % 30 == 0) {
                    output = n + " " + output;
                    n--;
                    s.append("f(" + n + ") + " + output + "\n");
                }

                if (n == 0) {
                    done = true;
                    stop = !stop;
                    s.append("DONE");
                    y++;
                    p.repaint();
                    y= 1;
                    pause = "";

                }
            }

            try { Thread.sleep(100); } catch (Exception e) { }
        }
    }


    static class myPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setFont(new Font("Arial", Font.BOLD, 30));

            g.setColor(Color.lightGray);
            g.drawString("//Calling the method", 400, 100);
            g.setColor(Color.BLACK);

            g.drawRect(250, 300, 600, 200);
            g.setColor(Color.gray);
            g.fillRect(450, 300, 200, 200);
            g.setColor(Color.white);
            int x = 500;
            if (!pause.equals("PAUSE")) {
                x -=20;
            }
            g.drawString(pause, x, 400);
            g.setColor(new Color(222, 111, 0));
            g.fillRect(650, 300, 200, 200);
            g.setColor(Color.WHITE);
            g.drawString("RESTART", 680, 400);
            g.setColor(Color.black);

            g.drawString(title, 250, 100);

            for (int i = 0; i < arr.length; i++) {
                if (i == y % arr.length)
                    g.setColor(Color.RED);

                g.drawString(arr[i], 250, 150 + 30 * i);

                if (i == y % arr.length)
                    g.setColor(Color.BLACK);
            }
            g.drawString("n = " + n, 300, 400);
        }
    }

    static class sidePanel extends JTextArea {
        public sidePanel() {

            setFont(new Font("Arial", Font.BOLD, 30));
            setEditable(false);

            append("Stack parameter \n\n");
        }
    }


}

