/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Fachlogik.Adresse;
import Fachlogik.Artikel;
import Fachlogik.Kunde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.util.Callback;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author maric010
 */
public class KundeListView extends ModalStage {

    Controller controller;


    ResourceBundle r;

    public KundeListView(Stage stage, Controller controller, ResourceBundle r) {
        super(stage);
        this.controller = controller;
        this.r = r;
    }

    void showView() {
        TableView table = new TableView();
        table.setEditable(false);

        TableColumn kundennrCol = new TableColumn(r.getString("kundennummer"));
        TableColumn vorNameCol = new TableColumn(r.getString("vorname"));
        TableColumn nachNamerCol = new TableColumn(r.getString("name"));
        TableColumn emailCol = new TableColumn(r.getString("email"));
        TableColumn strasseCol = new TableColumn(r.getString("strasse"));
        TableColumn hausnrCol = new TableColumn(r.getString("hausnummer"));
        TableColumn plzCol = new TableColumn(r.getString("plz"));
        TableColumn ortCol = new TableColumn(r.getString("ort"));
        TableColumn landCol = new TableColumn(r.getString("land"));


        kundennrCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        vorNameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        nachNamerCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));


        //Properties vom Adressen-objekt der Kunden-Klasse
        strasseCol.setCellValueFactory(new PropertyValueFactory<>("strasse"));
        hausnrCol.setCellValueFactory(new PropertyValueFactory<>("hausnummer"));
        plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));
        ortCol.setCellValueFactory(new PropertyValueFactory<>("ort"));
        landCol.setCellValueFactory(new PropertyValueFactory<>("land"));


        table.setItems(controller.getKundenList());

        table.getColumns().addAll(kundennrCol, vorNameCol, nachNamerCol,emailCol ,strasseCol ,hausnrCol ,plzCol ,ortCol ,landCol);


        
        Scene scene = new Scene(table);
        setTitle(r.getString("kundenliste"));
        setScene(scene);
        show();

    }

}
