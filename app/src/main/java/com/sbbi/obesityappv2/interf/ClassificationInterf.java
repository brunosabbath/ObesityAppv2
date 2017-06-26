package com.sbbi.obesityappv2.interf;

import com.sbbi.obesityappv2.model.Prediction;
import com.sbbi.obesityappv2.model.ResponseFood;

/**
 * Created by bsilva on 10/25/16.
 */
public interface ClassificationInterf {
    public void sendToResultScreen(Prediction prediction);
}
