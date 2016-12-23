package com.sbbi.obesityappv2.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.model.ResponseFood;
import com.sbbi.obesityappv2.model.SendMeal;
import com.sbbi.obesityappv2.model.bundle.BundleCorrectFood;
import com.sbbi.obesityappv2.recycleradapter.FoodPredictionRecyclerAdapter;
import com.sbbi.obesityappv2.request.SaveMeal;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements FoodInterf {

    private RecyclerView recyclerView;
    private FoodPredictionRecyclerAdapter foodAdapter;
    private final int CODE = 1;
    private final int TOTAL_FOOD = 13;
    private List<Food> listFood;
    private List<Number> listWeight;
    private List<String> listpredictedFood1;
    private List<String> listpredictedFood2;
    private List<String> listpredictedFood3;
    private List<List<String>> listAllpredictedFood;
    private ResponseFood responseFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_result);
        setContentView(R.layout.activity_result);//new layout with CardView

        Bundle extras = getIntent().getExtras();
        responseFood = (ResponseFood) extras.get("result");

        recyclerView = (RecyclerView) findViewById(R.id.foodPrediction);

        //mLayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(mLayoutManager);

        Food food1 = new Food();
        food1.setName(responseFood.getFood1()[0]);

        Food food2 = new Food();
        food2.setName(responseFood.getFood2()[0]);

        Food food3 = new Food();
        food3.setName(responseFood.getFood3()[0]);

        listFood = new ArrayList<Food>();
        listFood.add(food1);
        listFood.add(food2);
        listFood.add(food3);

        listWeight = new ArrayList<Number>();
        listWeight.add(responseFood.getWeightFood1());
        listWeight.add(responseFood.getWeightFood2());
        listWeight.add(responseFood.getWeightFood3());

        listpredictedFood1 = new ArrayList<String>();
        listpredictedFood2 = new ArrayList<String>();
        listpredictedFood3 = new ArrayList<String>();

        for(int i = 0; i < TOTAL_FOOD; i++){
            listpredictedFood1.add(responseFood.getFood1()[i]);
            listpredictedFood2.add(responseFood.getFood2()[i]);
            listpredictedFood3.add(responseFood.getFood3()[i]);
        }

        listAllpredictedFood = new ArrayList<List<String>>();
        listAllpredictedFood.add(listpredictedFood1);
        listAllpredictedFood.add(listpredictedFood2);
        listAllpredictedFood.add(listpredictedFood3);

        foodAdapter = new FoodPredictionRecyclerAdapter(listFood, listWeight, listAllpredictedFood, this);
        //foodAdapter = new FoodPredictionRecyclerAdapter(new ArrayList<Food>(), this);
        //foodAdapter = new FoodPredictionRecyclerAdapter(responseFood, this);
        recyclerView.setAdapter(foodAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*Food f1 = new Food();
        f1.setName("Breakfast");

        Food f2 = new Food();
        f2.setName("pow");

        listFood = new ArrayList<Food>();
        listFood.add(f1);
        listFood.add(f2);

        setLayoutAfterRequest(listFood);*/

        //ClassificationReturn classification = (ClassificationReturn) extras.get("result");

        /*
        String food1[] = extras.getStringArray("food1");
        String food2[] = extras.getStringArray("food2");
        String food3[] = extras.getStringArray("food3");
        */
        //TextView textView = (TextView) findViewById(R.id.result);
        //textView.setText(str);

        /*String food1[] = {"Peach","Raspberry","Apple","Carrot","Test","Test","Test","Test","Test","Test","Test","Test","Test"};
        String food2[] = {"Pear","Banana","Orange","Chips","Test","Test","Test","Test","Test","Test","Test","Test","Test"};
        String food3[] = {"Rice","Sandwich bread","Grilled breast chicken","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test"};*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.result_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.save_meal:
                Toast.makeText(getApplicationContext(), "button pressed", Toast.LENGTH_LONG).show();

                //new SaveMeal().execute(listFood);

                SendMeal sendMeal = makeSendMeal(responseFood);
                new SaveMeal().execute(sendMeal);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private SendMeal makeSendMeal(ResponseFood responseFood) {

        SendMeal meal = new SendMeal();

        meal.setFood1(responseFood.getFood1()[0]);
        meal.setFood2(responseFood.getFood2()[0]);
        meal.setFood3(responseFood.getFood3()[0]);
        meal.setWeightFood1(responseFood.getWeightFood1());
        meal.setWeightFood2(responseFood.getWeightFood2());
        meal.setWeightFood3(responseFood.getWeightFood3());
        meal.setNutrients1(responseFood.getNutrientsFood1());
        meal.setNutrients2(responseFood.getNutrientsFood2());
        meal.setNutrients3(responseFood.getNutrientsFood3());

        if (responseFood.getFood1() == null) {
            meal.setNutrients1(null);
            meal.setWeightFood1(0);
            meal.setFood1(null);
        } else if (responseFood.getFood2() == null) {
            meal.setNutrients2(null);
            meal.setWeightFood2(0);
            meal.setFood2(null);
        } else if (responseFood.getFood2() == null) {
            meal.setNutrients3(null);
            meal.setWeightFood3(0);
            meal.setFood3(null);
        }

        return meal;
    }

    public void startCorretPredictionActivity(Intent intent) {
        startActivityForResult(intent, CODE);
    }

    @Override
    public void setLayoutAfterRequest(List<Food> listFood) {
    //public void setLayoutAfterRequest(ResponseFood responseFood) {

        /*this.listFood = new ArrayList<Food>();
        this.listFood.add(responseFood.getNutrientsFood1());
        this.listFood.add(responseFood.getNutrientsFood2());
        this.listFood.add(responseFood.getNutrientsFood3());*/

        this.listFood = listFood;
        foodAdapter = new FoodPredictionRecyclerAdapter(listFood, this);
        //foodAdapter = new FoodPredictionRecyclerAdapter(responseFood, this);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE) {
            if (resultCode == RESULT_OK) {

                BundleCorrectFood bundle = (BundleCorrectFood) data.getExtras().getSerializable("myBundle");

                Food food = listFood.get(bundle.getPosition());
                food.setName(bundle.getName());

                listFood.get(bundle.getPosition()).setName(bundle.getName());

                //setLayoutAfterRequest(responseFood);
                setLayoutAfterRequest(listFood);

                Log.i("FOOD", bundle.getName() + " " + bundle.getPosition());
            }
        }
    }

}
