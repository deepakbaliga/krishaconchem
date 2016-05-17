package com.deepakbaliga.krishnaconchem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.deepakbaliga.krishnaconchem.Adapters.CertificationAdapter;

public class MajorUsersActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayout;
    private int pictures[] =  new int[]{
            R.drawable.mone,
            R.drawable.mtwo,
            R.drawable.mthree,
            R.drawable.mfour,
            R.drawable.mfive,
            R.drawable.msix,
            R.drawable.mseven,
            R.drawable.meight,
            R.drawable.mnine,
            R.drawable.mten,
            R.drawable.meleven,
            R.drawable.mtwelve

    };
    private String titles[] = new String[]{
            "Indian Railways",
            "NTPC LTD.",
            "L&T",
            "PWD",
            "Govt. Of Gujarat",
            "Godrej",
            "NHAI",
            "Reliance",
            "SEZ",
            "PAHAPUR",
            "ISRO",
            "UltraTech"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_certification_dialog);

        findViewById(R.id.title).setVisibility(View.GONE);

        recyclerView = (RecyclerView) findViewById(R.id.certification_recyclerview);



        gridLayout =  new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        linearLayoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayout);

        recyclerView.setAdapter(new CertificationAdapter(pictures, titles, this));

    }
}
