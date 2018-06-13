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
public class Product {
    private int id;
    private String type;
    private String brand;
    private int quantity;
    private String naam;
    
    public Product(){
    }
    
    public Product(String type, String brand, int quantity, String naam) {
       this.type = type;
       this.brand = brand;
       this.quantity = quantity;
       this.naam = naam;
   }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNaam() {
        return naam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    
    

 
}
