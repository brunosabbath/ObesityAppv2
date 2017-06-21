package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;

import com.sbbi.obesityappv2.helper.GetUserIdHelper;
import com.sbbi.obesityappv2.helper.Paths;
import com.sbbi.obesityappv2.interf.ClassificationInterf;
import com.sbbi.obesityappv2.model.ResponseFood;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Created by bsilva on 10/24/16.
 */
public class UploadImages extends AsyncTask<String[], Void, ResponseFood>{

    private ClassificationInterf listener;
    private final int TOP = 0;
    private final int SIDE_1 = 1;
    private final int SIDE_2 = 2;
    private final int SIDE_3 = 3;
    private int userId;

    public UploadImages(ClassificationInterf listener, int userId){
        this.listener = listener;
        this.userId = userId;
    }

    @Override
    protected ResponseFood doInBackground(String[]... strings) {

        String url = Paths.myPc + "/pictures/" + userId;

        String path[] = strings[0];

        RestTemplate restTemplate = new RestTemplate(true);

        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        formHttpMessageConverter.setCharset(Charset.forName("UTF8"));

        restTemplate.getMessageConverters().add( formHttpMessageConverter );
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

        if(hasPicture(path[0]))
            map.add("file1", new FileSystemResource(path[TOP]));
        else
            map.add("file1", new FileSystemResource(path[TOP]));

        if(hasPicture(path[1]))
            map.add("file2", new FileSystemResource(path[SIDE_1]));
        else
            map.add("file2", new FileSystemResource(path[TOP]));

        if(hasPicture(path[2]))
            map.add("file3", new FileSystemResource(path[SIDE_2]));
        else
            map.add("file3", new FileSystemResource(path[TOP]));

        if(hasPicture(path[3]))
            map.add("file4", new FileSystemResource(path[SIDE_3]));
        else
            map.add("file4", new FileSystemResource(path[TOP]));

        HttpHeaders imageHeaders = new HttpHeaders();
        imageHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> imageEntity = new HttpEntity<MultiValueMap<String, Object>>(map, imageHeaders);

        ResponseEntity<ResponseFood> response = restTemplate.exchange(url, HttpMethod.POST, imageEntity, ResponseFood.class);

        return response.getBody();
    }

    private boolean hasPicture(String path) {
        if(path != null)
            return true;
        else
            return false;

    }

    @Override
    protected void onPostExecute(ResponseFood responseFoodName) {
        listener.sendToResultScreen(responseFoodName);
    }
}
