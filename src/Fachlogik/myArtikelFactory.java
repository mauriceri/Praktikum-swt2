/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachlogik;

/**
 *
 * @author maric010
 */
public class myArtikelFactory implements ArtikelFactory{
    
    /**
     * Erzeugt Buch oder Hoerbuch anhand des Parameters typ
     * @param typ Art des Artikels
     * @param values String-Array mit Werten des Artikels
     * @return Artikel von Typ Buch oder Hörbuch
     */
    
    @Override
    public Artikel erzeugeElement(String typ, String[] values) {

        Artikel a = null;
        
        if(typ.equals("BUCH")){
 
            a = new Buch(values[0], values[1], values[2], values[3], Integer.parseInt(values[4]), values[5], values[6],
                        Double.parseDouble(values[7]), values[8], Integer.parseInt(values[9]),Boolean.parseBoolean(values[10]) );
            
        }else if(typ.equals("HOERBUCH")){
            
            a = new Hoerbuch(values[0], values[1], values[2], values[3], Integer.parseInt(values[4]), values[5], values[6],
                        Double.parseDouble(values[7]), values[8], Integer.parseInt(values[9]),Boolean.parseBoolean(values[10]));
        }
        
        
        return a;
        
        
    }
    
}
