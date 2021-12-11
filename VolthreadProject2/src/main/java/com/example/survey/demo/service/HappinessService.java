package com.example.survey.demo.service;


import com.example.survey.demo.model.Happiness;
import com.example.survey.demo.repo.HappinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class HappinessService {
    @Autowired
    private HappinessRepository happinessRepository;

    public Happiness saveHappiness(Happiness happiness){
        return happinessRepository.save(happiness);
    }
    public Happiness findById(long id){
        return happinessRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No geçersiz." +id));
    }
    public List<Happiness> findAll(){
        return happinessRepository.findAll();
    }

    public void delete(long id){
        Happiness happiness = happinessRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No geçersiz." +id));
        happinessRepository.delete(happiness);
    }
    public double calculateHappinessRate() {
        List<Happiness> happinessList = this.findAll();
        return !happinessList.isEmpty() ? happinessList.stream().
                mapToDouble(Happiness::getRate).average().getAsDouble() : 0.0;
    }
}
