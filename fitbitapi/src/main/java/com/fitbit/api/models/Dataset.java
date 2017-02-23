package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bsilva on 2/23/17.
 */

public class Dataset {

    @SerializedName("level")
    @Expose
    private Integer level;

    @SerializedName("mets")
    @Expose
    private Integer mets;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("value")
    @Expose
    private Double value;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMets() {
        return mets;
    }

    public void setMets(Integer mets) {
        this.mets = mets;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
