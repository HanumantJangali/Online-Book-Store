package com.example.onlinebookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.onlinebookstore.horizontalmodel.HorizontalModel;
import com.example.onlinebookstore.listadapter.ListAdapter;
import com.example.onlinebookstore.listadapter.ListAdapter1;
import com.example.onlinebookstore.listmodel.ListModel;
import com.example.onlinebookstore.listmodel.ListModel1;

public class Second_Book_List extends AppCompatActivity {
    CardView cardView1;
    Button buyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__book__list);
        buyButton = findViewById(R.id.buyButton);
        cardView1 = findViewById(R.id.cardView1);


        ListModel1[] listModels1 =new ListModel1[]{
                new ListModel1(R.drawable.britishinindia, "The British in India ", "495.90","Historical Book"),
                new ListModel1(R.drawable.earlyindia, "Early India", "198.01","Historical Book"),
                new ListModel1(R.drawable.heroandvillainsofhistory, "Heroes and Villains of History", "580.78","Historical Book"),
                new ListModel1(R.drawable.inventinghumanrights, "Inventing Human Rights", "689.74","Historical Book"),
                new ListModel1(R.drawable.firstworldwar, "The First World War ", "309.31","Historical Book"),
                new ListModel1(R.drawable.secondworldwar, "The Second World War", "560.12","Historical Book"),
                new ListModel1(R.drawable.silkroads, "THe Silk Roads", "301.77","Historical Book"),

        };

        RecyclerView recyclerView2 = findViewById(R.id.recycleView3);
        ListAdapter1 listAdapter = new ListAdapter1(listModels1);
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setAdapter(listAdapter);

    }
}