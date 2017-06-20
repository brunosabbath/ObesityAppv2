package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;
import android.view.View;

import com.sbbi.obesityappv2.helper.Paths;
import com.sbbi.obesityappv2.interf.FingerListener;
import com.sbbi.obesityappv2.model.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bsilva on 6/20/17.
 */

public class HttpSaveFinger extends AsyncTask<Double, Void, User>{

    private FingerListener listener;

    public HttpSaveFinger(FingerListener listener) {
        this.listener = listener;
    }

    @Override
    protected User doInBackground(Double... params) {

        double length = params[0];
        double width = params[1];
        double userIdDouble = params[2];
        int userId = (int)userIdDouble;

        User user = new User();
        user.setId(userId);
        user.setFingerLength(length);
        user.setFingerWidth(width);

        String url = Paths.finger;

        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        User userReturn = template.postForObject(url, user, User.class);

        return userReturn;
    }

    @Override
    protected void onPostExecute(User user) {
        if(user != null)
            listener.info("Finger measures added");
        else
            listener.info("Something weird happened");

    }
}
