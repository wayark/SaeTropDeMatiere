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

        JLabel n = new JLabel("Taille du graphe");

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
        left.setBackground(Color.red);
        left.setSize(200,0);
        left.setPreferredSize(new Dimension(200,0));

        JPanel middle = new GraphDrawing(listCity,f);
        middle.setLayout(new BoxLayout(middle,BoxLayout.Y_AXIS));
        middle.setSize(400,0);
        middle.setPreferredSize(new Dimension(400,0));

        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right,BoxLayout.Y_AXIS));
        right.setBackground(Color.yellow);
        right.add(n);
        right.setSize(200,0);
        right.setPreferredSize(new Dimension(200,0));


        //this.setLayout(new GridLayout(1,3));
        this.setLayout(new BorderLayout());
        this.add(left,BorderLayout.WEST);
        this.add(middle,BorderLayout.CENTER);
        this.add(right,BorderLayout.EAST);



    }


}
