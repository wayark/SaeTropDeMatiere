package IHM;

import NodePackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Screen1 extends JPanel{
    private ListCity listCity;
    private JFrame f;
    private JPanel graph;

    public Screen1(ListCity listCity, JFrame f) throws HeadlessException {
        this.listCity = listCity;
        this.f = f;
        setBorder(BorderFactory.createLineBorder(Color.gray));
        constrPan();
    }


    public void constrPan(){
        String[] e = {"Aucun Type","Ville","Lieu Culturel","Restaurant"};

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(Color.LIGHT_GRAY);
        left.setSize(300,0);
        left.setPreferredSize(new Dimension(300, 0));

        JLabel cityChoice = new JLabel("Choissisez le lieu dont vous voulez");
        JLabel cityChoice2 = new JLabel("connaitre les voisins de distance 1 :");
        JComboBox<String> cityCombo = new JComboBox<>(listCity.getListName());
        cityCombo.setMaximumSize(new Dimension(200, 40));

        JLabel typeChoice = new JLabel("Choissiez le type du voisin");
        JComboBox<String> typeCombo = new JComboBox<String>(e);
        typeCombo.setMaximumSize(new Dimension(200, 40));
        JButton validate1 = new JButton("Validez votre choix");

        JLabel edgeChoice = new JLabel("choisissez le lien voulu :");
        JComboBox<String> edgeCombo = new JComboBox<String>(listCity.getEdgeName());
        edgeCombo.setMaximumSize(new Dimension(270, 40));
        JButton validate2 = new JButton("Validez votre choix");


        cityChoice.setAlignmentX(CENTER_ALIGNMENT);
        cityChoice2.setAlignmentX(CENTER_ALIGNMENT);
        cityCombo.setAlignmentX(CENTER_ALIGNMENT);
        validate1.setAlignmentX(CENTER_ALIGNMENT);
        typeChoice.setAlignmentX(CENTER_ALIGNMENT);
        typeCombo.setAlignmentX(CENTER_ALIGNMENT);
        edgeChoice.setAlignmentX(CENTER_ALIGNMENT);
        edgeCombo.setAlignmentX(CENTER_ALIGNMENT);
        validate2.setAlignmentX(CENTER_ALIGNMENT);

        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(cityChoice);
        left.add(cityChoice2);
        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(cityCombo);
        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(typeChoice);
        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(typeCombo);
        left.add(Box.createRigidArea(new Dimension(100,15)));
        left.add(validate1);
        left.add(Box.createRigidArea(new Dimension(100,50)));
        left.add(edgeChoice);
        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(edgeCombo);
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
                String city = Objects.requireNonNull(cityCombo.getSelectedItem()).toString();
                String type = Objects.requireNonNull(typeCombo.getSelectedItem()).toString();
                Place cityChoosen = listCity.findByName(city);
                Neighbor tmp = cityChoosen.getHead();

                if (Objects.equals(type, "Ville")){
                    while (tmp != null){
                        if (tmp.getType().equals("V")){
                            listCity.findByName(tmp.getName()).flag = Flag.SECONDARY;
                        }
                        tmp = (Neighbor) tmp.next;
                    }
                }
                else if (Objects.equals(type, "Lieu Culturel")){
                    while (tmp != null){
                        if (tmp.getType().equals("L")){
                            listCity.findByName(tmp.getName()).flag = Flag.SECONDARY;
                        }
                        tmp = (Neighbor) tmp.next;
                    }
                }
                else if (Objects.equals(type, "Restaurant")){
                    while (tmp != null){
                        if (tmp.getType().equals("R")){
                            listCity.findByName(tmp.getName()).flag = Flag.SECONDARY;
                        }
                        tmp = (Neighbor) tmp.next;
                    }
                }
                else {
                    while (tmp != null){
                            listCity.findByName(tmp.getName()).flag = Flag.SECONDARY;
                        tmp = (Neighbor) tmp.next;
                    }
                }
                cityChoosen.flag = Flag.PRINCIPAL;


                graph.repaint();
                graph.revalidate();
            }
        });

        validate2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCity.setAllFlag(Flag.NONE);
                String edgeChoosen = Objects.requireNonNull(edgeCombo.getSelectedItem()).toString();
                for (Edge edge : listCity.getEdgeList()){
                    if (edge.toString().equals(edgeChoosen)){
                        edge.flag = Flag.PRINCIPAL;
                        edge.getLinked1().flag = Flag.SECONDARY;
                        edge.getLinked2().flag = Flag.SECONDARY;
                    }
                }
                graph.repaint();
                graph.revalidate();
            }
        });


    }
}
