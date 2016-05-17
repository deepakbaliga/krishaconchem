package com.deepakbaliga.krishnaconchem.retrofit.model;

/**
 * Created by baliga on 09/05/16.
 */
public class Product {

    private String cover;
    private String description;
    private String name;
    private String uses;

    public Product(String cover, String description, String name, String uses) {
        this.cover = cover;
        this.description = description;
        this.name = name;
        this.uses = uses;
    }

    public Product() {
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }
}
