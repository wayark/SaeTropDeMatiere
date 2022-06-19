package IHM;



import java.io.IOException;
import NodePackage.ListCity;
import Reader.CsvReader;

import javax.swing.*;

public class TestInterface {
    public static void main(String[] args) throws IOException {

        ListCity l = new ListCity();
        CsvReader c = new CsvReader(l);
        JFrame frame = new JFrame();
        frame.setSize(1500,800);
        //Screen0 s = new Screen0(l,frame);
        //Screen1 s = new Screen1(l,frame);
        //Screen2 s = new Screen2(l,frame);
        Screen3 s = new Screen3(l,frame);
        frame.setContentPane(s);
        frame.setVisible(true);
    }
}
