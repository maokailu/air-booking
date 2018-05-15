package com.cumt.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-05-15.
 */
public class MetaData {
    @JsonProperty("data")
    private Map<String, String> map  = new HashMap<>();

    private MetaData() {
    }

    public MetaData(Map<String, String> map) {
        this.map = map;
    }

    public String get(String key) {
        return map.get(key);
    }
}
