package com.deepakbaliga.krishnaconchem.retrofit;

import com.deepakbaliga.krishnaconchem.retrofit.model.DataSheetsResponse;
import com.deepakbaliga.krishnaconchem.retrofit.model.ProductResponse;
import com.deepakbaliga.krishnaconchem.retrofit.model.PublicationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by baliga on 04/05/16.
 */
public interface EndPoints {


    @Headers({
            "application-id :  5326ACA9-1D64-1485-FFEB-12F4C141EF00",
            "secret-key :  CCF70C9E-B3ED-1198-FF9C-911FE8015200"
    })
    @GET("data/publication")
    Call<PublicationResponse> getPublications();


    @Headers({
            "application-id :  5326ACA9-1D64-1485-FFEB-12F4C141EF00",
            "secret-key :  CCF70C9E-B3ED-1198-FF9C-911FE8015200",
            "application-type : REST",
            "Content-Type : application/json"
            })
    @GET("data/datasheets")
    Call<DataSheetsResponse> getTechnicalDatasheets(@Query("pageSize") int pageset);


    @Headers({
            "application-id :  5326ACA9-1D64-1485-FFEB-12F4C141EF00",
            "secret-key :  CCF70C9E-B3ED-1198-FF9C-911FE8015200"
    })
    @GET("data/products")
    Call<ProductResponse> getProducts(@Query("where") String code,@Query("pageSize") int pageset);



}
