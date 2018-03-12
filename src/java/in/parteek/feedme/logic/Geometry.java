/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.parteek.feedme.logic;

/**
 *
 * Created on : 11-Dec-2017, 10:51:00 PM
 * @author Parteek Dheri 
 */

public class Geometry implements java.io.Serializable{
    private Location location;

    @Override
    public String toString() {
        return "Geometry{" + "location=" + location + '}';
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Geometry() {
    }

    public Location getLocation() {
        return location;
    }
    

}
