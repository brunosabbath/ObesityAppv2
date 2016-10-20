package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;

import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.model.Food;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bsilva on 10/18/16.
 */
public class HttpRequestListFood extends AsyncTask<Void, Void, Food[]> {

    private FoodInterf listener;

    public HttpRequestListFood(FoodInterf listener){
        this.listener = listener;
    }

    @Override
    protected Food[] doInBackground(Void... params) {

        String url = "http://129.93.164.34:8080/food";

        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{

            Food[] list = template.getForObject(url, Food[].class);
            return list;

        } catch (RestClientException e){
            return new Food[0];
        }

    }

    @Override
    protected void onPostExecute(Food[] foods) {
        listener.serLayoutAfterRequest(foods);
    }
}
