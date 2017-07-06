package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.model.pojo.FoodPojo;
import com.sbbi.obesityappv2.model.pojo.MealPojo;
import com.sbbi.obesityappv2.recycleradapter.MealDetailsRecyclerAdapter;
import com.sbbi.obesityappv2.recycleradapter.MealRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MealDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MealDetailsRecyclerAdapter mealAdapter;
    private TextView totalCaloriesTextView;
    private TextView carbsTextView;
    private TextView weightTextView;
    private TextView fiberTextView;
    private TextView lipidsTextView;
    private TextView proteinTextView;
    private TextView sugarTextView;
    private double totalCalories;
    private double carbs;
    private double weight;
    private double fiber;
    private double lipids;
    private double protein;
    private double sugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        Bundle extras = getIntent().getExtras();
        MealPojo mealPojo = (MealPojo) extras.get("mealPojo");

        getData(mealPojo.getListFood());
        setData();

        //totalCalories.setText(mealpo);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_food_details);
        mealAdapter = new MealDetailsRecyclerAdapter(this, mealPojo.getListFood());
        recyclerView.setAdapter(mealAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setData() {
        totalCaloriesTextView = (TextView) findViewById(R.id.total_calories_label);
        carbsTextView = (TextView) findViewById(R.id.carbs_label);
        weightTextView = (TextView) findViewById(R.id.weight_label);
        fiberTextView = (TextView) findViewById(R.id.fiber_label);
        lipidsTextView = (TextView) findViewById(R.id.lipids_label);
        proteinTextView = (TextView) findViewById(R.id.protein_label);
        sugarTextView = (TextView) findViewById(R.id.sugar_label);

        totalCaloriesTextView.setText("Total calories: " + totalCalories + " kcal");
        carbsTextView.setText("Total carbohydrate: " + carbs + " g");
        weightTextView.setText("Weight:" + weight + " g");
        fiberTextView.setText("Total fiber: " + fiber + " g");
        lipidsTextView.setText("Total lipids: " + lipids + " g");
        proteinTextView.setText("Total protein" + protein + " g");
        sugarTextView.setText("Total sugar: " + sugar + " g");
    }

    private void getData(List<FoodPojo> listFood) {
        for(FoodPojo food : listFood){
            totalCalories = totalCalories + food.getEnergy();
            carbs = carbs + food.getCarbohydrate();
            weight = weight + food.getGrams();
            fiber = fiber + food.getFiber();
            lipids = lipids + food.getLipid();
            protein = protein + food.getProtein();
            sugar = sugar + food.getSugar();
        }
    }
}
