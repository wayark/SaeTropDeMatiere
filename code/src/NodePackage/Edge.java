package NodePackage;

public class Edge {
    Node linked1;
    Node linked2;
    int lenght;
    String type;

    public Edge(Node linked1, Node linked2, int length,String type) {
        this.linked1 = linked1;
        this.linked2 = linked2;
        this.lenght = length;
        this.type = type;
    }

    public Node getLinked1() {
        return linked1;
    }

    public Node getLinked2() {
        return linked2;
    }

    public void setLinked1(Node linked1) {
        this.linked1 = linked1;
    }

    public void setLinked2(Node linked2) {
        this.linked2 = linked2;
    }

    public String toString(){
        return ("From: "+linked1.getName()+ " To: "+linked2.getName()+ " | "+type+","+lenght);
    }
}
