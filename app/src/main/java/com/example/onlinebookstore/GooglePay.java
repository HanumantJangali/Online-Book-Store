package com.example.onlinebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GooglePay extends AppCompatActivity {

    TextView amount;
    Button googlePay;

    String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_pay);
        googlePay=findViewById(R.id.payButton);

        Bundle i = getIntent().getExtras();
        price = i.getString("pprice");

        amount = findViewById(R.id.amount);

        amount.setText(price);


        googlePay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GooglePay.this,"Payment Successful for Your Ordered Book through Google Pay",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(GooglePay.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}