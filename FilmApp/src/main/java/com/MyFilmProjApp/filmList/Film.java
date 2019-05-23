package com.MyFilmProjApp.filmList;

public class Film {

    private String title;
    private String genres;

    /**
     * Constructeur film
     * @param title Titre du film
     * @param genres genres des films, séparés par virgule
     */
    public Film(String title, String genres) {
        this.title = title;
        this.genres = genres;
    }

    /**
     * Récup titre.
     * @return titre film
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifie Titre Film
     * @param title nouveau titre du film
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Récup les genres
     * @return les genres sous forme de String
     */
    public String getGenres() {
        return genres;
    }

    /**
     * Modifie tous les genres du films
     * @param genres Nouveaux genres du film
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }


    /**
     * Récup les infos qui vont être affichés sur le film
     * @return Toutes les infos à afficher dans la liste
     */
    @Override
    public String toString() {
        return title + " G: " + genres;
    }
}

