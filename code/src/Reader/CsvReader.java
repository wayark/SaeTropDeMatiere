package Reader;

import NodePackage.*;

import java.io.BufferedReader;
import java.io.IOException;

public class CsvReader {
    ListCity listeVille;
    public CsvReader(ListCity listeVille) throws IOException {
        this.listeVille = listeVille;
        listCreation();
    }




    private void listCreation() throws IOException {
        BufferedReader br = new BufferedReader(new java.io.FileReader("src\\Graph.csv"));
        String line = "";

        while ((line = br.readLine())!= null){  //read each line of the csv doc

            String[] firstTreatment = line.split(":",2);//seperate the line in two: the city and all his neighbors
            String[] city = firstTreatment[0].split(",");

            Place currentPlace = (Place) listeVille.addEnd(city[1],city[0]);//create the city node and keep it to add the neighbors later

            String[] secondTreatment = firstTreatment[1].split(";",0);//seperate all the neighbors

            for(String neigborLink : secondTreatment){


                String[] ThirdTreatment = neigborLink.split("::");//seperate edge and neighbor

                String[] neighbor = ThirdTreatment[1].split(",");
                String[] link = ThirdTreatment[0].split(",");


                Neighbor currentNeighbor =(Neighbor) currentPlace.addEnd(neighbor[1],neighbor[0]);
                listeVille.getEdgeList().add(new Edge(currentPlace,currentNeighbor,Integer.parseInt(link[1]),link[0]));
            }

        }
        listeVille.convertNeighborToPlace();
        listeVille.removeDoubleEdge();
    }
    
}
