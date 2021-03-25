package com.example.tp3;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private String[] nom = {"Mercure", "Venus", "Terre", "Mars", "Jupiter", "Saturne", "Uranus", "Neptune", "Pluton"};
    ArrayList<Planete> planetes;
    String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000",
            "50000", "2300"};

    public Data() {
        planetes= new ArrayList<>();
       for(int i =0; i<=8;i++){
           Planete p= new Planete();
           p.setNom(nom[i]);
           p.setTaille(taillePlanetes[i]);
           planetes.add(p);

       }
    }


}
