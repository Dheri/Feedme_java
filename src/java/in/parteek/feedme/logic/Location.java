/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.parteek.feedme.logic;

import com.google.gson.Gson;

/**
 *
 * Created on : 11-Dec-2017, 11:00:56 PM
 *
 * @author Parteek Dheri
 */
public class Location implements java.io.Serializable{

    private String lat;
    private String lng;
    private String json;

    public Location(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
       
    }

    public Location() { 
    }

    @Override
    public String toString() {
        return "Location{" + "lat=" + lat + ", lng=" + lng + '}';
    }

    public String toJson() {
        Gson gson = new Gson();
        String s = gson.toJson(this);
        s = s.replace("\"", "");

        return s;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
