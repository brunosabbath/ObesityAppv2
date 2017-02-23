package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilva on 2/23/17.
 */

public class ActivitiesCaloriesIntraday {

    @SerializedName("dataset")
    @Expose
    private List<Dataset> listDataset = new ArrayList<Dataset>();

    @SerializedName("datasetInterval")
    @Expose
    private Integer datasetInterval;

    @SerializedName("datasetType")
    @Expose
    private String datasetType;

    public List<Dataset> getListDataset() {
        return listDataset;
    }

    public void setListDataset(List<Dataset> listDataset) {
        this.listDataset = listDataset;
    }

    public Integer getDatasetInterval() {
        return datasetInterval;
    }

    public void setDatasetInterval(Integer datasetInterval) {
        this.datasetInterval = datasetInterval;
    }

    public String getDatasetType() {
        return datasetType;
    }

    public void setDatasetType(String datasetType) {
        this.datasetType = datasetType;
    }
}
