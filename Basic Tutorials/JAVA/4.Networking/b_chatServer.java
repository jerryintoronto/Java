import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class b_chatServer {
    public static void main(String[] args) {
        Server s = new Server();
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            s.runServer();
        } catch (Exception e) { }
    }

    public static class Server extends JFrame {
        JTextField enterField = new JTextField();
        JTextArea displayArea = new JTextArea();
        Formatter output;
        Scanner input;
        ServerSocket server;
        Socket connection;

        public Server() {
            super("Server");
            enterField.addActionListener(
                    e -> {
                        sendData(e.getActionCommand());
                        enterField.setText("");
                    }
            );
            add(enterField, BorderLayout.NORTH);
            add(new JScrollPane(displayArea), BorderLayout.CENTER);
            setSize(800, 600);
            setVisible(true);
        }

        public void runServer() throws Exception {
            server = new ServerSocket(12345, 100);
            while (true) {
                try {
                    display("Waiting for connection\n");
                    connection = server.accept();
                    display("Connection received from\n");
                    output = new Formatter(connection.getOutputStream());
                    input = new Scanner(connection.getInputStream());
                    while (true)
                        display("\n" + input.nextLine());
                } catch (Exception e) {
                } finally {
                    output.close();
                    input.close();
                    connection.close();
                }
            }
        }

        private void sendData(String message) {
            try {
                output.format("SERVER>>> " + message + "\n");
                output.flush();
                display("\nSERVER>>> " + message);
            } catch (Exception e) { }
        }

        private void display(final String messageToDisplay) {
            SwingUtilities.invokeLater(() -> displayArea.append(messageToDisplay));
        }
    }
}
