package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;
import android.util.Log;

import com.sbbi.obesityappv2.helper.Paths;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.fitbit.Greeting;
import com.sbbi.obesityappv2.model.fitbit.LifetimeActivity;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bsilva on 11/29/16.
 */
public class FitbitApiHttp extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... voids) {

        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String url = "https://www.fitbit.com/oauth2/authorize?response_type=token&client_id=227N4J&redirect_uri=http%3A%2F%2Fgoogle.com&scope=activity%20profile%20sleep&expires_in=604800";
        String url2 = Paths.myPc;
        String getInfo = "https://api.fitbit.com/1/user/-/activities/date/2016-12-01.json";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0SkY5TlYiLCJhdWQiOiIyMjdZVkoiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJ3cHJvIHdhY3QiLCJleHAiOjE0ODEyMjk3MzIsImlhdCI6MTQ4MDYyNDkzMn0.b1ZT-oICYphGDGi0ZxkxR4wF6gGQ4JGc0VAkblEYvSs");

        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<LifetimeActivity> response = template.exchange(getInfo, HttpMethod.GET, request, LifetimeActivity.class);
        LifetimeActivity act = response.getBody();
/*
        try {
            URL url = new URL("http://129.93.164.34:5151/login");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int sc = con.getResponseCode();
            Log.i("CODIGO", String.valueOf(sc));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        /*try{

            Greeting activity = template.getForObject(url2, Greeting.class);
            return activity.getS();

        } catch (RestClientException e){
            return null;
        }*/
        return "1";

    }

    /*@Override
    protected void onPostExecute(LifetimeActivity lifetimeActivity) {
        Log.i("RESULT", String.valueOf(lifetimeActivity.getSteps()));
    }*/

    @Override
    protected void onPostExecute(String s) {
        Log.i("RESULT", s);
    }
}
