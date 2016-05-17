package com.deepakbaliga.krishnaconchem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.deepakbaliga.krishnaconchem.Adapters.PublicationAdapter;
import com.deepakbaliga.krishnaconchem.retrofit.APIAdapter;
import com.deepakbaliga.krishnaconchem.retrofit.APIResponseCallback;
import com.deepakbaliga.krishnaconchem.retrofit.model.Publication;
import com.deepakbaliga.krishnaconchem.retrofit.model.PublicationResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class PublicationsActivity extends AppCompatActivity {

    APIAdapter apiAdapter = new APIAdapter();
    PublicationAdapter adapter;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ButtonClick click;

    List<Publication> publications = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publications);

        getSupportActionBar().setTitle("Publications");

        recyclerView = (RecyclerView) findViewById(R.id.publication_recyclerview);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        click =  new ButtonClick() {
            @Override
            public void onClick(int position) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(publications.get(position).getLink()));
                startActivity(browserIntent);


            }
        };




        apiAdapter.getPublications(new APIResponseCallback() {
            @Override
            public void onSuccess(Response response) {
                Log.e("Pub", response.code()+"");

                Response<PublicationResponse> res = response;
                        publications = res.body().getPublications();

                adapter = new PublicationAdapter(publications, click);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(String error) {
                Log.e("Pub", error);
                progressBar.setVisibility(View.GONE);
            }
        });

    }
}
