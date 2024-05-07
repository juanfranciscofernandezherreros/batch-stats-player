package com.fernandez.batchtest.writer;

import com.fernandez.batchtest.model.entity.Results;
import com.fernandez.batchtest.repository.ResultsRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleItemWriter implements ItemWriter<Results> {

    private final ResultsRepository resultsRepository;

    @Autowired
    public ConsoleItemWriter(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    @Override
    public void write(List<? extends Results> items) throws Exception {
        resultsRepository.saveAll(items);
    }
}