package com.example.demo.Controller;

import com.example.demo.Model.Competition;
import com.example.demo.Model.Poste;
import com.example.demo.Repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class CompetitionController {

    @Autowired
    private CompetitionRepository competitionRepository;

    @GetMapping(value = "/foot/listCompetance")
    public List<Competition> listCompetition (){
        return competitionRepository.findAll();
    }
    @PostMapping(value = "/foot/addCompetiton")
    public Competition  addCompetition (@RequestBody Competition competition){
        return competitionRepository.save(competition);
    }
    @DeleteMapping("/foot/removeCompetition/{competitionID}")
    public boolean deleteCompetition (@PathVariable(value = "competitionID") int competitionID) {
        competitionRepository.deleteById(competitionID);
        return true;
    }
}
