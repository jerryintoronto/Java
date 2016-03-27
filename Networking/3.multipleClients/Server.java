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
    static int max = 5;

    public static void main(String[] args) throws IOException {
        GUI();
        Networking();
    }

    static void GUI() {
        JFrame f = new JFrame();
        f.setTitle("Server");
        outputArea = new JTextArea();
        outputArea.setFont(new Font("Arial", Font.BOLD, 30));
        outputArea.append("This is the server - capacity: " + max + "\n");
        f.add(outputArea);
        f.setSize(600, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void Networking() throws IOException {
        ExecutorService e= Executors.newFixedThreadPool(max);
        ServerSocket s= new ServerSocket(12345, max);

        for (int i = 0; i < max; i++)
            e.execute(new myClass(s.accept(), i));

    }

    static class myClass implements Runnable {
        Socket socket;
        Scanner input;
        Formatter output;
        int clientNumber;

        public myClass(Socket s, int n) {
            clientNumber = n;
            socket = s;

            try {
                input = new Scanner(socket.getInputStream());
                output = new Formatter(socket.getOutputStream());
                output.format("Hello player " + (n + 1) + "/" + max + "\n");
                output.flush();
                display("Player " + clientNumber + " connected");
            }

            catch (IOException e) { System.exit(1); }
        }

        public void run() {

            while (true) {
                String s = input.nextLine();
                display("Board location: " + s);

                output.format("SERVER>>>You clicked " + s + "\n");
                output.flush();

                try { Thread.sleep(400); }
                catch (Exception e) { }
            }
        }

        void display(String s) {
            SwingUtilities.invokeLater(() -> outputArea.append(s + "\n"));
        }

    }
}



