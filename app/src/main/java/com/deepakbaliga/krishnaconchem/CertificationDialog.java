package com.deepakbaliga.krishnaconchem;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.deepakbaliga.krishnaconchem.Adapters.CertificationAdapter;


public class CertificationDialog extends DialogFragment {



    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayout;
    private int pictures[] =  new int[]{
            R.drawable.cone,
            R.drawable.ctwo,
            R.drawable.cthree,
            R.drawable.cfour,
            R.drawable.cfive,
            R.drawable.csix,
            R.drawable.cseven,
            R.drawable.ceight,
            R.drawable.cnine
    };
    private String titles[] = new String[]{
            "CSIR India",
            "IIT Bombay",
            "IIT Kanpur",
            "CSIR CLRI",
            "ASTM",
            "CSIR SERC",
            "ISO 9001",
            "ISO 9001",
            "ISO 9001"
    };


    public CertificationDialog() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_certification_dialog, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.certification_recyclerview);



        gridLayout =  new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL, false);
        linearLayoutManager =  new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayout);

        recyclerView.setAdapter(new CertificationAdapter(pictures, titles, getActivity()));


        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }
    }


}
