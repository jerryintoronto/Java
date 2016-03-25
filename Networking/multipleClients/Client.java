import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    static JTextArea displayArea;
    static Scanner input;
    static Formatter output;

    public static void main(String[] args) {
        //1-GUI
        createGUI();
        //2-Networking
        new networking();
    }

    static void createGUI() {
        JFrame f = new JFrame();
        f.setTitle("Where did I click?");

        //DisplayArea
        displayArea = new JTextArea(4, 30);
        displayArea.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        //Board
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++)
            boardPanel.add(new Square(i)); //each Square is a class that extends JPanel
        f.add(boardPanel);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 750);
        f.setVisible(true);
    }
    //helper class for GUI
    static class Square extends JPanel {
        public Square(int location) {
            addMouseListener(
                    new MouseAdapter() {
                        //output when mouse released
                        public void mouseReleased(MouseEvent e) {
                            output.format("%d\n", location);
                            output.flush();
                        }
                    }); }

        public Dimension getPreferredSize() {
            return new Dimension(170, 170); }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setFont(new Font("Arial", Font.BOLD, getHeight() / 2));
            g.drawString("?", getWidth() * 2 / 5, getHeight() / 2);
        }
    }


    /***********************************
     *           NETWORKING
     ***********************************/
    static class networking implements Runnable {

        public networking() {
            try {
                Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
                input = new Scanner(socket.getInputStream());
                output = new Formatter(socket.getOutputStream());
            } catch (IOException e) {System.exit(1); }

            ExecutorService w = Executors.newFixedThreadPool(1);
            w.execute(this);
        }

        //listens for input
        public void run() {
            display("I am running");
            while (true) {
                if (input.hasNextLine())
                    display(input.nextLine());

                try { Thread.sleep(500); } catch (Exception e) { }
            }
        }
        void display(String s) {
            SwingUtilities.invokeLater(() -> displayArea.append(s + "\n"));
        }
    }
}

