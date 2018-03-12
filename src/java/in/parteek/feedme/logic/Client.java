/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.parteek.feedme.logic;

/**
 *
 * Created on : 19-Dec-2017, 2:50:43 AM
 * @author Parteek Dheri 
 */
public class Client {
    private String name;
    private String id;
    private String source;
    private String sourceID;

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", id=" + id + ", source=" + source + ", sourceID=" + sourceID + '}';
    }

    public Client(String name, String id, String source, String sourceID) {
        this.name = name;
        this.id = id;
        this.source = source;
        this.sourceID = sourceID;
    }

    public Client() {
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

}
