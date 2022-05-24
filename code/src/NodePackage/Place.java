package NodePackage;

public class Place extends Node{
    private Neighbor head;
    private int x;
    private int y;

    public Place(String name, String type, Node next) {
        super(name, type, next);
        this.head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Neighbor addEnd(String name, String type) {
        Neighbor retour;
        if (isEmpty()) {
            this.head = new Neighbor(name, type, null,this);
            retour = this.head;
        } else {

            Node tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Neighbor(name, type, null,this);
            retour = (Neighbor) tmp.next;
        }
        return retour;
    }

    public void showEdge(){
        Neighbor tmp = this.head;
        while(tmp != null){
            System.out.println(tmp.getEdge().toString());
            tmp = (Neighbor) tmp.next;
        }

    }

    public int showNeighbor(){
        Neighbor tmp = this.head;
        int numberOfNeigbor = 0;
        while(tmp != null){
            numberOfNeigbor++;
            System.out.println(tmp.getType()+","+ tmp.getName());
            tmp = (Neighbor) tmp.next;
        }
        return numberOfNeigbor;
    }

    public Neighbor getHead() {
        return head;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
