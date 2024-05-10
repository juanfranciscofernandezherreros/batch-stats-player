package com.fernandez.batchfixtures.model.dto;

import lombok.Data;

@Data
public class FixturesBean {

    private String matchId;
    private String eventTime;
    private String homeTeam;
    private String awayTeam;
    private String dateFile;
    private String country;
    private String competition;
}
