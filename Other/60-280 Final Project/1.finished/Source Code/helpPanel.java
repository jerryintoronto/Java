package finalProject;


import javax.swing.*;
import java.awt.*;

public class helpPanel extends JPanel {

    public helpPanel() {

        setBackground(new Color(40, 40, 40, 200));
        setPreferredSize(new Dimension(1000,1000));
        setVisible(false);

        String str = "<html><br><br>" +
                "HELP <br><br>" +
                "Undo:        Go back to previous state.<br> " +
                "             Warning there is no redo. <br>" +
                "Clear:       Clears all (your) drawings on screen.<br>" +
                "             Warning there is no redo. <br>" +
                "Set Name:    Set your name for chat. <br>" +
                "Toggle Chat: Show/Hide chat panel. </html>";

        JLabel l = new JLabel(str);
        l.setFont(new Font("Arial", Font.PLAIN, 25));
        l.setForeground(Color.LIGHT_GRAY);

        add(l);

    }


}
