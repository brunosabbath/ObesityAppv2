package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.model.pojo.FoodPojo;
import com.sbbi.obesityappv2.model.pojo.MealPojo;

public class MealDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        Bundle extras = getIntent().getExtras();
        MealPojo mealPojo = (MealPojo) extras.get("mealPojo");

        recyclerView = (RecyclerView) findViewById(R.id.meal_details_id);

        for(FoodPojo food : mealPojo.getListFood()){

        }


    }
}
