package com.sise.design.general.util.content;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Chen xuexin
 * @Time: 2019/7/20 19:24
 * @Descript: TODO
 * @Version: 1.0
 */


public class JsonUtil {

    public static Map jsonToMap(String json){
        Map map = new LinkedHashMap();
        JsonObject object=null;
        if(json.startsWith("[")){
            JsonArray object2 = (JsonArray) new JsonParser().parse(json);
            object = (JsonObject) new JsonParser().parse(String.valueOf(object2.iterator().next()));
        }else if(json.startsWith("{")){
            object = (JsonObject) new JsonParser().parse(json);
        }
        for(Map.Entry<String, JsonElement> entry : object.entrySet()){
            String value= String.valueOf(entry.getValue());
            if( "".equals(value) ){
                map.put(entry.getKey(),"");
                //System.out.print(entry.getKey()+":");
            }else if( value.startsWith("[") || value.startsWith("{") ){
                map.put(entry.getKey(),jsonToMap(value));
                //System.out.print(entry.getKey()+":");Str(value);
            }else{
                //System.out.println(entry.getKey()+":"+entry.getValue()+"\t");
                map.put(entry.getKey(),value);
            }
            // System.out.print(entry.getKey()+":"+entry.getValue()+"\t");
        }
        return map;
    }

}
