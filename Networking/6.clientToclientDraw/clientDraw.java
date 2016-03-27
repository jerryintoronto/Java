import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class clientDraw extends JPanel {

    Point allPoints[];
    ArrayList <Point> allOtherPoints;
    int n = 0;
    int n2 = 0;
    int size = 6;
    static Scanner input;
    static Formatter output;

    public static void main(String[] args) {

        clientDraw p = new clientDraw();
        JFrame f = new JFrame();
        f.add(p, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1200, 800);
        f.setVisible(true);
    }

    public clientDraw() {
        allPoints= new Point[10000];
        allOtherPoints = new ArrayList(10000);
        setBackground(Color.white);
        addMouseMotionListener(new myMouseEvents());
        new networking();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //own
        for (int i = 0; i < n; i++) {
            Point s = allPoints[i];
            g.fillRect(s.x, s.y, size, size);
        }

        //other
        g.setColor(Color.RED);
        for (int i = 0; i < n2 / 2; i++) {
            //unknown data loss (only recieves half the points)
            Point s = allOtherPoints.get(i);
            g.fillRect(s.x, s.y, size, size);
        }
    }

    class Point {
        int x, y;
        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    class myMouseEvents extends MouseAdapter {
        public void mouseDragged(MouseEvent e) {

            int x = e.getX();
            int y = e.getY();

            //send x,y,n to server
            output.format("%d %d %d\n", x, y, n);
            output.flush();

            //own client
            allPoints[n] = new Point(x, y);
            repaint();
            n++;
        }
    }

    class networking implements Runnable {

        public networking() {
            try {
                Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
                input = new Scanner(socket.getInputStream());
                output = new Formatter(socket.getOutputStream());
            } catch (IOException e) {
                System.exit(1);
            }

            ExecutorService w = Executors.newFixedThreadPool(1);
            w.execute(this);
        }

        //listens for input
        public void run() {
            while (true) {
                //recieves x,y
                if (input.hasNextLine())
                    process(input.nextLine());
            }
        }

        public void process(String s) {
            if (s.contains("TERMINATE"))
                System.exit(1);

            String arr[] = s.split(" ");
            int intArr[] = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();

            n2 = intArr[2];
            allOtherPoints.add(new Point(intArr[0], intArr[1]));
            repaint();
        }
    }
}
