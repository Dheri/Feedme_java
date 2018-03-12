/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.parteek.feedme.logic;

/**
 *
 * Created on : 11-Dec-2017, 10:09:40 PM
 *
 * @author Parteek Dheri
 */
public class Restaurant implements java.io.Serializable{

    private String name;
    private String id;
    private String place_id;
    private String reference;
    private String[] types;
    private String vicinity;
    private String rating;
    private Geometry geometry;

    public Restaurant(String name, String id, String place_id, String reference, String[] types, String vicinity, String rating, Geometry geometry) {
        this.name = name;
        this.id = id;
        this.place_id = place_id;
        this.reference = reference;
        this.types = types;
        this.vicinity = vicinity;
        this.rating = rating;
        this.geometry = geometry;
    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

}
