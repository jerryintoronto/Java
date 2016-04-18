#Swing Drawing 

main
{
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    myPanel p = new myPanel();
    f.add(p);
    f.setSize(800, 600);
    f.setVisible(true);
}

static class myPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.WHITE);

            int x = 20, y = 20;
            g.drawString("HELLO", x, y);

            String output = "How are you?";

            for (int i = 1; i < 7; i++) {
                g.setColor(new Color(0, i * 30 , i * 30));
                g.setFont(new Font("Courier", Font.BOLD, 22 + 3*i));
                g.drawString(output, x + 40 * i, y + 60 *i);
                output += "?";

            }
        }
    }