package com.MyFilmProjApp.filmList;

public class FilmPref implements Comparable<Integer>{
    /*Cette classe sert à attribuer des clés qui serviront à trier les films en toutes circonstances
    même en ayant tout mélanger. Les valeurs des clés seront les notes préditent
     */

    /*Initialisés à 0 car rang et IDs pas encore récup depuis la base...*/
    int id = 0;
    int rank = 0;

    /**
     * Set le rang du film qui sera la note attribuée par la prédiction
     * @param rank rank du film
     */
    public void setrank(int rank) {
        this.rank = rank;
    }

    /**
     *
     * @param otherFilmRank rang du film avec qui on va comparer
     * @return 0 si rang du film supérieur à celui de "o". retourne 1 sinon
     */
    @Override
    public int compareTo(Integer otherFilmRank) {
        Integer r = new Integer(rank);
        if(otherFilmRank.compareTo(r)==0)
            return 0;
        else
            return 1;
    }
}
