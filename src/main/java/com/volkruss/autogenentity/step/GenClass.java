package com.volkruss.autogenentity.step;

import com.volkruss.autogenentity.model.GenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GenClass {

    @Autowired
    private GenerateJavaFile generateJavaFile;

    private final String TEMPLATE_PATH = "templates/src/Template.txt";

    public void generateClass(List<GenModel> genModels){

        List<OutModel> outModels = new ArrayList<>();
        for(GenModel model : genModels){
            OutModel outModel = new OutModel();
            outModel.tableName = model.getTableName();
            Map<String,String> newMap = this.toTypeTextMap(model.getMap());
            outModel.colums.putAll(newMap);
            outModels.add(outModel);
        }

        this.generateJavaFile.generateTextWithTemplate(TEMPLATE_PATH,outModels);

        System.out.println("-----------finished-------");
    }

    private Map<String,String> toTypeTextMap(Map<String,String> map){
        Map<String,String> newMap = new HashMap<>();
        for(String k : map.keySet()){
            String newKey = JavaClassPair.getJavaClassName(k);
            newMap.put(newKey,map.get(k));
        }
        return newMap;
    }

}
