package com.example.demo.Repository;

import com.example.demo.Model.Performance;
import com.example.demo.Model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
@RestController
public interface PosteRepository extends JpaRepository<Poste,Integer> {
}
