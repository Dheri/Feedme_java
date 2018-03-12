/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.parteek.feedme.servlets;

import in.parteek.feedme.dao.DAO;
import in.parteek.feedme.logic.Client;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Created on : 19-Dec-2017, 2:40:29 AM
 *
 * @author Parteek Dheri
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String source = request.getParameter("source");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        DAO dao = new DAO();
        Client client = dao.getClient(source, id, name, email);
        HttpSession session = request.getSession();
        session.setAttribute("client", client);
        request.getRequestDispatcher("map.jsp").forward(request, response);
    }

}
