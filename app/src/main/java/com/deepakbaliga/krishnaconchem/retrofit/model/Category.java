package com.deepakbaliga.krishnaconchem.retrofit.model;

/**
 * Created by baliga on 09/05/16.
 */
public class Category {
    private int code;
    private String name;
    private int icon;

    public Category(int code, String name, int icon) {
        this.code = code;
        this.name = name;
        this.icon = icon;
    }

    public Category() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
