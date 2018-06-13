/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.controller;

import com.optiek.model.Test;
import com.optiek.model.TestDAO;
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
public class InsertTestServlet extends HttpServlet {

 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        
        String str_customer_id = (String) request.getParameter("klant");
        String str_r_sterkte = (String) request.getParameter("rsterkte");
        String str_r_cylinder = (String) request.getParameter("rcylinder");
        String str_r_as = (String) request.getParameter("ras");
        String str_l_sterkte = (String) request.getParameter("lsterkte");
        String str_l_cylinder = (String) request.getParameter("lcylinder");
        String str_l_as = (String) request.getParameter("las");
        
        
        int customer_id = Integer.parseInt(str_customer_id);
        double r_sterkte = Double.parseDouble(str_r_sterkte);
        double r_cylinder = Double.parseDouble(str_r_cylinder);
        double r_as = Double.parseDouble(str_r_as);
        double l_sterkte = Double.parseDouble(str_l_sterkte);
        double l_cylinder = Double.parseDouble(str_l_cylinder);
        double l_as = Double.parseDouble(str_l_as);
       

        try {
            conn = Database.getMySQLConnection();
            
            String errorString = null;
        Test test;
        test = new Test( customer_id,  r_sterkte, r_cylinder, r_as, l_sterkte, l_cylinder, l_as);
         if (errorString == null) {
             TestDAO.insertTest((com.mysql.jdbc.Connection) conn, test);
             
             if (errorString == null) {
            response.sendRedirect(request.getContextPath() + "/Tests");
            request.setAttribute("errorString", errorString);
        request.setAttribute("test", test);
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