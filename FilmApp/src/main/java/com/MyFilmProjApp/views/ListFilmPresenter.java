package com.MyFilmProjApp.views;

import com.MyFilmProjApp.filmList.Film;
import com.MyFilmProjApp.filmList.FilmPref;
import com.MyFilmProjApp.filmList.FilmListExample;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
//import com.gluonhq.charm.down.Platform;
import javafx.application.Platform;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LifecycleEvent;
import com.gluonhq.charm.down.plugins.LifecycleService;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static com.MyFilmProjApp.JSON.JsonReader.readJsonFromUrl;


public class ListFilmPresenter {

    @FXML
    private View secondary;

    private CharmListView<Film, FilmPref> charmListView;
    private CharmListView<Film, FilmPref> charmListViewBis;

    /**
     * Initialise la présentation Liste de Film
     */
    public void initialize() {

        //charmListView.setHeadersFunction(String::length);
        //Utile pour ranger selon longueur et peut faire selon autre

        charmListView = new CharmListView<>(FilmListExample.filmList);
//----------------------------------------------------

        //----------------------------
        charmListView.selectedItemProperty().addListener(
                (obs, ov, nv) -> System.out.println("Selected: " + nv +" "+nv.getClass().getName()+ " "+ nv.getGenres()));
        //Crée un label destiné à recevoir du texte
        Label label = new Label();
        secondary.setTop(label);

        //------------------------------
        try {
            JSONObject json = readJsonFromUrl("https://api.themoviedb.org/3/movie/550?api_key=814515eee1b9efee09ad3d2338fd27b2");
            //System.out.println(json.toString());
            System.out.println(json.get("id"));
            label.setText(json.get("id").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Centre la liste de Film sur écran
        secondary.setCenter(charmListView);
        secondary.setShowTransitionFactory(BounceInRightTransition::new);
        
        FloatingActionButton fab = new FloatingActionButton(MaterialDesignIcon.INFO.text,
                e -> System.out.println("Info"));
        fab.showOn(secondary);
        
        secondary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Liste de Films");
                appBar.getActionItems().add(MaterialDesignIcon.FAVORITE.button(e -> 
                        System.out.println("Favorite")));
            }
        });


    }
}
