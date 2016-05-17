package com.deepakbaliga.krishnaconchem.retrofit.model;

/**
 * Created by baliga on 09/05/16.
 */
public class DataSheet {

    private String title;
    private String link;

    public DataSheet(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public DataSheet() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
