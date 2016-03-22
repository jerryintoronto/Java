import javax.swing.*;
import java.awt.*;

public class colorChooser extends JPanel {

    public static void main(String args[]) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b = new JButton("Change Background");
        b.setFont(new Font("Arial", Font.BOLD, 70));
        
        b.addActionListener(
                e -> {
                    Color c = JColorChooser.showDialog(null,
                            "JColorChooser", b.getBackground());
                    if (c != null) {
                        b.setBackground(c);
                    }
                }
        );

        f.add(b);
        f.setSize(800, 800);
        f.setVisible(true);
    }

}

