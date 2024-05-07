package com.fernandez.batchtest.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RESULTS")
@Data
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matchId;
    private String eventTime;
    private String homeTeam;
    private String awayTeam;
    private Integer homeScore;
    private Integer awayScore;
    private Integer homeScore1;
    private Integer homeScore2;
    private Integer homeScore3;
    private Integer homeScore4;
    private Integer homeScore5;
    private Integer awayScore1;
    private Integer awayScore2;
    private Integer awayScore3;
    private Integer awayScore4;
    private Integer awayScore5;
}

