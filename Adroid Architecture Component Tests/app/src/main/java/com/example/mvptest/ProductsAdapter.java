package com.example.mvptest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<com.example.mvptest.ProductsAdapter.ProductsViewHolder> {

    private ArrayList<Product> products = new ArrayList<>();
    private final ProductsOnCustomClickListener listener;

    public ProductsAdapter(ProductsOnCustomClickListener listener) {
        this.listener = listener;
    }
   
    @NotNull
    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_product, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {
        holder.bind(products.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> listProducts)  {
        products = (ArrayList<Product>) listProducts;
        notifyDataSetChanged();
    }

    public static class ProductsViewHolder extends RecyclerView.ViewHolder{

        public ProductsViewHolder(View itemView) {
            super(itemView);
        }

        private void bind (Product product, ProductsOnCustomClickListener listener){

            ImageView ivImage = itemView.findViewById(R.id.iv_product_cv);
            TextView tvName = itemView.findViewById(R.id.tv_name1);
            TextView tvPrice = itemView.findViewById(R.id.tv_price1);
            TextView tvLength = itemView.findViewById(R.id.tv_length1);
            ConstraintLayout constraintLayoutProd = itemView.findViewById(R.id.cl_product1);

            Integer id_product = product.getId_product();
            Integer stock = product.getStock();

            tvName.setText(product.getName());
            tvPrice.setText(String.valueOf(product.getPrice()));
            tvLength.setText(String.valueOf("Longitud hoja " + product.getLength())+"cm");
            Picasso.with(itemView.getContext()).load(product.getImage()).into(ivImage);
        }
    }
}
