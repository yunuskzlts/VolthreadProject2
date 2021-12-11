package com.example.survey.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Football extends Survey {

    @Column(name = "football_team")
    private String footballTeam;

}
