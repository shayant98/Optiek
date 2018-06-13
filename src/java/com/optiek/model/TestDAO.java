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
public class TestDAO {
    public static List<Test> queryTest(Connection conn) throws SQLException {
        String sql = "Select * From tests INNER JOIN customers ON tests.customer_id = customers.id ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
  
        ResultSet rs = pstm.executeQuery();
        List<Test> list = new ArrayList<Test>();
         while (rs.next()) {
                Test test = new Test();
                test.setId(rs.getInt("id"));
                test.setCustomer_id(rs.getInt("customer_id"));
                test.setR_sterkte(rs.getDouble("r_sterkte"));
                 test.setR_cylinder(rs.getDouble("r_cylinder"));
                 test.setR_as(rs.getDouble("r_as"));
                 test.setL_sterkte(rs.getDouble("l_sterkte"));
                 test.setL_cylinder(rs.getDouble("l_cylinder"));
                 test.setL_as(rs.getDouble("l_as"));
                 test.setSurname(rs.getString("surname"));
                test.setName(rs.getString("name"));
                 

                
                
               list.add(test);
         }
        return list;
    }
    
      public static List<Test> queryKlantTest(Connection conn,String code) throws SQLException {
        String sql = "Select * From tests INNER JOIN customers ON tests.customer_id = customers.id WHERE customer_id=?";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
        List<Test> list = new ArrayList<Test>();
         while (rs.next()) {
                Test test = new Test();
                test.setId(rs.getInt("id"));
                test.setCustomer_id(rs.getInt("customer_id"));
                test.setR_sterkte(rs.getDouble("r_sterkte"));
                 test.setR_cylinder(rs.getDouble("r_cylinder"));
                 test.setR_as(rs.getDouble("r_as"));
                 test.setL_sterkte(rs.getDouble("l_sterkte"));
                 test.setL_cylinder(rs.getDouble("l_cylinder"));
                 test.setL_as(rs.getDouble("l_as"));
                 test.setSurname(rs.getString("surname"));
                test.setName(rs.getString("name"));
                 

                
                
               list.add(test);
         }
        return list;
    }
      public static void insertTest (Connection conn, Test test) throws SQLException {
        String sql = "Insert into tests(customer_id, r_sterkte,r_cylinder,r_as,l_sterkte,l_cylinder,l_as) values (?,?,?,?,?,?,?)";
 
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setInt(1, test.getCustomer_id());
        pstm.setDouble(2, test.getR_sterkte());
        pstm.setDouble(3,  test.getR_cylinder());
        pstm.setDouble(4,  test.getR_as());
        pstm.setDouble(5, test.getL_sterkte());
        pstm.setDouble(6,  test.getL_cylinder());
        pstm.setDouble(7,  test.getL_as());
        pstm.executeUpdate();
    }
    
}
