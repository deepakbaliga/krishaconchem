package com.deepakbaliga.krishnaconchem;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.deepakbaliga.krishnaconchem.retrofit.model.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailFragment extends DialogFragment {


    private Product product;
    public ProductDetailFragment() {
        // Required empty public constructor
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.product_detail, container, false);

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView uses = (TextView) view.findViewById(R.id.uses);
        TextView description = (TextView) view.findViewById(R.id.description);

        title.setText(product.getName());
        description.setText(product.getDescription());
        uses.setText(product.getUses());


        return  view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);


        return dialog;
    }

}
