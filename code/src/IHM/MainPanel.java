package IHM;

import NodePackage.ListCity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class MainPanel extends JPanel {
    private int x;
    private int y;
    ListCity listeVille;

    public MainPanel(ListCity listeVille) {
        super();
        this.listeVille = listeVille;
        setBorder(BorderFactory.createLineBorder(Color.gray));
        constpan();

    }
    private void constpan(){


        JButton affichage0Distance = new JButton("Affichage d'un élément");
        JButton affichageVoisinDirect = new JButton("Affichage des voisins");
        JButton affichageVoisin2Distance = new JButton("Affichage des voisins : Distance 2");
        JButton Comparer2Villes = new JButton("Comparer des villes");
        JButton Distance = new JButton("distance entre deux sites");

        this.add(Comparer2Villes);
        this.add(affichageVoisin2Distance);
        this.add(affichageVoisinDirect);
        this.add(affichage0Distance);
        this.add(Distance);
        this.revalidate();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                System.out.println(x+","+y);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void paintNode(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        int.ra
    }



}
