package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sbbi.obesityappv2.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        //ClassificationReturn classification = (ClassificationReturn) extras.get("result");

        String str[] = extras.getStringArray("result");

        //TextView textView = (TextView) findViewById(R.id.result);
        //textView.setText(str);

        buildFood1(str);

    }

    private void buildFood1(String result[]) {

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
}
