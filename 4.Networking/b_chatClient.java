import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class b_chatClient {
    public static void main(String[] args) {
        Client c = new Client();
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.runClient();
    }

    public static class Client extends JFrame {
        JTextField enterField =  new JTextField();
        static JTextArea displayArea =  new JTextArea();
        Formatter output;
        Scanner input;
        Socket client;

        public Client() {
            enterField.addActionListener(
                    e -> {
                        sendData(e.getActionCommand());
                        enterField.setText(""); } );

            add(enterField, BorderLayout.NORTH);
            add(new JScrollPane(displayArea));
            setSize(800, 600);
            setVisible(true);
        }

        public void runClient() {
            try {
                display("Attempting connection\n");
                client = new Socket(InetAddress.getByName("127.0.0.1"), 12345);
                output = new Formatter(client.getOutputStream());
                input = new Scanner(client.getInputStream());
                while(true) { display("\n" + input.nextLine()); }
            }
            catch (Exception e) {} 
            finally { closeConnection(); }
        }

        private void closeConnection() {
            try {
                output.close();
                input.close();
                client.close();
            } catch (Exception e) { }
        }

        private void sendData(String message) {
            try {
                output.format("CLIENT>>> " + message + "\n");
                output.flush();
                display("\nCLIENT>>> " + message);
            } catch (Exception e) { }
        }

        static void display(final String s) {
            SwingUtilities.invokeLater( () -> displayArea.append(s));
        }
    }
}

