package com.sbbi.obesityappv2.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.error.EditTextError;
import com.sbbi.obesityappv2.helper.ConnectionHelper;
import com.sbbi.obesityappv2.helper.PasswordHelper;
import com.sbbi.obesityappv2.helper.VerifyHelper;
import com.sbbi.obesityappv2.interf.UserListener;
import com.sbbi.obesityappv2.model.User;
import com.sbbi.obesityappv2.request.LoginHttp;
import com.sbbi.obesityappv2.sqlite.ObesityDbDao;

public class LoginActivity extends AppCompatActivity implements UserListener, EditTextError {

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

                if(VerifyHelper.isValidEditText(email) && VerifyHelper.isValidEditText(password)){
                    String passwordStr = password.getText().toString().trim();

                    User user = new User();
                    user.setEmail(email.getText().toString().trim());
                    user.setPassword(PasswordHelper.securePassword(passwordStr));
                    callApi(user);
                }
                else{
                    showMandatoryFieldsMessage("All fields are required");
                }


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
        if(ConnectionHelper.isInternetAvailable(getApplicationContext())){
            new LoginHttp(this).execute(user);
        }
        else{
            Toast.makeText(getApplicationContext(), "No internet connectivity", Toast.LENGTH_LONG).show();
        }
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
            showUserNotFound();
        }else{
            insertUserIdDb(user);
            goToMainActivity();
        }

    }

    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.arg1 == 1)
                Toast.makeText(getApplicationContext(),"User not found", Toast.LENGTH_LONG).show();
        }
    };

    private void showUserNotFound() {
        //Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
        Message msg = handler.obtainMessage();
        msg.arg1 = 1;
        handler.sendMessage(msg);
    }

    @Override
    public void showMandatoryFieldsMessage(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}
