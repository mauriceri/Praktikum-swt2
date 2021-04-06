/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Fachlogik.Buch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author maric010
 */
public class BuchView extends ModalStage {

    private Stage stage;
    private Controller controller;
    private final String typ = "BUCH";


    Locale l = new Locale("en", "GB");

    ResourceBundle r;

        
    public BuchView(Stage stage, Controller controller, ResourceBundle r) {
        super(stage);
        this.controller = controller;
        this.r = r;
        
    }

    public void showView() {

        GridPane gp = new GridPane();
        Label l1 = new Label(r.getString("artikelnummer"));
        Label l2 = new Label(r.getString("titel"));
        Label l3 = new Label(r.getString("autor"));
        Label l4 = new Label(r.getString("verlag"));
        Label l5 = new Label(r.getString("genre"));
        Label l6 = new Label(r.getString("sprache"));
        Label l7 = new Label(r.getString("art"));
        Label l8 = new Label(r.getString("preis"));
        Label l9 = new Label(r.getString("erscheinungsjahr"));
        Label l10 = new Label(r.getString("seitenanzahl"));
        

        TextField artikelnummer_tf = new TextField();
        TextField title_tf = new TextField();
        TextField autor_tf = new TextField();
        TextField verlag_tf = new TextField();
        TextField genre_tf = new TextField();
        TextField sprache_tf = new TextField();
        TextField art_tf = new TextField();
        TextField preis_tf = new TextField();
        TextField erscheinungsjahr_tf = new TextField();
        TextField seitenanzahl_tf = new TextField();

        Button b1 = new Button(r.getString("hinzufuegen"));
        Button b2 = new Button(r.getString("abbrechen"));
        
        RadioButton rb1 = new RadioButton(r.getString("zum_katalog"));
        
        gp.setAlignment(Pos.CENTER);

        //label + textfields
        gp.add(l1, 0, 0);
        gp.add( artikelnummer_tf, 1, 0, 2, 1);
        gp.add(l2, 0, 1);
        gp.add(title_tf, 1, 1, 2, 1);
        gp.add(l3, 0, 2);
        gp.add(autor_tf, 1, 2, 2, 1);
        gp.add(l4, 0, 3);
        gp.add(verlag_tf, 1, 3, 2, 1);
        gp.add(l5, 0, 4);
        gp.add(genre_tf, 1, 4, 2, 1);
        gp.add(l6, 0, 5);
        gp.add(sprache_tf, 1, 5, 2, 1);
        gp.add(l7, 0, 6);
        gp.add(art_tf, 1, 6, 2, 1);
        gp.add(l8, 0, 7);
        gp.add(preis_tf, 1, 7, 2, 1);
        gp.add(l9, 0, 8);
        gp.add(erscheinungsjahr_tf, 1, 8, 2, 1);
        gp.add(l10, 0, 9);
        gp.add(seitenanzahl_tf, 1, 9, 2, 1);

        //buttons
        HBox btnbox = new HBox();
        btnbox.getChildren().addAll(rb1, b1, b2);
        btnbox.setPadding(new Insets(10));
        btnbox.setSpacing(10.0);
        gp.add(btnbox, 2, 10);

        gp.setPadding(new Insets(10, 10, 10, 10));   //Abstand vom Rand
        gp.setHgap(5.0);
        gp.setVgap(5.0);
        Scene scene = new Scene(gp, 500, 350.0);
        
        

        b1.setOnAction(e->
        {
            String[] values = new String[11];
            values[0] = artikelnummer_tf.getText();
            values[1] = title_tf.getText();
            values[2] = autor_tf.getText();
            values[3] = verlag_tf.getText();
            values[4] = erscheinungsjahr_tf.getText();
            values[5] = sprache_tf.getText();
            values[6] = genre_tf.getText();
            values[7] = preis_tf.getText();
            values[8] = art_tf.getText();
            values[9] = seitenanzahl_tf.getText();
            values[10] = Boolean.toString(rb1.isSelected());
            
            controller.newArtikel(typ, values);
            close();
        });
        b2.setOnAction(e-> close());
        

        setScene(scene);
        setTitle(r.getString("buchhinzufuegen"));
        show();
    }

}
