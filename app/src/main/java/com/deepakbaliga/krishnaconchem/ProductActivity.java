package com.deepakbaliga.krishnaconchem;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.deepakbaliga.krishnaconchem.Adapters.ProductsAdapter;
import com.deepakbaliga.krishnaconchem.Adapters.PublicationAdapter;
import com.deepakbaliga.krishnaconchem.retrofit.APIAdapter;
import com.deepakbaliga.krishnaconchem.retrofit.APIResponseCallback;
import com.deepakbaliga.krishnaconchem.retrofit.model.Product;
import com.deepakbaliga.krishnaconchem.retrofit.model.ProductResponse;
import com.deepakbaliga.krishnaconchem.retrofit.model.Publication;
import com.deepakbaliga.krishnaconchem.retrofit.model.PublicationResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {




    RecyclerView recyclerView;
    ProgressBar progressBar;
    ButtonClick click;
    ProductsAdapter adapter;
    TextView nothing;

    List<Product> products = new ArrayList<>();
    private int code;
    private APIAdapter apiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        apiAdapter = new APIAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        progressBar = (ProgressBar) findViewById(R.id.progress);
        nothing = (TextView) findViewById(R.id.nothing);

        progressBar.setVisibility(View.VISIBLE);
        click =  new ButtonClick() {
            @Override
            public void onClick(int position) {


                FragmentManager fm = getSupportFragmentManager();
                ProductDetailFragment fragment =  new ProductDetailFragment();
                fragment.setProduct(products.get(position));
                fragment.show(fm, "");


            }
        };

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            code = extras.getInt("code");
            Log.e("CODE", code+"");
            getData(code);
        }
    }


    private void getData(int _code){

        apiAdapter.getProducts(new APIResponseCallback() {
            @Override
            public void onSuccess(Response response) {
                Log.e("Reponse" , response.code()+"");

                Response<ProductResponse> res = response;
                products = res.body().getProducts();

                adapter =  new ProductsAdapter(ProductActivity.this, products, click);
                recyclerView.setAdapter(adapter);

                progressBar.setVisibility(View.GONE);

                if (products.size()<=0){
                    nothing.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(String error) {
                Log.e("Reponse" , error);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ProductActivity.this, "Please Connect to Internet", Toast.LENGTH_LONG).show();
            }
        }, _code);
    }
}
