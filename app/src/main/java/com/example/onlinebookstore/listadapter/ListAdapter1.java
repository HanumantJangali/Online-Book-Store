package com.example.onlinebookstore.listadapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinebookstore.BookOrder;
import com.example.onlinebookstore.Payment;
import com.example.onlinebookstore.R;
import com.example.onlinebookstore.listmodel.ListModel1;

public class ListAdapter1 extends RecyclerView.Adapter<ListAdapter1.ListViewHolder> {

    ListModel1[] rowModel1;

    public ListAdapter1(ListModel1[] rowModel1) {
        this.rowModel1 = rowModel1;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.second_book_list, null, false);
        ListAdapter1.ListViewHolder viewHolder = new ListAdapter1.ListViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.imageView.setImageResource(rowModel1[position].getImgId());
        holder.name.setText(rowModel1[position].getName());
        holder.price.setText(rowModel1[position].getPrice());
        holder.category.setText(rowModel1[position].getCategory());
        holder.cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), BookOrder.class);

                i.putExtra("iimage",rowModel1[position].getImgId());
                i.putExtra("iname",rowModel1[position].getName());
                i.putExtra("iprice",rowModel1[position].getPrice());
                i.putExtra("icategory",rowModel1[position].getCategory());
                view.getContext().startActivity(i);

                //view.getContext().startActivity(new Intent(view.getContext(), BookOrder.class));
                Toast.makeText(view.getContext(),"Clicked on your Book",Toast.LENGTH_LONG).show();
            }
        });
        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), Payment.class));
                Toast.makeText(view.getContext(),"Complete Payment to Order your Book ",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return rowModel1.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView name;
        final TextView price;
        final TextView category;
        final CardView cardView1;
        Button buyButton;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.name = itemView.findViewById(R.id.name);
            this.price = itemView.findViewById(R.id.price);
            this.category = itemView.findViewById(R.id.category);
            this.cardView1 = itemView.findViewById(R.id.cardView1);
            this.buyButton = itemView.findViewById(R.id.buyButton);

        }
    }
}
