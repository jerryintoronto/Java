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
                    
                    //g.drawString (________); 
                    //g.drawLine(_____); 
                    //etc 
        
                    }
                }
            }
