import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ListCity listCity = new ListCity();
        CsvReader s = new CsvReader(listCity);

        listCity.showNeighbor("Corbas");

    }
}
