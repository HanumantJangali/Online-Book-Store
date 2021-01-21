package com.example.onlinebookstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.onlinebookstore.horizontaladapter.HorizontalAdapter;
import com.example.onlinebookstore.horizontalmodel.HorizontalModel;
import com.example.onlinebookstore.listmodel.ListModel;

public class MainActivity extends AppCompatActivity {

    protected static HorizontalModel[] horizontalModels;
    CardView cardView;
    ImageButton moreCrime, moreHistory;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = findViewById(R.id.flipperId);
        viewFlipper.startFlipping();
        cardView = findViewById(R.id.cardView);

        moreCrime = findViewById(R.id.moreCrime);
        moreHistory = findViewById(R.id.moreHistory);

        moreCrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookList.class);
                startActivity(intent);
            }
        });

        HorizontalModel[] horizontalModels = new HorizontalModel[]{
                new HorizontalModel(R.drawable.criminalmanual,"Criminal Manual","500.00","Crime Book"),
                new HorizontalModel(R.drawable.blackseconds,"Black Seconds", "250.16","Crime Book"),
                new HorizontalModel(R.drawable.faceofevil,"Face of Evil","285.84","Crime Book"),
                new HorizontalModel(R.drawable.thedrownedboy,"The Drowned Boy","250.16","Crime Book"),
                new HorizontalModel(R.drawable.thewatersedge,"The Water's Edge","316.36","Crime Book"),
                new HorizontalModel(R.drawable.walkthewire,"Walk the Wire","400.00","Crime Book"),
                new HorizontalModel(R.drawable.whisperer,"The Whisperer","350.40","Crime Book"),
                new HorizontalModel(R.drawable.devilanddarkwater,"The Devil and The Dark Water","279.50","Crime Book")

        };
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(horizontalModels);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(horizontalAdapter);


        moreHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Second_Book_List.class);
                startActivity(intent);
            }
        });

        HorizontalModel[] horizontalModels1 = new HorizontalModel[]{
                new HorizontalModel(R.drawable.britishinindia, "The British in India ", "495.90","Historical Book"),
                new HorizontalModel(R.drawable.earlyindia, "Early India", "198.01","Historical Book"),
                new HorizontalModel(R.drawable.heroandvillainsofhistory, "Heroes and Villains of History", "580.78","Historical Book"),
                new HorizontalModel(R.drawable.inventinghumanrights, "Inventing Human Rights", "689.74","Historical Book"),
                new HorizontalModel(R.drawable.firstworldwar, "The First World War ", "309.31","Historical Book"),
                new HorizontalModel(R.drawable.secondworldwar, "The Second World War", "560.12","Historical Book"),
                new HorizontalModel(R.drawable.silkroads, "THe Silk Roads", "301.77","Historical Book"),

        };
        RecyclerView recyclerView1 = findViewById(R.id.recycleView1);
        HorizontalAdapter horizontalAdapter1 = new HorizontalAdapter(horizontalModels1);
        recyclerView1.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        recyclerView1.setAdapter(horizontalAdapter1);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(this);
        alertDialogbuilder.setTitle("Exit this app...?");
        alertDialogbuilder.setIcon(R.drawable.ic_exit_to_app_black_24dp);
        alertDialogbuilder.setMessage("Are you sure you want to exit the app..?");
        alertDialogbuilder.setCancelable(false);
        alertDialogbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        alertDialogbuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "App not exiting", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogbuilder.create();
        alertDialog.show();
    }
}


