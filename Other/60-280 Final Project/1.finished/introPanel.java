package finalProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class introPanel extends JPanel {

    static ArrayList<myBall> ballArr = new ArrayList(20);
    static Random random = new Random();
    static boolean flag = true;
    static JFrame mainFrame;
    static int cMax = 50;

    public introPanel(JFrame f) {
        mainFrame = f;

        setBackground(Color.WHITE);

        JLabel title = new JLabel("60-280 FINAL PROJECT");
        title.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 60));
        add(title);
        ballArr.add(new myBall());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (myBall b : ballArr) {
            g.setColor(b.color);
            g.fillOval(b.x, b.y, 100, 100);
            Font myFont = new Font("Courier New", Font.BOLD, 27);
            g.setFont(myFont);
            g.drawString(b.str, b.x+15, b.y-5);
            g.setColor(Color.white);
            g.drawString("^", b.x + 20, b.y + 50);
            g.drawString("^", b.x + 70, b.y + 50);
            g.drawArc(b.x + 20, (b.y + 60), 60, 20, 0, -180);
        }

        notes(g);
    }

    void notes(Graphics g) {
        g.setColor(new Color(244,222,222));
        g.drawString("Client to Client chat..."
                ,  this.getWidth()/3 , this.getHeight()/2);
        g.drawString("Client to Client drawing..."
                ,  this.getWidth()/3 , this.getHeight()/2 + 30);
        g.drawString("Using concepts from 60-280."
                ,  this.getWidth()/3 , this.getHeight()/2 + 60);
        g.drawString("Press START! to continue."
                ,  this.getWidth()/3 , this.getHeight()/2 + 90);
    }


    void start() {

        while (flag) {
            for (myBall b : ballArr)
                b.update(this.getWidth(), this.getHeight());

            if (ballArr.size() < 20 && random.nextInt(700) == 1) {
                ballArr.add(new myBall());
            }



            repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    static class myBall {

        int r, g, b, x, y;
        boolean moveRight = true;
        boolean moveUp = true;
        Color color;
        String str;
        String words[] = "Hey! Hi! Hello! Hullo!".split(" ");

        public myBall() {
            x = random.nextInt(700) + 100;
            y = random.nextInt(700) + 100;
            color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            str = words[random.nextInt(words.length)];
        }

        void update(int wallX, int wallY) {

            //borders
            if (x > wallX || x < 10) {
                color = lightColor();
                moveRight = !moveRight;
            }

            if (y > wallY || y < 10) {
                color = lightColor();
                moveUp = !moveUp;
            }

            //move
            if (moveRight)
                x++;
            else x--;

            if (moveUp)
                y++;
            else
                y--;

        }

        Color lightColor() {
            r = random.nextInt(cMax) + 150;
            g = random.nextInt(cMax) + 150;
            b = random.nextInt(cMax) + 150;
            color = new Color(r, g, b);

            return color;
        }


    }

}

