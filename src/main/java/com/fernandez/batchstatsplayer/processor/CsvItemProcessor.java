package com.fernandez.batchstatsplayer.processor;

import com.fernandez.batchstatsplayer.model.dto.StatsPlayerBean;
import com.fernandez.batchstatsplayer.model.entity.StatsPlayer;
import com.fernandez.batchstatsplayer.reader.CsvItemReader;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CsvItemProcessor implements ItemProcessor<StatsPlayerBean, StatsPlayer> {

    private final CsvItemReader csvItemReader;

    @Autowired
    public CsvItemProcessor(CsvItemReader csvItemReader) {
        this.csvItemReader = csvItemReader;
    }

    @Override
    public StatsPlayer process(StatsPlayerBean statsPlayerBean) throws Exception {
        StatsPlayer statsPlayer = new StatsPlayer();
        statsPlayer.setName(statsPlayerBean.getName());
        statsPlayer.setTeam(statsPlayerBean.getTeam());
        statsPlayer.setPts(statsPlayerBean.getPts());
        statsPlayer.setReb(statsPlayerBean.getReb());
        statsPlayer.setAst(statsPlayerBean.getAst());
        statsPlayer.setMin(statsPlayerBean.getMin());
        statsPlayer.setFgm(statsPlayerBean.getFgm());
        statsPlayer.setFga(statsPlayerBean.getFga());
        statsPlayer.set_2pm(statsPlayerBean.get_2pm());
        statsPlayer.set_2pa(statsPlayerBean.get_2pa());
        statsPlayer.set_3pm(statsPlayerBean.get_3pm());
        statsPlayer.set_3pa(statsPlayerBean.get_3pa());
        statsPlayer.setFtm(statsPlayerBean.getFtm());
        statsPlayer.setFta(statsPlayerBean.getFta());
        statsPlayer.setPlusMinus(statsPlayerBean.getPlusMinus());
        statsPlayer.setOffensiveRebounds(statsPlayerBean.getOffensiveRebounds());
        statsPlayer.setDr(statsPlayerBean.getDr());
        statsPlayer.setPf(statsPlayerBean.getPf());
        statsPlayer.setSt(statsPlayerBean.getSt());
        statsPlayer.setTurnovers(statsPlayerBean.getTurnovers());
        statsPlayer.setBs(statsPlayerBean.getBs());
        statsPlayer.setBa(statsPlayerBean.getBa());
        statsPlayer.setTfm(statsPlayerBean.getTfm());
        statsPlayer.setMatchId(statsPlayerBean.getMatchId());
        return statsPlayer;
    }
}
