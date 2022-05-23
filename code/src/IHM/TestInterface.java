package IHM;

import NodePackage.ListCity;
import Reader.CsvReader;

import java.io.IOException;

public class TestInterface {
    public static void main(String[] args) throws IOException {
        ListCity listCity = new ListCity();
        CsvReader s = new CsvReader(listCity);
        MainWindow mainWindow = new MainWindow(listCity);
        Ecran0 ecran = new Ecran0();
    }
}
