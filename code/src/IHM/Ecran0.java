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
        JButton affichage0Distance = new JButton("Affichage d'un élément");
        main.add(affichage0Distance);
        JButton affichageVoisinDirect = new JButton("Affichage des voisins");
        main.add(affichageVoisinDirect);
        JButton affichageVoisin2Distance = new JButton("Affichage des voisins : Distance 2");
        main.add(affichageVoisin2Distance);
        JButton Comparer2Villes = new JButton("Comparer des villes");
        main.add(Comparer2Villes);
        JButton Distance = new JButton("distance entre deux sites");
        main.add(Distance);

        return main;

    }
}
