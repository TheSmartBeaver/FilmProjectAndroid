package com.MyFilmProjApp.views;

import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class LoginView {

    /**
     * Retourne vue
     */
    public View getView() {
        try {
            View view = FXMLLoader.load(AuthentificationView.class.getResource("loginView.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
