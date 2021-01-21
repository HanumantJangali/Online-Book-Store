package com.example.onlinebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreditCard extends AppCompatActivity {
    TextView amount;
    Button creditPay;
    String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);
        creditPay =findViewById(R.id.creditpayButton);
        Bundle i = getIntent().getExtras();
        price = i.getString("Pprice");

        amount = findViewById(R.id.price);

        amount.setText(price);




        creditPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreditCard.this,"Payment Successful for Your Ordered Book through Credit Card Method",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CreditCard.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}