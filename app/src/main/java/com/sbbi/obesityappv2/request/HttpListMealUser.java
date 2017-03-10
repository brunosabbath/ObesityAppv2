package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;

import com.sbbi.obesityappv2.helper.Paths;
import com.sbbi.obesityappv2.interf.MealPojoListener;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.pojo.MealPojo;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilva on 3/10/17.
 */

public class HttpListMealUser extends AsyncTask<Integer, Void, List<MealPojo>> {

    private MealPojoListener listener;

    public HttpListMealUser(MealPojoListener listener){
        this.listener = listener;
    }

    @Override
    protected List<MealPojo> doInBackground(Integer... params) {

        int userId = params[0];

        String url = Paths.meal + "/" + userId;

        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{

            MealPojo[] list = template.getForObject(url, MealPojo[].class);

            List<MealPojo> listMeal = new ArrayList<MealPojo>();

            for(int i = 0; i < list.length; i++){
                listMeal.add(list[i]);
            }

            return listMeal;
            //return list;

        } catch (RestClientException e){
            return new ArrayList<MealPojo>();
        }

    }

    @Override
    protected void onPostExecute(List<MealPojo> list) {
        listener.setLayoutAfterRequest(list);
    }
}
