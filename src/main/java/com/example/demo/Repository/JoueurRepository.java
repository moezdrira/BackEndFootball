package com.example.demo.Repository;

import com.example.demo.Model.Joueur;
import com.example.demo.Model.Performance;
import com.example.demo.Model.Poste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface JoueurRepository extends JpaRepository<Joueur,Integer> {

    @Query("select c from Joueur c  where c.nation like :x")
    public List<Joueur> ChercherParNation(@Param("x") String x);

    @Query("select j from Joueur j inner join j.equipe  where j.equipe.nom =:x")
    public List<Joueur> ChercherParEquipe(@Param("x") String x);

    @Query("select j from Joueur j,Poste p inner join j.equipe inner join j.postes where p.poste =:y and j.equipe.nom =:x")
    public List<Joueur> ChercherParEquipeEtPoste(@Param("x") String x ,@Param("y") String y);

    @Query("select j from Joueur j inner join j.equipe   where j.equipe.nom =:x and j.nbrBut = (select max(k.nbrBut)  from Joueur k  where k.equipe.nom =:x)")
    public Joueur ChercherParButeurEquipe(@Param("x") String x);

    @Query("select j from Joueur j inner join j.equipe   where j.equipe.division =:x  and j.nbrBut = (select max(k.nbrBut)  from Joueur k  where k.equipe.division =:x and j.equipe.nom like k.equipe.nom ) order by j.nbrBut desc")
    public List <Joueur> ChercherParButeurDivision(@Param("x") int x);

    @Query("select j from Joueur j inner join j.equipe   where j.equipe.nom =:x  and j.etatPerfermance=:y")
    public List <Joueur> ChercherParPerformenceParEquipe(@Param("x") String x ,@Param("y") Performance y);

    @Query("select j from Joueur j inner join j.equipe   where j.equipe.division =:x  and j.etatPerfermance=:y")
    public List <Joueur> ChercherParPerformenceParDivision(@Param("x") int x ,@Param("y") Performance y);



}
