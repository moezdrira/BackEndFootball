package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Entity
public class Equipe implements Serializable {
    @Id @GeneratedValue
    private int id;
    private String nom;
    private int division;
    private int nbrPoint;
    private double budget;
@OneToMany(mappedBy = "equipe",fetch = FetchType.LAZY)
private List<Joueur> joueurs;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "Equipe_Competition",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "competition_id"))
    private List<Competition> competitions;

    public Equipe() {
    }
    public Equipe(String nom,int division,double budget) {
        this.id=id;
        this.nom=nom;
        this.division=division;
        this.budget=budget;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getNbrPoint() {
        return nbrPoint;
    }

    public void setNbrPoint(int nbrPoint) {
        this.nbrPoint = nbrPoint;
    }

}
