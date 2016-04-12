import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class c_clientToClientChat {

    static Scanner input;
    static Formatter output;
    static JFrame f = new JFrame();
    static JTextArea displayArea = new JTextArea();
    static JTextField t = new JTextField();

    public static void main(String[] args) {
        createGUI();
        startNetworking();
    }

    static void createGUI() {
        t.addActionListener(
                e -> {
                    output.format(e.getActionCommand() + "\n");
                    output.flush();
                    t.setText("");
                });

        f.add(new JScrollPane(displayArea));
        f.add(t, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 750);
        f.setVisible(true);
    }

    static void startNetworking() {
        display("Connecting...");
        try {
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
            input = new Scanner(socket.getInputStream());
            output = new Formatter(socket.getOutputStream());
        } catch (Exception e) { }

        while (true)
            if (input.hasNextLine())
                display(input.nextLine());
    }
    //writes input
    static void display(String s) {
        if (s.equals("TERMINATE")) System.exit(1);
        SwingUtilities.invokeLater(() -> displayArea.append(s + "\n"));
    }
}

