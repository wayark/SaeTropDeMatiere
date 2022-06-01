package IHM;

import NodePackage.Edge;
import NodePackage.ListCity;
import NodePackage.Place;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

public class GraphDisplay extends JPanel {
    JFrame f;
    ListCity listCity;
    Ellipse2D.Double[] node;
    Line2D.Double[] line;


    public GraphDisplay(ListCity listCity, JFrame f) {
        super();
        this.f = f;
        this.listCity = listCity;
        node = new Ellipse2D.Double[listCity.size()];
        line = new Line2D.Double[listCity.getEdgeList().size()];
        setBorder(BorderFactory.createLineBorder(Color.gray));

    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int i;
        Random r = new Random();
        Place tmp = listCity.getHead();



        g2.setStroke(new BasicStroke(2f));
        i=0;


        for (Edge e : listCity.getEdgeList()){
            g2.setColor(Color.GRAY);
            line[i] = new Line2D.Double(e.getLinked1().getX()+5,e.getLinked1().getY()+5,e.getLinked2().getX()+5,e.getLinked2().getY()+5);
            g2.draw(line[i]);
            g2.setColor(Color.red);
            g2.drawString(e.getType()+","+e.getLenght(),(e.getLinked1().getX()+e.getLinked2().getX())/2,(e.getLinked1().getY()+e.getLinked2().getY())/2);
            i++;
        }

        i=0;
        g2.setColor(Color.black);
        while (tmp !=null){
            g2.setColor(Color.black);
            node[i] = new Ellipse2D.Double(tmp.getX(),tmp.getY(),15,15);
            g2.drawString(tmp.getType()+","+tmp.getName(),tmp.getX(),tmp.getY());
            g2.draw(node[i]);

            switch (tmp.getType()) {
                case "V" -> g2.setColor(Color.green);
                case "L" -> g2.setColor(Color.orange);
                case "R" -> g2.setColor(Color.red);
            }
            g2.fill(node[i]);

            i++;
            tmp = (Place) tmp.next;
        }





    }
}
