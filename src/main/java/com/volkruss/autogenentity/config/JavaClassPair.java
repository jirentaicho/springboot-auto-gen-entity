package com.volkruss.autogenentity.config;

import java.util.Map;
import java.util.Objects;

public class JavaClassPair {

    private static Map<String,String> map = Map.of(
            "1","char",
            "-5","int",
            "2","int",
            "4","int",
            "6","float",
            "8","double",
            "12","String", // VARCHAR
            "91","java.util.Date",
            "92","java.util.Date",
            "93","java.util.Date"
    );

    public static String getJavaClassName(String key){
        String javaKey = JavaClassPair.map.get(key);
        if(Objects.isNull(javaKey)){
            javaKey = "String";
        }
        return javaKey;
    }

}
