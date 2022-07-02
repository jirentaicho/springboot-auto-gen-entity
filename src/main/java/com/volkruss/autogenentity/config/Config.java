package com.volkruss.autogenentity.config;

import com.volkruss.autogenentity.step.GenerateEntityTask;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class Config {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final GenerateEntityTask sampleTask;

    public Config(JobBuilderFactory jobBuilderFactory,
                  StepBuilderFactory stepBuilderFactory,
                  GenerateEntityTask sampleTask){
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.sampleTask = sampleTask;
    }

    @Bean
    public Job sampleJob(Step step){
        return this.jobBuilderFactory.get("sampleJob")
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step sampleStep(){
        return this.stepBuilderFactory.get("sampleStep")
                .tasklet(sampleTask)
                .build();
    }

}
