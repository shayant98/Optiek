/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.controller;

import com.mysql.jdbc.Connection;
import com.optiek.model.History;
import com.optiek.model.HistoryDAO;
import com.optiek.model.Klant;
import com.optiek.model.KlantDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class KlantHistoryServlet extends HttpServlet {
            private HistoryDAO historydao;

    public KlantHistoryServlet() {
        super();
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Connection conn;
String code = (String) request.getParameter("code");
         String errorString = null;
        List<History> list = null;
        try {
             conn = Database.getMySQLConnection();
             
        
        list = historydao.queryKlantHistory(conn, code);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlantenServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
             e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("History", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/views/verkoop.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


 
 
}
