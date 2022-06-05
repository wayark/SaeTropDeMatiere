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
    private int x;
    private int y;


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

        JLabel size = new JLabel("Taille du graphe :"+ String.valueOf(listCity.countList()));
        JLabel type = new JLabel("Nombre de noeud selon le type :");
        JLabel city = new JLabel("Ville : "+String.valueOf(listCity.countByType("V")));
        JLabel place = new JLabel("Lieu Culturel : "+String.valueOf(listCity.countByType("L")));
        JLabel restaurant = new JLabel("Restaurant : "+String.valueOf(listCity.countByType("R")));
        JLabel edge = new JLabel("Nombre de lien : "+String.valueOf(listCity.countEdge()));
        JLabel delim = new JLabel("--------------------------------");
        JLabel info = new JLabel("Cliquez sur un sommets pour avoir des info :");
        JLabel nameP = new JLabel();
        JLabel typeP = new JLabel();
        JLabel countNeighbor = new JLabel();


        size.setAlignmentX(CENTER_ALIGNMENT);
        type.setAlignmentX(CENTER_ALIGNMENT);
        city.setAlignmentX(CENTER_ALIGNMENT);
        place.setAlignmentX(CENTER_ALIGNMENT);
        restaurant.setAlignmentX(CENTER_ALIGNMENT);
        edge.setAlignmentX(CENTER_ALIGNMENT);
        delim.setAlignmentX(CENTER_ALIGNMENT);
        info.setAlignmentX(CENTER_ALIGNMENT);
        nameP.setAlignmentX(CENTER_ALIGNMENT);
        typeP.setAlignmentX(CENTER_ALIGNMENT);
        countNeighbor.setAlignmentX(CENTER_ALIGNMENT);


        left.add(Box.createRigidArea(new Dimension(100,75)));
        left.add(size);
        left.add(new JLabel(" "));
        left.add(type);
        left.add(city);
        left.add(place);
        left.add(restaurant);
        left.add(new JLabel(" "));
        left.add(edge);
        left.add(Box.createRigidArea(new Dimension(100,75)));
        left.add(delim);
        left.add(info);
        left.add(Box.createRigidArea(new Dimension(100,75)));
        left.add(nameP);
        left.add(typeP);
        left.add(countNeighbor);



        JPanel graph = new GraphDisplay(listCity,f);
        graph.setLayout(new BoxLayout(graph,BoxLayout.Y_AXIS));
        graph.setSize(1200,0);
        graph.setPreferredSize(new Dimension(1200,0));

        this.setLayout(new BorderLayout());
        this.add(left,BorderLayout.WEST);
        this.add(graph,BorderLayout.CENTER);



        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX()-300;
                y = e.getY();
                Place placeClicked;

                if ((placeClicked = listCity.isClicked(x,y))!=null){


                    nameP.setText("Nom de la ville : "+placeClicked.getName());
                    switch (placeClicked.getType()) {
                        case "V" -> typeP.setText("Type : Ville");
                        case "L" -> typeP.setText("Type : Lieu culturel");
                        case "R" -> typeP.setText("Type : Restaurant");
                    }
                    /*countNeighbor.setText("Nombre de voisin : "+String.valueOf(listCity.showNeighbor(placeClicked.getName())));*/
                    f.revalidate();
                }
            }
        });
    }


}
