package com.fernandez.batchtest.processor;

import com.fernandez.batchtest.model.dto.ResultsBean;
import com.fernandez.batchtest.model.entity.Results;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CsvItemProcessor implements ItemProcessor<ResultsBean, Results> {

    @Override
    public Results process(ResultsBean item) throws Exception {
        Results results = new Results();
        results.setMatchId(item.getMatchId());
        results.setHomeTeam(item.getHomeTeam());
        results.setAwayTeam(item.getAwayTeam());
        results.setMatchId(item.getMatchId());
        results.setEventTime(item.getEventTime());

        if (StringUtils.isNotBlank(item.getHomeScore())) {
            results.setHomeScore(Integer.valueOf(item.getHomeScore()));
        }
        if (StringUtils.isNotBlank(item.getHomeScore1())) {
            results.setHomeScore1(Integer.valueOf(item.getHomeScore1()));
        }
        if (StringUtils.isNotBlank(item.getHomeScore2())) {
            results.setHomeScore2(Integer.valueOf(item.getHomeScore2()));
        }
        if (StringUtils.isNotBlank(item.getHomeScore3())) {
            results.setHomeScore3(Integer.valueOf(item.getHomeScore3()));
        }
        if (StringUtils.isNotBlank(item.getHomeScore4())) {
            results.setHomeScore4(Integer.valueOf(item.getHomeScore4()));
        }
        if (StringUtils.isNotBlank(item.getHomeScore5())) {
            results.setHomeScore5(Integer.valueOf(item.getHomeScore5()));
        }

        if (StringUtils.isNotBlank(item.getAwayScore())) {
            results.setAwayScore(Integer.valueOf(item.getAwayScore()));
        }
        if (StringUtils.isNotBlank(item.getAwayScore1())) {
            results.setAwayScore1(Integer.valueOf(item.getAwayScore1()));
        }
        if (StringUtils.isNotBlank(item.getAwayScore2())) {
            results.setAwayScore2(Integer.valueOf(item.getAwayScore2()));
        }
        if (StringUtils.isNotBlank(item.getAwayScore3())) {
            results.setAwayScore3(Integer.valueOf(item.getAwayScore3()));
        }
        if (StringUtils.isNotBlank(item.getAwayScore4())) {
            results.setAwayScore4(Integer.valueOf(item.getAwayScore4()));
        }
        if (StringUtils.isNotBlank(item.getAwayScore5())) {
            results.setAwayScore5(Integer.valueOf(item.getAwayScore4()));
        }
        return results;
    }
}
