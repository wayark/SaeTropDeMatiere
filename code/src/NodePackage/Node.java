package NodePackage;
public class Node {
    private String name;
    private String type;
    public Node next;
    private int x,y;

    public Node(String name, String type,Node next) {
        this.type = type;
        this.name = name;
        this.next = next;
    }

    public boolean isEmpty(){
        return false;
    }

    public Node addEnd(String name, String type){
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
