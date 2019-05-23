package com.MyFilmProjApp.HTTP;

//import okhttp3.*;

import com.gluonhq.connect.GluonObservableObject;
import com.gluonhq.connect.provider.DataProvider;
import com.gluonhq.connect.provider.RestClient;

import javax.json.JsonObject;


public class HttpUtils {

    /**
     * Retourne info sur film passé en argument
     * @param movieId l'ID du film dont on veut info
     * @return String d'un json avec info du film
     */
    public String getMovieInfo(int movieId) {
        String res = "";

    /*RestClient restClient = RestClient.create()
            .host("https://postman-echo.com")
            .path("/post")
            .method("POST");*/

        /*https://api.themoviedb.org/3/movie/550?api_key=814515eee1b9efee09ad3d2338fd27b2*/
        /*Il s'agit d'une requête GET pour intérroger l'API Tmdb*/
        RestClient restClient = RestClient.create()
                .method("GET")
                .host("https://api.themoviedb.org")
                .path("/3/movie/"+movieId+"?api_key=814515eee1b9efee09ad3d2338fd27b2");

        /*Retire un objet JSON du DataProvider*/
        GluonObservableObject<JsonObject> myjson = DataProvider.retrieveObject(restClient.createObjectDataReader(JsonObject.class));
        JsonObject obj = null;
        if (myjson == null) {
            obj = myjson.get();
            System.out.println(obj);
            res = obj.toString();
        }
        return res;
    }
}
