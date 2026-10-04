package com.iim.golf.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trou {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    int id;

    @JsonProperty("numero")
    int numero;

    @JsonProperty("par")
    int par;

    @JsonProperty("distance")
    int distance;

    public Trou() {}

    public Trou(int numero , int par ,int distance) {
        this.numero = numero;
        this.par = par;
        this.distance = distance;

    }

    public int[] importTrou(){
        return new int[]{numero, par, distance};

    }
}
