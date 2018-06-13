/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.controller;

import com.mysql.jdbc.Connection;
import com.optiek.model.Klant;
import com.optiek.model.KlantDAO;
import com.optiek.model.Test;
import com.optiek.model.TestDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
public class TestServlet extends HttpServlet {
            private TestDAO testdoa;

 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
String code = (String) request.getParameter("code");
         String errorString = null;
        List<Test> list = null;
        List<Klant> listKlant = null;
        try {
             conn = Database.getMySQLConnection();
             
        
        list = TestDAO.queryTest(conn);
        listKlant = KlantDAO.queryKlantInfo(conn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlantenServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("Tests", list);
        request.setAttribute("klantinfo", listKlant);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/views/tests.jsp");
        dispatcher.forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

  
   

}
