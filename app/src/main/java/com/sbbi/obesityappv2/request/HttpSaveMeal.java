package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;
import android.util.Log;

import com.sbbi.obesityappv2.helper.Paths;
import com.sbbi.obesityappv2.interf.ClassificationInterf;
import com.sbbi.obesityappv2.interf.RedirectListener;
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

public class HttpSaveMeal extends AsyncTask<Void, Void, Prediction> {

    private ClassificationInterf listener;
    private int userId;
    private Prediction predictions;

    public HttpSaveMeal(ClassificationInterf listener, int userId, Prediction predictions){
        this.listener = listener;
        this.userId = userId;
        this.predictions = predictions;
    }

    @Override
    protected Prediction doInBackground(Void... params) {

        String url = Paths.myPc + "/meal/" + userId;


        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        try {
            predictions = restTemplate.postForObject(url, predictions, Prediction.class);
            return predictions;

        } catch (HttpClientErrorException e) {
            Log.e("ERROR", e.getLocalizedMessage(), e); //user not found
        } catch (ResourceAccessException e) {
            Log.e("ERROR", e.getLocalizedMessage(), e);
        }

        return predictions;
    }

    @Override
    protected void onPostExecute(Prediction prediction) {
        listener.sendToResultScreen(prediction);
    }
}