package com.example.onlinebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private EditText username,email,password;
    private Button signIn,signUp;
    private Spinner spinner1;
    private DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.loginButton);
        signUp = findViewById(R.id.registerButton);


        myDB = new DatabaseHelper(this);
        insertUser();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }
    public void insertUser(){
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String item = spinner1.getSelectedItem().toString();
                final String susername = username.getText().toString().trim();
                final String semail = email.getText().toString().trim();
                final String spassw = password.getText().toString().trim();
                validate(susername,semail,spassw);

            }
        });
    }

    private void validate(String susername, String semail, String spassw) {
        String username_pattern = "^[a-z]+$";
        String email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(susername.isEmpty() || semail.isEmpty() || spassw.isEmpty()){
            showMessage("Please fill all the fields");

            Intent intent = new Intent(Register.this,Register.class);
            startActivity(intent);
            return;
        }
        else if(!Pattern.compile(username_pattern).matcher(susername).matches()){
            showMessage("Please Enter a valid Username");
            Intent intent = new Intent(Register.this,Register.class);
            startActivity(intent);
            return;
        }
        else if(!Pattern.compile(email_pattern).matcher(semail).matches()){
            showMessage("Please Enter a valid Email Id");
            Intent intent = new Intent(Register.this,Register.class);
            startActivity(intent);
            return;
        }
        else if(spassw.length() < 8 ) {
            showMessage("Password length should be alteast 8 charecters");

            Intent intent = new Intent(Register.this,Register.class);
            startActivity(intent);
            return;
        }


        boolean var = myDB.registerUser(username.getText().toString(),email.getText().toString(),password.getText().toString());
        if (var){
            Toast.makeText(Register.this,"User Registered Successfully!!",Toast.LENGTH_LONG).show();
            startActivity(  new Intent(Register.this, MainActivity.class));
            finish();
        }else {
            Toast.makeText(Register.this,"Registration Error!!",Toast.LENGTH_LONG).show();
        }
    }
    private void showMessage(String str) {
        Toast.makeText(Register.this, str, Toast.LENGTH_SHORT).show();
    }
}
