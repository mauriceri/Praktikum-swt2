package GUI;

import Fachlogik.Artikel;
import Fachlogik.Warenkorb;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class ArtikelLoeschView extends ModalStage {


    private Controller controller;



    ResourceBundle r;


    public ArtikelLoeschView(Stage stage, Controller controller, ResourceBundle r){
        super(stage);
        this.controller = controller;
        this.r = r;
    }




    public void showView(){
        GridPane gp = new GridPane();
        Label l1 = new Label(r.getString("artikelnr"));


        TextField artikelnummer_tf = new TextField();

        Button b1 = new Button(r.getString("artikel_loeschen"));
        Button b2 = new Button(r.getString("abbrechen"));
        gp.setAlignment(Pos.CENTER);

        //label + textfields
        gp.add(l1, 0, 0);
        gp.add( artikelnummer_tf, 1, 0, 2, 1);


        //buttons
        HBox btnbox = new HBox();
        btnbox.getChildren().addAll(b1, b2);
        btnbox.setPadding(new Insets(10));
        btnbox.setSpacing(10.0);
        gp.add(btnbox, 2, 1);

        gp.setPadding(new Insets(10, 10, 10, 10));   //Abstand vom Rand
        gp.setHgap(5.0);
        gp.setVgap(5.0);
        Scene scene = new Scene(gp, 300, 200);


        //Artikel muss gefunden werden
        
        
        b1.setOnAction(e ->{
            controller.removeArtikel(artikelnummer_tf.getText());
            close();
                });
        b2.setOnAction(e -> close());


        setScene(scene);
        setTitle(r.getString("artikel_loeschen"));
        show();

        
    }
}
