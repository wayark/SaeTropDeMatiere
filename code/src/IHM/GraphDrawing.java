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

public class GraphDrawing extends JPanel {
    private int x;
    private int y;
    JFrame f;
    ListCity listCity;
    Ellipse2D.Double[] node;
    Line2D.Double[] line;


    public GraphDrawing(ListCity listCity, JFrame f) {
        super();
        this.f = f;
        this.listCity = listCity;
        node = new Ellipse2D.Double[listCity.size()];
        line = new Line2D.Double[listCity.getEdgeList().size()];
        setBorder(BorderFactory.createLineBorder(Color.gray));
        constpan();

    }
    private void constpan(){



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
        int i;
        int currentX;
        int currentY;

        Random r = new Random();
        Place tmp = listCity.getHead();

        i=0;
        while (tmp !=null){
            g2.setColor(Color.black);
            node[i] = new Ellipse2D.Double((currentX = r.nextInt(100,d.width-100)),(currentY = r.nextInt(100,d.height-100)),15,15);
            g2.drawString(tmp.getType()+","+tmp.getName(),currentX,currentY-5);
            tmp.setX(currentX);
            tmp.setY(currentY);
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

        i=0;
        g2.setStroke(new BasicStroke(2f));


        for (Edge e : listCity.getEdgeList()){
            line[i] = new Line2D.Double(e.getLinked1().getX()+5,e.getLinked1().getY()+5,e.getLinked2().getX()+5,e.getLinked2().getY()+5);
            g2.draw(line[i]);
            i++;
        }
    }
}
