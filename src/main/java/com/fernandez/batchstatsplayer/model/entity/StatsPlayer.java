package com.fernandez.batchstatsplayer.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STATSPLAYER")
@Data
public class StatsPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String team;
    private String pts;
    private String reb;
    private String ast;
    private String min;
    private String fgm;
    private String fga;
    private String _2pm;
    private String _2pa;
    private String _3pm;
    private String _3pa;
    private String ftm;
    private String fta;
    private String plusMinus;
    private String offensiveRebounds;
    private String dr;
    private String pf;
    private String st;
    private String turnovers;
    private String bs;
    private String ba;
    private String tfm;
    private String matchId;
}

