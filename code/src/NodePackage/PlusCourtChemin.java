package NodePackage;

import java.util.ArrayList;

public class PlusCourtChemin {
    private Node node;
    private int distance;

    public PlusCourtChemin(Node node, int distance){
        this.node = node;
        this.distance = distance;
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
}
