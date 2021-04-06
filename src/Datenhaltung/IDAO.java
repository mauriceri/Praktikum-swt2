package Datenhaltung;


import Fachlogik.Artikel;
import Fachlogik.Kunde;

import java.util.List;


public interface IDAO<T> {

    void speicherListe(List<T> liste);

    void speicher(T object);

    List<T> laden();


}
