package com.sbbi.obesityappv2.activity;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.expandableListView.MyExpandableAdapter;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.FoodsWeightEstimation;
import com.sbbi.obesityappv2.model.Prediction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.R.id.list;

public class ResultNutrientActivity extends AppCompatActivity{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private FoodsWeightEstimation foodsWeightEstimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_nutrient);

        Bundle extras = getIntent().getExtras();
        foodsWeightEstimation = (FoodsWeightEstimation) extras.get("result");

        if(foodsWeightEstimation.getFood1() != null && foodsWeightEstimation.getFood2() != null && foodsWeightEstimation.getFood3() != null){
            listView = (ExpandableListView) findViewById(R.id.expandable_list);
            initData();
            listAdapter = new MyExpandableAdapter(this, listDataHeader, listHash);
            listView.setAdapter(listAdapter);
        }
        else{
            Toast.makeText(getApplicationContext(), "No foods logged for this meal", Toast.LENGTH_LONG).show();
        }

    }

    private void initData(){
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        Food food1 = foodsWeightEstimation.getFood1();
        Food food2 = foodsWeightEstimation.getFood2();
        Food food3 = foodsWeightEstimation.getFood3();

        listDataHeader.add(food1.getName());
        listDataHeader.add(food2.getName());
        listDataHeader.add(food3.getName());
        listDataHeader.add("Nutrient breakdown");


        List<String> food1List = new ArrayList<>();
        food1List.add("Grams: " + food1.getGrams() + " g");
        food1List.add("Calories: " + food1.getEnergy() + " kcal");
        food1List.add("Carbohydrates: " + food1.getCarbohydrate() + " g");
        food1List.add("Proteins: " + food1.getProtein() + " g");
        food1List.add("Sugars: " + food1.getSugar() + " g");

        List<String> food2List = new ArrayList<>();
        food2List.add("Grams: " + food2.getGrams() + " g");
        food2List.add("Calories: " + food2.getEnergy() + " kcal");
        food2List.add("Carbohydrates: " + food2.getCarbohydrate() + " g");
        food2List.add("Proteins: " + food2.getProtein() + " g");
        food2List.add("Sugars: " + food2.getSugar() + " g");

        List<String> food3List = new ArrayList<>();
        food3List.add("Grams: " + food3.getGrams() + " g");
        food3List.add("Calories: " + food3.getEnergy() + " kcal");
        food3List.add("Carbohydrates: " + food3.getCarbohydrate() + " g");
        food3List.add("Proteins: " + food3.getProtein() + " g");
        food3List.add("Sugars: " + food3.getSugar() + " g");

        double totalCalories = food1.getEnergy() + food2.getEnergy() + food3.getEnergy();
        double totalGrams = food1.getGrams() + food2.getGrams() + food3.getGrams();
        double totalCarbs = food1.getCarbohydrate() + food2.getCarbohydrate() + food3.getCarbohydrate();
        double totalProteins = food1.getProtein() + food2.getProtein() + food3.getProtein();
        double totalSugars = food1.getSugar() + food2.getSugar() + food3.getSugar();

        List<String> breakdownList = new ArrayList<>();
        breakdownList.add("Total calories: " + totalCalories + " kcal");
        breakdownList.add("Total grams: " + totalGrams + " g");
        breakdownList.add("Total carbohydrates: " + totalCarbs + " g");
        breakdownList.add("Total proteins: " + totalProteins + " g");
        breakdownList.add("Total sugars: " + totalSugars + " g");

        //higher in calories
        //higher in protein
        //higher in sugar
        //higher in carbs

        //percentage of each nutrient

        listHash.put(listDataHeader.get(0), food1List);
        listHash.put(listDataHeader.get(1), food2List);
        listHash.put(listDataHeader.get(2), food3List);
        listHash.put(listDataHeader.get(3), breakdownList);
    }

}