package com.example.demo.Controller;

import com.example.demo.Model.Equipe;
import com.example.demo.Model.Joueur;
import com.example.demo.Repository.EquipeRepository;
import com.example.demo.Repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EquipeController {
    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping(value = "/foot/listEquipe")
    public List<Equipe> listEquipe(){
        return equipeRepository.findAll();
    }
    @PutMapping(value = "/foot/updateEquipe/{equipeID}")
    public Equipe updateEquipe (@PathVariable(value = "equipeID") int playerID,
                                 @RequestBody Equipe equipe){
        return equipeRepository.findById(playerID).map(rEquipe -> {
            rEquipe.setNom(equipe.getNom());
            rEquipe.setBudget(equipe.getBudget());
            rEquipe.setDivision(equipe.getDivision());

            return equipeRepository.save(rEquipe);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId "));
    }
    @PostMapping(value = "/foot/addEquipe")
    public Equipe  addEquipe ( @RequestBody Equipe equipe){
        return equipeRepository.save(equipe);
    }
    @DeleteMapping("/foot/removeEquipe/{equipeID}")
    public boolean deleteEquipe(@PathVariable (value = "equipeID") int equipeID) {
        equipeRepository.deleteById(equipeID);
        return true;
    }

    @GetMapping(value = "/foot/Classement/{x}")
    public List<Equipe> Classement(@PathVariable (value = "x") int x){
        return equipeRepository.Classement(x);
    }

}
