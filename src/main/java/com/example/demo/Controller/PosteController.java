package com.example.demo.Controller;

import com.example.demo.Model.Equipe;
import com.example.demo.Model.Poste;
import com.example.demo.Repository.EquipeRepository;
import com.example.demo.Repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class PosteController {
    @Autowired
    private PosteRepository posteRepository;

    @GetMapping(value = "/foot/listPoste")
    public List<Poste> listPoste(){
        return posteRepository.findAll();
    }
    @PostMapping(value = "/foot/addPoste")
    public Poste  addPoste ( @RequestBody Poste poste){
        return posteRepository.save(poste);
    }
    @DeleteMapping("/foot/removePoste/{posteID}")
    public boolean deleteEquipe(@PathVariable (value = "posteID") int posteID) {
        posteRepository.deleteById(posteID);
        return true;
    }
}
