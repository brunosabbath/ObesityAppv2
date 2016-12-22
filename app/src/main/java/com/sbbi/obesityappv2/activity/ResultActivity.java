package com.sbbi.obesityappv2.activity;

import android.content.Intent;
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
import com.sbbi.obesityappv2.model.bundle.BundleCorrectFood;
import com.sbbi.obesityappv2.recycleradapter.FoodPredictionRecyclerAdapter;
import com.sbbi.obesityappv2.request.SaveMeal;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements FoodInterf{

    private RecyclerView recyclerView;
    private FoodPredictionRecyclerAdapter foodAdapter;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private final int CODE = 1;
    private List<Food> listFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_result);
        setContentView(R.layout.activity_result);//new layout with CardView

        recyclerView = (RecyclerView) findViewById(R.id.foodPrediction);

        //mLayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(mLayoutManager);

        foodAdapter = new FoodPredictionRecyclerAdapter(new ArrayList<Food>(), this);
        recyclerView.setAdapter(foodAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Food f1 = new Food();
        f1.setName("Breakfast");

        Food f2 = new Food();
        f2.setName("pow");

        /*Food foods[] = new Food[2];
        foods[0] = f1;
        foods[1] = f2;*/

        listFood = new ArrayList<Food>();
        listFood.add(f1);
        listFood.add(f2);

        setLayoutAfterRequest(listFood);

        Bundle extras = getIntent().getExtras();
        //ClassificationReturn classification = (ClassificationReturn) extras.get("result");

        /*
        String food1[] = extras.getStringArray("food1");
        String food2[] = extras.getStringArray("food2");
        String food3[] = extras.getStringArray("food3");
        */
        //TextView textView = (TextView) findViewById(R.id.result);
        //textView.setText(str);

        String food1[] = {"Peach","Raspberry","Apple","Carrot","Test","Test","Test","Test","Test","Test","Test","Test","Test"};
        String food2[] = {"Pear","Banana","Orange","Chips","Test","Test","Test","Test","Test","Test","Test","Test","Test"};
        String food3[] = {"Rice","Sandwich bread","Grilled breast chicken","Test","Test","Test","Test","Test","Test","Test","Test","Test","Test"};

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.result_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.save_meal:
                Toast.makeText(getApplicationContext(), "button pressed", Toast.LENGTH_LONG).show();
                new SaveMeal().execute(listFood);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void startCorretPredictionActivity(Intent intent){
        startActivityForResult(intent, CODE);
    }

    @Override
    public void setLayoutAfterRequest(List<Food> listFood) {

        this.listFood = listFood;
        foodAdapter = new FoodPredictionRecyclerAdapter(listFood, this);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODE){
            if(resultCode == RESULT_OK){

                BundleCorrectFood bundle = (BundleCorrectFood) data.getExtras().getSerializable("myBundle");

                Food food = listFood.get(bundle.getPosition());
                food.setName(bundle.getName());

                listFood.get(bundle.getPosition()).setName(bundle.getName());

                setLayoutAfterRequest(listFood);

                Log.i("FOOD", bundle.getName() + " " + bundle.getPosition());
            }
        }
    }

}
