package com.example.demo.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Joueur implements Serializable {
    @Id @GeneratedValue
    int id;
    private String nomJoeur;
    private String prenom;
    private String photo;
    private String nation;
    private int nbrBut;
    private Performance etatPerfermance;
    @Temporal(TemporalType.DATE)
    private Date  dateNaissance;
    @ManyToOne
    @JoinColumn(name="Id_Equipe")
    private Equipe equipe;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "Joueur_Poste",
            joinColumns = @JoinColumn(name = "Joueur_id"),
            inverseJoinColumns = @JoinColumn(name = "poste_id"))
    private List<Poste> postes;

    public Joueur() {
    }

    public Joueur(String nomJoeur, String prenom, String photo, String nation, Performance etatPerfermance, Date dateNaissance) {
    this.nomJoeur=nomJoeur;
    this.prenom=prenom;
    this.photo=photo;
    this.nation=nation;
    this.etatPerfermance=etatPerfermance;
    this.dateNaissance=dateNaissance;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNomJoeur() {
        return nomJoeur;
    }

    public void setNomJoeur(String nomJoeur) {
        this.nomJoeur = nomJoeur;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Performance getEtatPerfermance() {
        return etatPerfermance;
    }

    public void setEtatPerfermance(Performance etatPerfermance) {
        this.etatPerfermance = etatPerfermance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Poste> getPostes() {
        return postes;
    }

    public void setPostes(List<Poste> postes) {
        this.postes = postes;
    }

    public int getNbrBut() {
        return nbrBut;
    }

    public void setNbrBut(int nbrBut) {
        this.nbrBut = nbrBut;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", nomJoeur='" + nomJoeur + '\'' +
                ", prenom='" + prenom + '\'' +
                ", photo='" + photo + '\'' +
                ", nation='" + nation + '\'' +
                ", etatPerfermance=" + etatPerfermance +
                ", dateNaissance=" + dateNaissance +
                ", equipe=" + equipe +
                ", postes=" + postes +
                '}';
    }
}
