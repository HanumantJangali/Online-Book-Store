package com.example.onlinebookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onlinebookstore.horizontaladapter.HorizontalAdapter;
import com.example.onlinebookstore.horizontalmodel.HorizontalModel;
import com.example.onlinebookstore.listadapter.ListAdapter;
import com.example.onlinebookstore.listmodel.ListModel;

public class BookList  extends AppCompatActivity {

    CardView cardView1;
    Button buyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        getSupportActionBar().setTitle("Online Book Store");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        buyButton = findViewById(R.id.buyButton);
        cardView1 = findViewById(R.id.cardView1);


        ListModel[] listModels =new ListModel[]{
                new ListModel(R.drawable.criminalmanual,"Criminal Manual","500.00","Crime Book"),
                new ListModel(R.drawable.blackseconds,"Black Seconds", "250.16","Crime Book"),
                new ListModel(R.drawable.faceofevil,"Face of Evil","285.84","Crime Book"),
                new ListModel(R.drawable.thedrownedboy,"The Drowned Boy","250.16","Crime Book"),
                new ListModel(R.drawable.thewatersedge,"The Water's Edge","316.36","Crime Book"),
                new ListModel(R.drawable.walkthewire,"Walk the Wire","400.00","Crime Book"),
                new ListModel(R.drawable.whisperer,"The Whisperer","350.40","Crime Book"),
                new ListModel(R.drawable.devilanddarkwater,"The Devil and The Dark Water","279.50","Crime Book")

    };

        RecyclerView recyclerView = findViewById(R.id.recycleView2);
        ListAdapter listAdapter = new ListAdapter(listModels);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listAdapter);

    }
}