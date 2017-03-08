package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;

import com.sbbi.obesityappv2.helper.Paths;
import com.sbbi.obesityappv2.interf.UserListener;
import com.sbbi.obesityappv2.model.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bsilva on 3/3/17.
 */

public class LoginHttp extends AsyncTask<User, Void, User> {

    private UserListener listener;

    public LoginHttp(UserListener listener){
        this.listener = listener;
    }

    @Override
    protected User doInBackground(User... params) {
        User user = params[0];
        String url = Paths.login;

        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{

            user = template.postForObject(url, user, User.class);
            listener.userInfo(user);
            return user;

        } catch (RestClientException e){
            listener.userInfo(null);
            return null;
        }
    }

}
