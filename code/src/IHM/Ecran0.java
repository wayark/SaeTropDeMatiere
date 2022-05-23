package IHM;

import javax.swing.*;
import java.awt.*;

public class Ecran0 extends JFrame {
    public Ecran0() throws HeadlessException {
        setup();
    }

    public void setup(){
        setTitle("Ecran 0");
        setSize(1000,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(constrPan());
        setVisible(true);
    }

    public JPanel constrPan(){

        JPanel main = new JPanel();
        JButton Retour = new JButton("Retour");
        Retour.addActionListener(event ->
        {
            this.dispose();
        });

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JLabel jlabel = new JLabel("Affichage d'un élément");
        main.add(jlabel);


        return main;

    }
}
