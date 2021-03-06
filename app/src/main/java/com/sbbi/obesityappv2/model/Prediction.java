package com.sbbi.obesityappv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilva on 6/26/17.
 */

public class Prediction implements Serializable{

    private List<String> predictionsFoodLeft;
    private List<String> predictionsFoodRight;
    private List<String> predictionsFoodBottom;
    private Food predictedFoodLeft;
    private Food predictedFoodRight;
    private Food predictedFoodBottom;
    private String path;
    private Pixels pixels;
    private int typeMeal;

    public Prediction(){}

    public Prediction(List<String> predictionsFoodLeft, List<String> predictionsFoodRight, List<String> predictionsFoodBottom) {
        this.predictionsFoodLeft = predictionsFoodLeft;
        this.predictionsFoodRight = predictionsFoodRight;
        this.predictionsFoodBottom = predictionsFoodBottom;
    }

    public List<String> getPrediction(int position){
        if(position == 0)
            return predictionsFoodLeft;
        else if(position == 1)
            return predictionsFoodRight;
        else
            return predictionsFoodBottom;
    }

    public void setTypeMeal(int typeMeal){
        this.typeMeal = typeMeal;
    }

    public int getTypeMeal(){
        return typeMeal;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Food getPredictedFoodLeft() {
        return predictedFoodLeft;
    }

    public void setPredictedFoodLeft(Food predictedFoodLeft) {
        this.predictedFoodLeft = predictedFoodLeft;
    }

    public Food getPredictedFoodRight() {
        return predictedFoodRight;
    }

    public void setPredictedFoodRight(Food predictedFoodRight) {
        this.predictedFoodRight = predictedFoodRight;
    }

    public Food getPredictedFoodBottom() {
        return predictedFoodBottom;
    }

    public void setPredictedFoodBottom(Food predictedFoodBottom) {
        this.predictedFoodBottom = predictedFoodBottom;
    }

    public List<String> getPredictionsFoodLeft() {
        return predictionsFoodLeft;
    }

    public void setPredictionsFoodLeft(List<String> predictionsFoodLeft) {
        this.predictionsFoodLeft = predictionsFoodLeft;
    }

    public List<String> getPredictionsFoodRight() {
        return predictionsFoodRight;
    }

    public void setPredictionsFoodRight(List<String> predictionsFoodRight) {
        this.predictionsFoodRight = predictionsFoodRight;
    }

    public List<String> getPredictionsFoodBottom() {
        return predictionsFoodBottom;
    }

    public void setPredictionsFoodBottom(List<String> predictionsFoodBottom) {
        this.predictionsFoodBottom = predictionsFoodBottom;
    }

    public void setPixels(Pixels pixels) {
        this.pixels = pixels;
    }

    public Pixels getPixels(){
        return this.pixels;
    }

    public void updatePredictionLeft(String s) {
        predictionsFoodLeft = new ArrayList<>();
        predictionsFoodLeft.add(s);
    }

    public void updatePredictionRight(String s) {
        predictionsFoodRight = new ArrayList<>();
        predictionsFoodRight.add(s);
    }

    public void updatePredictionBottom(String s) {
        predictionsFoodBottom = new ArrayList<>();
        predictionsFoodBottom.add(s);
    }
}