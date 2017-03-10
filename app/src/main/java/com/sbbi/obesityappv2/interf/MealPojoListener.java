package com.sbbi.obesityappv2.interf;

import com.sbbi.obesityappv2.model.pojo.MealPojo;

import java.util.List;

/**
 * Created by bsilva on 3/10/17.
 */

public interface MealPojoListener {

    public void setLayoutAfterRequest(List<MealPojo> listMeal);

}
