package com.sbbi.obesityappv2.model.fitbit;

/**
 * Created by bsilva on 11/30/16.
 */
public class LifetimeActivity {

    private int caloriesOut = 0;
    private float distance = 0;
    private int floors = 0;
    private int steps = 0;

    public int getCaloriesOut() {
        return caloriesOut;
    }

    public void setCaloriesOut(int caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

}
