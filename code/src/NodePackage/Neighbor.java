package NodePackage;

public class Neighbor extends Node{

    private Edge edge;
    private Place from;


    public Neighbor(String name, String type, Node next, Place from) {
        super(name, type, next);
        this.from = from;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(String type, int lenght) {
        this.edge = new Edge(from,this,lenght,type);
    }
}
