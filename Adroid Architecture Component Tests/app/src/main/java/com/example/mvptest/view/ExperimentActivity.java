package com.example.mvptest.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvptest.Product;
import com.example.mvptest.ProductsAdapter;
import com.example.mvptest.ProductsOnCustomClickListener;
import com.example.mvptest.R;
import com.example.mvptest.base.BaseActivity;
import com.example.mvptest.interfaces.ExperimentActivityInterface;
import com.example.mvptest.model.ProductsInteractor;
import com.example.mvptest.presenter.ProductPresenterActivities;

import java.util.List;


public class ExperimentActivity extends BaseActivity<ProductPresenterActivities> implements ProductsOnCustomClickListener, ExperimentActivityInterface {

    public ProductsAdapter productsAdapter = new ProductsAdapter(this);
    public  RecyclerView rvProducts;
    public ProgressBar progressBar;

    protected ProductPresenterActivities createPresenter(@NonNull Context context){
        return new ProductPresenterActivities(this, new ProductsInteractor());//aca se intancia el interactor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment);


        rvProducts = findViewById(R.id.rv_products);
        progressBar = findViewById(R.id.pb);

        fetchData();
    }

    private void rvproducts(){

        rvProducts.setLayoutManager(new GridLayoutManager(this, 2));
        rvProducts.setAdapter(productsAdapter);
    }

    @Override
    public void onItemClick(Product product, int position) {
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRv() {
        rvProducts.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRv() {
        rvProducts.setVisibility(View.GONE);
    }

    @Override
    public void setProductsList(List<Product> products) {
        rvproducts();
        rvProducts.setVisibility(View.VISIBLE);
        productsAdapter.setProducts(products);
    }

    @Override
    public void fetchData() {
        presenterActivity.fetchData("*");
    }
}