package com.sbbi.obesityappv2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.model.User;
import com.sbbi.obesityappv2.sqlite.ObesityDbDao;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_login);

        login = (Button) findViewById(R.id.btn_login);
        signUp = (Button) findViewById(R.id.link_signup);

        /*if(isLoggedIn()){
            goToMainActivity();
        }*/

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = (EditText) findViewById(R.id.input_email);
                password = (EditText) findViewById(R.id.input_password);
                //TODO call HTTP to do login
                int userId = 0;
                //insertUserIdDb(user);
                //goToMainActivity();

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignup();

            }
        });

    }

    private void goToSignup() {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }

    private boolean isLoggedIn() {
        boolean logged = false;

        ObesityDbDao dao = new ObesityDbDao(this);
        User user = dao.getUser();

        if(user != null){
            logged = true;
        }

        return logged;
    }

    private void goToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    private void insertUserIdDb(User user){
        ObesityDbDao dao = new ObesityDbDao(this);
        dao.addUser(user);
    }
}
