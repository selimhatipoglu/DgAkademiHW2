package com.selimhatipoglu.w022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecylerViewHolder> {
    ArrayList<RecylerModel> recylerModels;




    ArrayList<RecylerModelFav> favoritesrecylerModels;


    public Button addtofavoritesbutton;




    public RecyclerAdapter(ArrayList<RecylerModel> recylerModels) {
        this.recylerModels=recylerModels;
    }



    @NonNull
    @Override
    public RecylerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recylermodel,parent,false);

        return new RecylerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerViewHolder holder, int position) {

        RecylerModel recylerModel=recylerModels.get(position);
        holder.productname.setText(recylerModel.getProductname());
        holder.productprice.setText(recylerModel.getProductprice());


    }




    @Override
    public int getItemCount() {
        return recylerModels.size();
    }

    public class RecylerViewHolder extends RecyclerView.ViewHolder{
        TextView productname, productprice;
        LinearLayout linearLayout;


        public RecylerViewHolder(@NonNull View itemView) {
            super(itemView);
            productname=itemView.findViewById(R.id.product_name);
            productprice=itemView.findViewById(R.id.product_price);


            addtofavoritesbutton=itemView.findViewById(R.id.addtofavoritesbutton);

            linearLayout= itemView.findViewById(R.id.linearLayout);



            favoritesrecylerModels=new ArrayList<>();
            addtofavoritesbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    favoritesrecylerModels.add(new RecylerModelFav(productname.getText().toString(),productprice.getText().toString()));
                    }
            });






        }



    }



    public ArrayList<RecylerModelFav> getFavoritesrecylerModels() {
        return favoritesrecylerModels;
    }


}
