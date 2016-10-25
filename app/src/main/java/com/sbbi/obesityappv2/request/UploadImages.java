package com.sbbi.obesityappv2.request;

import android.os.AsyncTask;

import com.sbbi.obesityappv2.interf.ClassificationInterf;
import com.sbbi.obesityappv2.model.ClassificationReturn;

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
public class UploadImages extends AsyncTask<String[], Void, ClassificationReturn>{

    private ClassificationInterf listener;

    public UploadImages(ClassificationInterf listener){
        this.listener = listener;
    }

    @Override
    protected ClassificationReturn doInBackground(String[]... strings) {

        String url = "http://129.93.164.34:8080/pictures";

        String path[] = strings[0];

        RestTemplate restTemplate = new RestTemplate(true);

        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        formHttpMessageConverter.setCharset(Charset.forName("UTF8"));

        restTemplate.getMessageConverters().add( formHttpMessageConverter );
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        if(path[0] != null)
            map.add("file1", new FileSystemResource(path[0]));
        else
            map.add("file1", new FileSystemResource(path[0]));

        if(path[1] != null)
            map.add("file2", new FileSystemResource(path[1]));
        else
            map.add("file2", new FileSystemResource(path[0]));

        if(path[2] != null)
            map.add("file3", new FileSystemResource(path[2]));
        else
            map.add("file3", new FileSystemResource(path[0]));

        if(path[3] != null)
            map.add("file4", new FileSystemResource(path[3]));
        else
            map.add("file4", new FileSystemResource(path[0]));


        HttpHeaders imageHeaders = new HttpHeaders();
        imageHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> imageEntity = new HttpEntity<MultiValueMap<String, Object>>(map, imageHeaders);

        ResponseEntity<ClassificationReturn> response = restTemplate.exchange(url, HttpMethod.POST, imageEntity, ClassificationReturn.class);

        return response.getBody();
    }

    @Override
    protected void onPostExecute(ClassificationReturn classificationReturn) {
        listener.sendToResultScreen(classificationReturn);
    }
}
