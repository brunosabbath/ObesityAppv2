package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.model.Food;

public class ListNutrients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_prediction);

        Food food = (Food) getIntent().getExtras().getSerializable("food");

        String carbs = "Carbohydrate: " + food.getCarbohydrate() + "g";
        String cholesterol = "Cholesterol: " + food.getCholesterol() + "g";
        String energy = "Energy: " + food.getEnergy() + "kcal";
        String fiber = "Fiber: " + food.getFiber() + "g";
        String lipid = "Lipid: " + food.getLipid() + "g";
        String protein = "Protein: " + food.getProtein() + "g";
        String sugar = "Sugar: " + food.getSugar() + "g";

        String[] mobileArray = {carbs, cholesterol, energy, fiber, lipid, protein, sugar};

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.food_predicted_list);
        listView.setAdapter(adapter);
    }
}
