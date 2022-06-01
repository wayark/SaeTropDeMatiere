package IHM;

import NodePackage.ListCity;
import NodePackage.Place;

import javax.swing.*;
import java.awt.*;

public class Ecran0 extends JPanel {
    JFrame f;
    ListCity listCity;

    public Ecran0(ListCity listCity, JFrame f) throws HeadlessException {
        super();
        this.f = f;
        this.listCity = listCity;
        setBorder(BorderFactory.createLineBorder(Color.gray));
        constrPan();

    }


    public void constrPan() {

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(Color.LIGHT_GRAY);
        left.setSize(300, 0);
        left.setPreferredSize(new Dimension(300, 0));

        JLabel typeChoice = new JLabel("Choissisez un type de noeud à afficher : ");
        JComboBox<String> c = new JComboBox<String>();
        //c.setSize(new Dimension(100,30));
        c.setPreferredSize(new Dimension(100,30));

        typeChoice.setAlignmentX(CENTER_ALIGNMENT);
        c.setAlignmentX(CENTER_ALIGNMENT);

        left.add(typeChoice);
        left.add(c);

        JPanel graph = new GraphDisplay(listCity, f);
        graph.setLayout(new BoxLayout(graph, BoxLayout.Y_AXIS));
        graph.setSize(1200, 0);
        graph.setPreferredSize(new Dimension(1200, 0));


        this.setLayout(new BorderLayout());
        this.add(left, BorderLayout.WEST);
        this.add(graph, BorderLayout.CENTER);


    }
}
