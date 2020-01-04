package com.example.neighborly;

import android.graphics.Bitmap;

import com.google.firebase.auth.FirebaseUser;

public class Item {

    private Bitmap image;
    private String name;
    private FirebaseUser owner;
    private String description;

    public Item(Bitmap image, String name, FirebaseUser owner, String description) {
        this.image = image;
        this.name = name;
        this.owner = owner;
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FirebaseUser getOwner() {
        return owner;
    }

    public void setOwner(FirebaseUser owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
