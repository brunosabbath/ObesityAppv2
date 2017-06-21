package com.sbbi.obesityappv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bsilva on 10/18/16.
 */
public class User {

    private int id;
    private String email;
    private String name;
    private String password;
    private double weight;
    private double height;
    private char sex;
    private double fingerLength;
    private double fingerWidth;

    //bi-directional many-to-one association to Meal
    private List<Meal> meals;

    public User() {}

    @JsonIgnore
    public char getSex(){
        return sex;
    }
    @JsonIgnore
    public void setSex(char sex){
        this.sex = sex;
    }

    public double getFingerLength() {
        return fingerLength;
    }

    public void setFingerLength(double fingerLength) {
        this.fingerLength = fingerLength;
    }

    public double getFingerWidth() {
        return fingerWidth;
    }

    public void setFingerWidth(double fingerWidth) {
        this.fingerWidth = fingerWidth;
    }

    public int getId() {
        return this.id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public double getHeight() {
        return this.height;
    }

    public User setHeight(double height) {
        this.height = height;
        return this;
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

    public User setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public List<Meal> getMeals() {
        return this.meals;
    }

    public void removePassword(){
        this.password = "";
    }

    @Override
    public String toString() {
        return getName();
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