package com.example.btc.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.btc.R;
import com.example.btc.models.CoinData;

import java.util.ArrayList;

public class MutiCoin_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<CoinData> item;
    public  Context context;
    public MutiCoin_Adapter(ArrayList<CoinData> item, Context context) {

        this.item = item;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0){
            return new NormalViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.normal_list,
                            parent,
                            false
                    )
            );
        }
        else{
            return new FifthViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.fifth_item,
                            parent,
                            false
                    )
            );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == 0){
            ((NormalViewHolder)
                    holder).setNormalData(item.get(position));
        }
        else{
            ((FifthViewHolder)
                    holder).setFifthData(item.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return item.size();
    }



    @Override
    public int getItemViewType(int position) {
        return item.get(position).getType();
    }

    static class NormalViewHolder extends RecyclerView.ViewHolder{
        private final ImageView icon;
        private final TextView txtName, txtSymbol;
        public NormalViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.ImIcon);
            txtName = itemView.findViewById(R.id.txtName);
            txtSymbol = itemView.findViewById(R.id.txtSymbol);
        }

        void setNormalData(CoinData coin){
            txtName.setText(coin.getName());
            txtSymbol.setText(coin.getSymbol());


            Glide.with(itemView)
                    .load(coin.getImage())
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(icon);

        }
    }

    static class FifthViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final ImageView icon;
        private final TextView txtUrl, txtSymbol;
        public FifthViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.ImIcon);
            txtUrl = itemView.findViewById(R.id.txtUrl);
            txtSymbol = itemView.findViewById(R.id.txtSymbol);

            itemView.setOnClickListener(this);

        }

        void setFifthData(CoinData coin){
            txtUrl.setText(coin.getUrl());
            txtSymbol.setText(coin.getSymbol());
            Glide.with(itemView)
                    .load(coin.getImage())
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(icon);

        }

        @Override
        public void onClick(View view) {
            String url = txtUrl.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
           view.getContext().startActivity(intent);
        }
    }
}
