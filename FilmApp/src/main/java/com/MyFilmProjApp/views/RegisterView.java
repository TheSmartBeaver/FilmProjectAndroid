package com.MyFilmProjApp.views;

import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class RegisterView {

    public View getView() {
        try {
            View view = FXMLLoader.load(ListFilmView.class.getResource("registerView.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
