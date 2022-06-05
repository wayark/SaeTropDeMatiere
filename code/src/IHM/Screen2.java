package IHM;

import NodePackage.ListCity;

import javax.swing.*;
import java.awt.*;

public class Screen2 extends JPanel {
    private ListCity listCity;
    JFrame f;
    JPanel graph;

    public Screen2(ListCity listCity, JFrame f) throws HeadlessException {
        this.listCity = listCity;
        this.f = f;
        setBorder(BorderFactory.createLineBorder(Color.gray));
        constrPan();
    }


    public void constrPan(){

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(Color.LIGHT_GRAY);
        left.setSize(300,0);
        left.setPreferredSize(new Dimension(300, 0));


        graph = new GraphDisplay(listCity, f);
        graph.setLayout(new BoxLayout(graph, BoxLayout.Y_AXIS));
        graph.setSize(1200, 0);
        graph.setPreferredSize(new Dimension(1200, 0));

        this.setLayout(new BorderLayout());
        this.add(left, BorderLayout.WEST);
        this.add(graph, BorderLayout.CENTER);
    }
}
