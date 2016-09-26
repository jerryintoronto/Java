import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class finalClient {

    //network
    static Scanner input;
    static Formatter output;

    //chat
    static JTextArea displayArea= new JTextArea();
    static String name = "me";
    static boolean showChat = true;

    //draw
    static Point allPoints[];
    static ArrayList<Point> allOtherPoints;
    static int n = 0;
    static int n2 = 0;
    static int size = 6;
    static drawPanel p2 = new drawPanel(); //drawPanel is an inner class!

    //helpButton
    static boolean showHelp = false;


    //----------------------------------------------------------------------

    public static void main(String[] args) {

        myFrame f = new myFrame();

        //Chat
        JTextField t = new JTextField();
        chatPanel p1 = new chatPanel(displayArea,t);
        t.addActionListener(
                e -> {
                    String s = e.getActionCommand();
                    output.format(s + "\n");
                    output.flush();
                    SwingUtilities.invokeLater(() -> displayArea.append(
                            name + ": " + s + "\n"));
                    t.setText("");
                });
        p1.add(new JScrollPane(displayArea));
        p1.add(t, BorderLayout.SOUTH);

        //Buttons
        JPanel p3 = new JPanel();
        JButton undo = new JButton("Undo");
        JButton clear = new JButton("Clear");
        JButton nameButton = new JButton("Set Name");
        JButton hideChatButton = new JButton("Toggle Chat");
        JButton questionButton = new JButton("?");

        undo.addActionListener(e -> p2.clearLastShape());
        clear.addActionListener(e -> p2.clearDrawing());
        nameButton.addActionListener(e ->
                name = JOptionPane.showInputDialog(f,
                        "What is your name?", null));
        hideChatButton.addActionListener(
                e -> {
                    showChat = !showChat;
                    p1.setVisible(showChat);
                });

        //questionButton show/hides p5
        helpPanel p5 = new helpPanel();
        questionButton.addActionListener(
                e -> {
                    showHelp = !showHelp;
                    p5.setVisible(showHelp);
                } );

        p3.add(undo);
        p3.add(clear);
        p3.add(nameButton);
        p3.add(hideChatButton);
        p3.add(questionButton);
        p2.add(p5);

        //add font type of each button in another class
        new buttonSettings(undo,clear,nameButton, hideChatButton, questionButton);

        //intro screen
        JPanel p4 = new JPanel();
        p4.setBackground(Color.WHITE);
        p4.setLayout(new BorderLayout());

        introPanel animationCover = new introPanel(f);

        JButton b = new JButton("START!");
        b.setFont(new Font("Arial", Font.BOLD, 40));
        b.addActionListener(e -> {
            animationCover.flag = false; //turn off animation
            p4.setVisible(false);

            f.setLayout(new BorderLayout(5, 5));
            f.add(p2, BorderLayout.CENTER);
            f.add(p1, BorderLayout.EAST);
            f.add(p3, BorderLayout.NORTH);
        });

        p4.add(b, BorderLayout.SOUTH);
        p4.add(animationCover);
        f.add(p4);


        f.setVisible(true); //this needs to be after intro!
        animationCover.start(); //starts intro animation
        new networking(); //starts networking
    }


    //---------------------------------------------------------------------
    //drawPanel uses a lot of shared variables, so an inner class is used.
    static class drawPanel extends JPanel {

        public drawPanel() {
            allOtherPoints = new ArrayList(10000);
            allPoints = new Point[10000];
            setBackground(Color.white);
            addMouseMotionListener(new myMouseEvents());
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < n; i++) {
                Point s = allPoints[i];
                g.setColor(Color.black);
                g.fillRect(s.x, s.y, size, size);
            }

            //other
            g.setColor(Color.RED);
            for (int i = 0; i < n2 ; i++) {
                Point s = allOtherPoints.get(i);
                g.fillRect(s.x, s.y, size, size);
            }
        }

        public void clearLastShape() {
            if (n > 0)
                n -= 10;
            repaint();
            //sends id key and new n
            output.format("#t333t %d\n",n);
            output.flush();
        }

        public void clearDrawing() {
            n = 0;
            repaint();
            //sends [id key] to server
            output.format("#t222t\n");
            output.flush();
        }


        class myMouseEvents extends MouseAdapter {
            public void mouseDragged(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();

                //send [id key],x,y,n to server
                output.format("#t111t %d %d %d\n", x, y, n);
                output.flush();

                //add point to own client
                allPoints[n] = new Point(x, y);
                repaint();
                n++;
            }
        }
    }


    /**********************************************
     * NETWORKING
     *****************************************/
    static class networking implements Runnable {

        public networking() {
            try {
                Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
                input = new Scanner(socket.getInputStream());
                output = new Formatter(socket.getOutputStream());
            } catch (IOException e) {
                String message = "Please run the starServer first!\n";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                        JOptionPane.ERROR_MESSAGE); //error message
                System.exit(1);
            }
            ExecutorService w = Executors.newFixedThreadPool(1);
            w.execute(this);
        }

        //listens for input
        public void run() {
            while (true) {
                if (input.hasNextLine())
                    process(input.nextLine());
            }
        }

        void process(String s) {
            //processes server's outputs (both chat and draw)
            if (s.equals("TERMINATE"))
                System.exit(1);

            //#txxxt is for drawPanel
            if (s.contains("#t333t")) {
                String arr[] = s.split(" ");
                for (int num = n2; num >Integer.parseInt(arr[1]); num-- ) {
                    allOtherPoints.remove(num);
                }
                n2 = Integer.parseInt(arr[1]);
                p2.repaint();
            } else if (s.contains("#t222t")) {
                n2 = 0;
                allOtherPoints.clear();
                p2.repaint();
            } else if (s.contains("#t111t")) {

                String arr[] = s.split(" ");
                n2 = Integer.parseInt(arr[3]);
                int x = Integer.parseInt(arr[1]);
                int y = Integer.parseInt(arr[2]);
                allOtherPoints.add(new Point(x, y));
                p2.repaint();
            } else //this is for chat!
                SwingUtilities.invokeLater(() -> displayArea.append("Other: " + s + "\n"));

        }
    }
}




