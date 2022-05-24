package IHM;


import NodePackage.ListCity;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private ListCity listCity;

    public MainWindow(ListCity listCity) throws HeadlessException {
        this.listCity = listCity;
        setup();
    }

    public void setup(){
        setTitle("Graph Map Analysis");
        setSize(1200,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MainPanel(listCity, this));
        setVisible(true);
    }

}
