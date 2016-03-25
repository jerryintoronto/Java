import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static JTextArea outputArea;

    public static void main(String[] args) {
        GUI();
        new Networking();
    }

    static void GUI() {
        JFrame f = new JFrame();
        f.setTitle("Server");
        outputArea = new JTextArea();
        outputArea.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(outputArea);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static class Networking {
        int max = 5;
        serverThread arr[] = new serverThread[max];
        ServerSocket server;
        ExecutorService executor = Executors.newFixedThreadPool(max);

        public Networking() {
            try {
                server = new ServerSocket(12345, max);
            } catch (IOException e) { System.exit(1); }

            display("This is the Server - run me first.");
            display("I can handle " + max + " Clients");

            for (int i = 0; i < arr.length; i++) {
                try {
                    arr[i] = new serverThread(server.accept(), i);
                    executor.execute(arr[i]);
                }
                catch (IOException e) { System.exit(1); }
            }
        }

        private void display(final String s) {
            SwingUtilities.invokeLater(() -> outputArea.append(s + "\n"));
        }

        class serverThread implements Runnable {
            //seperate thread for each client hosting
            Socket socket;
            Scanner input;
            Formatter output;
            int clientNumber;

            public serverThread(Socket s, int n) {
                clientNumber = n;
                socket = s;

                try {
                    input = new Scanner(socket.getInputStream());
                    output = new Formatter(socket.getOutputStream());
                } catch (IOException e) { System.exit(1); }

                output.format("Hello player " + (n+1) + "/" + max + "\n");
                output.flush();
            }


            public void run() {
                display("Player " + clientNumber + " connected");

                while (true) {
                    String s = input.nextLine();
                    display("Board location: " + s);

                    output.format("SERVER>>>You clicked " + s + "\n");
                    output.flush();
                    try { Thread.sleep(1000);
                    } catch (Exception e) { }
                }
            }
        }
    }
}


