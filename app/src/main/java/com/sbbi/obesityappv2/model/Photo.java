package com.sbbi.obesityappv2.model;

/**
 * Created by bsilva on 10/18/16.
 */
public class Photo {

    private int id;

    private String path;

    //bi-directional many-to-one association to Meal
    private Meal meal;

    public Photo() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Meal getMeal() {
        return this.meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

}
