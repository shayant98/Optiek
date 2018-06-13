/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.controller;

import com.mysql.jdbc.Connection;
import com.optiek.model.Product;
import com.optiek.model.ProductDAO;
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
public class ProductenServlet extends HttpServlet {

    
private ProductDAO productdoa;

    
   
    
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorString = null;
        List<Product> list = null;
        try {
            Connection conn = Database.getMySQLConnection();
             
        
        list = productdoa.queryProduct((com.mysql.jdbc.Connection) conn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlantenServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
             e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("producten", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/views/producten.jsp");
        dispatcher.forward(request, response);
        
    }
    }

