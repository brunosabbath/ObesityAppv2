package com.sbbi.obesityappv2.model;

/**
 * Created by bsilva on 3/2/17.
 */

public class Finger {

    private double height;
    private double width;

    public Finger(){}
    public Finger(double height, double width){
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
