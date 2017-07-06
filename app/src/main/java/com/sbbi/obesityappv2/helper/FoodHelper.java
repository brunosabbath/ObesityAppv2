package com.sbbi.obesityappv2.helper;

import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.pojo.FoodPojo;

/**
 * Created by bsilva on 7/6/17.
 */

public class FoodHelper {

    public static Food FoodPojoToFood(FoodPojo foodPojo){
        Food food = new Food();

        food.setCarbohydrate(foodPojo.getCarbohydrate()).setCholesterol(foodPojo.getCholesterol()).setEnergy(foodPojo.getEnergy())
                .setFiber(foodPojo.getFiber()).setLipid(foodPojo.getLipid()).setProtein(foodPojo.getProtein()).setSugar(foodPojo.getSugar())
                .setName(foodPojo.getName()).setGrams(foodPojo.getGrams());

        return food;
    }

}
