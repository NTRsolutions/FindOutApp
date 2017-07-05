package com.project.verbosetech.findout.model;

/**
 * Created by this pc on 09-06-17.
 */

public class Review {

    String name;
    String date;
    String image;
    String rating;

    public Review(String name, String date, String image, String rating) {
        this.name = name;
        this.date = date;
        this.image = image;
        this.rating = rating;
    }

    public Review(String name, String date, String rating) {
        this.name = name;
        this.date = date;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
