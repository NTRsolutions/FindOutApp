package com.project.verbosetech.findout.Models;

/**
 * Created by this pc on 10-06-17.
 */

public class GridCardModel {

    String image;
    String name;
    String number;

    public GridCardModel(String image, String name, String number) {
        this.image = image;
        this.name = name;
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
