package com.armistic.myapplication.category;

/**
 * Created by jibieta on 10-08-16.
 */
public class Category {

    private String key;
    private String category;
    private String selected;
    private Integer formType;
    private Integer choiceMode;
    private String loadUrl;

    public Category() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public Integer getChoiceMode() {
        return choiceMode;
    }

    public void setChoiceMode(Integer choiceMode) {
        this.choiceMode = choiceMode;
    }

    public String getLoadUrl() {
        return loadUrl;
    }

    public void setLoadUrl(String loadUrl) {
        this.loadUrl = loadUrl;
    }
}
