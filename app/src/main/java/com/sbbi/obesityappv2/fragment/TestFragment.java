package com.sbbi.obesityappv2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.activity.PhotoMenuActivity;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.recycleradapter.FoodRecyclerAdapter;

/**
 * Created by bsilva on 10/20/16.
 */
public class TestFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.test_fragment, container, false);

        return layout;
    }

    public static TestFragment newInstance() {
        return new TestFragment();
    }

}
