package com.volkruss.autogenentity.hoge;

import com.volkruss.autogenentity.model.GenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateModelList {

    @Autowired
    private DataSource dataSource;

    public List<GenModel> getGenModels() throws SQLException {
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

        return models;

    }

}
