package com.deepakbaliga.krishnaconchem.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by baliga on 09/05/16.
 */
public class DataSheetsResponse {


    @SerializedName("data")
    private List<DataSheet> dataSheets = new ArrayList<>();

    public DataSheetsResponse(List<DataSheet> dataSheets) {
        this.dataSheets = dataSheets;
    }

    public List<DataSheet> getDataSheets() {
        return dataSheets;
    }

    public void setDataSheets(List<DataSheet> dataSheets) {
        this.dataSheets = dataSheets;
    }

    public DataSheetsResponse() {
    }

}
