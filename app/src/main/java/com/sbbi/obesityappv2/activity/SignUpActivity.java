package com.sbbi.obesityappv2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sbbi.obesityappv2.R;
import com.sbbi.obesityappv2.error.EditTextError;
import com.sbbi.obesityappv2.helper.PasswordHelper;
import com.sbbi.obesityappv2.helper.VerifyHelper;
import com.sbbi.obesityappv2.interf.UserListener;
import com.sbbi.obesityappv2.model.User;
import com.sbbi.obesityappv2.request.SignUpHttp;
import com.sbbi.obesityappv2.sqlite.ObesityDbDao;

public class SignUpActivity extends AppCompatActivity implements UserListener, EditTextError {

    private EditText name;
    private EditText email;
    private EditText password;
    private Button signUp;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUp = (Button) findViewById(R.id.btn_signup);
        login = (Button) findViewById(R.id.link_login);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = (EditText) findViewById(R.id.input_email);
                password = (EditText) findViewById(R.id.input_password);
                name = (EditText) findViewById(R.id.input_name);

                if(VerifyHelper.isValidEditText(email) && VerifyHelper.isValidEditText(password) && VerifyHelper.isValidEditText(name)){

                    String passwordStr = password.getText().toString().trim();

                    User user = new User();
                    user.setName(name.getText().toString())
                            .setEmail(email.getText().toString())
                            .setPassword(PasswordHelper.securePassword(passwordStr));
                    callApi(user);
                }
                else{
                    showMandatoryFieldsMessage("All fields are required");
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnLogin();
            }
        });
    }

    private void callApi(User user) {
        new SignUpHttp(this).execute(user);
    }

    private void returnLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void userInfo(User user) {

        ObesityDbDao dao = new ObesityDbDao(this);
        if(dao.isEmpty()){
            dao.addUser(user);
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    @Override
    public void showMandatoryFieldsMessage(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}
