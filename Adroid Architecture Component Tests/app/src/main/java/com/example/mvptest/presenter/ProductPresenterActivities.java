package com.example.mvptest.presenter;

import androidx.annotation.NonNull;

import com.example.mvptest.Product;
import com.example.mvptest.base.BasePresenterActivities;
import com.example.mvptest.interfaces.ExperimentActivityInterface;
import com.example.mvptest.model.ProductsInteractor;

import java.util.List;

public class ProductPresenterActivities extends BasePresenterActivities implements ProductsInteractor.onDetailsFetched {

    private ExperimentActivityInterface view;
    private ProductsInteractor productsInteractor;

    public ProductPresenterActivities(@NonNull ExperimentActivityInterface view, @NonNull ProductsInteractor productsInteractor){
     this.view = view;
     this.productsInteractor = productsInteractor;
    }

    public void fetchData(String filter){
        view.hideRv();
        view.showProgressBar();
        productsInteractor.remoteFetch(filter,this);
    }

    @Override
    public void onSucces(List<Product> productsFetchedData) {
        view.hideProgressBar();
        view.showRv();
        view.setProductsList(productsFetchedData);
    }

    @Override
    public void onFailure() {
        view.showProgressBar();
    }
}
