/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optiek.model;

/**
 *
 * @author Shayant
 */


import com.optiek.controller.Database;
public class Klant {
    private int id;
    private String id_number;
    private String name;
    private String surname;
    private String birthday;
    private String gender;

      public Klant() {
 
   }
 
   public Klant(String id_number, String name, String surname, String birthday, String gender) {
       this.id_number = id_number;
       this.name = name;
       this.surname = surname;
       this.birthday = birthday;
       this.gender = gender;
   }

   

    public int getId() {
        return id;
    }

    public String getId_number() {
        return id_number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
