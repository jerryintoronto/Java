package finalProject;

import javax.swing.*;
import java.awt.*;

public class finalTester {

    public static void main(String[] args) {

        finalPanel p = new finalPanel();

        JButton undo = new JButton("Undo");
        undo.setFont(new Font("Arial", Font.BOLD, 40));
        undo.addActionListener(e -> p.clearLastShape());
        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.BOLD, 40));
        clear.addActionListener(e -> p.clearDrawing());


        //Adding buttons to panel
        JPanel t = new JPanel();
        t.add(undo);
        t.add(clear);

        //Add panels to frame
        JFrame f = new JFrame();
        f.add(t, BorderLayout.NORTH);
        f.add(p, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1200, 800);
        f.setVisible(true);
    }
}
