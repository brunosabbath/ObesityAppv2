package com.sbbi.obesityappv2.model;

import java.util.List;

/**
 * Created by bsilva on 10/18/16.
 */
public class TypeMeal {

    private int id;

    private String type;

    //bi-directional many-to-one association to Meal
    private List<Meal> meals;

    public TypeMeal() {
    }

    public TypeMeal(int typeMeal) {
        this.id = typeMeal;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Meal> getMeals() {
        return this.meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + type;
    }

}
