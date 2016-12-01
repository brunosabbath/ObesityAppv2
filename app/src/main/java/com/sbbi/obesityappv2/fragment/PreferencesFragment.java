package com.sbbi.obesityappv2.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.Test;
import com.sbbi.obesityappv2.request.FitbitApiHttp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bsilva on 10/18/16.
 */
public class PreferencesFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_preferences, container, false);

        Button btnFitbit = (Button) layout.findViewById(R.id.btnFitbit);
        btnFitbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "api", Toast.LENGTH_SHORT).show();
                new FitbitApiHttp().execute();

                /*String url = "https://www.fitbit.com/oauth2/authorize?response_type=token&client_id=227YVJ&redirect_uri=fitbittester://logincallback&scope=activity&expires_in=604800&prompt=login";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getActivity(), Uri.parse(url));
                */

                //Intent i = new Intent(getActivity(), Test.class);
                //startActivity(i);

            }
        });


        return layout;
    }

}
