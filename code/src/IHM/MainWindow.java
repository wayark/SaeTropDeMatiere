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
    private final JPanel ecran1;

    public MainWindow(ListCity listCity) throws HeadlessException {
        this.listCity = listCity;
        this.listCity.GraphDrawing();
        f = this;
        mainWindow = new MainPanel(listCity,this);
        ecran1 = new Ecran1(listCity,this);

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

        JMenuItem mainI = new JMenuItem("Accueil");
        JMenu mainM = new JMenu("Accueil");
        mainM.add(mainI);

        JMenuItem item1 = new JMenuItem("Affichage d'un élément");
        JMenu menu1 = new JMenu("Affichage d'un élément");
        menu1.add(item1);

        JMenuItem item2 = new JMenuItem("Affichage des voisins");
        JMenu menu2 = new JMenu("Affichage des voisins");
        menu2.add(item2);

        JMenuItem item3 = new JMenuItem("Affichage des voisins distance 2");
        JMenu menu3 = new JMenu("Affichage des voisins distance 2");
        menu3.add(item3);

        JMenuItem item4 = new JMenuItem("Comparer des villes");
        JMenu menu4 = new JMenu("Comparer des villes");
        menu4.add(item4);

        JMenuItem item5 = new JMenuItem("distance entre deux sites");
        JMenu menu5 = new JMenu("distance entre deux sites");
        menu5.add(item5);

        mainI.setHorizontalAlignment(SwingConstants.CENTER);
        menu1.setHorizontalAlignment(SwingConstants.CENTER);
        menu2.setHorizontalAlignment(SwingConstants.CENTER);
        menu3.setHorizontalAlignment(SwingConstants.CENTER);
        menu4.setHorizontalAlignment(SwingConstants.CENTER);
        menu5.setHorizontalAlignment(SwingConstants.CENTER);

        menu.add(mainM);
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);
        menu.add(menu4);
        menu.add(menu5);



        mainI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().removeAll();
                f.repaint();
                f.getContentPane().add(mainWindow);
                f.revalidate();
            }
        });
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ecran0 e0 = new Ecran0(f);
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
