import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    static ObjectOutputStream output;
    static JTextArea displayArea = new JTextArea();
    static ObjectInputStream input;
    static Socket socket;

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setTitle("Client");
        JTextField t = new JTextField();
        t.addActionListener(
                e -> {
                    try {
                        String s = e.getActionCommand();
                        output.writeObject("CLIENT>>> " + s);
                        output.flush();
                        display("CLIENT>>> " + s);
                    } catch (IOException ex) { }

                    t.setText("");
                });

        f.add(new JScrollPane(displayArea));
        f.add(t, BorderLayout.SOUTH);
        f.setSize(800, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //connect to server
        try {
            display("Attempting connection");
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            input = new ObjectInputStream(socket.getInputStream());
            display("Connected.. \n");

            //read from server
            while (true)
                display((String) input.readObject());
        } catch (Exception e) {
        } finally {
            display("Closing connection.");
            try {
                output.close();
                input.close();
                socket.close();
            } catch (Exception e) { }
        }
    }

    static void display(final String s) {
        displayArea.setFont(new Font("Serif", Font.PLAIN, 40));
        SwingUtilities.invokeLater(
                () -> displayArea.append(s + "\n"));
            /*
            all interaction with needs to be performed on a single thread (the EDT).
            If you need to do GUI updates from another thread (networking thread)
            use SwingUtilities.invokeLater
            */
    }
}

