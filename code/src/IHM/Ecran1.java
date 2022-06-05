package IHM;

import NodePackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Objects;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class Ecran1 extends JPanel{
    private ListCity listCity;
    JFrame f;
    JPanel graph;

    public Ecran1(ListCity listCity, JFrame f) throws HeadlessException {
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

        cityChoice.setAlignmentX(CENTER_ALIGNMENT);
        cityChoice2.setAlignmentX(CENTER_ALIGNMENT);
        cityCombo.setAlignmentX(CENTER_ALIGNMENT);
        validate1.setAlignmentX(CENTER_ALIGNMENT);
        typeChoice.setAlignmentX(CENTER_ALIGNMENT);
        typeCombo.setAlignmentX(CENTER_ALIGNMENT);

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
                String choixCity = Objects.requireNonNull(cityCombo.getSelectedItem()).toString();
                String choixType = Objects.requireNonNull(typeCombo.getSelectedItem()).toString();
                Place cityChoosen = listCity.findByName(choixCity);
                Neighbor tmp = cityChoosen.getHead();

                if (Objects.equals(choixType, "Ville")){
                    while (tmp != null){
                        if (tmp.getType().equals("V")){
                            listCity.findByName(tmp.getName()).flag = Flag.SECONDARY;
                        }
                        tmp = (Neighbor) tmp.next;
                    }
                }
                else if (Objects.equals(choixType, "Lieu Culturel")){
                    while (tmp != null){
                        if (tmp.getType().equals("L")){
                            listCity.findByName(tmp.getName()).flag = Flag.SECONDARY;
                        }
                        tmp = (Neighbor) tmp.next;
                    }
                }
                else if (Objects.equals(choixType, "Restaurant")){
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

                graph.removeAll();
                graph.repaint();
                graph = null;
                graph = new GraphDisplay(listCity,f);
                graph.repaint();
                graph.revalidate();
            }
        });
    }
}
