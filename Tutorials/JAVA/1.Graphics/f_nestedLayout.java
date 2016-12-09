import javax.swing.*;
import java.awt.*;

public class f_nestedLayout {

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setLayout(new BorderLayout(5,5));

        JPanel p1 = new JPanel();
        p1.setBackground(Color.BLUE);

        p1.setPreferredSize(new Dimension(300, 300));
        f.add(p1, BorderLayout.EAST);

        JPanel p2 = new JPanel();
        p2.setBackground(Color.RED);
        f.add(p2, BorderLayout.CENTER);

        JPanel p3 = new JPanel();
        p3.setBackground(Color.GREEN);
        f.add(p3, BorderLayout.NORTH);
        p3.setPreferredSize(new Dimension(200, 200));
        p3.setLayout(new FlowLayout());

        p3.add(new JButton("B1"));
        p3.add(new JButton("B2"));


        p1.setLayout(new BorderLayout());
        p1.add(new JTextArea());
        p1.add(new JTextField(), BorderLayout.SOUTH);




        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 1000);

    }
}
