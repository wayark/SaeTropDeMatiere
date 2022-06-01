package IHM;

import NodePackage.Edge;
import NodePackage.ListCity;
import NodePackage.Place;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class MainPanel extends JPanel {
    JFrame f;
    ListCity listCity;


    public MainPanel(ListCity listCity, JFrame f) {
        super();
        this.f = f;
        this.listCity = listCity;
        setBorder(BorderFactory.createLineBorder(Color.gray));
        constpan();

    }
    private void constpan(){



        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
        left.setBackground(Color.LIGHT_GRAY);
        left.setSize(300,0);
        left.setPreferredSize(new Dimension(300,0));

        JLabel size = new JLabel("Taille du graphe :"+String.valueOf(listCity.countList()));
        JLabel type = new JLabel("Type de Noeud :");
        



        left.add(n);

        JPanel graph = new GraphDisplay(listCity,f);
        graph.setLayout(new BoxLayout(graph,BoxLayout.Y_AXIS));
        graph.setSize(800,0);
        graph.setPreferredSize(new Dimension(800,0));

        this.setLayout(new BorderLayout());
        this.add(left,BorderLayout.WEST);
        this.add(graph,BorderLayout.CENTER);


    }


}
