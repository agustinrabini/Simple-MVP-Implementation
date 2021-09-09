package com.example.mvptest.presenter;

import androidx.annotation.NonNull;

import com.example.mvptest.Product;
import com.example.mvptest.base.BasePresenterFragments;
import com.example.mvptest.interfaces.ExperimentActivityInterface;
import com.example.mvptest.interfaces.TestFragmentInterface;
import com.example.mvptest.model.ProductsInteractor;

import java.util.List;

public class ProductPresenterFragemnts extends BasePresenterFragments implements ProductsInteractor.onDetailsFetched {

    private TestFragmentInterface view;
    private ProductsInteractor productsInteractor;

    public ProductPresenterFragemnts(@NonNull TestFragmentInterface view, @NonNull ProductsInteractor productsInteractor){
        this.view = (TestFragmentInterface) view;
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
