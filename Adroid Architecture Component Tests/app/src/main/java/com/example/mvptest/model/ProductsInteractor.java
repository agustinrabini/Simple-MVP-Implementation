package com.example.mvptest.model;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvptest.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsInteractor extends AppCompatActivity {

    private DataInterfaceProd mListener;

    public interface onDetailsFetched{
        void onSucces(List<Product> productsFetchedData);
        void onFailure();
    }

    public void remoteFetch(String filter, final  onDetailsFetched listener){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("URL HERE")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiConnectionInterface apiConnectionInterface = retrofit.create(ApiConnectionInterface.class);

        Call<List<Product>> call = apiConnectionInterface.productsList(filter);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                if(!response.isSuccessful()){
                    listener.onFailure();
                }

                List<Product> productList = response.body();

                if (productList!=null){
                  listener.onSucces(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsInteractor.this, "Error:" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void SetOnDataListenerProd(DataInterfaceProd listener){
        mListener = listener;
    }

    public interface DataInterfaceProd {
        void responseProd(List<Product> products);
    }
}
