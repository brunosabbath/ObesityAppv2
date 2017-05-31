package com.sbbi.obesityappv2.model.pojo;

import com.sbbi.obesityappv2.model.Food;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilva on 3/10/17.
 */

public class MealPojo implements Serializable{

    private String type;
    private boolean eatingOutside;
    private List<FoodPojo> listFood;

    public MealPojo(){
        listFood = new ArrayList<FoodPojo>();
    }

    public void setEatingOutside(boolean eatingOutside){
        this.eatingOutside = eatingOutside;
    }

    public boolean isEatingOutside(){
        return eatingOutside;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<FoodPojo> getListFood() {
        return listFood;
    }

    public void addFood(FoodPojo food) {
        this.listFood.add(food);
    }

}
