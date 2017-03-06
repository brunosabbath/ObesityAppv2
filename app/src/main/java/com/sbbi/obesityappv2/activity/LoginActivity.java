package com.sbbi.obesityappv2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.interf.UserListener;
import com.sbbi.obesityappv2.model.User;
import com.sbbi.obesityappv2.request.LoginHttp;
import com.sbbi.obesityappv2.sqlite.ObesityDbDao;

public class LoginActivity extends AppCompatActivity implements UserListener {

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

        if(isLoggedIn()){
            goToMainActivity();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = (EditText) findViewById(R.id.input_email);
                password = (EditText) findViewById(R.id.input_password);

                User user = new User();
                user.setEmail(email.getText().toString().trim());
                user.setPassword(password.getText().toString().trim());
                callApi(user);

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignup();
            }
        });

    }

    private void callApi(User user) {
        new LoginHttp(this).execute(user);
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

    @Override
    public void userInfo(User user) {

        if(user == null){
            Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
        }else{
            insertUserIdDb(user);
            goToMainActivity();
        }

    }
}
