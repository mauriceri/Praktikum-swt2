/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;


import Datenhaltung.IDAO;
import Datenhaltung.KundeDAO;

import Fachlogik.Kunde;
import junit.framework.TestCase;


import java.util.List;

/**
 *
 * @author maric010
 */
public class DBtest extends TestCase{


    IDAO idao;
    
    public DBtest(String text){
        super(text);
        idao = new KundeDAO();

    }
    




    public void testKundeLoad(){

        List<Kunde> testkundenListe;
        testkundenListe = idao.laden();


        assertTrue(testkundenListe.get(0).getName().equals("123"));

    }
}
