package com.iim.golf.model;

public class Baseballeur implements Frappeur {
    String nom;
    String club;
    String licence;
    int reflexe;
    int force;

    Baseballeur(String nom , String club , String licence ,int reflexe , int force) {
        this.nom = nom;
        this.club = club;
        this.licence = licence;
        this.reflexe = reflexe;
        this.force = force;
    }
    @Override
    public int tirer(int reflexe , int force) {
        return reflexe * force;
    }

    @Override
    public String getNom(String nom) {
        return nom;
    }
}
