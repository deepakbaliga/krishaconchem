package com.deepakbaliga.krishnaconchem.retrofit;

import com.deepakbaliga.krishnaconchem.retrofit.model.DataSheetsResponse;
import com.deepakbaliga.krishnaconchem.retrofit.model.ProductResponse;
import com.deepakbaliga.krishnaconchem.retrofit.model.Publication;
import com.deepakbaliga.krishnaconchem.retrofit.model.PublicationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by baliga on 04/05/16.
 */
public class APIAdapter {

    private Retrofit retrofit;
    private EndPoints endPoints;

    public APIAdapter() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endPoints = retrofit.create(EndPoints.class);
    }


    public void getPublications( final APIResponseCallback callback){


        Call<PublicationResponse> call = endPoints.getPublications();

        call.enqueue(new Callback<PublicationResponse>() {
            @Override
            public void onResponse(Call<PublicationResponse> call, Response<PublicationResponse> response) {
                callback.onSuccess(response);
            }

            @Override
            public void onFailure(Call<PublicationResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }


    public void getTechnicalDatasheets( final APIResponseCallback callback){


        Call<DataSheetsResponse> call = endPoints.getTechnicalDatasheets(40);

        call.enqueue(new Callback<DataSheetsResponse>() {
            @Override
            public void onResponse(Call<DataSheetsResponse> call, Response<DataSheetsResponse> response) {
                callback.onSuccess(response);
            }

            @Override
            public void onFailure(Call<DataSheetsResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public void getProducts( final APIResponseCallback callback, int code){


        Call<ProductResponse> call = endPoints.getProducts("category="+code, 40);

        call.enqueue(new Callback<ProductResponse>() {

            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                callback.onSuccess(response);
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}
