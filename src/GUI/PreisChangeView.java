package GUI;

import Fachlogik.Artikel;
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

public class PreisChangeView extends ModalStage {


    private Controller controller;
    private Artikel artikel;

    private double newPreis;

    ResourceBundle r;

    public PreisChangeView(Stage stage, Controller controller, Artikel artikel, ResourceBundle r){
        super(stage);
        this.artikel = artikel;
        this.controller = controller;
        this.r = r;
    }


    public void showView(){

        GridPane gp = new GridPane();
        Label l1 = new Label(r.getString("aktuellerpreis") +" " + artikel.getPreis());


        TextField preis_tf = new TextField(String.valueOf(artikel.getPreis()));

        gp.setAlignment(Pos.CENTER);

        //label + textfields
        gp.add(l1, 0, 0);
        gp.add( preis_tf, 1, 0, 2, 1);


        //buttons


        Button b1 = new Button(r.getString("preisaendern"));
        Button b2 = new Button(r.getString("abbrechen"));

        HBox btnbox = new HBox();
        btnbox.getChildren().addAll(b1, b2);
        btnbox.setPadding(new Insets(10));
        btnbox.setSpacing(10.0);
        gp.add(btnbox, 2, 1);

        gp.setPadding(new Insets(10, 10, 10, 10));   //Abstand vom Rand
        gp.setHgap(5.0);
        gp.setVgap(5.0);


        Scene scene = new Scene(gp, 500, 250);


        b1.setOnAction(e->{
            newPreis = Double.parseDouble(preis_tf.getText());


            controller.preisChange(newPreis, artikel);

            close();
        });
        b2.setOnAction(e -> close());

        setScene(scene);
        setTitle(r.getString("preisaendern"));
        showAndWait();




    }
}
