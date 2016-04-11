import javax.swing.*;
import java.awt.*;

public class f_usingSwingWorker extends JFrame {

    static JTextField numField = new JTextField();
    static JButton goButton = new JButton("Go!!!");
    static JButton stop = new JButton("Stop/Clear");
    static f_usingSwingWorker a = new f_usingSwingWorker();

    public static void main(String[] args) {
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public f_usingSwingWorker() {
        setLayout(new GridLayout(1, 1));
        goButton.addActionListener(
                e -> {
                    int n = Integer.parseInt(numField.getText());
                    numField.setText("Calculating...");
                    numField.setEditable(false);
                    getFib x = new getFib(n);
                    x.execute(); //!
                });

        stop.addActionListener(
                e -> {
                    getFib x = new getFib(-1);
                    x.execute();
                }
        );

        goButton.setBackground(Color.GREEN);
        stop.setBackground(Color.RED);

        add(numField);
        add(goButton);
        add(stop);
        setSize(475, 100);
        setVisible(true);
    }


    public class getFib extends SwingWorker<Long, Object> {
        final int fibNum;
        public getFib(int n) {
            fibNum = n;
        }
        public Long doInBackground() { //!
            return fib(fibNum);
        }
        public long fib(long n) {
            if (n == 0 || n == 1) return n;
            else return fib(n - 1) + fib(n - 2);
        }

        protected void done() {
            try {
                if (fibNum >= 0) {
                    numField.setText(get() + " ");
                } else
                    numField.setText("");
                numField.setEditable(true);
            } catch (Exception ex) {
            }
        }
    }
}

