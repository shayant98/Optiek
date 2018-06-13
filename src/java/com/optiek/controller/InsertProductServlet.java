/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.controller;

import com.optiek.model.Product;
import com.optiek.model.ProductDAO;
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
public class InsertProductServlet extends HttpServlet {

 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        
        String type = (String) request.getParameter("Type");
        String brand = (String) request.getParameter("Brand");
        String quantity = (String) request.getParameter("Quantity");
        String naam = (String) request.getParameter("Name");
        
        int qty = Integer.parseInt(quantity);
        try {
            conn = Database.getMySQLConnection();
            
            String errorString = null;
        Product product;
        product = new Product(type,brand,qty,naam);
         if (errorString == null) {
             ProductDAO.insertProduct((com.mysql.jdbc.Connection) conn, product);
             
             if (errorString == null) {
            response.sendRedirect(request.getContextPath() + "/Producten");
            request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
        }
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertKlantServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertKlantServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    

        
        
         
          
        
 
        // Store infomation to request attribute, before forward to views.
        
       
    }

}