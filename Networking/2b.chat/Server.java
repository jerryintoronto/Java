import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Server {

    static JTextArea displayArea = new JTextArea();
    static Formatter output;
    static Scanner input;
    static Socket socket;

    public static void main(String[] args) throws Exception{
        JFrame f = new JFrame();
        JTextField t = new JTextField();
        t.setFont(new Font("Serif", Font.PLAIN, 40));
        displayArea.setFont(new Font("Serif", Font.PLAIN, 40));
        t.addActionListener(
                e -> {
                    String s = "SERVER>>>" + e.getActionCommand();
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


        ServerSocket server = new ServerSocket(12345, 100);
        socket = server.accept();
        output = new Formatter(socket.getOutputStream());
        input = new Scanner(socket.getInputStream());

        while (true)
            if (input.hasNextLine())
                display(input.nextLine());
    }


    static void display(String s) {
        SwingUtilities.invokeLater(
                () -> displayArea.append(s + "\n"));

    }
}
