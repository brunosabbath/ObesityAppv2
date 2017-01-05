package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;
import android.util.Log;

import com.sbbi.obesityappv2.model.SendMeal;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bsilva on 12/22/16.
 */

public class SaveMeal extends AsyncTask<SendMeal, Void, Boolean> {
    @Override
    protected Boolean doInBackground(SendMeal... params) {

        String url = "http://129.93.164.34:8080/meal";

        SendMeal mealToBeSent = params[0];

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());


        try {
            restTemplate.postForObject(url, mealToBeSent, SendMeal.class);
            return true;
        } catch (HttpClientErrorException e) {
            Log.e("ERROR", e.getLocalizedMessage(), e); //user not found
        } catch (ResourceAccessException e) {
            Log.e("ERROR", e.getLocalizedMessage(), e);

        }

        return false;
    }

}
