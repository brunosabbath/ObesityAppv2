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

import com.fitbit.authentication.AuthenticationHandler;
import com.fitbit.authentication.AuthenticationManager;
import com.fitbit.authentication.AuthenticationResult;
import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.Test;
import com.sbbi.obesityappv2.fitbit.FitbitAuthApplication;
import com.sbbi.obesityappv2.fitbit.RootActivity;
import com.sbbi.obesityappv2.request.FitbitApiHttp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bsilva on 10/18/16.
 */
public class PreferencesFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_preferences, container, false);

        Button btnGetActivity = (Button) layout.findViewById(R.id.btnGetActivity);
        btnGetActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean loggedIn = AuthenticationManager.isLoggedIn();
                Log.i("LOGGED",loggedIn+"");
            }
        });

        Button btnFitbit = (Button) layout.findViewById(R.id.btnFitbit);
        btnFitbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //It must redirect back to this fragment / or to the main activity
                Intent i = new Intent(getActivity(), RootActivity.class);
                startActivity(i);

            }
        });

        return layout;
    }

}
