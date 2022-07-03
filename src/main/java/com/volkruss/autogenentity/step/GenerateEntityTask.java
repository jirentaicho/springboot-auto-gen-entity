package com.volkruss.autogenentity.step;

import com.volkruss.autogenentity.hoge.CreateModelList;
import com.volkruss.autogenentity.model.GenModel;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
@StepScope
public class GenerateEntityTask implements Tasklet {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private GenClass genClass;

    @Autowired
    private CreateModelList createModelList;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        List<GenModel> models = this.createModelList.getGenModels();

        this.genClass.generateClass(models);

        return RepeatStatus.FINISHED;
    }
}