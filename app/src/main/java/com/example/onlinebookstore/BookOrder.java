package com.example.onlinebookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookOrder extends AppCompatActivity {
    public static Object selecteditems;
    CardView cardView2;
    ImageView image;
    TextView bookName,bookPrice,bookCategory;
    Button cartButton,buyButton;

    int img;
    String name;
    String price;
    String category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_order);
        getSupportActionBar().setTitle("Online Book Store");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


       Bundle i = getIntent().getExtras();

        name = i.getString("iname");
        img = i.getInt("iimage");
        price = i.getString("iprice");
        category =  i.getString("icategory");



        bookName = findViewById(R.id.bookname);
        bookPrice =findViewById(R.id.bookprice);
        bookCategory = findViewById(R.id.bookcategory);
        cardView2 =findViewById(R.id.cardView2);
        image = findViewById(R.id.image);
        buyButton = findViewById(R.id.buyButton);
        cartButton = findViewById(R.id.cartButton);



        bookName.setText(name);
        image.setImageResource(img);
        bookPrice.setText(price);
        bookCategory.setText(category);


        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookOrder.this,"Complete Payment to Order your Book  ",Toast.LENGTH_LONG).show();
                String iprice = bookPrice.getText().toString();

                Intent intent = new Intent(BookOrder.this,Payment.class);
                intent.putExtra("price",iprice);
                startActivity(intent);
            }
        });

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookOrder.this,"Your Book is added to Cart ",Toast.LENGTH_LONG).show();

            }
        });

    }

}