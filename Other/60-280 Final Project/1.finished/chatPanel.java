package finalProject;

import javax.swing.*;
import java.awt.*;

public class chatPanel extends JPanel {
    public chatPanel(JTextArea displayArea, JTextField t) {

        setPreferredSize(new Dimension(300, 300));
        setLayout(new BorderLayout());
        displayArea.setFont(new Font("Arial", Font.BOLD, 30));
        displayArea.setEditable(false);
        displayArea.append("Welcome to Chat \n\n");
        t.setFont(new Font("Serif", Font.PLAIN, 30));
    }
}
