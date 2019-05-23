package com.MyFilmProjApp.JSON;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.URL;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

    public class JsonReader {
        /**
         * Lit le JSON et le renvoie en String
         * @param rd Un flux héritant de Reader qui pointe sur Stream URL
         * @return le JSON en String
         */
        private static String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        }

        /*Substitut au module HTTP...*/
        /**
         * Permet de récupérer JSON renoyé par une URL, ici notre API Tmdb
         * @param url
         * @return retourne JSON lu à URL
         */
        public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);
                return json;
            } finally {
                is.close();
            }
        }


    }

