package com.fernandez.batchstatsplayer.writer;

import com.fernandez.batchstatsplayer.model.entity.StatsPlayer;
import com.fernandez.batchstatsplayer.repository.StatsPlayerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleItemWriter implements ItemWriter<StatsPlayer> {

    private final StatsPlayerRepository statsPlayerRepository;

    @Autowired
    public ConsoleItemWriter(StatsPlayerRepository statsPlayerRepository) {
        this.statsPlayerRepository = statsPlayerRepository;
    }

    @Override
    public void write(List<? extends StatsPlayer> items) throws Exception {
        statsPlayerRepository.saveAll(items);
    }
}