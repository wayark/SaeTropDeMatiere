package NodePackage;

public class Edge {
    private Node linked1;
    private Node linked2;
    private int lenght;
    private String type;
    public Flag flag;

    public Edge(Node linked1, Node linked2, int length,String type) {
        this.linked1 = linked1;
        this.linked2 = linked2;
        this.lenght = length;
        this.type = type;
        flag = Flag.NONE;
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

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        return (linked1.getName()+ ", "+linked2.getName()+ " | "+type+","+lenght);
    }
}
