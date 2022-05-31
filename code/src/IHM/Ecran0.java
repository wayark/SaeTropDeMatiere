package IHM;

import javax.swing.*;
import java.awt.*;

public class Ecran0 extends JPanel {
    JFrame f;
    public Ecran0(JFrame f) throws HeadlessException {
        this.f = f;
    }

    public void setup(){
    }

    public JPanel constrPan(){

        JPanel main = new JPanel();


        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JLabel jlabel = new JLabel("Affichage d'un élément");
        main.add(jlabel);


        return main;

    }
}
