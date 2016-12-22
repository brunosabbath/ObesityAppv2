package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.interf.FoodInterf;
import com.sbbi.obesityappv2.model.Food;
import com.sbbi.obesityappv2.recycleradapter.FoodPredictionRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements FoodInterf{

    private RecyclerView recyclerView;
    private FoodPredictionRecyclerAdapter foodAdapter;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_result);
        setContentView(R.layout.activity_result2);//new layout with CardView

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

        List<Food> listFood = new ArrayList<Food>();
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

        //buildFood1(food1);
        //buildFood2(food2);
        //buildFood3(food3);

    }

    private void buildFood3(String[] result) {
        TextView textView1 = (TextView) findViewById(R.id.f3btn1);
        textView1.setText(result[0]);

        TextView textView2 = (TextView) findViewById(R.id.f3btn2);
        textView2.setText(result[1]);

        TextView textView3 = (TextView) findViewById(R.id.f3btn3);
        textView3.setText(result[2]);

        TextView textView4 = (TextView) findViewById(R.id.f3btn4);
        textView4.setText(result[3]);

        TextView textView5 = (TextView) findViewById(R.id.f3btn5);
        textView5.setText(result[4]);

        TextView textView6 = (TextView) findViewById(R.id.f3btn6);
        textView6.setText(result[5]);

        TextView textView7 = (TextView) findViewById(R.id.f3btn7);
        textView7.setText(result[6]);

        TextView textView8 = (TextView) findViewById(R.id.f3btn8);
        textView8.setText(result[7]);

        TextView textView9 = (TextView) findViewById(R.id.f3btn9);
        textView9.setText(result[8]);

        TextView textView10 = (TextView) findViewById(R.id.f3btn10);
        textView10.setText(result[9]);

        TextView textView11 = (TextView) findViewById(R.id.f3btn11);
        textView11.setText(result[10]);

        TextView textView12 = (TextView) findViewById(R.id.f3btn12);
        textView12.setText(result[11]);

        TextView textView13 = (TextView) findViewById(R.id.f3btn13);
        textView13.setText(result[12]);

    }

    private void buildFood2(String[] result) {
        TextView textView1 = (TextView) findViewById(R.id.f2btn1);
        textView1.setText(result[0]);

        TextView textView2 = (TextView) findViewById(R.id.f2btn2);
        textView2.setText(result[1]);

        TextView textView3 = (TextView) findViewById(R.id.f2btn3);
        textView3.setText(result[2]);

        TextView textView4 = (TextView) findViewById(R.id.f2btn4);
        textView4.setText(result[3]);

        TextView textView5 = (TextView) findViewById(R.id.f2btn5);
        textView5.setText(result[4]);

        TextView textView6 = (TextView) findViewById(R.id.f2btn6);
        textView6.setText(result[5]);

        TextView textView7 = (TextView) findViewById(R.id.f2btn7);
        textView7.setText(result[6]);

        TextView textView8 = (TextView) findViewById(R.id.f2btn8);
        textView8.setText(result[7]);

        TextView textView9 = (TextView) findViewById(R.id.f2btn9);
        textView9.setText(result[8]);

        TextView textView10 = (TextView) findViewById(R.id.f2btn10);
        textView10.setText(result[9]);

        TextView textView11 = (TextView) findViewById(R.id.f2btn11);
        textView11.setText(result[10]);

        TextView textView12 = (TextView) findViewById(R.id.f2btn12);
        textView12.setText(result[11]);

        TextView textView13 = (TextView) findViewById(R.id.f2btn13);
        textView13.setText(result[12]);
    }

    private void buildFood1(String[] result) {

        TextView textView1 = (TextView) findViewById(R.id.f1btn1);
        textView1.setText(result[0]);

        TextView textView2 = (TextView) findViewById(R.id.f1btn2);
        textView2.setText(result[1]);

        TextView textView3 = (TextView) findViewById(R.id.f1btn3);
        textView3.setText(result[2]);

        TextView textView4 = (TextView) findViewById(R.id.f1btn4);
        textView4.setText(result[3]);

        TextView textView5 = (TextView) findViewById(R.id.f1btn5);
        textView5.setText(result[4]);

        TextView textView6 = (TextView) findViewById(R.id.f1btn6);
        textView6.setText(result[5]);

        TextView textView7 = (TextView) findViewById(R.id.f1btn7);
        textView7.setText(result[6]);

        TextView textView8 = (TextView) findViewById(R.id.f1btn8);
        textView8.setText(result[7]);

        TextView textView9 = (TextView) findViewById(R.id.f1btn9);
        textView9.setText(result[8]);

        TextView textView10 = (TextView) findViewById(R.id.f1btn10);
        textView10.setText(result[9]);

        TextView textView11 = (TextView) findViewById(R.id.f1btn11);
        textView11.setText(result[10]);

        TextView textView12 = (TextView) findViewById(R.id.f1btn12);
        textView12.setText(result[11]);

        TextView textView13 = (TextView) findViewById(R.id.f1btn13);
        textView13.setText(result[12]);

    }

    @Override
    public void setLayoutAfterRequest(List<Food> listFood) {

        foodAdapter = new FoodPredictionRecyclerAdapter(listFood, this);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
