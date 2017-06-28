package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;
import android.util.Log;

import com.sbbi.obesityappv2.helper.Paths;
import com.sbbi.obesityappv2.interf.ClassificationInterf;
import com.sbbi.obesityappv2.interf.RedirectListener;
import com.sbbi.obesityappv2.interf.SavedMealListener;
import com.sbbi.obesityappv2.model.FoodsWeightEstimation;
import com.sbbi.obesityappv2.model.Prediction;
import com.sbbi.obesityappv2.model.SendMeal;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bsilva on 12/22/16.
 */

public class HttpSaveMeal extends AsyncTask<Void, Void, FoodsWeightEstimation> {

    private SavedMealListener listener;
    private int userId;
    private Prediction predictions;

    public HttpSaveMeal(SavedMealListener listener, int userId, Prediction predictions){
        this.listener = listener;
        this.userId = userId;
        this.predictions = predictions;
    }

    @Override
    protected FoodsWeightEstimation doInBackground(Void... params) {

        String url = Paths.myPc + "/meal/" + userId;


        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        FoodsWeightEstimation foodsWeightEstimation = null;

        try {
            foodsWeightEstimation = restTemplate.postForObject(url, predictions, FoodsWeightEstimation.class);
            return foodsWeightEstimation;

        } catch (HttpClientErrorException e) {
            Log.e("ERROR", e.getLocalizedMessage(), e); //user not found
        } catch (ResourceAccessException e) {
            Log.e("ERROR", e.getLocalizedMessage(), e);
        }

        return foodsWeightEstimation;
    }

    @Override
    protected void onPostExecute(FoodsWeightEstimation foodsWeightEstimation) {
        listener.sendToResultScreen(foodsWeightEstimation);
    }
}