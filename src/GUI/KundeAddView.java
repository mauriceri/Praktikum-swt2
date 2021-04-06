/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Fachlogik.Adresse;
import Fachlogik.Kunde;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author maric010
 */
public class KundeAddView extends ModalStage {

    private Controller controller;

    ResourceBundle r;

    public KundeAddView(Stage stage, Controller controller, ResourceBundle r) {

        super(stage);

        this.controller = controller;
        this.r = r;
    }


    void showView() {

        GridPane gp = new GridPane();
        //Label l1 = new Label("Kundennummer");
        Label l2 = new Label(r.getString("name"));
        Label l3 = new Label(r.getString("vorname"));
        Label l4 = new Label(r.getString("email"));
        Label l5 = new Label(r.getString("strasse"));
        Label l6 = new Label(r.getString("hausnummer"));
        Label l7 = new Label(r.getString("plz"));
        Label l8 = new Label(r.getString("ort"));
        Label l9 = new Label(r.getString("land"));


        //TextField kundennummer_tf = new TextField();
        TextField name_tf = new TextField();
        TextField vorname_tf = new TextField();
        TextField email_tf = new TextField();
        TextField strasse_tf = new TextField();
        TextField hausnummer_tf = new TextField();
        TextField plz_tf = new TextField();
        TextField ort_tf = new TextField();
        TextField land_tf = new TextField();


        Button b1 = new Button(r.getString("hinzufuegen"));
        Button b2 = new Button(r.getString("abbrechen"));
        gp.setAlignment(Pos.CENTER);

        //label + textfields
        // gp.add(l1, 0, 0);
        //gp.add(kundennummer_tf, 1, 0, 2, 1);
        gp.add(l2, 0, 1);
        gp.add(name_tf, 1, 1, 2, 1);
        gp.add(l3, 0, 2);
        gp.add(vorname_tf, 1, 2, 2, 1);
        gp.add(l4, 0, 3);
        gp.add(email_tf, 1, 3, 2, 1);
        gp.add(l5, 0, 4);
        gp.add(strasse_tf, 1, 4, 2, 1);
        gp.add(l6, 0, 5);
        gp.add(hausnummer_tf, 1, 5, 2, 1);
        gp.add(l7, 0, 6);
        gp.add(plz_tf, 1, 6, 2, 1);
        gp.add(l8, 0, 7);
        gp.add(ort_tf, 1, 7, 2, 1);
        gp.add(l9, 0, 8);
        gp.add(land_tf, 1, 8, 2, 1);


        HBox btnbox = new HBox();
        btnbox.getChildren().addAll(b1, b2);
        btnbox.setPadding(new Insets(10));
        btnbox.setSpacing(10.0);
        gp.add(btnbox, 2, 9);


        gp.setPadding(new Insets(10, 10, 10, 10));   //Abstand vom Rand
        gp.setHgap(5.0);
        gp.setVgap(5.0);
        Scene scene = new Scene(gp, 500, 350.0);


        b1.setOnAction(e -> {
            controller.newKunde(new Kunde(name_tf.getText(), vorname_tf.getText(),
                    new Adresse(strasse_tf.getText(), Integer.parseInt(hausnummer_tf.getText()), plz_tf.getText(),
                            ort_tf.getText(), land_tf.getText()),
                    email_tf.getText()));


            close();
        });

        b2.setOnAction(e -> close());

        setScene(scene);
        setTitle(r.getString("kunde_neu"));
        show();


    }

}
