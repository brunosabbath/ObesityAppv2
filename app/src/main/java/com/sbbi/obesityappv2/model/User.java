package com.sbbi.obesityappv2.model;

import java.util.List;

/**
 * Created by bsilva on 10/18/16.
 */
public class User {

    private int id;
    private String email;
    private String height;
    private String name;
    private String password;
    private double weight;
    private double fingerLength;
    private double fingerWidth;

    //bi-directional many-to-one association to Meal
    private List<Meal> meals;

    public User() {
    }

    public double getFingerLength() {
        return fingerLength;
    }

    public void setFingerLength(double length) {
        this.fingerLength = length;
    }

    public double getFingerWidth() {
        return fingerWidth;
    }

    public void setFingerWidth(double width) {
        this.fingerWidth = width;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public User setPassword(String password) {

        this.password = password;
        return this;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Meal> getMeals() {
        return this.meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Meal addMeal(Meal meal) {
        getMeals().add(meal);
        meal.setUser(this);

        return meal;
    }

    public Meal removeMeal(Meal meal) {
        getMeals().remove(meal);
        meal.setUser(null);

        return meal;
    }

}
