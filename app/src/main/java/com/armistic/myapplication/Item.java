package com.armistic.myapplication;


/**
 * Created by jibieta on 05-08-16.
 */
public class Item {

    private String title;
    private Boolean checked;

    public Item(String title, Boolean checked) {
        this.title = title;
        this.checked = checked;
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
