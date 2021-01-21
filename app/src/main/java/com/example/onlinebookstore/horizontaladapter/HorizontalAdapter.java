package com.example.onlinebookstore.horizontaladapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinebookstore.BookOrder;
import com.example.onlinebookstore.MainActivity;
import com.example.onlinebookstore.R;
import com.example.onlinebookstore.horizontalmodel.HorizontalModel;

public class HorizontalAdapter  extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {
   HorizontalModel[] horizontalModel;


    public HorizontalAdapter(HorizontalModel[] horizontalModel) {
        this.horizontalModel = horizontalModel;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.book_slide,null,false);
        HorizontalViewHolder viewHolder = new HorizontalViewHolder(item);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        holder.imageView.setImageResource(horizontalModel[position].getImgId());
        holder.name.setText(horizontalModel[position].getName());
        holder.price.setText(horizontalModel[position].getPrice());
        holder.category.setText(horizontalModel[position].getCategory());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),BookOrder.class);

                i.putExtra("iimage",horizontalModel[position].getImgId());
                i.putExtra("iname",horizontalModel[position].getName());
                i.putExtra("iprice",horizontalModel[position].getPrice());
                i.putExtra("icategory",horizontalModel[position].getCategory());
                view.getContext().startActivity(i);

                Toast.makeText(view.getContext(),"Clicked on your Book: ",Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return horizontalModel.length;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
       ImageView imageView;
       TextView name;
       TextView price;
       TextView category;
       CardView cardView;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView =itemView.findViewById(R.id.imageView);
            this.name = itemView.findViewById(R.id.bookname);
            this.price = itemView.findViewById(R.id.price);
            this.category = itemView.findViewById(R.id.category);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
