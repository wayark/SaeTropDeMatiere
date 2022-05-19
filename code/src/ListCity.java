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

    public int showNeighbor(String place){//show the neighbor of the place wanted in the String variable and return the sum of neigbor
        Place city;
        int numberOfNeighbor = 0;

        if((city = (Place) findByName(place))!=null){
            numberOfNeighbor = city.showNeighbor();
        }

        return numberOfNeighbor;
    }

    public int showTwoNeighbor(String place){
        Place city;
        int numberOf2neighbor = 0;

        if((city = (Place) findByName(place))!=null){
            Neighbor tmp = city.getHead();
            while (tmp != null){

                Place distance2 = findByName(tmp.getName());
                numberOf2neighbor += distance2.showNeighbor();

                tmp = (Neighbor) tmp.next;
        }
        }

        return  numberOf2neighbor;
    }

    public void showByType(String type){
        type = type.substring(0,1);
        if("VLR".contains(type)){
            Node tmp = this.head;

            while (tmp != null){
                if (tmp.getType().equals(type)){
                    System.out.println(tmp.getType()+","+tmp.getName());
                }

                tmp = tmp.next;
            }
        }
    }

    public Place findByName(String place){//find a node by inserting a string
        Node tmp = this.head;
        Place found;

        while(tmp != null && !tmp.getName().equals(place) ){//want to find node with the name of the string
            tmp = (Place) tmp.next;
        }
        //if nothing is found we will return false
        found = (Place) tmp;
        return found;
    }

    public void Compare(String cityOne, String cityTwo){
        Place city1, city2;
        int opening1,opening2;

        if ((city1 =findByName(cityOne)).getType() == "V" && (city2 =findByName(cityTwo)).getType() == "V" ){
            System.out.println(cityOne+ " distance two neigbors :");
            opening1 = showTwoNeighbor(cityOne);
            System.out.println("=================");
            System.out.println(cityTwo+ " distance two neigbors :");
            opening2 = showTwoNeighbor(cityTwo);

            System.out.println(cityOne+ " has "+opening1 + " distance two neigbors");
            System.out.println(cityTwo+ " has "+opening2 + " distance two neigbors");
        }
    }
}
