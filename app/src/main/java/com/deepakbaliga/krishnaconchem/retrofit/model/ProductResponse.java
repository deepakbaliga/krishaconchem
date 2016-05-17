package com.deepakbaliga.krishnaconchem.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 09/05/16.
 */
public class ProductResponse {
    @SerializedName("data")
    private List<Product> products = new ArrayList<>();

    public ProductResponse(List<Product> products) {
        this.products = products;
    }

    public ProductResponse() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
