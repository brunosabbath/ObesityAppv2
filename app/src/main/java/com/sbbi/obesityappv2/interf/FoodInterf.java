package com.sbbi.obesityappv2.interf;

import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.ResponseFood;

import java.util.List;

/**
 * Created by bsilva on 10/18/16.
 */
public interface FoodInterf {

    public void setLayoutAfterRequest(List<Food> listFood);
    //public void setLayoutAfterRequest(ResponseFood responseFood);

}
