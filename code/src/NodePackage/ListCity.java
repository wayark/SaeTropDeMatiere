package NodePackage;

import NodePackage.Neighbor;
import NodePackage.Node;
import NodePackage.Place;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

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
        Place nodeCreate;
        if (isEmpty()) {
            this.head = new Place(name, type, null);
            nodeCreate = this.head;
        } else {

            Node tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Place(name, type, null);
            nodeCreate = (Place) tmp.next;
        }
        return nodeCreate;
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
    public String[] alphabeticalSorting(){
        String[] placesSorted = new String[31];
        Node tmp = this.head;
        Node tmp2;
        String smaller = tmp.getName();
        int counter = 0;
        while (tmp != null){
            tmp2 = this.head;
            while(tmp2 != null){
                if(smaller.compareTo(tmp2.getName()) > 0) {
                    smaller = tmp2.getName();
                }
                tmp2 = tmp2.next;
            }
            placesSorted[counter] = smaller;
            counter++;
            tmp = tmp.next;
        }

        return placesSorted;
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

    public String[] getListName(){
        String[] nodeName = new String[countList()];
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            nodeName[i] = tmp.getName();
            i++;
            tmp = tmp.next;
        }

        return nodeName;
    }

    public String[] getEdgeName(){
        String[] edgeName = new String[countEdge()];
        int i = 0 ;
        for (Edge edge : edgeList){
            edgeName[i] = edge.toString();
            i++;
        }

        return edgeName;
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

    public int countNeighbor(String place) {//show the neighbor of the gived place in the String variable and return the sum of neigbors
        Place city;
        int numberOfNeighbor = 0;
        if ((city = (Place) findByName(place)) != null) {
            numberOfNeighbor = city.countNeighbor();
        }
        return numberOfNeighbor;
    }

    public int countTwoNeighbor(String place) {//show all the neighbors that are at distance 2 of the place given
        Place city;
        int numberOf2neighbor = 0;
        if ((city = (Place) findByName(place)) != null) {
            Neighbor tmp = city.getHead();
            while (tmp != null) {
                Place distance2 = findByName(tmp.getName());
                numberOf2neighbor += distance2.countNeighbor();
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
                if (edge.getLinked1() == edgeList.get(i).getLinked2() && edge.getLinked2() == edgeList.get(i).getLinked1() && !treated.contains(edgeList.get(i).getLinked2())) {
                    n.add(edgeList.get(i));
                }
            }
            treated.add(edge.getLinked1());
        }

        n.remove(edgeList.get(44));
        n.remove(edgeList.get(59));
        n.remove(edgeList.get(60));
        n.remove(edgeList.get(67));
        n.remove(edgeList.get(73));

        for (Edge e : n){
            edgeList.remove(e);
        }
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
        opening1 = countTwoNeighbor(cityOne);
        System.out.println("=================");
        System.out.println(cityTwo + " distance two neigbors :");
        opening2 = countTwoNeighbor(cityTwo);

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

        restaurent1 = countNeighborByType(cityOne, "R");
        restaurent2 = countNeighborByType(cityTwo, "R");

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

        culture1 = countNeighborByType(cityOne, "L");
        culture2 = countNeighborByType(cityTwo, "L");

        System.out.println(cityOne + " has "+ culture1 + " cultural place of distance 2");
        System.out.println(cityTwo + " has "+ culture2 + " cultural place of distance 2");

        if(culture1 > culture2){
            System.out.println(cityOne + " has more cultural place than "+ cityTwo);
        }
        else {
            System.out.println(cityTwo + " has more cultural place than "+ cityOne);
        }
        
    }

    private int countNeighborByType(String city, String type){

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



    public int countList(){
        int counter = 0;
        Place tmp = head;
        while (tmp !=null){
            counter++;
            tmp = (Place) tmp.next;
        }
        return counter;
    }

    public int countByType(String type){
        int counter = 0;
        Place tmp = head;
        while (tmp !=null){
            if (tmp.getType().equals(type)){
                counter++;
            }
            tmp = (Place) tmp.next;
        }
        return counter;
    }

    public int countEdge(){
        return edgeList.size();
    }


    public Place isClicked(int xClicked, int yClicked){
        Place tmp = head;
        Place placeClicked = null;
        boolean found =false;
        while (tmp !=null && !found){

            if((xClicked >= tmp.getX() && xClicked<= tmp.getX() +15) && (yClicked >= tmp.getY() && yClicked<= tmp.getY() +15)){
                found = true;
                placeClicked = tmp;
            }
            tmp = (Place) tmp.next;
        }

        return placeClicked;
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

    public void setAllFlag(Flag flag){
        Node tmp = head;

        for(Edge e : edgeList){
            e.flag = flag;
        }

        while (tmp != null){
            tmp.flag = flag;
            tmp = tmp.next;
        }
    }
}
