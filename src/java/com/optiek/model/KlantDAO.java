/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.optiek.model.Klant;
import com.optiek.controller.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
;
/**
 *
 * @author Shayant
 */
public class KlantDAO {

      public static List<Klant> queryKlant(Connection conn) throws SQLException {
        String sql = "Select * From customers ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Klant> list = new ArrayList<Klant>();
         while (rs.next()) {
                Klant klant = new Klant();
                klant.setId(rs.getInt("id"));
                klant.setName(rs.getString("name"));
                klant.setSurname(rs.getString("surname"));
                klant.setId_number(rs.getString("id_number"));
                klant.setGender(rs.getString("gender"));
                klant.setBirthday(rs.getString("birthday"));
                
               list.add(klant);
         }
        return list;
    }
      public static List<Klant> queryKlantInfo(Connection conn) throws SQLException {
        String sql = "Select id,name,surname From customers ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Klant> list = new ArrayList<Klant>();
         while (rs.next()) {
                Klant klant = new Klant();
                klant.setId(rs.getInt("id"));
                klant.setName(rs.getString("name"));
                klant.setSurname(rs.getString("surname"));

                
               list.add(klant);
         }
        return list;
    }
      public static void insertKlant(Connection conn, Klant klant) throws SQLException {
        String sql = "Insert into Customers(id_number, name,surname,birthday,gender) values (?,?,?,?,?)";
 
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setString(1, klant.getId_number());
        pstm.setString(2, klant.getName());
        pstm.setString(3,  klant.getSurname());
        pstm.setString(4,  klant.getBirthday());
        pstm.setString(5,  klant.getGender());

        pstm.executeUpdate();
    }
      
       public static void deleteKlant(Connection conn, String code) throws SQLException {
        String sql = "Delete From Customers where id= ?";
 
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        pstm.executeUpdate();
    }
     

   
}


//{
//            
//        }