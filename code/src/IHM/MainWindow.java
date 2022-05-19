package IHM;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        setup();
    }

    public void setup(){
        setTitle("Play Word Interface");
        setSize(800,350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(constrPan());
        setVisible(true);
    }

    public JPanel constrPan(){
        JPanel main = new JPanel();



        return main;
    }
}
