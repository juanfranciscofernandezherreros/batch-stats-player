package com.fernandez.batchfixtures.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "FIXTURES")
@Data
public class Fixtures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matchId;
    private String eventTime;
    private String homeTeam;
    private String awayTeam;
    private String dateFile;
    private String country;
    private String competition;
}

