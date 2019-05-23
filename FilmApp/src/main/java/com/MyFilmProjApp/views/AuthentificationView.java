package com.MyFilmProjApp.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class AuthentificationView {

    /**
     * Retourne vue
     */
    public View getView() {
        try {
            View view = FXMLLoader.load(AuthentificationView.class.getResource("primary.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
