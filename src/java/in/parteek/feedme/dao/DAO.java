/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.parteek.feedme.dao;

import in.parteek.feedme.logic.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * Created on : 19-Dec-2017, 2:49:56 AM
 *
 * @author Parteek Dheri
 */
public class DAO {

    /*
    Important info
    database is on a remote server
     */
    public String userName = "feedme";
    public String password = "dummy_password";
    public String host = "jdbc:mysql://dummy_Address.com:3306/"; // 
    String database = "feedme";

    public DAO(String host, String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.host = host;
    }

    public DAO() {

    }

    /**
     *
     * @param source
     * @param id
     * @param name
     * @param email
     * @return
     */
    public Client addClient(String source, String id, String name, String email) {
        Client client = new Client();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection(host + database, userName, password);

            // inserting to primary user tablea nd secondary usre table
            String tb1 = "user";
            String add = "INSERT INTO " + tb1 + " (name, source, source_id)  VALUES "
                    + "('" + name
                    + "' , '" + source
                    + "' , '" + id
                    + "');";
            System.out.println("l 62 DOA");
            System.out.println(add);

            String tb2 = source + "_user";
            String add2 = "INSERT INTO " + tb2 + " VALUES "
                    + "('" + id
                    + "', " + "(SELECT user_id from user where source ='" + source + "' and source_id ='" + id
                    + "') , '" + email
                    + "');";
            System.out.println("l 70 DOA");
            System.out.println(add2);

            Statement st = con.createStatement();

            try {
                st.executeUpdate(add);
                st.executeUpdate(add2);

                String Query = "select  * from user where "
                        + "source = '" + source + "' and  "
                        + "source_id = '" + id + "' ;";
                ResultSet rs = st.executeQuery(Query);

                rs.first();
                client.setId(rs.getString(1));
                client.setName(rs.getString(2));
                client.setSource(rs.getString(3));
                client.setSourceID(rs.getString(4));

                System.out.println("new user added to DB */*-*//-*/*/-*/-*/-/-*/*-/*-/*-/-*/--*/*-/*-*/-/*/*-*/--");

            } catch (Exception e) {
                System.out.println(e);
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return client;
    }

    //-------------------------//-/-/-/-/**-*-*/*/-*/-*/-*/-*/-*/-*/-*/-*/-*/-*/-*/-*/-*/-
    public boolean storeReq(Client client, String loc) {
        String id = client.getId();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection(host + database, userName, password);

            String tb1 = "request";
            String add = "INSERT INTO " + tb1 + " (user_id, loc)  VALUES "
                    + "('" + id
                    + "' , '" + loc
                    + "');";

            System.out.println(add);

            Statement st = con.createStatement();

            try {
                st.executeUpdate(add);

            } catch (Exception e) {
                System.out.println(e);
            }

            con.close();
            return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /*----------------------------------------------------------------------*-*-*/
    
    public ArrayList<Client> getClients() {
        ArrayList<Client> clients = new ArrayList();
        try {
            //create a connection to our jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            //create a connection to the sql server
            Connection con = DriverManager.getConnection(host + database, userName, password);;

            Statement st = con.createStatement();
            String Query = "select u.name, count(r.user_id) from  request r join user u on u.user_id=r.user_id group by r.user_id order by 2 desc;"; //mysql statement

            ResultSet rs = st.executeQuery(Query);
            //st.executeUpdate(Query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();

            while (rs.next()) {
                Client c = new Client();
                c.setName(rs.getString(1));
                c.setId(rs.getString(2));
               // c.setSource(rs.getString(3));
               // c.setSourceID(rs.getString(4));
                clients.add(c);

            }
 // may be because of return 
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }

        return clients;
    }

    /**
     *
     *
     * @param source
     * @param id
     * @param name
     * @param email
     * @return
     */
    public Client getClient(String source, String id, String name, String email) {

        Client client = new Client();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection(host + database, userName, password);
            Statement st = con.createStatement();
            String Query = "select  * from user where "
                    + "source = '" + source + "' and  "
                    + "source_id = '" + id + "' ;";
            ResultSet rs = st.executeQuery(Query);
            rs.last();
            int length = rs.getRow();

            if (length < 1) { // user is not in the db
                System.out.println(" line 162 DAO, s:" + source + " id: " + id + " naem: " + name + " mail: " + email);
                client = addClient(source, id, name, email);

            } else { //user is in the db and we get him
                rs.first();
                client.setId(rs.getString(1));
                client.setName(rs.getString(2));
                client.setSource(rs.getString(3));
                client.setSourceID(rs.getString(4));

                System.out.println("old user retrived from DB */*-*//-*/*/-*/-*/-/-*/*-/*-/*-/-*/--*/*-/*-*/-/*/*-*/--");
                System.out.println(" client retrived: DOA L 173 " + client.toString());

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(client.toString());
        return client;
    }

    public void startSession(String source, String id, String name, String email) {

    }
}
