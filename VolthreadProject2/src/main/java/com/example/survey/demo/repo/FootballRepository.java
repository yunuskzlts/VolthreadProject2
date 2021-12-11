package com.example.survey.demo.repo;

import com.example.survey.demo.model.Football;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballRepository extends JpaRepository <Football,Long>{


}
