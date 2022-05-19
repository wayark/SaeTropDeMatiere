import NodePackage.Neighbor;
import NodePackage.Node;
import NodePackage.Place;

public class ListCity {
    Place head;

    public ListCity(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Place addEnd(String name, String type){
        Place retour;
        if (isEmpty()) {
            this.head = new Place(name, type, null);
            retour = this.head;
        } else {

            Node tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Place(name, type, null);
            retour = (Place) tmp.next;
        }
        return retour;
    }

    public void showList(){
        Node tmp = this.head;

        while (tmp != null){
            System.out.println(tmp.getType()+","+tmp.getName());
            tmp = tmp.next;
        }
    }

    public boolean showNeighbor(String place){//show the neighbor of the place wanted in the String variable
        boolean found = true;
        Place city;

        if((city = (Place) findNode(place))==null){//if nothing is found we will return false
            found = false;
        }
        else {
            city.showNeighbor();
        }

        return found;
    }

    public Node findNode(String place){//find a node by inserting a string
        Place tmp = this.head;
        Place found;

        while(tmp != null && !tmp.getName().equals(place) ){//want to find node with the name of the string
            tmp = (Place) tmp.next;
        }
        if(tmp == null){//if nothing is found we will return false
            found = null;
        }
        else {
            found = tmp;
        }
        return found;
    }
}
