package com.example.survey.demo.repo;

import com.example.survey.demo.model.Happiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HappinessRepository extends JpaRepository<Happiness,Long> {
}
