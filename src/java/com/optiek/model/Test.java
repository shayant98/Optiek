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
public class Test {
    private int id;
    private int customer_id;
    private double r_sterkte;
    private double r_cylinder;
    private double r_as;
    private double l_sterkte;
    private double l_cylinder;
    private double l_as;
    private String name;
    private String surname;

    public Test(){
    }
    
    public Test(int customer_id, double r_sterkte,double r_cylinder,double r_as,double l_sterkte,double l_cylinder,double l_as){
        this.customer_id = customer_id;
        this.r_sterkte = r_sterkte;
        this.r_cylinder = r_cylinder;
        this.r_as = r_as;
        this.l_sterkte = l_sterkte;
        this.l_cylinder = l_cylinder;
        this.l_as = l_as;
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

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public double getR_sterkte() {
        return r_sterkte;
    }

    public void setR_sterkte(double r_sterkte) {
        this.r_sterkte = r_sterkte;
    }

    public double getR_cylinder() {
        return r_cylinder;
    }

    public void setR_cylinder(double r_cylinder) {
        this.r_cylinder = r_cylinder;
    }

    public double getR_as() {
        return r_as;
    }

    public void setR_as(double r_as) {
        this.r_as = r_as;
    }

    public double getL_sterkte() {
        return l_sterkte;
    }

    public void setL_sterkte(double l_sterkte) {
        this.l_sterkte = l_sterkte;
    }

    public double getL_cylinder() {
        return l_cylinder;
    }

    public void setL_cylinder(double l_cylinder) {
        this.l_cylinder = l_cylinder;
    }

    public double getL_as() {
        return l_as;
    }

    public void setL_as(double l_as) {
        this.l_as = l_as;
    }


    
    
    
    
}
