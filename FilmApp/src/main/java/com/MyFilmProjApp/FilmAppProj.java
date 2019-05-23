package com.MyFilmProjApp;

import com.MyFilmProjApp.views.AuthentificationView;
import com.MyFilmProjApp.views.ListFilmView;
import com.MyFilmProjApp.views.LoginView;
import com.MyFilmProjApp.views.RegisterView;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FilmAppProj extends MobileApplication {

    public static final String PRIMARY_VIEW = HOME_VIEW;
    public static final String SECONDARY_VIEW = "Secondary View";
    public static final String THIRD_VIEW = "Third View";
    public static final String FOURTH_VIEW = "Fourth View";
    
    @Override
    public void init() {
        addViewFactory(PRIMARY_VIEW, () -> new AuthentificationView().getView());
        addViewFactory(SECONDARY_VIEW, () -> new ListFilmView().getView());
        addViewFactory(THIRD_VIEW, () -> new LoginView().getView());
        addViewFactory(FOURTH_VIEW, () -> new RegisterView().getView());
        /*Ne pas oublier import pour modif les vues !!!*/


        DrawerManager.buildDrawer(this);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(FilmAppProj.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(FilmAppProj.class.getResourceAsStream("/icon.png")));
    }
}
