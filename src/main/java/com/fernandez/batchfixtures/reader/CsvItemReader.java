package com.fernandez.batchfixtures.reader;

import com.fernandez.batchfixtures.model.dto.FixturesBean;
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
public class CsvItemReader extends FlatFileItemReader<FixturesBean> {
	
    private String filePath;

	 @Autowired
	    public CsvItemReader(@Value("${file}") String filePath) {
	        this.filePath = filePath;
	        setResource(new FileSystemResource(filePath));
	        setLineMapper(createLineMapper());
		    setLinesToSkip(1); // Skip the first line
	    }

    private LineMapper<FixturesBean> createLineMapper() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("matchId", "eventTime", "homeTeam", "awayTeam");
        tokenizer.setDelimiter(",");
        BeanWrapperFieldSetMapper<FixturesBean> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(FixturesBean.class);
        DefaultLineMapper<FixturesBean> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

}
