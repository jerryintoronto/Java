import javax.swing.*;
import java.io.IOException;

public class a_webViewer {
    public static void main(String[] args) {

        JFrame f = new JFrame();

        try {
            JEditorPane p = new JEditorPane("https://www.google.ca/");
            p.setEditable(false);
            f.add(new JScrollPane(p));
        }

        catch (IOException e) { }

        f.setSize(1000, 800);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


