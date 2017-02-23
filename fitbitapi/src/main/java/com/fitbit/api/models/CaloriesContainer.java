package com.fitbit.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilva on 2/23/17.
 */

public class CaloriesContainer {

    @SerializedName("activities-calories")
    @Expose
    private List<ActivitiesCalories> listActivitiesCalories = new ArrayList<ActivitiesCalories>();

    @SerializedName("activities-calories-intraday")
    @Expose
    private ActivitiesCaloriesIntraday activitiesCaloriesIntraday;

    public List<ActivitiesCalories> getListActivitiesCalories() {
        return listActivitiesCalories;
    }

    public void setListActivitiesCalories(List<ActivitiesCalories> listActivitiesCalories) {
        this.listActivitiesCalories = listActivitiesCalories;
    }

    public ActivitiesCaloriesIntraday getActivitiesCaloriesIntraday() {
        return activitiesCaloriesIntraday;
    }

    public void setActivitiesCaloriesIntraday(ActivitiesCaloriesIntraday activitiesCaloriesIntraday) {
        this.activitiesCaloriesIntraday = activitiesCaloriesIntraday;
    }
}
