package com.saroj.hamrobazar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saroj.hamrobazar.R;
import com.saroj.hamrobazar.model.Product;
import com.saroj.hamrobazar.url.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.Viewholder> {
    Context context;
    List<Product> productList;


    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listed_ads,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Product product = productList.get(position);
        holder.tvName.setText(product.getName());
        holder.tvCondition.setText(product.getType());
        holder.tvPrice.setText(product.getPrice() +"");

        String image=product.getImage();
        String imgPath = Url.imagePath + image;
        Picasso.get().load(imgPath).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView tvName, tvPrice, tvCondition;
        protected  Boolean popular;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imageAd);
            tvName = itemView.findViewById(R.id.tvAdName);
            tvPrice = itemView.findViewById(R.id.tvAdPrice);
            tvCondition = itemView.findViewById(R.id.tvProductType);
        }
    }
}
