package com.project.verbosetech.findout.Models;

/**
 * Created by this pc on 07-06-17.
 */

public class Places {

    int image;
    String name;
    String address;
    String distance;

    public Places(int image, String name, String address, String distance) {
        this.image = image;
        this.name = name;
        this.address = address;
        this.distance = distance;
    }

    public Places(String name, String address, String distance) {
        this.name = name;
        this.address = address;
        this.distance = distance;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
