/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.controller;

import com.optiek.model.History;
import com.optiek.model.HistoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shayantsital
 */
public class InsertPurchaseServlet extends HttpServlet {

 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        
        String strcustomer_id = (String) request.getParameter("klant");
        String strproduct_id = (String) request.getParameter("product");
        String date = (String) request.getParameter("date");
        String birthday = (String) request.getParameter("birthday");
        String gender = (String) request.getParameter("gender");
        
        int customer_id = Integer.parseInt(strcustomer_id);
        int product_id = Integer.parseInt(strproduct_id);
        
        try {
            conn = Database.getMySQLConnection();
            
            String errorString = null;
        History history;
        history = new History(customer_id,product_id,date);
         if (errorString == null) {
             HistoryDAO.insertPurchase((com.mysql.jdbc.Connection) conn, history);
             
             if (errorString == null) {
            response.sendRedirect(request.getContextPath() + "/History");
            request.setAttribute("errorString", errorString);
        request.setAttribute("klant", history);
        }
        }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InsertKlantServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    

        
        
         
          
        
 
        // Store infomation to request attribute, before forward to views.
        
       
    }

}