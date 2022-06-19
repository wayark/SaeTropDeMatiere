import IHM.MainWindow;
import NodePackage.ListCity;
import Reader.CsvReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ListCity l = new ListCity();
        CsvReader c = new CsvReader(l);
        MainWindow mainWindow = new MainWindow(l);

    }
}
