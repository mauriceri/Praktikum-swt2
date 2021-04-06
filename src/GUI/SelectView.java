/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Res.BundleSelection;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author maric010
 */
public class SelectView {

    private Stage stage;


    ResourceBundle r;




    public SelectView(Stage stage) {


        this.stage = stage;


    }

    public void showView() {


        this.r = new BundleSelection("Deutsch").getBundle();


       
        VBox box = new VBox();
        Button main = new Button(r.getString("zur_mainview"));
        Button kunde = new Button(r.getString("zur_kundeview"));

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("Deutsch", "English");
        comboBox.getSelectionModel().selectFirst();




        box.getChildren().addAll(comboBox, main, kunde);

        box.setPadding(new Insets(10, 10, 10, 10));
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10.00);


        main.setOnAction(e -> {
            r = new BundleSelection((String) comboBox.getSelectionModel().getSelectedItem()).getBundle();

            new MainView(stage, r).showView();
        });
        kunde.setOnAction(e -> {
            r = new BundleSelection((String) comboBox.getSelectionModel().getSelectedItem()).getBundle();
            new KundeView(stage, r).showView();
        });


        Scene scene = new Scene(box, 250, 150);
        stage.setScene(scene);
        stage.setTitle(r.getString("selectview_titel"));
        stage.show();


    }
}
