package com.danielminami.memorygameshopify.model;

import android.widget.ImageView;

import java.util.ArrayList;

public class CardsClicked extends ArrayList<CardsClicked> {

    private Card card;
    private ImageView imageView;

    public CardsClicked() {}

    public CardsClicked(Card card, ImageView imageView) {
        this.card = card;
        this.imageView = imageView;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

}
