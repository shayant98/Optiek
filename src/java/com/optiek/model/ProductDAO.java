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
public class ProductDAO {
    
    public static List<Product> queryProduct(Connection conn) throws SQLException {
    String sql = "Select * From products ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
         while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setBrand(rs.getString("brand"));
                product.setType(rs.getString("type"));
                product.setNaam(rs.getString("naam"));
                product.setQuantity(rs.getInt("quantity"));
                
               list.add(product);
         }
        return list;
        
        
    }
          public static List<Product> queryProductInfo(Connection conn) throws SQLException {
        String sql = "Select id,naam From products ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
         while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setNaam(rs.getString("naam"));

                
               list.add(product);
         }
        return list;
          }
     public static void insertProduct (Connection conn, Product product) throws SQLException {
        String sql = "Insert into products(brand, type,quantity,naam) values (?,?,?,?)";
 
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setString(1, product.getBrand());
        pstm.setString(2, product.getType());
        pstm.setInt(3,  product.getQuantity());
        pstm.setString(4,  product.getNaam());
        pstm.executeUpdate();
    }
    
    
}
