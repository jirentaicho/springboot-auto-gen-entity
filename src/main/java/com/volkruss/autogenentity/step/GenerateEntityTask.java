package com.volkruss.autogenentity.step;

import com.volkruss.autogenentity.model.GenModel;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
@StepScope
public class GenerateEntityTask implements Tasklet {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private GenClass genClass;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE" });

        List<GenModel> models = new ArrayList<>();

        while (tables.next()) {
            String tableName=tables.getString("TABLE_NAME");
            ResultSet columns = metaData.getColumns(null,  null,  tableName, "%");

            GenModel genModel = new GenModel(tableName);

            while (columns.next()) {
                String columnName=columns.getString("COLUMN_NAME");
                String dataType = columns.getString("DATA_TYPE");
                genModel.addColumnInfo(dataType,columnName);
            }
            models.add(genModel);
        }

        this.genClass.generateClass(models);

        return RepeatStatus.FINISHED;
    }
}