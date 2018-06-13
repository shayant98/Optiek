/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.controller;

import com.mysql.jdbc.Connection;
import com.optiek.model.KlantDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shayantsital
 */
public class DeleteKlantServlet extends HttpServlet {

    public DeleteKlantServlet() {
        super();
    }
    
    @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        String code = (String) request.getParameter("code");
        String errorString = null;
 
        try {
            conn = Database.getMySQLConnection();
            
            KlantDAO.deleteKlant(conn, code);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteKlantServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            errorString = e.getMessage();
        }
 
        
 
        
         
         
        // If has an error, redirecte to the error page.
        if (errorString != null) {
            // Store the information in the request attribute, before forward to views.
            request.setAttribute("errorString", errorString);
            // 
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteKlantErrorView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.        
        else {
            response.sendRedirect(request.getContextPath() + "/Klanten");
        }}
 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
