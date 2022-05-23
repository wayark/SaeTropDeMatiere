package IHM;
    import java.awt.Graphics;
    import javax.swing.*;

public class ligne extends JPanel{
        public void paint(Graphics g){

            g.drawLine(20, 20, 200, 180);
        }

        public static void main(String[] args){

            JFrame f = new JFrame("Dessiner une ligne");
            f.getContentPane().add(new ligne());
            f.setSize(250, 250);
            f.setVisible(true);
            f.setResizable(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}
