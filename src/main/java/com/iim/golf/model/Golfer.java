package com.iim.golf.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Golfer {

    private static int CPT = 1;

    @Id
    @JsonProperty("id")
    int id;

    @JsonProperty("nom")
    String nom;

    @JsonProperty("club")
    String club;

    @JsonProperty("handicap")
    int handicap;

    @JsonProperty("swing")
    int swing;

    @JsonProperty("force")
    int force;

    public Golfer(){}

    public Golfer(String nom, String club ,int handicap, int swing, int force){
        this.id = CPT++;
        this.nom = nom;
        this.club = club;
        this.handicap = handicap;
        this.swing = swing;
        this.force = force;
    }
}








// public void clubUtiliser(String nom, String club){
     //   System.out.println("Le club utilisé par " + nom + " est le " + club);
    //}

    //@Override
    //public int tirer(int reflexe , int force) {
      //  return reflexe * force;
    //}

    //@Override
    //public String getNom(String nom) {
      //  return nom;
  //  }
//}