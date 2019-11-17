package com.haqqnuru.tourguideapp;

public class TourGuide {

    // tourGuide variables
    private int image;
    private String name;
    private String location;
    private String description;

    // constructor for tourGuide
    public TourGuide(int image, String name, String location, String description) {
        this.image = image;
        this.name = name;
        this.location = location;
        this.description = description;
    }

    // get Image
    public int getImage() {
        return image;
    }

    // get name
    public String getName() {
        return name;
    }

    //get location
    public String getLocation() {
        return location;
    }

    // get description
    public String getDescription() {
        return description;
    }
}
