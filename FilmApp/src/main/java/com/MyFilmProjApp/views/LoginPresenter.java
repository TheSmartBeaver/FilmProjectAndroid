package com.MyFilmProjApp.views;

import com.MyFilmProjApp.SQL.SqlUtils;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginPresenter {

    @FXML
    private View loginView;

    @FXML
    private Label label;

    @FXML
    private TextField textPseudo;

    @FXML
    private TextField textMdp;

    /**
     * Initialise la présentation Login
     */
    public void initialize() {
        loginView.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Third");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search third")));
            }
        });
    }

    /**
     * Passe à la vue des films si LogIn succès
     */
    @FXML
    void loginbuttonClick() {
        SqlUtils sql = new SqlUtils();
        if(sql.logIn(textPseudo.getText(), textMdp.getText()))
            MobileApplication.getInstance().switchView("Secondary View");
        else
            ;
    }
}
