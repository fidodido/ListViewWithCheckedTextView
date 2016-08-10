package com.armistic.myapplication.select;

/**
 * Created by jibieta on 02-08-16.
 */
public class Item {

    private Integer id;
    private String title;
    private Boolean checked;

    public Item() {
    }

    public Item(Integer id, String title, Boolean checked) {
        this.id = id;
        this.title = title;
        this.checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}