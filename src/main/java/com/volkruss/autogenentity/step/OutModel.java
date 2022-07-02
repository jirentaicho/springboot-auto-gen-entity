package com.volkruss.autogenentity.step;

import java.util.HashMap;
import java.util.Map;

public class OutModel {
    public String tableName;
    public Map<String,String> colums = new HashMap<>();

    public String planeTableName(){
        return this.tableName.toLowerCase();
    }


}
