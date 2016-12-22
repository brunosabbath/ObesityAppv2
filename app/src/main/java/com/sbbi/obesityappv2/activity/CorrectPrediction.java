package com.sbbi.obesityappv2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.model.bundle.BundleCorrectFood;

public class CorrectPrediction extends AppCompatActivity {

    private String[] mobileArray = {"rice","beans","chicken","blah"};
    private final int CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_prediction);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview, mobileArray);

        final ListView listView = (ListView) findViewById(R.id.food_predicted_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String foodName = listView.getItemAtPosition(position).toString();

                BundleCorrectFood myBundle = (BundleCorrectFood) getIntent().getExtras().getSerializable("myBundle");

                myBundle.setName(foodName);

                Intent intent = new Intent();
                intent.putExtra("myBundle", myBundle);

                setResult(RESULT_OK, intent);
                finish();
                //Toast.makeText(parent.getContext(), item, Toast.LENGTH_LONG).show();
            }
        });

    }
}
