/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shayantsital
 */
public class HistoryDAO {
    public static List<History> queryHistory(Connection conn) throws SQLException {
        String sql = "Select * From Purchases INNER JOIN customers ON Purchases.customer_id = customers.id INNER JOIN Products ON Purchases.product_id = Products.id";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        
 
        ResultSet rs = pstm.executeQuery();
        List<History> list = new ArrayList<>();
         while (rs.next()) {
                History history = new History(); 
                Klant klant = new Klant();
                history.setId(rs.getInt("id"));
                history.setSurname(rs.getString("surname"));
                history.setName(rs.getString("name"));
                history.setProductName(rs.getString("Naam"));
                history.setProduct_id(rs.getInt("product_id"));
                history.setDate(rs.getString("date"));
                
                
               list.add(history);
         }
        return list;
    }
    public static List<History> queryKlantHistory(Connection conn,String code) throws SQLException {
        String sql = "Select * From Purchases INNER JOIN customers ON Purchases.customer_id = customers.id INNER JOIN Products ON Purchases.product_id = Products.id where customer_id=? ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
        List<History> list = new ArrayList<>();
         while (rs.next()) {
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setSurname(rs.getString("surname"));
                history.setName(rs.getString("name"));
                history.setProductName(rs.getString("Naam"));
                history.setProduct_id(rs.getInt("product_id"));
                history.setDate(rs.getString("date"));
                
                
               list.add(history);
         }
        return list;
    }
    public static void insertPurchase(Connection conn, History history) throws SQLException {
        String sql = "Insert into Purchases(customer_id, product_id,date) values (?,?,?)";
 
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setInt(1, history.getCustomer_id());
        pstm.setInt(2, history.getProduct_id());
        pstm.setString(3,  history.getDate());


        pstm.executeUpdate();
    }
}
