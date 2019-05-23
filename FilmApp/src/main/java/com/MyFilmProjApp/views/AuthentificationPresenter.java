package com.MyFilmProjApp.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AuthentificationPresenter {

    @FXML
    private View primary;

    @FXML
    private Label label;

    /**
     * Initialise la présentation Authentification Mode
     */
    public void initialize() {
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Authentification");
                /*appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e ->
                        System.out.println("Search")));*/
            }
        });
    }
    /**
     * Passe à la vue Login
     */
    @FXML
    void loginButtonClick() {
        MobileApplication.getInstance().switchView("Third View");
    }

    /**
     * Passe à la vue Register
     */
    @FXML
    void registerButtonClick() {
        MobileApplication.getInstance().switchView("Fourth View");
    }
    
}
