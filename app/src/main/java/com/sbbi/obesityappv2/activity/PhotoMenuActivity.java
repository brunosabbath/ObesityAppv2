package com.sbbi.obesityappv2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.interf.ClassificationInterf;
import com.sbbi.obesityappv2.model.ResponseFoodName;
import com.sbbi.obesityappv2.request.UploadImages;

/**
 * Created by bsilva on 10/20/16.
 */
public class PhotoMenuActivity extends AppCompatActivity implements ClassificationInterf{

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

        //API CALL
        //new UploadImages(this).execute(paths);
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void photoTopClick(View view){
        //paths[TOP] = "top";
        /*Camera2BasicFragment camera2BasicFragment = Camera2BasicFragment.newInstance();
        camera2BasicFragment.setPhotoPath(paths);
        camera2BasicFragment.setTypePhoto(0);
        getFragmentManager().beginTransaction().replace(R.id.photo, Camera2BasicFragment.newInstance()).commit();*/
        //new Camera2BasicFragment();
        Intent intent = new Intent(this, CameraActivity.class);
        Bundle extras = new Bundle();
        extras.putStringArray("photoPath", paths);
        extras.putInt("position", 0);
        intent.putExtras(extras);
        startActivity(intent);

    }

    public void photoSide1Click(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        Bundle extras = new Bundle();
        extras.putStringArray("photoPath", paths);
        extras.putInt("position", 1);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void photoSide2Click(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        Bundle extras = new Bundle();
        extras.putStringArray("photoPath", paths);
        extras.putInt("position", 2);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void photoSide3Click(View view){
        Intent intent = new Intent(this, CameraActivity.class);
        Bundle extras = new Bundle();
        extras.putStringArray("photoPath", paths);
        extras.putInt("position", 3);
        intent.putExtras(extras);
        startActivity(intent);

    }

    @Override
    public void sendToResultScreen(ResponseFoodName responseFoodName) {
        Intent intent = new Intent(this, ResultActivity.class);
        Bundle extras = new Bundle();
        //extras.putSerializable("result",classificationReturn);
        //extras.putString("result", classificationReturn.getFood1Str());
        extras.putStringArray("food1", responseFoodName.getFood1());
        extras.putStringArray("food2", responseFoodName.getFood2());
        extras.putStringArray("food3", responseFoodName.getFood3());
        intent.putExtras(extras);

        startActivity(intent);
    }
}
