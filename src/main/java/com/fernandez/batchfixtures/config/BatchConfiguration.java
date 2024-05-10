package com.fernandez.batchfixtures.config;

import com.fernandez.batchfixtures.model.dto.FixturesBean;
import com.fernandez.batchfixtures.model.entity.Fixtures;
import com.fernandez.batchfixtures.writer.ConsoleItemWriter;
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
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.fernandez.batchfixtures.decorator.ThreadLoggingTaskDecorator;
import com.fernandez.batchfixtures.job.MyJobListener;
import com.fernandez.batchfixtures.processor.CsvItemProcessor;
import com.fernandez.batchfixtures.reader.CsvItemReader;

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
        return jobBuilderFactory.get("myJobFixtures")
                .incrementer(new RunIdIncrementer())
                .listener(myJobListener)
                .start(myStep())
                .build();
    }

    @Bean
    public Step myStep() {
        return stepBuilderFactory.get("myStepFixtures")
                .<FixturesBean, Fixtures>chunk(chunk)
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
        taskExecutor.setThreadNamePrefix("my-batch-fixtures-thread-");
        taskExecutor.setTaskDecorator(new ThreadLoggingTaskDecorator());
        return taskExecutor;
    }
}
