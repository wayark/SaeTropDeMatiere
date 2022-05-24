package NodePackage;

import NodePackage.Neighbor;
import NodePackage.Node;
import NodePackage.Place;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ListCity {

    private Place head;
    private ArrayList<Edge> edgeList;

    public ListCity() {
        head = null;
        edgeList = new ArrayList<Edge>();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Place addEnd(String name, String type) {//place the node at the end of the list
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

    public int size(){
        Place tmp = this.head;
        int counter = 0;
        while (tmp !=null){
            counter++;
            tmp = (Place) tmp.next;
        }
        return  counter;
    }

    public ArrayList<Place> getList(){
        ArrayList<Place> list = new ArrayList<Place>();
        Node tmp = this.head;
        while (tmp != null){
            list.add((Place) tmp);
            tmp = tmp.next;
        }

        return list;
    }

    public void showList() {//print all the node present in the list
        Node tmp = this.head;

        while (tmp != null) {
            System.out.println(tmp.getType() + "," + tmp.getName());
            tmp = tmp.next;
        }
    }

    public void showEdge(){
        int i = 0;
        for (Edge e : edgeList){
            System.out.println(i+ ".   " + e.toString());
            i++;
        }
    }

    public int showNeighbor(String place) {//show the neighbor of the gived place in the String variable and return the sum of neigbors
        Place city;
        int numberOfNeighbor = 0;

        if ((city = (Place) findByName(place)) != null) {
            numberOfNeighbor = city.showNeighbor();
        }

        return numberOfNeighbor;
    }

    public int showTwoNeighbor(String place) {//show all the neighbors that are at distance 2 of the place given
        Place city;
        int numberOf2neighbor = 0;

        if ((city = (Place) findByName(place)) != null) {
            Neighbor tmp = city.getHead();
            while (tmp != null) {

                Place distance2 = findByName(tmp.getName());
                numberOf2neighbor += distance2.showNeighbor();

                tmp = (Neighbor) tmp.next;
            }
        }

        return numberOf2neighbor;
    }

    public void convertNeighborToPlace(){//convert all the Neigbor class in the edge list by their equivalent in Place class
        Place tmp;
        for(Edge e : edgeList){
            tmp = findByName(e.getLinked2().getName());
            e.setLinked2(tmp);
        }
    }

    public void removeDoubleEdge(){// remove edge that have doubled because of the csv reading
        ArrayList<Edge> tmp = edgeList;
        ArrayList<Edge> n = new ArrayList<Edge>();
        ArrayList<Node> treated = new ArrayList<Node>();


        for (Edge edge : tmp) {
            for (int i = 0 ; i< edgeList.size() ; i++){
                if (edge.getLinked1() == edgeList.get(i).getLinked2() && !treated.contains(edgeList.get(i).getLinked2()) && edge.getLinked2() == edgeList.get(i).getLinked1()) {
                    n.add(edgeList.get(i));
                }
            }
            treated.add(edge.getLinked1());
        }
        for (Edge e : n){
            edgeList.remove(e);
        }
        showEdge();
    }



    public void showByType(String type) {//show all the node that have the type given

        type = type.substring(0, 1);

        if ("VLR".contains(type)) {
            Node tmp = this.head;

            while (tmp != null) {
                if (tmp.getType().equals(type)) {
                    System.out.println(tmp.getType() + "," + tmp.getName());
                }
                tmp = tmp.next;
            }
        }
    }



    public Place findByName(String place) {//find a node by inserting a string
        Node tmp = this.head;
        Place found;

        while (tmp != null && !tmp.getName().equals(place)) {//want to find node with the name of the string
            tmp = (Place) tmp.next;
        }
        found = (Place) tmp;
        return found;
    }




    public void compare(String cityOne, String cityTwo, int choice) {
        Place city1, city2;

        if((city1 = findByName(cityOne)) !=null && (city2 = findByName(cityTwo)) != null && city1.getType().equals("V")&& city2.getType().equals("v")){
            switch (choice){
                case 0:
                    opening(cityOne,cityTwo);
                    break;
                case 1:
                    gastronomic(cityOne,cityTwo);
                    break;
                case 2:
                    culturalPlaces(cityOne,cityTwo);
                    break;
                default:
                    System.out.println("not a valid choice");
            }
        }

    }

    private void opening(String cityOne, String cityTwo) {//show the opening between two city
        int opening1, opening2;

        System.out.println(cityOne + " distance two neigbors :");
        opening1 = showTwoNeighbor(cityOne);
        System.out.println("=================");
        System.out.println(cityTwo + " distance two neigbors :");
        opening2 = showTwoNeighbor(cityTwo);

        System.out.println(cityOne + " has " + opening1 + " distance two neigbors");
        System.out.println(cityTwo + " has " + opening2 + " distance two neigbors");
        System.out.println("=================");
        if (opening1 > opening2) {
            System.out.println(cityOne + " is more open than " + cityTwo);
        } else {
            System.out.println(cityTwo + " is more open than " + cityOne);
        }

    }

    private void gastronomic(String cityOne, String cityTwo) {//show the number of restaurent between two city
        int restaurent1 = 0, restaurent2 = 0;

        restaurent1 = countByType(cityOne, "R");
        restaurent2 = countByType(cityTwo, "R");

        System.out.println(cityOne + " has "+ restaurent1 + " restaurant of distance 2");
        System.out.println(cityTwo + " a "+ restaurent2 + " restaurant of distance 2");

        if(restaurent1 > restaurent2){
            System.out.println(cityOne + " has more restaurant than "+ cityTwo);
        }
        else {
            System.out.println(cityTwo + " has more restaurant than "+ cityOne);
        }

    }

    private void culturalPlaces(String cityOne, String cityTwo){//show the number of cultural place between two city
        int culture1 = 0, culture2 = 0;

        culture1 = countByType(cityOne, "L");
        culture2 = countByType(cityTwo, "L");

        System.out.println(cityOne + " has "+ culture1 + " cultural place of distance 2");
        System.out.println(cityTwo + " has "+ culture2 + " cultural place of distance 2");

        if(culture1 > culture2){
            System.out.println(cityOne + " has more cultural place than "+ cityTwo);
        }
        else {
            System.out.println(cityTwo + " has more cultural place than "+ cityOne);
        }
        
    }

    private int countByType(String city, String type){

        int nbrOfType = 0;
        Place cityNode = (Place) findByName(city);//get the node with the same name as the string
        Neighbor neighbor = cityNode.getHead();
        while (neighbor != null) {
            Place distance2 = findByName(neighbor.getName());
            Neighbor tmp2 = distance2.getHead();
            while (tmp2 != null) {

                if (tmp2.getType().equals(type)){
                    nbrOfType++;
                }
                tmp2 = (Neighbor) tmp2.next;
            }
            neighbor = (Neighbor) neighbor.next;
        }
        return nbrOfType;
    }


    public boolean isClicked(int xClicked, int yClicked){
        Place tmp = head;
        boolean found =false;
        while (tmp !=null && !found){

            if((xClicked >= tmp.getX() && xClicked<= tmp.getX() +10) && (yClicked >= tmp.getY() && yClicked<= tmp.getY() +10)){
                found = true;
            }
            tmp = (Place) tmp.next;
        }
        return found;
    }

    public ArrayList<Node> findShortestPath(){
        ArrayList<Node> shortestPath = new ArrayList<Node>();

        return shortestPath;
    }

    public Place getHead(){
        return head;
    }

    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }
}
