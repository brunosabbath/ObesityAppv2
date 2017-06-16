package com.sbbi.obesityappv2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilva on 6/16/17.
 */

public class RecommendationRequest {

    private int userId;
    private int caloriesOut;
    private List<Meal> listMeal;

    public RecommendationRequest(){
        listMeal = new ArrayList<Meal>();
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getCaloriesOut() {
        return caloriesOut;
    }
    public void setCaloriesOut(int caloriesOut) {
        this.caloriesOut = caloriesOut;
    }
    public List<Meal> getListMeal() {
        return listMeal;
    }
    public void setListMeal(List<Meal> listMeal) {
        this.listMeal = listMeal;
    }

}
