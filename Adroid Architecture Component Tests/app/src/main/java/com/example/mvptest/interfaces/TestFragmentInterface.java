package com.example.mvptest.interfaces;

import com.example.mvptest.Product;

import java.util.List;

public interface TestFragmentInterface {

    void showProgressBar();
    void hideProgressBar();

    void showRv();
    void hideRv();

    void setProductsList(List<Product> products);

    void fetchData();
}
