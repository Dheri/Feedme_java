/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.parteek.feedme.logic;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * Created on : 11-Dec-2017, 9:52:21 AM
 *
 * @author Parteek Dheri
 */
public class QuerryRestaurant {

    public static void main(String[] args) {
        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?"
                + "location=43.7169803,-79.7063207"
                + "&radius=1000"
                + "&type=restaurant"
                + "&keyword=indian"
                + "&key=dummy_key";
        String message = readUrl(url);
        Result r = gsonTest(message);
    }

    public static String readUrl(String urllink) {
        try {
            // identify the url
            URL url = new URL(urllink);

            //read in our url
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            String message = org.apache.commons.io.IOUtils.toString(br);
            return message;
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static Result gsonTest(String message) {
        Gson gson = new Gson();
        Result r = gson.fromJson(message, Result.class);

        return r;

    }

}
