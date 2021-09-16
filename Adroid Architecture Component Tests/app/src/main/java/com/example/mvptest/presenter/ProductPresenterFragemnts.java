package com.example.mvptest.presenter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvptest.Product;
import com.example.mvptest.ProductsAdapter;
import com.example.mvptest.ProductsOnCustomClickListener;
import com.example.mvptest.base.BasePresenterFragments;
import com.example.mvptest.interfaces.ExperimentActivityInterface;
import com.example.mvptest.interfaces.TestFragmentInterface;
import com.example.mvptest.model.ProductsInteractor;

import java.util.List;

public class ProductPresenterFragemnts extends BasePresenterFragments implements ProductsInteractor.onDetailsFetched, ProductsOnCustomClickListener {

    private TestFragmentInterface view;
    private ProductsInteractor productsInteractor;
    private ProductsAdapter productsAdapter = new ProductsAdapter(this);

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
        view.setProductsList(productsFetchedData, productsAdapter);
    }


    @Override
    public void onFailure() {
        view.showProgressBar();
    }

    @Override
    public void onItemClick(Product product, int position) {

    }
}
