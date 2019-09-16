package com.danielminami.memorygameshopify.model;

import com.danielminami.memorygameshopify.model.Image;

public class Card {

    private int id;
    private String imageSrc;

    public Card() {}

    public Card(int id, String imageSrc) {
        this.id = id;
        this.imageSrc = imageSrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
}
