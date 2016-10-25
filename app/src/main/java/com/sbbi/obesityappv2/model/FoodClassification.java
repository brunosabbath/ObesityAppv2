package com.sbbi.obesityappv2.model;

/**
 * Created by bsilva on 10/25/16.
 */
public class FoodClassification {

    private int id;
    private String foodName;
    private double value;

    public FoodClassification(){}

    public FoodClassification(int id, String foodName, double value){
        this.id = id;
        this.foodName = foodName;
        this.value = value;
    }

    public String getFoodName() {
        return foodName;
    }
    public FoodClassification setFoodName(String foodName) {
        this.foodName = foodName;
        return this;
    }
    public double getValue() {
        return value;
    }
    public FoodClassification setValue(double value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return foodName + " -> " + value;
    }

}
