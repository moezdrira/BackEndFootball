package com.example.demo.Repository;

import com.example.demo.Model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


@RestController
public interface CompetitionRepository extends JpaRepository<Competition,Integer> {
}
