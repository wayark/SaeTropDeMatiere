import NodePackage.ListCity;
import Reader.CsvReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ListCity l = new ListCity();
        CsvReader c = new CsvReader(l);

      /*  //Recherche selon nom
       listCity.findByName("Lyon");


        //Afficher tout les lieux
        listCity.showByType("V");
        System.out.println("------------");

        //Lister tout les lieux
        listCity.showList();
        System.out.println("------------");

        //affichage sommet voisin
        listCity.showNeighbor("Lyon");
        System.out.println("------------");

        //affichage sommet voisin distance 2
        listCity.showTwoNeighbor("Lyon");
        System.out.println("------------");*/

    }
}
