package org.loose.fis.sre.models;

import org.dizitart.no2.objects.Id;

public class User {
    @Id
    private String username;
    private String password,rol,numeComplet,adresa,email,nrTel;


    public User(String username, String password, String rol, String numeComplet, String adresa, String email, String nrTel) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.numeComplet = numeComplet;
        this.adresa = adresa;
        this.email = email;
        this.nrTel = nrTel;
    }

    public User(){

    }

    public String getAdresa() {
        return adresa;
    }

    public String getEmail() {
        return email;
    }

    public String getNrTel() {
        return nrTel;
    }

    public String getNumeComplet() {
        return numeComplet;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public void setNumeComplet(String numeComplet) {
        this.numeComplet = numeComplet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
