package com.example.mvptest.interfaces;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mvptest.Product;
import com.example.mvptest.ProductsAdapter;

import java.util.List;

public interface TestFragmentInterface {

    void showProgressBar();
    void hideProgressBar();

    void showRv();
    void hideRv();

    void setProductsList(List<Product> products, ProductsAdapter productsAdapter);

    void fetchData();
}
