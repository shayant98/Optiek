/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.model;

/**
 *
 * @author shayantsital
 */
public class History {
    private int id;
    private int customer_id;
    private int product_id;
    private String date;
    private String name;
    private String surname;
    private String productName;
    
    public History(){
    }
    
    public History(int customer_id,int product_id, String date){
        
        this.customer_id =customer_id;
        this.product_id =product_id;
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public int getId() {
        return id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

   

      
    
    
    
    
}
