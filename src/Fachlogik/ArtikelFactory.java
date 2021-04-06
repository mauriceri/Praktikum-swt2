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
public interface ArtikelFactory {
    
    public Artikel erzeugeElement(String typ, String[] values);
}
