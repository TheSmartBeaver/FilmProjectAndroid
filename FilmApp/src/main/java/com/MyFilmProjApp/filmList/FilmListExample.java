package com.MyFilmProjApp.filmList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilmListExample {
    /*Il s'agit d'un petit exemple de liste à afficher*/
    public static ObservableList<Film> filmList = FXCollections.observableArrayList(
            new Film("Toy Story", "Gamin"),
            new Film("Jurassic Park", "Action"),
            new Film("The Thing", "Horreur")
    );
}