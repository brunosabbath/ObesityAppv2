package com.sbbi.obesityappv2.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.v13.app.FragmentCompat;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.fitbit.api.ResourceLoadedHandler;
import com.fitbit.api.services.CaloriesService;
import com.fitbit.api.services.DeviceService;
import com.fitbit.api.services.UserService;
import com.fitbit.authentication.AuthenticationHandler;
import com.fitbit.authentication.AuthenticationManager;
import com.fitbit.authentication.AuthenticationResult;
import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.LoginActivity;
import com.sbbi.obesityappv2.activity.Test;
import com.sbbi.obesityappv2.fitbit.FitbitAuthApplication;
import com.sbbi.obesityappv2.fitbit.RootActivity;
import com.sbbi.obesityappv2.fitbit.UserDataActivity;
import com.sbbi.obesityappv2.helper.LogoutHelper;
import com.sbbi.obesityappv2.request.FitbitApiHttp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bsilva on 10/18/16.
 */
public class PreferencesFragment extends Fragment implements ResourceLoadedHandler{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_preferences, container, false);

        Button btnGetActivity = (Button) layout.findViewById(R.id.btnGetActivity);
        btnGetActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean loggedIn = AuthenticationManager.isLoggedIn();

                Intent intent = new Intent(getActivity(), UserDataActivity.class);
                startActivity(intent);

                Log.i("LOGGED", loggedIn + "");
            }
        });

        Button btnLogout = (Button) layout.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();

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

    private void logout() {

        LogoutHelper.logout(getContext());
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }

    @Override
    public void onResourceLoaded(Object resource) {

    }

    @Override
    public void onResourceLoadError(String errorMessage) {

    }
}
