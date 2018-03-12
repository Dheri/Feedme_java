/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.parteek.feedme.servlets;


import in.parteek.feedme.dao.DAO;
import in.parteek.feedme.logic.Client;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author ishan
 */
@WebServlet(name = "ViewClients", urlPatterns = {"/add"})
public class ViewClients extends HttpServlet {

    
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     String userName = "feedme";
     String password = "dummy_password";
     String host = "jdbc:mysql://dummy_address:3306/";
       DAO dao = new DAO(host, userName, password);
      
       ArrayList<Client> clients= dao.getClients();
     
//       Test.clientTest(clients);//
       
       HttpSession session = request.getSession();
       session.setAttribute("topClients",clients);
       request.getRequestDispatcher("view.jsp").forward(request, response);
    }

   

}
