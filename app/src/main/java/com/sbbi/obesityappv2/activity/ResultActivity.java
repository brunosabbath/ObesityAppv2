package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.model.ClassificationReturn;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        //ClassificationReturn classification = (ClassificationReturn) extras.get("result");

        String str = (String) extras.get("result");

        TextView textView = (TextView) findViewById(R.id.result);
        textView.setText(str);

    }
}
