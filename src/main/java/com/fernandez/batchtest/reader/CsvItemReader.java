package com.fernandez.batchtest.reader;

import com.fernandez.batchtest.model.dto.ResultsBean;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class CsvItemReader extends FlatFileItemReader<ResultsBean> {
	
    private String filePath;
	
	 @Autowired
	    public CsvItemReader(@Value("${file}") String filePath) {
	        this.filePath = filePath;
	        setResource(new FileSystemResource(filePath));
	        setLineMapper(createLineMapper());
		    setLinesToSkip(1); // Skip the first line
	    }

    private LineMapper<ResultsBean> createLineMapper() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("matchId", "eventTime", "homeTeam", "awayTeam", "homeScore", "awayScore",
                "homeScore1", "homeScore2", "homeScore3", "homeScore4", "homeScore5",
                "awayScore1", "awayScore2", "awayScore3", "awayScore4", "awayScore5");
        tokenizer.setDelimiter(",");
        BeanWrapperFieldSetMapper<ResultsBean> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(ResultsBean.class);
        DefaultLineMapper<ResultsBean> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

}
