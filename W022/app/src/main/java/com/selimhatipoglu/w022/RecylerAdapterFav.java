package com.selimhatipoglu.w022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylerAdapterFav extends RecyclerView.Adapter<RecylerAdapterFav.RecylerViewFavHolder> {

    ArrayList<RecylerModelFav> recylerModelsFav;


    public RecylerAdapterFav(ArrayList<RecylerModelFav> recylerModelsFav) {
        this.recylerModelsFav=recylerModelsFav;
    }




    @NonNull
    @Override
    public RecylerViewFavHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerviewfav,parent,false);

        return new RecylerViewFavHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerViewFavHolder holder, int position) {
        RecylerModelFav recylerModelFav=recylerModelsFav.get(position);
        holder.productname.setText(recylerModelFav.getProductname());
        holder.productprice.setText(recylerModelFav.getProductprice());
    }

    @Override
    public int getItemCount() {
        return recylerModelsFav.size();
    }


    public class RecylerViewFavHolder extends RecyclerView.ViewHolder{
        TextView productname, productprice;
        LinearLayout linearLayout;


        public RecylerViewFavHolder(@NonNull View itemView) {
            super(itemView);
            productname=itemView.findViewById(R.id.product_name1);
            productprice=itemView.findViewById(R.id.product_price1);


            linearLayout= itemView.findViewById(R.id.linearLayout1);







        }



    }

}
