package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;
import android.util.Log;

import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.ResponseFood;
import com.sbbi.obesityappv2.model.User;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsilva on 12/22/16.
 */

public class SaveMeal extends AsyncTask<List<Food>, Void, Void> {
    @Override
    protected Void doInBackground(List<Food>... params) {

        String url = "http://129.93.164.34:8080/meal";

        /*RestTemplate restTemplate = new RestTemplate(true);

        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        formHttpMessageConverter.setCharset(Charset.forName("UTF8"));

        restTemplate.getMessageConverters().add( formHttpMessageConverter );
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

        map.add("foods", params);

        HttpHeaders imageHeaders = new HttpHeaders();
        imageHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> imageEntity = new HttpEntity<MultiValueMap<String, Object>>(map, imageHeaders);

        ResponseEntity<ResponseFood> response = restTemplate.exchange(url, HttpMethod.POST, imageEntity, ResponseFood.class);*/

        List<Food> listFood = new ArrayList<Food>();
        listFood = params[0];

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        Food foods[] = new Food[listFood.size()];

        for(int i = 0; i < listFood.size(); i++){
            foods[i] = listFood.get(i);
        }

        try {
            //restTemplate.postForObject(url, user, User.class);
        } catch (HttpClientErrorException e) {
            Log.e("ERROR", e.getLocalizedMessage(), e); //user not found
        } catch (ResourceAccessException e) {
            Log.e("ERROR", e.getLocalizedMessage(), e);

        }

        return null;
    }
}
