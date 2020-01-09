package com.saroj.hamrobazar.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saroj.hamrobazar.R;

import java.util.List;

public class TrendingAdsAdapter extends RecyclerView.Adapter<TrendingAdsAdapter.TrendingAdsViewHolder> {

    Context mContext;
    List<TreandingAds> treandingAdsList;
    public TrendingAdsAdapter(Context mContext, List<TreandingAds> treandingAdsList) {
        this.mContext = mContext;
        this.treandingAdsList = treandingAdsList;
    }

    @NonNull
    @Override
    public TrendingAdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_trending_ads,parent,false);
        return new TrendingAdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdsViewHolder holder, int position) {

        TreandingAds treandingAds=treandingAdsList.get(position);
        holder.imageProduct.setImageResource(treandingAds.getImageId());
        holder.tvType.setText(treandingAds.getType());
        holder.tvProductName.setText(treandingAds.getName());
        holder.tvPrice.setText(treandingAds.getPrice());
    }

    @Override
    public int getItemCount() {
        return treandingAdsList.size();
    }

    public class TrendingAdsViewHolder extends RecyclerView.ViewHolder{

        ImageView imageProduct;
        TextView tvProductName,tvPrice,tvType;
        public TrendingAdsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageProduct=itemView.findViewById(R.id.imageProduct);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvProductName=itemView.findViewById(R.id.tvProductName);
            tvType=itemView.findViewById(R.id.tvType);
        }
    }
}
