package com.deepakbaliga.krishnaconchem.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 04/05/16.
 */
public class PublicationResponse {

    @SerializedName("data")
    private List<Publication> publications = new ArrayList<>();

    public PublicationResponse(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }
}
