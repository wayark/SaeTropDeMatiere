package IHM;

import NodePackage.ListCity;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

public class MainWindow extends JFrame {
    private ListCity listVille;
    public MainWindow(ListCity listVille) throws HeadlessException {
        setup();
        this.listVille = listVille;
    }

    public void setup(){
        setTitle("Graph Map Analysis");
        setSize(1000,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MainPanel(listVille));
        setVisible(true);
    }

}
