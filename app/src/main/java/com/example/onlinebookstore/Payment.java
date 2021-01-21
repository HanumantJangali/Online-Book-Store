package com.example.onlinebookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    TextView bookPrice;
    String iprice;
    CardView googlePayView,creditCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        googlePayView = findViewById(R.id.googlePay);
        creditCardView = findViewById(R.id.creditCard);

        Bundle i = getIntent().getExtras();
        iprice = i.getString("price");


        bookPrice = findViewById(R.id.bookAmount);
        bookPrice.setText(iprice);

        googlePayView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gprice = bookPrice.getText().toString();
                Intent intent = new Intent(Payment.this,GooglePay.class);
                intent.putExtra("pprice",gprice);
                startActivity(intent);

                Toast.makeText(Payment.this,"Fill all detail to complete your Payment ",Toast.LENGTH_LONG).show();


            }
        });

        creditCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cprice = bookPrice.getText().toString();
                Intent in = new Intent(Payment.this,CreditCard.class);
                in.putExtra("Pprice",cprice);
                startActivity(in);
                Toast.makeText(Payment.this,"Fill all detail to complete your Payment ",Toast.LENGTH_LONG).show();

            }
        });
    }
}