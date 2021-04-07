package com.toumal.blogblog.Model;

import com.google.gson.annotations.SerializedName;

public class Blog {
   private int id;
   private String title;
   private String description;
   private String cover_photo;
   private String[] categories;

   @SerializedName("author")
   private Author authors;

    public Blog() {
    }

    public Blog(int id, String title, String description, String cover_photo, String[] categories, Author authors) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cover_photo = cover_photo;
        this.categories = categories;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(String cover_photo) {
        this.cover_photo = cover_photo;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public Author getAuthors() {
        return authors;
    }

    public void setAuthors(Author authors) {
        this.authors = authors;
    }
}
