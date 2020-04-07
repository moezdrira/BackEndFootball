package com.example.demo;

import com.example.demo.Model.*;
import com.example.demo.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
@Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Equipe.class);
        repositoryRestConfiguration.exposeIdsFor(Joueur.class);
        repositoryRestConfiguration.exposeIdsFor(Poste.class);
        repositoryRestConfiguration.exposeIdsFor(Competition.class);
/*
        equipeRepository.save(new Equipe("real","3",2000));
*/
    }
}
