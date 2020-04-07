package com.example.demo.Repository;

import com.example.demo.Model.Equipe;
import com.example.demo.Model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

    @Query("select c from Equipe c where  c.division=:x order by c.nbrPoint desc ")
    public List<Equipe> Classement(@Param("x") int x);


}
