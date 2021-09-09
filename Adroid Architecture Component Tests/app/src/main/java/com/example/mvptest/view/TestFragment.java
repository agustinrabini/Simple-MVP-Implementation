package com.example.mvptest.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mvptest.ProductsAdapter;
import com.example.mvptest.ProductsOnCustomClickListener;
import com.example.mvptest.Product;
import com.example.mvptest.R;
import com.example.mvptest.base.BaseFragment;
import com.example.mvptest.interfaces.TestFragmentInterface;
import com.example.mvptest.model.ProductsInteractor;
import com.example.mvptest.presenter.ProductPresenterActivities;
import com.example.mvptest.presenter.ProductPresenterFragemnts;

import java.util.List;


public class TestFragment extends BaseFragment<ProductPresenterFragemnts> implements ProductsOnCustomClickListener, TestFragmentInterface {

    public ProductsAdapter productsAdapter = new ProductsAdapter(this);
    public  RecyclerView rvProducts;
    public ProgressBar progressBar;

    protected ProductPresenterFragemnts createPresenter(@NonNull Context context){
        return new ProductPresenterFragemnts(this, new ProductsInteractor());//aca se intancia el interactor
    }

    public TestFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_test, container, false);

        rvProducts = v.findViewById(R.id.rv_products_test);
        progressBar = v.findViewById(R.id.pb_test);

        fetchData();

        return v;
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
        rvProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvProducts.setAdapter(productsAdapter);
        rvProducts.setVisibility(View.VISIBLE);
        productsAdapter.setProducts(products);
    }

    @Override
    public void fetchData() {
        presenterFragment.fetchData("*");
    }
}