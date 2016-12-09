import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c_clientToClientServer {

    static int max = 2;
    static Formatter outputs[] = new Formatter[max];
    static Socket client[] = new Socket[max];

    public static void main(String[] args) {
        GUI();
        Networking();
    }

    static void GUI() {
        JFrame f = new JFrame();
        f.setTitle("chatServer");
        JButton button = new JButton("Terminate");
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.addActionListener(
                e -> {
                    outputAll("TERMINATE\n");
                    System.exit(1);
                }
        );

        f.add(button, BorderLayout.SOUTH);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void Networking() {
        ExecutorService e = Executors.newFixedThreadPool(max);
        ServerSocket s;

        try {
            s = new ServerSocket(12345, max);
            client[0] = s.accept();
            client[1] = s.accept();
            outputs[0] = new Formatter(client[0].getOutputStream());
            outputs[1] = new Formatter(client[1].getOutputStream());
        }
        catch (Exception ex) { }

        e.execute(new myClass(client[0], 0));
        e.execute(new myClass(client[1], 1));

        outputAll("Connected!\n");
    }

    static void outputAll(String s) {
        outputs[0].format(s + "\n");
        outputs[0].flush();
        outputs[1].format(s + "\n");
        outputs[1].flush();
    }

    static class myClass implements Runnable {
        Socket socket;
        Scanner input;
        int n;

        public myClass(Socket s, int n) {
            this.n = n + 1;
            socket = s;
            try { input = new Scanner(client[n].getInputStream()); }
            catch (Exception e) { }
        }

        public void run() {
            while (true) {
                String s = "Client " + n + ": " + input.nextLine();
                outputAll(s);
            }
        }
    }
}

