package com.example.demo.Controller;

import com.example.demo.Model.Joueur;
import com.example.demo.Model.Performance;
import com.example.demo.Model.Poste;
import com.example.demo.Repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class JoueurController {
    @Autowired
    private JoueurRepository joueurRepository;

    @GetMapping(value = "/foot/listJoueurs")
    public List<Joueur> listJoueur() {
        return joueurRepository.findAll();
    }

    @GetMapping(value = "/foot/listJoueursParNation/{x}")
    public List<Joueur> listJoueurParNation(@PathVariable(value = "x") String x) {
        return joueurRepository.ChercherParNation(x);
    }
    @GetMapping(value = "/foot/listJoueursParEquipe/{x}")
    public List<Joueur> listJoueurParEquipe(@PathVariable(value = "x") String x) {
        return joueurRepository.ChercherParEquipe(x);
    }


    @GetMapping(value = "/foot/listJoueursParEquipeEtPoste/{x}/{y}")
    public List<Joueur> listJoueurParEquipeEtJoueur(@PathVariable(value = "x") String x,
                                                    @PathVariable(value = "y") String y) {
        return joueurRepository.ChercherParEquipeEtPoste(x, y);
    }

    @GetMapping(value = "/foot/ButeurParEquipe/{x}")
    public Joueur ButeurParEquipe(@PathVariable(value = "x") String x) {
        return joueurRepository.ChercherParButeurEquipe(x);
    }

    @GetMapping(value = "/foot/ButeurParDivision/{x}")
    public List <Joueur> ButeurParDivision(@PathVariable(value = "x") int x) {
        return joueurRepository.ChercherParButeurDivision(x);
    }

    @GetMapping(value = "/foot/PerformanceByDivision/{x}/{y}")
    public List <Joueur> performanceByDivision(@PathVariable(value = "x") int x,
                                             @PathVariable(value = "y") Performance y) {
        return joueurRepository.ChercherParPerformenceParDivision(x,y);
    }

    @GetMapping(value = "/foot/PerformanceByEquipe/{x}/{y}")
    public List <Joueur> performanceByEquipe(@PathVariable(value = "x") String x,
                                             @PathVariable(value = "y") Performance y) {
        return joueurRepository.ChercherParPerformenceParEquipe(x,y);
    }


    @PutMapping(value = "/foot/updateJoueurs/{playerID}")
    public Joueur updateJoueur(@PathVariable(value = "playerID") int playerID,
                               @RequestBody Joueur joueur) {
        return joueurRepository.findById(playerID).map(rJoueur -> {
            rJoueur.setNomJoeur(joueur.getNomJoeur());
            rJoueur.setPrenom(joueur.getPrenom());
            rJoueur.setPhoto(joueur.getPhoto());
            rJoueur.setNation(joueur.getNation());
            rJoueur.setEtatPerfermance(joueur.getEtatPerfermance());
            rJoueur.setDateNaissance(joueur.getDateNaissance());
            rJoueur.setEquipe(joueur.getEquipe());
            rJoueur.setPostes(joueur.getPostes());
            return joueurRepository.save(rJoueur);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId "));
    }

    @PostMapping(value = "/foot/addJoueur")
    public Joueur addJoueur(@RequestBody Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    @DeleteMapping("/foot/removeJoueur/{playerID}")
    public boolean removeJoueur(@PathVariable(value = "playerID") int playerID) {
        joueurRepository.deleteById(playerID);
        return true;
    }
}





