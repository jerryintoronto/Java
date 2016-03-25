import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Client {

    static Formatter output;
    static Scanner input;
    static Socket socket;
    static JTextArea displayArea = new JTextArea();

    public static void main(String[] args) throws Exception {

        JFrame f = new JFrame();
        f.setTitle("Client");
        JTextField t = new JTextField();
        t.setFont(new Font("Serif", Font.PLAIN, 40));
        displayArea.setFont(new Font("Serif", Font.PLAIN, 40));
        t.addActionListener(
                e -> {
                    String s = "CLIENT>>>" + e.getActionCommand() ;
                    display(s);
                    output.format(s + "\n");
                    output.flush();
                    t.setText("");
                });

        f.add(new JScrollPane(displayArea));
        f.add(t, BorderLayout.SOUTH);
        f.setSize(800, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        socket = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
        output = new Formatter(socket.getOutputStream());
        input = new Scanner(socket.getInputStream());

        while (true)
            if (input.hasNextLine())
                display(input.nextLine());

    }

    static void display(String s) {
        SwingUtilities.invokeLater(
                () -> displayArea.append(s+"\n"));

    }
}

