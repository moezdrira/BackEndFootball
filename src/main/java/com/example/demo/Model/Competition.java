package com.example.demo.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Competition implements Serializable {
    @Id
    @GeneratedValue
    int id;
    String nomCompetition;
    String vainqueur;
    String saison;


    public Competition() {
    }

    public Competition(String nomCompetition, String vainqueur, String saison) {
        this.nomCompetition=nomCompetition;
        this.vainqueur=vainqueur;
        this.saison=saison;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCompetition() {
        return nomCompetition;
    }

    public void setNomCompetition(String nomCompetition) {
        this.nomCompetition = nomCompetition;
    }

    public String getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(String vainqueur) {
        this.vainqueur = vainqueur;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

}
