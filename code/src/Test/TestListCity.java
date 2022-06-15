package Test;


import NodePackage.ListCity;
import NodePackage.Neighbor;
import NodePackage.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestListCity {

    ListCity l;
    Place p;


    @BeforeEach
    void setup(){
        l = new ListCity();
        p = null;
    }

    @Test
    void testAddEnd(){
        l.addEnd("Lyon","V");
        int resultat = l.size();
        assertEquals(resultat,1);

    }

    @Test
    void testFindByName(){
        p = l.addEnd("Lyon","V");
        Place resultat = l.findByName("Lyon");
        assertEquals(resultat,p);
    }

    @Test
    void testCountByType(){
        l.addEnd("Lyon","V");
        int resultat = l.countByType("V");
        assertEquals(resultat,1);
    }
}
