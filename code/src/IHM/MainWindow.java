package IHM;


import NodePackage.ListCity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    
    private ListCity listCity;
    private final JFrame f;
    private final JPanel mainWindow;

    public MainWindow(ListCity listCity) throws HeadlessException {
        this.listCity = listCity;
        f = this;
        mainWindow = new MainPanel(listCity,this);
        setup();
    }

    public void setup(){
        setTitle("Graph Map Analysis");
        setSize(1500,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainWindow);
        setJMenuBar(constMenu());
        setVisible(true);
    }

    private JMenuBar constMenu(){
        JMenuBar menu = new JMenuBar();

        JMenuItem mainW = new JMenuItem("Accueil");
        JMenuItem item1 = new JMenuItem("Affichage d'un élément");
        JMenuItem item2 = new JMenuItem("Affichage des voisins");
        JMenuItem item3 = new JMenuItem("Affichage des voisins distance 2");
        JMenuItem item4 = new JMenuItem("Comparer des villes");
        JMenuItem item5 = new JMenuItem("distance entre deux sites");

        mainW.setHorizontalAlignment(SwingConstants.CENTER);
        item1.setHorizontalAlignment(SwingConstants.CENTER);
        item2.setHorizontalAlignment(SwingConstants.CENTER);
        item3.setHorizontalAlignment(SwingConstants.CENTER);
        item4.setHorizontalAlignment(SwingConstants.CENTER);
        item5.setHorizontalAlignment(SwingConstants.CENTER);

        menu.add(mainW);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);



        mainW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().add(mainWindow);
                f.revalidate();
            }
        });
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ecran0 e0 = new Ecran0();
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.getContentPane().add(new Ecran1(listCity,f));
                f.revalidate();
            }
        });

        return menu;
    }

}
