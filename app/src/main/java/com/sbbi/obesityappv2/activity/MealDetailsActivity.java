package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.model.pojo.FoodPojo;
import com.sbbi.obesityappv2.model.pojo.MealPojo;
import com.sbbi.obesityappv2.recycleradapter.MealDetailsRecyclerAdapter;
import com.sbbi.obesityappv2.recycleradapter.MealRecyclerAdapter;

import java.util.ArrayList;

public class MealDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MealDetailsRecyclerAdapter mealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        Bundle extras = getIntent().getExtras();
        MealPojo mealPojo = (MealPojo) extras.get("mealPojo");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_food_details);
        mealAdapter = new MealDetailsRecyclerAdapter(this, mealPojo.getListFood());
        recyclerView.setAdapter(mealAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
