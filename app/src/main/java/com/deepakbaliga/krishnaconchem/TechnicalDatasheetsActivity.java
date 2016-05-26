package com.deepakbaliga.krishnaconchem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.deepakbaliga.krishnaconchem.Adapters.DatasheetAdapter;
import com.deepakbaliga.krishnaconchem.Adapters.PublicationAdapter;
import com.deepakbaliga.krishnaconchem.retrofit.APIAdapter;
import com.deepakbaliga.krishnaconchem.retrofit.APIResponseCallback;
import com.deepakbaliga.krishnaconchem.retrofit.model.DataSheet;
import com.deepakbaliga.krishnaconchem.retrofit.model.DataSheetsResponse;
import com.deepakbaliga.krishnaconchem.retrofit.model.Publication;
import com.deepakbaliga.krishnaconchem.retrofit.model.PublicationResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class TechnicalDatasheetsActivity extends AppCompatActivity {

    APIAdapter apiAdapter = new APIAdapter();
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DatasheetAdapter adapter;
    ButtonClick click;
    private ProgressBar progressBar;

    List<DataSheet> dataSheets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_datasheets);

        getSupportActionBar().setTitle("Technical Data Sheets");

        linearLayoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        recyclerView.setLayoutManager(linearLayoutManager);

        click = new ButtonClick() {
            @Override
            public void onClick(int position) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dataSheets.get(position).getLink()));
                startActivity(browserIntent);
            }
        };


        apiAdapter.getTechnicalDatasheets(new APIResponseCallback() {
            @Override
            public void onSuccess(Response response) {
                Log.e("TDS", response.code()+"");
                Log.e("TDS", response.message()+"");
                Log.e("TDS", response.body().toString()+"");



                Response<DataSheetsResponse> res = response;
                dataSheets = res.body().getDataSheets();
                Log.e("TDS", dataSheets.size()+"");

                adapter = new DatasheetAdapter(dataSheets, click);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(String error) {
                Log.e("TDS", error);
                progressBar.setVisibility(View.GONE);

            }
        });

    }


}
