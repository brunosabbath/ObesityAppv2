package com.sbbi.obesityappv2.model.bundle;

import java.io.Serializable;

/**
 * Created by bsilva on 12/22/16.
 */

public class BundleCorrectFood implements Serializable{

    private int position;
    private String name;

    public BundleCorrectFood(){}

    public int getPosition() {
        return position;
    }

    public BundleCorrectFood setPosition(int position) {
        this.position = position;
        return this;
    }

    public String getName() {
        return name;
    }

    public BundleCorrectFood setName(String name) {
        this.name = name;
        return this;
    }
}
