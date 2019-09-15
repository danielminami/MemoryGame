package com.danielminami.memorygameshopify.model;

import com.danielminami.memorygameshopify.model.Image;

public class Card {

    private int id;
    private Image image;

    public Card(int id, Image image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
