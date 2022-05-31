package IHM;

import NodePackage.Edge;
import NodePackage.ListCity;
import NodePackage.Neighbor;
import NodePackage.Place;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class Ecran1 extends JPanel{
    private ListCity listCity;
    private int x;
    private int y;
    JFrame f;
    Ellipse2D.Double[] node;
    Line2D.Double[] line;

    public Ecran1(ListCity listCity, JFrame f) throws HeadlessException {
        this.listCity = listCity;
        this.x = x;
        this.y = y;
        this.f = f;
        node = new Ellipse2D.Double[listCity.size()];
        line = new Line2D.Double[listCity.getEdgeList().size()];
        setBorder(BorderFactory.createLineBorder(Color.gray));
        constrPan();
    }


    public void constrPan(){
        Neighbor neighbor;
        JPanel main = new JPanel();

        JLabel jLabel = new JLabel("Affichage des voisins direct");
        main.add(jLabel);
        JTextField jTextField = new JTextField();
        main.add(jTextField);
        JButton jButton =new JButton("Valider");
        jButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        String nomVille = jTextField.getText();

                    }
                }
        );
        main.add(jButton);

        this.add(main);
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
            node[i] = new Ellipse2D.Double(tmp.getX(),tmp.getY(),15,15);
            g2.drawString(tmp.getType()+","+tmp.getName(),tmp.getX(),tmp.getY());
            g2.draw(node[i]);

            if(tmp.getType().equals("V")){
                g2.setColor(Color.green);
            }
            else if(tmp.getType().equals("L")){
                g2.setColor(Color.orange);
            }
            else if(tmp.getType().equals("R")){
                g2.setColor(Color.red);
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
