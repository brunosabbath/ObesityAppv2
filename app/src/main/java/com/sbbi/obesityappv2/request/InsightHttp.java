package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;

import com.fitbit.api.services.CaloriesService;
import com.sbbi.obesityappv2.helper.Paths;
import com.sbbi.obesityappv2.interf.ReturnInsightListener;
import com.sbbi.obesityappv2.model.RecommendationRequest;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilva on 6/16/17.
 */

public class InsightHttp extends AsyncTask<Integer, Void, String[]> {

    private ReturnInsightListener listener;

    public InsightHttp(ReturnInsightListener listener){
        this.listener = listener;
    }

    public InsightHttp(CaloriesService.CalorieHandler calorieHandler) {

    }

    @Override
    protected String[] doInBackground(Integer... params) {

        int userId = params[0];
        int caloriesOut = params[1];

        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        RecommendationRequest req = new RecommendationRequest();
        req.setUserId(userId);
        req.setCaloriesOut(caloriesOut);

        String url = Paths.recommendation;

        String[] list = template.postForObject(url, req, String[].class);


        return list;
    }


    @Override
    protected void onPostExecute(String[] strings) {

        List<String> list = new ArrayList<String>();
        for(int i = 0; i < strings.length; i++)
            list.add(strings[i]);

        listener.setResult(list);
    }
}
