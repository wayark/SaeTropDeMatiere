package NodePackage;

import java.util.ArrayList;

public class Place extends Node{
    private Neighbor head;

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
            this.head = new Neighbor(name, type, null);
            retour = this.head;
        } else {

            Node tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Neighbor(name, type, null);
            retour = (Neighbor) tmp.next;
        }
        return retour;
    }



    public int countNeighbor(){
        Neighbor tmp = this.head;
        int numberOfNeigbor = 0;
        while(tmp != null){
            numberOfNeigbor++;
            tmp = (Neighbor) tmp.next;
        }
        return numberOfNeigbor;
    }

    public Neighbor getHead() {
        return head;
    }

    public boolean containNeigbor(String name){
        boolean found = false;
        Neighbor tmp = head;

        while (tmp!=null && !found){
            if(tmp.getName().equals(name)){
                found = true;
            }
            tmp = (Neighbor) tmp.next;
        }

        return found;
    }

}
