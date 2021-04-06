package Res;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleSelection {

    String sprache;
    String land;
    String selection;

    public BundleSelection(String selection){

        this.selection = selection;


    }



    //erzeugt ein Resourcebundle anhand der variable selection
    public ResourceBundle getBundle(){

        if(selection.equals("Deutsch")){
            sprache = "de";
            land = "DE";

        }else if (selection.equals("English")){
            sprache = "en";
            land = "GB";
        }

        Locale l = new Locale(sprache, land);

        ResourceBundle r = ResourceBundle.getBundle("Res/MainView", l);
        return  r;

    }


}
