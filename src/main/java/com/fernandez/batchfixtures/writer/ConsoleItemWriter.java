package com.fernandez.batchfixtures.writer;

import com.fernandez.batchfixtures.model.entity.Fixtures;
import com.fernandez.batchfixtures.repository.FixturesRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleItemWriter implements ItemWriter<Fixtures> {

    private final FixturesRepository fixturesRepository;

    @Autowired
    public ConsoleItemWriter(FixturesRepository fixturesRepository) {
        this.fixturesRepository = fixturesRepository;
    }

    @Override
    public void write(List<? extends Fixtures> items) throws Exception {
        fixturesRepository.saveAll(items);
    }
}