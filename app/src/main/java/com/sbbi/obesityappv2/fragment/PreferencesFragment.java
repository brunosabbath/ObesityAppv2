package com.sbbi.obesityappv2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sbbi.obesityappv2.R;

/**
 * Created by bsilva on 10/18/16.
 */
public class PreferencesFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_preferences, container, false);
        return layout;
    }

}
