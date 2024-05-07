package com.fernandez.batchtest.config;

import com.fernandez.batchtest.model.dto.ResultsBean;
import com.fernandez.batchtest.model.entity.Results;
import com.fernandez.batchtest.writer.ConsoleItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.fernandez.batchtest.decorator.ThreadLoggingTaskDecorator;
import com.fernandez.batchtest.job.MyJobListener;
import com.fernandez.batchtest.processor.CsvItemProcessor;
import com.fernandez.batchtest.reader.CsvItemReader;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CsvItemReader csvItemReader;

    @Autowired
    private CsvItemProcessor csvItemProcessor;

    @Autowired
    private ConsoleItemWriter consoleItemWriter;
    
    @Autowired
    private MyJobListener myJobListener;

    @Value("${batch.taskExecutor.corePoolSize:1}")
    private int corePoolSize;

    @Value("${batch.taskExecutor.maxPoolSize:2}")
    private int maxPoolSize;

    @Value("${batch.taskExecutor.queueCapacity:2}")
    private int queueCapacity;
    
    @Value("${chunk:2}")
    private int chunk;

    @Bean
    public Job myJob() {
        return jobBuilderFactory.get("myJob")
                .incrementer(new RunIdIncrementer())
                .listener(myJobListener)
                .start(myStep())
                .build();
    }

    @Bean
    public Step myStep() {
        return stepBuilderFactory.get("myStep")
                .<ResultsBean, Results>chunk(chunk)
                .reader(csvItemReader)
                .processor(csvItemProcessor)
                .writer(consoleItemWriter)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setThreadNamePrefix("my-batch-thread-");
        taskExecutor.setTaskDecorator(new ThreadLoggingTaskDecorator());
        return taskExecutor;
    }
}
