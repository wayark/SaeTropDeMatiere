package IHM;

import NodePackage.Compare;
import NodePackage.ListCity;

import javax.swing.*;
import java.awt.*;

public class Screen3 extends JPanel {

    private JFrame f;
    private ListCity listCity;
    private JPanel graph;

    private JComboBox<String> cityCombo1;
    private JComboBox<String> cityCombo2;
    private JLabel opening;
    private JLabel gastronomic;
    private JLabel cultural;
    private Screen3 panel;

    public Screen3(ListCity listCity, JFrame f) throws HeadlessException {
        super();
        this.f = f;
        this.listCity = listCity;
        this.panel = this;
        setBorder(BorderFactory.createLineBorder(Color.gray));
        constrPan();

    }

    public void constrPan(){


        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(Color.LIGHT_GRAY);
        left.setSize(300,0);
        left.setPreferredSize(new Dimension(300, 0));



        JLabel city1 = new JLabel("Choissisez une première ville");
        cityCombo1 = new JComboBox<>(listCity.getListName());
        cityCombo1.setMaximumSize(new Dimension(200, 40));

        JLabel city2 = new JLabel("Choissisez une seconde ville");
        cityCombo2 = new JComboBox<>(listCity.getListName());
        cityCombo2.setMaximumSize(new Dimension(200, 40));
        JButton check = new JButton("Comparer les deux villes");
        JLabel compare = new JLabel("Comparaison des deux villes");

        opening = new JLabel();
        gastronomic = new JLabel();
        cultural = new JLabel();

        city1.setAlignmentX(CENTER_ALIGNMENT);
        city2.setAlignmentX(CENTER_ALIGNMENT);
        cityCombo1.setAlignmentX(CENTER_ALIGNMENT);
        cityCombo1.setAlignmentX(CENTER_ALIGNMENT);
        check.setAlignmentX(CENTER_ALIGNMENT);
        compare.setAlignmentX(CENTER_ALIGNMENT);
        opening.setAlignmentX(CENTER_ALIGNMENT);
        gastronomic.setAlignmentX(CENTER_ALIGNMENT);
        cultural.setAlignmentX(CENTER_ALIGNMENT);


        graph = new GraphDisplay(listCity, f);
        graph.setLayout(new BoxLayout(graph, BoxLayout.Y_AXIS));
        graph.setSize(1200, 0);
        graph.setPreferredSize(new Dimension(1200, 0));

        this.setLayout(new BorderLayout());
        this.add(left, BorderLayout.WEST);
        this.add(graph, BorderLayout.CENTER);

        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(city1);
        left.add(cityCombo1);
        left.add(Box.createRigidArea(new Dimension(100,10)));
        left.add(city2);
        left.add(cityCombo2);
        left.add(Box.createRigidArea(new Dimension(100,20)));
        left.add(check);
        left.add(Box.createRigidArea(new Dimension(100,40)));
        left.add(compare);
        left.add(Box.createRigidArea(new Dimension(100,20)));
        left.add(opening);
        left.add(Box.createRigidArea(new Dimension(100,40)));
        left.add(gastronomic);
        left.add(Box.createRigidArea(new Dimension(100,40)));
        left.add(cultural);




        check.addActionListener(new Compare(panel,listCity));

    }




    public JComboBox<String> getCityCombo1() {
        return cityCombo1;
    }

    public JComboBox<String> getCityCombo2() {
        return cityCombo2;
    }

    public JLabel getOpening() {
        return opening;
    }

    public JLabel getGastronomic() {
        return gastronomic;
    }

    public JLabel getCultural() {
        return cultural;
    }
}
