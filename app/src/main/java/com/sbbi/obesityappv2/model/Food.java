package com.sbbi.obesityappv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by bsilva on 10/18/16.
 */
public class Food implements Serializable{

    private int id;
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
    private List<Meal> meals;
    private double grams;
    private char grade;
    private double calcium;
    private double iron;
    private double potassium;
    private double sodium;


    public Food() {
        this.id = 0;
        this.carbohydrate = 0;
        this.cholesterol = 0;
        this.energy = 0;
        this. fiber = 0;
        this.lipid = 0;
        this.protein = 0;
        this.sugar = 0;
        this.name = "";
        this.grams = 0;
        this.grade = ' ';
        this.calcium = 0;
        this.iron = 0;
        this.potassium = 0;
        this.sodium = 0;
    }

    public double getCalcium() {
        return calcium;
    }

    public Food setCalcium(double calcium) {
        this.calcium = calcium;
        return this;
    }

    public double getIron() {
        return iron;
    }

    public Food setIron(double iron) {
        this.iron = iron;
        return this;
    }

    public double getPotassium() {
        return potassium;
    }

    public Food setPotassium(double potassium) {
        this.potassium = potassium;
        return this;
    }

    public double getSodium() {
        return sodium;
    }

    public Food setSodium(double sodium) {
        this.sodium = sodium;
        return this;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public double getGrams() {
        return grams;
    }

    public Food setGrams(double grams) {
        this.grams = grams;
        return this;
    }

    public Food(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Food(Food food) {
        this.carbohydrate = food.getCarbohydrate();
        this.cholesterol = food.getCholesterol();
        this.energy = food.getEnergy();
        this.fattyAcidsMonounsaturated = food.getFattyAcidsMonounsaturated();
        this.fattyAcidsPolyunsaturated = food.getFattyAcidsPolyunsaturated();
        this.fattyAcidsSaturated = food.getFattyAcidsSaturated();
        this.fattyAcidTrans = food.getFattyAcidTrans();
        this.fiber = food.getFiber();
        this.lipid = food.getLipid();
        this.protein = food.getProtein();
        this.sugar = food.getSugar();
        this.name = food.getName();
        this.grams = food.getGrams();

    }

    public int getId() {
        return this.id;
    }

    public Food setId(int id) {
        this.id = id;
        return this;
    }

    public double getCarbohydrate() {
        return this.carbohydrate;
    }

    public Food setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
        return this;
    }

    public double getCholesterol() {
        return this.cholesterol;
    }

    public Food setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
        return this;
    }

    public double getEnergy() {
        return this.energy;
    }

    public Food setEnergy(double energy) {
        this.energy = energy;
        return this;
    }

    public double getFattyAcidsMonounsaturated() {
        return this.fattyAcidsMonounsaturated;
    }

    public Food setFattyAcidsMonounsaturated(double fattyAcidsMonounsaturated) {
        this.fattyAcidsMonounsaturated = fattyAcidsMonounsaturated;
        return this;
    }

    public double getFattyAcidsPolyunsaturated() {
        return this.fattyAcidsPolyunsaturated;
    }

    public Food setFattyAcidsPolyunsaturated(double fattyAcidsPolyunsaturated) {
        this.fattyAcidsPolyunsaturated = fattyAcidsPolyunsaturated;
        return this;
    }

    public double getFattyAcidsSaturated() {
        return this.fattyAcidsSaturated;
    }

    public Food setFattyAcidsSaturated(double fattyAcidsSaturated) {
        this.fattyAcidsSaturated = fattyAcidsSaturated;
        return this;
    }

    public double getFattyAcidTrans() {
        return this.fattyAcidTrans;
    }

    public Food setFattyAcidTrans(double fattyAcidTrans) {
        this.fattyAcidTrans = fattyAcidTrans;
        return this;
    }

    public double getFiber() {
        return this.fiber;
    }

    public Food setFiber(double fiber) {
        this.fiber = fiber;
        return this;
    }

    public double getLipid() {
        return this.lipid;
    }

    public Food setLipid(double lipid) {
        this.lipid = lipid;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Food setName(String name) {
        this.name = name;
        return this;
    }

    public double getProtein() {
        return this.protein;
    }

    public Food setProtein(double protein) {
        this.protein = protein;
        return this;
    }

    public double getSugar() {
        return this.sugar;
    }

    public Food setSugar(double sugar) {
        this.sugar = sugar;
        return this;
    }

    public List<Meal> getMeals() {
        return this.meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Food changeAmountGrams(double grams){
        this.grams = grams;
        this.energy *= grams/100;
        this.protein *= grams/100;
        this.lipid *= grams/100;
        this.carbohydrate *= grams/100;
        this.fiber *= grams/100;
        this.sugar *= grams/100;
        this.fattyAcidsSaturated *= grams/100;
        this.fattyAcidsMonounsaturated *= grams/100;
        this.fattyAcidsPolyunsaturated *= grams/100;
        this.fattyAcidTrans *= grams/100;
        this.cholesterol *= grams/100;
        return this;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " energy: " + this.energy +
                " protein: " + this.protein +
                " lipids: " + this.lipid;
    }

    public void formatOutput() {
        DecimalFormat df = new DecimalFormat("#.00");

        carbohydrate = Double.parseDouble(df.format(carbohydrate).replace(',','.'));
        cholesterol = Double.parseDouble(df.format(cholesterol).replace(',','.'));
        energy = Double.parseDouble(df.format(energy).replace(',','.'));
        fattyAcidsMonounsaturated = Double.parseDouble(df.format(fattyAcidsMonounsaturated).replace(',','.'));
        fattyAcidsPolyunsaturated = Double.parseDouble(df.format(fattyAcidsPolyunsaturated).replace(',','.'));
        fattyAcidsSaturated = Double.parseDouble(df.format(fattyAcidsSaturated).replace(',','.'));
        fattyAcidTrans = Double.parseDouble(df.format(fattyAcidTrans).replace(',','.'));
        fiber = Double.parseDouble(df.format(fiber).replace(',','.'));
        lipid = Double.parseDouble(df.format(lipid).replace(',','.'));
        protein = Double.parseDouble(df.format(protein).replace(',','.'));
        sugar = Double.parseDouble(df.format(sugar).replace(',','.'));
        calcium = Double.parseDouble(df.format(calcium).replace(',','.'));
        iron = Double.parseDouble(df.format(iron).replace(',','.'));
        potassium = Double.parseDouble(df.format(potassium).replace(',','.'));
        sodium = Double.parseDouble(df.format(sodium).replace(',','.'));
    }
}
