package IHM;


import NodePackage.Flag;
import NodePackage.ListCity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private ListCity listCity;
    private final JFrame f;

    public MainWindow(ListCity listCity) throws HeadlessException {
        this.listCity = listCity;
        f = this;

        setup();
    }

    public void setup() {
        setTitle("Graph Map Analysis");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new MainPanel(listCity, this));
        setJMenuBar(constMenu());
        setVisible(true);
    }

    private JMenuBar constMenu() {

        JMenuBar menu = new JMenuBar();

        JMenuItem mainI = new JMenuItem("Accueil");
        JMenuItem item1 = new JMenuItem("Affichage d'un élément");
        JMenuItem item2 = new JMenuItem("Affichage des voisins");
        JMenuItem item3 = new JMenuItem("Affichage des voisins distance 2");
        JMenuItem item4 = new JMenuItem("Comparer des villes");
        JMenuItem item5 = new JMenuItem("distance entre deux sites");

        mainI.setHorizontalAlignment(SwingConstants.CENTER);
        item1.setHorizontalAlignment(SwingConstants.CENTER);
        item2.setHorizontalAlignment(SwingConstants.CENTER);
        item3.setHorizontalAlignment(SwingConstants.CENTER);
        item4.setHorizontalAlignment(SwingConstants.CENTER);
        item5.setHorizontalAlignment(SwingConstants.CENTER);

        menu.add(mainI);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        //menu.add(item5);


        mainI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCity.setAllFlag(Flag.NONE);
                f.getContentPane().removeAll();
                f.getContentPane().add(new MainPanel(listCity, f));
                f.revalidate();
            }
        });
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCity.setAllFlag(Flag.NONE);
                f.getContentPane().removeAll();
                f.getContentPane().add(new Screen0(listCity, f));
                f.revalidate();
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCity.setAllFlag(Flag.NONE);
                f.getContentPane().removeAll();
                f.getContentPane().add(new Screen1(listCity, f));
                f.revalidate();
            }
        });

        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCity.setAllFlag(Flag.NONE);
                f.getContentPane().removeAll();
                f.getContentPane().add(new Screen2(listCity, f));
                f.revalidate();
            }
        });

        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCity.setAllFlag(Flag.NONE);
                f.getContentPane().removeAll();
                f.getContentPane().add(new Screen3(listCity, f));
                f.revalidate();
            }
        });

        return menu;
    }

}
