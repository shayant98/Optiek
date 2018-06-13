/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Shayant
 */
public class Database {

    public static Connection getMySQLConnection()
         throws ClassNotFoundException, SQLException {
     // Note: Change the connection parameters accordingly.
     String hostName = "localhost";
     String dbName = "rs_optiek";
     String userName = "root";
     String password = "root";
     return getMySQLConnection(hostName, dbName, userName, password);
 }
  
 public static Connection getMySQLConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
    
     Class.forName("com.mysql.jdbc.Driver");
  
     // URL Connection for MySQL:
     // Example: 
     // jdbc:mysql://localhost:3306/simplehr
     String connectionURL = "jdbc:mysql://" + hostName + ":8889/" + dbName;
  
     Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }

}