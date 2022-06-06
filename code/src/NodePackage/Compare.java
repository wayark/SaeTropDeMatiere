package NodePackage;

import IHM.Screen3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Compare extends AbstractAction {
    private final Screen3 panel;
    private final ListCity listCity;


    public Compare(Screen3 panel, ListCity listCity) {
        this.panel = panel;
        this.listCity = listCity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String city1 = Objects.requireNonNull(panel.getCityCombo1().getSelectedItem()).toString();
        String city2 = Objects.requireNonNull(panel.getCityCombo2().getSelectedItem()).toString();

        opening(city1,city2);
        gastronomic(city1,city2);
        culturalPlaces(city1,city2);


    }





    private void opening(String cityOne, String cityTwo) {//show the opening between two city
        int opening1, opening2;


        opening1 = listCity.countTwoNeighbor(cityOne);
        opening2 = listCity.countTwoNeighbor(cityTwo);

        if (opening1 > opening2) {
            panel.getOpening().setText("<html>Ouverture<br/>"+cityOne + " : " + opening1 + " Voisins de distance 2<br/>"+cityTwo + " : " + opening2 + " Voisins de distance 2<br/><br/>"+cityOne + " est plus ouvert que " + cityTwo+"<html>");

        }
        else if (opening1 < opening2){
            panel.getOpening().setText("<html>Ouverture<br/>"+cityOne + " : " + opening1 + " Voisins de distance 2<br/>"+cityTwo + " : " + opening2 + " Voisins de distance 2<br/><br/>"+cityTwo + " est plus ouvert que " + cityOne+"<html>");

        }
        else {
            panel.getOpening().setText("<html>Ouverture<br/>"+cityOne + " : " + opening1 + " Voisins de distance 2<br/>"+cityTwo + " : " + opening2 + " Voisins de distance 2<br/><br/>"+cityTwo + " et " + cityOne+" sont également ouverts<html>");

        }

    }

    private void gastronomic(String cityOne, String cityTwo) {//show the number of restaurent between two city
        int restaurant1 = 0, restaurant2 = 0;

        restaurant1 = countNeighborByType(cityOne, "R");
        restaurant2 = countNeighborByType(cityTwo, "R");

        System.out.println(cityOne + " has "+ restaurant1 + " restaurant of distance 2");
        System.out.println(cityTwo + " a "+ restaurant2 + " restaurant of distance 2");

        if(restaurant1 > restaurant2){
            panel.getGastronomic().setText("<html>Gastronomique<br/>"+cityOne + " : " + restaurant1 + " Restaurant à distance 2<br/>"+cityTwo + " : " + restaurant2 + " Restaurant à distance 2<br/><br/>"+cityOne + " a plus de restaurant que " + cityTwo+"<html>");
        }
        else if (restaurant1 < restaurant2) {
            panel.getGastronomic().setText("<html>Gastronomique<br/>"+cityOne + " : " + restaurant1 + " Restaurant à distance 2<br/>"+cityTwo + " : " + restaurant2 + " Restaurant à distance 2<br/><br/>"+cityTwo + " a plus de restaurant que " + cityOne+"<html>");
        }
        else {
            panel.getGastronomic().setText("<html>Gastronomique<br/>"+cityOne + " : " + restaurant1 + " Restaurant à distance 2<br/>"+cityTwo + " : " + restaurant2 + " Restaurant à distance 2<br/><br/>"+cityOne + " a autant de restaurant que " + cityTwo+"<html>");
        }

    }

    private void culturalPlaces(String cityOne, String cityTwo){//show the number of cultural place between two city
        int culture1 = 0, culture2 = 0;

        culture1 = countNeighborByType(cityOne, "L");
        culture2 = countNeighborByType(cityTwo, "L");

        if(culture1 > culture2){
            panel.getCultural().setText("<html>Culturelle<br/>"+cityOne + " : " + culture1 + " Lieu culturel à distance 2<br/>"+cityTwo + " : " + culture2 + " Lieu culturel à distance 2<br/><br/>"+cityOne + " a plus de lieu culturel que " + cityTwo+"<html>");

        }
        else if (culture1 < culture2) {
            panel.getCultural().setText("<html>Culturelle<br/>"+cityOne + " : " + culture1 + " Lieu culturel à distance 2<br/>"+cityTwo + " : " + culture2 + " Lieu culturel à distance 2<br/><br/>"+cityTwo + " a plus de lieu culturel que " + cityOne+"<html>");

        }
        else {
            panel.getCultural().setText("<html>Culturelle<br/>"+cityOne + " : " + culture1 + " Lieu culturel à distance 2<br/>"+cityTwo + " : " + culture2 + " Lieu culturel à distance 2<br/><br/>"+cityOne + " a autant de lieu culturel que " + cityTwo+"<html>");
        }

    }

    private int countNeighborByType(String city, String type){//count the 2 distance place with the specified type

        int nbrOfType = 0;
        Place cityNode = (Place) listCity.findByName(city);//get the node with the same name as the string
        Neighbor neighbor = cityNode.getHead();
        while (neighbor != null) {
            Place distance2 = listCity.findByName(neighbor.getName());
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
}
