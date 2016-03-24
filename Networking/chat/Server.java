import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static JTextArea displayArea = new JTextArea();
    static ObjectOutputStream output;
    static ObjectInputStream input;
    static Socket socket;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JTextField t = new JTextField();
        t.addActionListener(
                e -> {
                    try {
                        String s = e.getActionCommand();
                        output.writeObject("SERVER>>> " + s);
                        output.flush();
                        display("SERVER>>> " + s);
                    } catch (IOException ex) { }
                    t.setText("");
                });

        f.add(new JScrollPane(displayArea));
        f.add(t, BorderLayout.SOUTH);
        f.setSize(800, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        runServer();
    }

    static void runServer() {
        while (true) {
            try {
                connect();
            }
            catch (Exception e) { }
            finally {
                closeConnection();
            }
        }
    }

    static void connect() throws Exception {
        display("Waiting for connection");
        ServerSocket server = new ServerSocket(12345, 100);
        socket = server.accept();

        output = new ObjectOutputStream(socket.getOutputStream());
        output.flush();
        input = new ObjectInputStream(socket.getInputStream());

        display("Connected... \n");

        while (true)
            display((String) input.readObject());
    }

    static void closeConnection() {
        display("Closing connection");
        try {
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) { }
    }

    static void display(final String s) {
        displayArea.setFont(new Font("Serif", Font.PLAIN, 40));
        SwingUtilities.invokeLater(
                () -> displayArea.append(s + "\n"));
    }
}
