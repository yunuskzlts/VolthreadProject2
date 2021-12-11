package com.example.survey.demo.service;


import com.example.survey.demo.model.Football;
import com.example.survey.demo.repo.FootballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballService {
    @Autowired
    private FootballRepository footballRepository;

    public Football saveFootball(Football football){
        return footballRepository.save(football);
    }

    public Football findById(long id){
        return footballRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No Geçersiz.."));
    }

    public List<Football> findAll(){
        return footballRepository.findAll();
    }

    public void delete(long id){
        Football football= footballRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No geçersiz."));
        footballRepository.delete(football);
    }
}
