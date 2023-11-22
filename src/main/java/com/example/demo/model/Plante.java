package com.example.demo.model;

public class Plante {

    private Integer id;
    private String nom;
    private int TCH;
    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTCH() {
        return TCH;
    }

    public void setTCH(int TCH) {
        this.TCH = TCH;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", TCH=" + TCH +
                ", type='" + type + '\'' +
                '}';
    }
}
