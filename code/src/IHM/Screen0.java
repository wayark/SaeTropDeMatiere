package IHM;

import NodePackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Screen0 extends JPanel {
    private JFrame f;
    private ListCity listCity;
    private JPanel graph;

    public Screen0(ListCity listCity, JFrame f) throws HeadlessException {
        super();
        this.f = f;
        this.listCity = listCity;
        setBorder(BorderFactory.createLineBorder(Color.gray));
        constrPan();

    }


    public void constrPan() {

        String[] e = {"Ville","Lieu Culturel","Restaurant"};
        String[] r = {"Autoroute","Nationale","Departementale"};

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(Color.LIGHT_GRAY);
        left.setSize(300,0);
        left.setPreferredSize(new Dimension(300, 0));

        JLabel typeChoice1 = new JLabel("Choisisez un type de noeud à sélectionner : ");
        JComboBox<String> placeType1 = new JComboBox<String>(e);
        placeType1.setMaximumSize(new Dimension(200, 40));
        JButton validate1 = new JButton("Validez votre choix");

        JLabel typeChoice2 = new JLabel("Choisissez un type de route à selectionner : ");
        JComboBox<String> placeType2 = new JComboBox<String>(r);
        placeType2.setMaximumSize(new Dimension(200, 40));
        JButton validate2 = new JButton("Validez votre choix");


        typeChoice1.setAlignmentX(CENTER_ALIGNMENT);
        placeType1.setAlignmentX(CENTER_ALIGNMENT);
        validate1.setAlignmentX(CENTER_ALIGNMENT);
        typeChoice2.setAlignmentX(CENTER_ALIGNMENT);
        placeType2.setAlignmentX(CENTER_ALIGNMENT);
        validate2.setAlignmentX(CENTER_ALIGNMENT);

        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(typeChoice1);
        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(placeType1);
        left.add(validate1);
        left.add(Box.createRigidArea(new Dimension(100,30)));
        left.add(typeChoice2);
        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(placeType2);
        left.add(validate2);


        graph = new GraphDisplay(listCity, f);
        graph.setLayout(new BoxLayout(graph, BoxLayout.Y_AXIS));
        graph.setSize(1200, 0);
        graph.setPreferredSize(new Dimension(1200, 0));


        this.setLayout(new BorderLayout());
        this.add(left, BorderLayout.WEST);
        this.add(graph, BorderLayout.CENTER);

        validate1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCity.setAllFlag(Flag.NONE);
                String choix = Objects.requireNonNull(placeType1.getSelectedItem()).toString();
                Place tmp = listCity.getHead();

                if (Objects.equals(choix, "Ville")){
                    while (tmp != null){
                        if (tmp.getType().equals("V")){
                            tmp.flag = Flag.PRINCIPAL;

                        }
                        tmp = (Place) tmp.next;
                    }
                }
                else if (Objects.equals(choix, "Lieu Culturel")){
                    while (tmp != null){

                        if (tmp.getType().equals("L")){
                            tmp.flag = Flag.PRINCIPAL;
                        }
                        tmp = (Place) tmp.next;
                    }
                }
                else if (Objects.equals(choix, "Restaurant")){
                    while (tmp != null){
                        if (tmp.getType().equals("R")){
                            tmp.flag = Flag.PRINCIPAL;
                            System.out.println("salut");
                        }
                        tmp = (Place) tmp.next;
                    }
                }
                graph.removeAll();
                graph.repaint();
                graph = null;
                graph = new GraphDisplay(listCity,f);
                graph.repaint();
                graph.revalidate();
            }
        });

        validate2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCity.setAllFlag(Flag.NONE);
                String choix = Objects.requireNonNull(placeType2.getSelectedItem()).toString();

                if (Objects.equals(choix, "Autoroute")){
                    for (Edge edge : listCity.getEdgeList()){
                        if (edge.getType().equals("A")){
                            edge.flag = Flag.PRINCIPAL;
                        }
                    }
                }
                else if (Objects.equals(choix, "Nationale")){
                    for (Edge edge : listCity.getEdgeList()){
                        if (edge.getType().equals("N")){
                            edge.flag = Flag.PRINCIPAL;
                        }
                    }
                }
                else if (Objects.equals(choix, "Departementale")){
                    for (Edge edge : listCity.getEdgeList()){
                        if (edge.getType().equals("D")){
                            edge.flag = Flag.PRINCIPAL;
                        }
                    }
                }
                graph.removeAll();
                graph.repaint();
                graph = new GraphDisplay(listCity,f);
                graph.repaint();
                graph.revalidate();
            }
        });


    }
}
