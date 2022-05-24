package IHM;

import NodePackage.ListCity;
import NodePackage.Place;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

public class MainPanel extends JPanel {
    private int x;
    private int y;
    JFrame f;
    ListCity listCity;
    Ellipse2D.Double[] c;

    public MainPanel(ListCity listCity, JFrame f) {
        super();
        this.f = f;
        this.listCity = listCity;
        c = new Ellipse2D.Double[listCity.size()];
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        Dimension d = f.getSize();
        g2.setColor(Color.black);


        Random r = new Random();
        Ellipse2D.Double c = new Ellipse2D.Double(100, 100, 50, 50);
        Ellipse2D.Double c1 = new Ellipse2D.Double(250, 200, 50, 50);
        Ellipse2D.Double c2 = new Ellipse2D.Double(500, 220, 50, 50);
        Ellipse2D.Double c3 = new Ellipse2D.Double(950, 450, 50, 50);
        g2.draw(c);
        g2.draw(c1);
        g2.draw(c2);
        g2.draw(c3);
        g2.fill(c);
        g2.fill(c1);
        g2.fill(c2);
        g2.fill(c3);
        /*for (int i = 0 ; i < listCity.size(); i++){
            c[i] = new Ellipse2D.Double(100,10+(r.nextInt()%d.height),10,10);
            System.out.println(d.width);
            System.out.println(d.height);
            g2.draw(c[i]);
            g2.fill(c[i]);
        }*/
    }



}
