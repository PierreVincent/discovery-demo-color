package com.newsweaver.demo.colorservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Color {

    private final String name;

    private final String hex;

    @JsonCreator
    public Color(@JsonProperty("name") String name,
                 @JsonProperty("hex") String hex) {
        this.name = name;
        this.hex = hex;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getHex() {
        return hex;
    }

}
