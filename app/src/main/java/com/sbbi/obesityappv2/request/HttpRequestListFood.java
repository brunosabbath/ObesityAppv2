package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;

import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.interf.TestFoodInterf;
import com.sbbi.obesityappv2.model.Food;

import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilva on 10/18/16.
 */
public class HttpRequestListFood extends AsyncTask<Void, Void, List<Food>> {

    private TestFoodInterf listener;

    public HttpRequestListFood(TestFoodInterf listener){
        this.listener = listener;
    }

    @Override
    protected List<Food> doInBackground(Void... params) {

        String url = "http://129.93.164.34:8080/food";

        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{

            Food[] list = template.getForObject(url, Food[].class);

            List<Food> listFood = new ArrayList<Food>();

            for(int i = 0; i < list.length; i++){
                listFood.add(list[i]);
            }

            return listFood;
            //return list;

        } catch (RestClientException e){
            return new ArrayList<Food>();
        }

    }

    @Override
    protected void onPostExecute(List<Food> foods) {
        listener.setLayoutAfterRequest(foods);
    }
}
