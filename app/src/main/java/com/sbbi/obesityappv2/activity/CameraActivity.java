package com.sbbi.obesityappv2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.camera.Camera2BasicFragment;

public class CameraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if (null == savedInstanceState) {
            Camera2BasicFragment camera2BasicFragment = Camera2BasicFragment.newInstance();
            Bundle extras = getIntent().getExtras();
            camera2BasicFragment.setPhotoPath(extras.getStringArray("photoPath"));
            camera2BasicFragment.setTypePhoto(extras.getInt("position"));
            getFragmentManager().beginTransaction().replace(R.id.container, camera2BasicFragment).commit();
        }
    }

}
