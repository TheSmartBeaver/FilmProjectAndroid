package com.MyFilmProjApp.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class ListFilmView {

    /**
     * Retourne vue
     */
    public View getView() {
        try {
            View view = FXMLLoader.load(ListFilmView.class.getResource("secondary.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
