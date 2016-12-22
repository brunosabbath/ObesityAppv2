package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sbbi.obesityappv2.R;

public class CorrectPrediction extends AppCompatActivity {

    private String[] mobileArray = {"rice","beans","chicken","blah"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_prediction);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.food_predicted_list);
        listView.setAdapter(adapter);
    }
}
