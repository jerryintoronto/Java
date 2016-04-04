package finalProject;

import javax.swing.*;

public class myFrame extends JFrame {

    public myFrame() {

        super("Client");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
    }



}
