package com.deepakbaliga.krishnaconchem.retrofit.model;

/**
 * Created by baliga on 04/05/16.
 */
public class Publication {

    private String link;
    private String description;
    private String authors;
    private String title;

    public Publication() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
