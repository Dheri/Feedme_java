/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.parteek.feedme.servlets;

import in.parteek.feedme.dao.*;
import in.parteek.feedme.logic.*;

import in.parteek.feedme.logic.Result;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created on : 11-Dec-2017, 9:50:17 AM
 *
 * @author Parteek Dheri
 */
@WebServlet(name = "getLoc", urlPatterns = {"/getLoc"})
public class getLoc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String lat = request.getParameter("lat");
        String lng = request.getParameter("lng");

        Location loc = new Location(lat, lng); // will store this in DB

        HttpSession session = request.getSession(false);
        Client client = (Client) session.getAttribute("client");
        String keyword = "food";
        String radius = "1000";
        String google_key = "dummy_key"; 

        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?"
                + "location=" + lat
                + "," + lng
                + "&radius=" + radius
                + "&type=restaurant"
                + "&keyword=" + keyword
                + "&key=" + google_key;
        String message = QuerryRestaurant.readUrl(url);
        Result r = QuerryRestaurant.gsonTest(message);
        ArrayList<Restaurant> arr = new ArrayList();
        
        arr.addAll(Arrays.asList(r.results));
        Collections.shuffle(arr);
        Restaurant[] rests = new Restaurant[3];
        rests[0] = arr.get(0);
        rests[1] = arr.get(1);
        rests[2] = arr.get(2);
        

        request.setAttribute("result", r);
        request.setAttribute("rests", rests);
        DAO dao = new DAO();
        dao.storeReq(client, loc.toJson()); //store the request made by client

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
