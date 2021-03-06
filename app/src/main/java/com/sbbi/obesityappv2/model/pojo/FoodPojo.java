package com.sbbi.obesityappv2.model.pojo;

import java.io.Serializable;

/**
 * Created by bsilva on 3/10/17.
 */

public class FoodPojo implements Serializable {

    private double carbohydrate;
    private double cholesterol;
    private double energy;
    private double fattyAcidsMonounsaturated;
    private double fattyAcidsPolyunsaturated;
    private double fattyAcidsSaturated;
    private double fattyAcidTrans;
    private double fiber;
    private double lipid;
    private double protein;
    private double sugar;
    private String name;
    private double grams;

    public FoodPojo(){
        this.carbohydrate = 0;
        this.cholesterol = 0;
        this.energy = 0;
        this.fiber = 0;
        this.lipid = 0;
        this.protein = 0;
        this.sugar = 0;
        this.name = "";
        this.grams = 0;
    }

    public String getName() {
        return name;
    }

    public double getGrams() {
        return grams;
    }

    public FoodPojo setGrams(double grams) {
        this.grams = grams;
        return this;
    }

    public FoodPojo setName(String name) {
        this.name = name;
        return this;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public FoodPojo setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
        return this;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public FoodPojo setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
        return this;
    }

    public double getEnergy() {
        return energy;
    }

    public FoodPojo setEnergy(double energy) {
        this.energy = energy;
        return this;
    }

    public double getFattyAcidsMonounsaturated() {
        return fattyAcidsMonounsaturated;
    }

    public FoodPojo setFattyAcidsMonounsaturated(double fattyAcidsMonounsaturated) {
        this.fattyAcidsMonounsaturated = fattyAcidsMonounsaturated;
        return this;
    }

    public double getFattyAcidsPolyunsaturated() {
        return fattyAcidsPolyunsaturated;
    }

    public FoodPojo setFattyAcidsPolyunsaturated(double fattyAcidsPolyunsaturated) {
        this.fattyAcidsPolyunsaturated = fattyAcidsPolyunsaturated;
        return this;
    }

    public double getFattyAcidsSaturated() {
        return fattyAcidsSaturated;
    }

    public FoodPojo setFattyAcidsSaturated(double fattyAcidsSaturated) {
        this.fattyAcidsSaturated = fattyAcidsSaturated;
        return this;
    }

    public double getFattyAcidTrans() {
        return fattyAcidTrans;
    }

    public FoodPojo setFattyAcidTrans(double fattyAcidTrans) {
        this.fattyAcidTrans = fattyAcidTrans;
        return this;
    }

    public double getFiber() {
        return fiber;
    }

    public FoodPojo setFiber(double fiber) {
        this.fiber = fiber;
        return this;
    }

    public double getLipid() {
        return lipid;
    }

    public FoodPojo setLipid(double lipid) {
        this.lipid = lipid;
        return this;
    }

    public double getProtein() {
        return protein;
    }

    public FoodPojo setProtein(double protein) {
        this.protein = protein;
        return this;
    }

    public double getSugar() {
        return sugar;
    }

    public FoodPojo setSugar(double sugar) {
        this.sugar = sugar;
        return this;
    }

    public void changeAmountGrams(double grams){
        this.grams = grams / 100;
        this.energy *= grams;
        this.protein *= grams;
        this.lipid *= grams;
        this.carbohydrate *= grams;
        this.fiber *= grams;
        this.sugar *= grams;
        this.fattyAcidsSaturated *= grams;
        this.fattyAcidsMonounsaturated *= grams;
        this.fattyAcidsPolyunsaturated *= grams;
        this.fattyAcidTrans *= grams;
        this.cholesterol *= grams;
    }

    @Override
    public String toString() {
        return "name: " + getName() + ", energy: " + getEnergy();
    }
}
