package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.interf.ReturnInsightListener;
import com.sbbi.obesityappv2.request.InsightHttp;

import java.util.List;

public class InsightActivity extends AppCompatActivity implements ReturnInsightListener{

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insight);

        Bundle extras = getIntent().getExtras();
        int userId = extras.getInt("userId");
        int caloriesBurned = extras.getInt("caloriesBurned");

        text = (TextView) findViewById(R.id.insight);

        callApi(userId, caloriesBurned);

    }

    private void callApi(int userId, int caloriesBurned) {

        new InsightHttp(this).execute(userId, caloriesBurned);

    }

    @Override
    public void setResult(List<String> insights) {
        String finalText = "";

        for(String str : insights){
            finalText = finalText + str + "\n";
        }

        text.setText(finalText);
    }
}
