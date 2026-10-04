package com.iim.golf.model;

import java.util.List;

public class Main {
    public static void main(String[] args){

        //Scanner username = new Scanner(System.in);
        //System.out.println("Choisir nom !");

        //int userName = username.nextInt();
        //System.out.println("Ton nom est : " + userName);


        //Golfer golfer1 = new Golfer("Gerard","fer7",90,100,100);
        //golfer1.getNom(golfer1.nom);
        //golfer1.tirer(golfer1.force,golfer1.handicap);
        //golfer1.clubUtiliser(golfer1.nom,golfer1.club);
        //System.out.println("le tir de " + golfer1.nom + " est de " + golfer1.tirer(golfer1.force,golfer1.handicap) + "m");

        //Golfer golfer2 = new Golfer("Raphael","driver",1,10,200);
        //golfer2.getNom(golfer2.nom);
        //golfer2.tirer(golfer2.force,golfer2.handicap);
        //golfer2.clubUtiliser(golfer2.nom,golfer2.club);
        //System.out.println("le tir de " + golfer2.nom + " est de " + golfer2.tirer(golfer2.force,golfer2.handicap) + "m");


        //Baseballeur baseballeur1 = new Baseballeur("Pierrick","batte","pro",100,100);
        //baseballeur1.getNom(baseballeur1.nom);
        //baseballeur1.tirer(baseballeur1.force, baseballeur1.reflexe);
        //System.out.println(baseballeur1.getNom(baseballeur1.nom));
        //System.out.println(baseballeur1.tirer(baseballeur1.force, baseballeur1.reflexe));


        Trou trou1 = new Trou(1,3,200);
        Trou trou2 = new Trou(2,4,300);
        Trou trou3 = new Trou(3,3,350);

        Terain terrain1 = new Terain("GreenFEE","Facile",100,List.of(trou1,trou2,trou3));
    }

}
