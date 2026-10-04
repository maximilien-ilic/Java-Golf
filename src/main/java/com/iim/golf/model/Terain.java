package com.iim.golf.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Terain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    int id;

    @JsonProperty("nom")
    String nom;

    @JsonProperty("dificulter")
    String dificulter;

    @JsonProperty("handicapNeccessaire")
    int handicapNeccessaire;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "terain_id")
    @JsonProperty("trous")
    List<Trou> trous = new ArrayList<>();

    public Terain() {}

    public Terain(String nom , String dificulter ,int handicapNeccessaire,List<Trou> trous ) {
        this.nom = nom;
        this.dificulter = dificulter;
        this.handicapNeccessaire = handicapNeccessaire;
        this.trous = trous;
    }

    public boolean handiMin(int handicap){
        return handicapNeccessaire >= handicap;
    }

    public int parTotal(){
        int total = 0;
        for (Trou trou : trous) total += trou.par;
        return total;
    }
}
