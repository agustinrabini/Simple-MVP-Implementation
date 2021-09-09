package com.example.mvptest.interfaces;

import android.widget.Adapter;
import android.widget.ListView;

import com.example.mvptest.Product;

import java.util.List;

public interface ExperimentActivityInterface {

    void showProgressBar();
    void hideProgressBar();

    void showRv();
    void hideRv();

    void setProductsList(List<Product> products);

    void fetchData();
}
