package com.sbbi.obesityappv2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.helper.ConnectionHelper;
import com.sbbi.obesityappv2.helper.GetUserIdHelper;
import com.sbbi.obesityappv2.helper.VerifyHelper;
import com.sbbi.obesityappv2.interf.FingerListener;
import com.sbbi.obesityappv2.request.HttpSaveFinger;

public class FingerActivity extends AppCompatActivity implements FingerListener {

    private Button btnSaveFinger;
    private EditText lengthEditText;
    private EditText widthEditText;
    private double length;
    private double width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger);

        btnSaveFinger = (Button) findViewById(R.id.save_finger);

        btnSaveFinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lengthEditText = (EditText) findViewById(R.id.finger_length_text);
                widthEditText = (EditText) findViewById(R.id.finger_width_text);

                String lengthStr = lengthEditText.getText().toString().trim();
                String widthStr = widthEditText.getText().toString().trim();

                if(!VerifyHelper.isValidText(lengthStr)|| !VerifyHelper.isValidText(widthStr)){
                    Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();
                }
                else{
                    length = Double.parseDouble(lengthStr);
                    width = Double.parseDouble(widthStr);
                    int userId = GetUserIdHelper.getUserId(getApplicationContext());

                    callApi(length, width, (double)userId);
                }

            }
        });
    }

    private void callApi(double length, double width, double userId) {

        if(ConnectionHelper.isInternetAvailable(getApplicationContext())){
            new HttpSaveFinger(this).execute(length, width, (double)userId);
        }
        else{
            Toast.makeText(getApplicationContext(), "No internet connectivity", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void info(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        finish();
    }
}