package com.example.mvptest.model;

import com.example.mvptest.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiConnectionInterface {

    @GET("/products/filter/{filter}")
    Call<List<Product>> productsList(@Path("filter") String filter);
}