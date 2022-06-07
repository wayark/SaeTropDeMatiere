package IHM;

import NodePackage.Flag;
import NodePackage.ListCity;
import NodePackage.Neighbor;
import NodePackage.Place;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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


        JLabel cityChoice1 = new JLabel("Choissisez une première ville");
        JComboBox<String> cityCombo1 = new JComboBox<>(listCity.getListName());
        cityCombo1.setMaximumSize(new Dimension(200, 40));

        JLabel cityChoice2 = new JLabel("Choissisez une seconde ville");
        JComboBox<String> cityCombo2 = new JComboBox<>(listCity.getListName());
        cityCombo2.setMaximumSize(new Dimension(200, 40));

        JLabel answer = new JLabel("Découvrez si deux lieu on une distance de deux entre elles !");

        JButton check = new JButton("Valider");
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean test = true;
                Place city;
                String city1 = cityCombo1.getSelectedItem().toString();

                if ((city = (Place) listCity.findByName(city1)) != null) {
                    Neighbor tmp = city.getHead();
                    Neighbor tmp2;
                    while (tmp != null) {
                        tmp2 = listCity.findByName(tmp.getName()).getHead();
                        while(tmp2 != null && test){
                            if(tmp2.getName().toString().equals(cityCombo2.getSelectedItem().toString()) && !city.containNeigbor(tmp2.getName())){
                                answer.setText("Les villes sont à deux de distance !");
                                test = false;
                            }
                            else{
                                answer.setText("La distance entre ces deux villes n'est pas de deux...");
                            }

                            tmp2 = (Neighbor) tmp2.next;
                        }

                        tmp = (Neighbor) tmp.next;
                    }
                }
                f.revalidate();
            }
        });

        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(cityChoice1);
        left.add(cityCombo1);
        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(cityChoice2);
        left.add(cityCombo2);
        left.add(Box.createRigidArea(new Dimension(100,20)));
        left.add(check);
        left.add(Box.createRigidArea(new Dimension(100,20)));
        left.add(answer);
        cityChoice1.setAlignmentX(CENTER_ALIGNMENT);
        cityChoice2.setAlignmentX(CENTER_ALIGNMENT);
        cityCombo1.setAlignmentX(CENTER_ALIGNMENT);
        cityCombo1.setAlignmentX(CENTER_ALIGNMENT);
        check.setAlignmentX(CENTER_ALIGNMENT);
        answer.setAlignmentX(CENTER_ALIGNMENT);
    }
}
