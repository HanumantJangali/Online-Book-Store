package com.example.onlinebookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private EditText lemail,passw;
    private Button signIn;
    private Spinner spinner;
    private DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lemail = findViewById(R.id.lemail);
        passw = findViewById(R.id.password);
        signIn = findViewById(R.id.loginButton);

        myDB = new DatabaseHelper(this);
        loginUser();


    }
    private  void loginUser(){
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = lemail.getText().toString().trim();
                final String password = passw.getText().toString().trim();
                validate(username,password);
            }
        });
    }

    private void validate(String username, String password) {

        String mail_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(username.isEmpty() || password.isEmpty()){
            showMessage("Please fill all the details to login...");
            Intent in = new Intent(Login.this,Login.class);
            startActivity(in);
            return;
        }
        else if(!Pattern.compile(mail_pattern).matcher(username).matches()){
            showMessage("Please enter the valid Email Id....");

            Intent intent = new Intent(Login.this,Login.class);
            startActivity(intent);
            return;
        }
        else if(password.length() < 8){
            showMessage("Password length should be more than 8 charecters");

            Intent intent = new Intent(Login.this,Login.class);
            startActivity(intent);
            return;
        }


        boolean var = myDB.checkUser(lemail.getText().toString(),passw.getText().toString());
        if (var){
            Toast.makeText(Login.this,"User Login Successfully!!",Toast.LENGTH_LONG).show();
            startActivity(  new Intent(Login.this, MainActivity.class));
            finish();
        }else {
            Toast.makeText(Login.this,"Login Error!!",Toast.LENGTH_LONG).show();
        }

    }
    private void showMessage(String s) {
        Toast.makeText(Login.this, s, Toast.LENGTH_SHORT).show();
    }
}