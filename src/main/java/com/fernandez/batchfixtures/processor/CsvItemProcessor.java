package com.fernandez.batchfixtures.processor;

import com.fernandez.batchfixtures.model.dto.FixturesBean;
import com.fernandez.batchfixtures.model.entity.Fixtures;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CsvItemProcessor implements ItemProcessor<FixturesBean, Fixtures> {

    @Override
    public Fixtures process(FixturesBean item) throws Exception {
        Fixtures results = new Fixtures();
        results.setMatchId(item.getMatchId());
        results.setHomeTeam(item.getHomeTeam());
        results.setAwayTeam(item.getAwayTeam());
        results.setMatchId(item.getMatchId());
        results.setEventTime(item.getEventTime());
        return results;
    }
}
