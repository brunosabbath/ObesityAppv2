package com.sbbi.obesityappv2.activity;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.camera.Camera2BasicFragment;
import com.sbbi.obesityappv2.fragment.TestFragment;
import com.sbbi.obesityappv2.request.UploadImages;

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

        Bundle extras = getIntent().getExtras();
        paths = new String[4];

        if(extras != null){
            paths = extras.getStringArray("photoPath");
        }


        setContentView(R.layout.activity_photo_menu);

    }

    public void analyzeOnClick(View view){
        //Toast.makeText(this,paths[0] + "\n" + paths[1] + "\n" + paths[2] + "\n" + paths[3], Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "ahsdkjshd", Toast.LENGTH_SHORT).show();
        new UploadImages().execute(paths);
    }

    public void photoTopClick(View view){
        //paths[TOP] = "top";
        /*Camera2BasicFragment camera2BasicFragment = Camera2BasicFragment.newInstance();
        camera2BasicFragment.setPhotoPath(paths);
        camera2BasicFragment.setTypePhoto(0);
        getFragmentManager().beginTransaction().replace(R.id.photo, Camera2BasicFragment.newInstance()).commit();*/
        //new Camera2BasicFragment();

        startActivity((new Intent(this, CameraActivity.class)));

    }

    public void photoSide1Click(View view){
        //paths[SIDE_1] = "SIDE1";
        //getFragmentManager().beginTransaction().replace(R.id.photo, TestFragment.newInstance()).commit();
        Camera2BasicFragment camera2BasicFragment = Camera2BasicFragment.newInstance();
        camera2BasicFragment.setPhotoPath(paths);
        camera2BasicFragment.setTypePhoto(1);
        getFragmentManager().beginTransaction().replace(R.id.photo, Camera2BasicFragment.newInstance()).commit();
    }

    public void photoSide2Click(View view){
        paths[SIDE_2] = "side2";
        Camera2BasicFragment camera2BasicFragment = Camera2BasicFragment.newInstance();
        camera2BasicFragment.setPhotoPath(paths);
        camera2BasicFragment.setTypePhoto(2);
        getFragmentManager().beginTransaction().replace(R.id.photo, Camera2BasicFragment.newInstance()).commit();
    }

    public void photoSide3Click(View view){
        paths[SIDE_3] = "SIDE3";

        Camera2BasicFragment camera2BasicFragment = Camera2BasicFragment.newInstance();
        camera2BasicFragment.setPhotoPath(paths);
        camera2BasicFragment.setTypePhoto(3);
        getFragmentManager().beginTransaction().replace(R.id.photo, camera2BasicFragment).commit();

    }

}
