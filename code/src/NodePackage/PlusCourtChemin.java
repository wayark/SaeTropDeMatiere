package NodePackage;

import java.util.ArrayList;

public class PlusCourtChemin {
    private Node node;
    private int distance;
    private String chemin;

    public PlusCourtChemin(Node node, String chemin){
        this.node = node;
        this.distance = 10000;
        this.chemin = chemin;
    }

    public Node getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }
}
