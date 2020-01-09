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

public class ListedAdsAdapter extends RecyclerView.Adapter<ListedAdsAdapter.ListedAdsViewHolder> {

    Context mContext;
    List<ListedAds> listedAdsList;
    public ListedAdsAdapter(Context mContext,List<ListedAds> listedAdsList){
        this.mContext=mContext;
        this.listedAdsList=listedAdsList;
    }
    @NonNull
    @Override
    public ListedAdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listed_ads,parent,false);
        return new ListedAdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListedAdsViewHolder holder, int position) {

        ListedAds listedAds=listedAdsList.get(position);
        holder.imageAd.setImageResource(listedAds.getImagesId());
        holder.tvProductType.setText(listedAds.getProducttype());
        holder.tvAdName.setText(listedAds.getAdName());
        holder.tvAdPrice.setText(listedAds.getAdprice());
    }

    @Override
    public int getItemCount() {
        return listedAdsList.size();
    }

    public class ListedAdsViewHolder extends RecyclerView.ViewHolder{
        ImageView imageAd;
        TextView tvAdName,tvAdPrice,tvProductType;

        public ListedAdsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAd=itemView.findViewById(R.id.imageAd);
            tvAdName=itemView.findViewById(R.id.tvAdName);
            tvAdPrice=itemView.findViewById(R.id.tvAdPrice);
            tvProductType=itemView.findViewById(R.id.tvProductType);
        }
    }
}
