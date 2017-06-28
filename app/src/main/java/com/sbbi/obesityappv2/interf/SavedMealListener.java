package com.sbbi.obesityappv2.interf;

import com.sbbi.obesityappv2.model.FoodsWeightEstimation;
import com.sbbi.obesityappv2.model.Prediction;

/**
 * Created by bsilva on 6/28/17.
 */

public interface SavedMealListener {
    public void sendToResultScreen(FoodsWeightEstimation foodsWeightEstimation);
}
