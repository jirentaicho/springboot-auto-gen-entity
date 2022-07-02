package com.volkruss.autogenentity.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class GenModel {

    // sales
    private final String tableName;

    // int / name
    private final Map<String,String> columnInfo = new HashMap<>();

    public GenModel(String tableName){
        this.tableName = tableName;
    }

    public void addColumnInfo(String dataType, String name){
        this.columnInfo.put(dataType,name);
    }

    public Map<String,String> getMap(){
        return this.columnInfo;
    }

    /**
     * 先頭を大文字に変換して返します
     *
     * @return
     */
    public String getTableName(){
        String first = this.tableName.substring(0,1);
        String rest = this.tableName.substring(1,this.tableName.length());

        return first.toUpperCase() + rest;
    }

    public void setMap(Map<String,String> newMap){
        if(Objects.isNull(newMap)){
            System.out.println("-----ERROR----");
            System.out.println("テーブルのカラム情報に不備があります。\n\n\n");
            throw new RuntimeException();
        }
        this.columnInfo.clear();
        this.columnInfo.putAll(newMap);
    }

}
