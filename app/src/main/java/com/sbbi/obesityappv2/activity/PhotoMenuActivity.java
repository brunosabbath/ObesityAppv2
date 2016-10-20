package com.sbbi.obesityappv2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.camera.Camera2BasicFragment;
import com.sbbi.obesityappv2.fragment.TestFragment;

/**
 * Created by bsilva on 10/20/16.
 */
public class PhotoMenuActivity extends AppCompatActivity{

    private final int TOP = 0;
    private final int SIDE_1 = 1;
    private final int SIDE_2 = 2;
    private final int SIDE_3 = 3;
    private String paths[];

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        paths = new String[4];
        setContentView(R.layout.activity_photo_menu);

    }

    public void analyzeOnClick(View view){
        Toast.makeText(this,paths[0] + paths[1] + paths[2] + paths[3], Toast.LENGTH_SHORT).show();
    }

    public void photoTopClick(View view){
        //paths[TOP] = "top";
        getFragmentManager().beginTransaction().replace(R.id.photo, Camera2BasicFragment.newInstance()).commit();
        //new Camera2BasicFragment();
    }

    public void photoSide1Click(View view){
        //paths[SIDE_1] = "SIDE1";
        getFragmentManager().beginTransaction().replace(R.id.photo, TestFragment.newInstance()).commit();
    }

    public void photoSide2Click(View view){
        paths[SIDE_2] = "side2";
    }

    public void photoSide3Click(View view){
        paths[SIDE_3] = "SIDE3";
    }

}
