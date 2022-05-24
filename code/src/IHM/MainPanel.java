package IHM;

import NodePackage.ListCity;
import NodePackage.Place;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
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



        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
                System.out.println(listCity.isClicked(x,y));
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);

        Dimension d = f.getSize();
        int i = 0;
        int currentX;
        int currentY;

        Random r = new Random();
        Place tmp = listCity.getHead();


        while (tmp !=null){
            c[i] = new Ellipse2D.Double((currentX = r.nextInt(100,d.width-100)),(currentY = r.nextInt(100,d.height-100)),15,15);
            g2.drawString(tmp.getName(),currentX,currentY-5);
            tmp.setX(currentX);
            tmp.setY(currentY);
            g2.draw(c[i]);
            g2.fill(c[i]);

            i++;
            tmp = (Place) tmp.next;
        }
    }



}
