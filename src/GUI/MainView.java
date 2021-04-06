/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Fachlogik.Artikel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author maric010
 */
public class MainView {

    private final Controller controller;
    private Stage stage;


    ResourceBundle r;

    public MainView(Stage stage, ResourceBundle r) {
        this.controller = new Controller();
        this.stage = stage;
        this.r = r;
        
    }

    void showView() {

        VBox vBox = new VBox();
        MenuBar menuBar = new MenuBar();
        
        ObservableList<Artikel> ol = FXCollections.observableArrayList();

        ListView listView = new ListView(ol);
        controller.setObl(ol);

        Menu m_file = new Menu(r.getString("datei"));
        Menu m_artikel = new Menu(r.getString("artikel"));
        Menu m_kunde = new Menu(r.getString("kunde"));
        Menu m_katalog = new Menu(r.getString("katalog"));

        MenuItem laden = new MenuItem(r.getString("laden"));
        MenuItem speichern = new MenuItem(r.getString("speichern"));
        MenuItem beenden = new MenuItem(r.getString("beenden"));

        MenuItem buch_neu = new MenuItem(r.getString("buchadd"));
        MenuItem hoerbuch_neu = new MenuItem(r.getString("hoerbuchadd"));
        MenuItem buchlist_anzeigen = new MenuItem(r.getString("buchlist_anzeigen"));
        MenuItem hbuchlist_anzeigen = new MenuItem(r.getString("hbuchlist_anzeigen"));
        MenuItem artikel_loeschen = new MenuItem(r.getString("artikel_loeschen"));
        MenuItem preis_aendern = new MenuItem(r.getString("preis_aendern"));

        MenuItem katalog_anzeigen = new MenuItem(r.getString("katalog_anzeigen"));

        
        MenuItem kunde_neu = new MenuItem(r.getString("kunde_neu"));
        MenuItem kunde_anzeigen = new MenuItem(r.getString("kunde_anzeigen"));
        MenuItem kunde_loeschen = new MenuItem(r.getString("kunde_loeschen"));
        
        m_file.getItems().addAll(laden, speichern, beenden);
        m_artikel.getItems().addAll(buch_neu, hoerbuch_neu, artikel_loeschen, buchlist_anzeigen,hbuchlist_anzeigen, preis_aendern);

        m_kunde.getItems().addAll(kunde_neu, kunde_loeschen,kunde_anzeigen);
        m_katalog.getItems().add(katalog_anzeigen);

        menuBar.getMenus().addAll(m_file, m_artikel, m_kunde, m_katalog);
        vBox.getChildren().addAll(menuBar, listView);
        
        
        
        
        laden.setOnAction(e -> controller.load());
        speichern.setOnAction(e -> controller.save());
        beenden.setOnAction(e -> Platform.exit());
        
        
        buch_neu.setOnAction(e -> new BuchView(stage, controller, r).showView());
        hoerbuch_neu.setOnAction(e-> new HoerbuchView(stage, controller, r).showView());
        buchlist_anzeigen.setOnAction( e -> new BuchListView(stage, controller, r).showView());
        hbuchlist_anzeigen.setOnAction(e -> new HoerbuchListView(stage, controller, r).showView());

        preis_aendern.setOnAction(e-> new PreisChangeView(stage, controller, (Artikel) listView.getSelectionModel().getSelectedItem(), r).showView());
        
        
        kunde_neu.setOnAction(e -> new KundeAddView(stage, controller, r).showView());
        kunde_anzeigen.setOnAction(e ->new KundeListView(stage, controller, r).showView());
        kunde_loeschen.setOnAction(e -> new KundeLoeschView(stage, controller, r).showView());
        
        katalog_anzeigen.setOnAction(e -> new KatalogListView(stage, controller, r).showView());

        artikel_loeschen.setOnAction(e -> new ArtikelLoeschView(stage, controller, r).showView());



        Scene scene = new Scene(vBox, 600, 400);
        
       
        stage.setTitle(r.getString("titel_mainview"));
        stage.setScene(scene);
        stage.show();

    }
}
