package finalProject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class finalServer {

    static int max = 2;
    static Formatter outputs[] = new Formatter[max];
    static Socket client[] = new Socket[max];

    public static void main(String[] args) throws IOException {
        GUI();
        Networking();
    }

    static void GUI() {
        JFrame f = new JFrame();
        f.setTitle("finalServer");
        JButton button = new JButton("Terminate");
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.addActionListener(
                e ->
                {
                    outputs[0].format("TERMINATE\n");
                    outputs[1].format("TERMINATE\n");
                    outputs[0].flush();
                    outputs[1].flush();
                    System.exit(1);
                }
        );

        f.add(button, BorderLayout.SOUTH);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void Networking() throws IOException {
        ExecutorService e = Executors.newFixedThreadPool(max);
        ServerSocket s = new ServerSocket(12345, max);

        client[0] = s.accept();
        client[1] = s.accept();
        outputs[0] = new Formatter(client[0].getOutputStream());
        outputs[1] = new Formatter(client[1].getOutputStream());
        e.execute(new myClass(client[0], 0));
        e.execute(new myClass(client[1], 1));
    }

    static class myClass implements Runnable {
        Socket socket;
        Scanner input;
        int clientNumber;

        public myClass(Socket s, int n) {
            clientNumber = n;
            socket = s;

            try {
                input = new Scanner(client[n].getInputStream());
            } catch (IOException e) {
                System.exit(1);
            }
        }

        public void run() {

            while (true) {
                if (input.hasNextLine()) {
                    String s = input.nextLine();
                    if (clientNumber == 0) {
                        outputs[1].format(s + "\n");
                        outputs[1].flush();

                    } else {
                        outputs[0].format(s + "\n");
                        outputs[0].flush();
                    }
                }
            }
        }
    }
}
