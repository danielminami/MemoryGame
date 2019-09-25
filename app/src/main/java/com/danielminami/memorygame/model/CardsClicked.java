package com.danielminami.memorygame.model;

import android.widget.ImageView;

import java.util.ArrayList;


/**
 * This Class Models Cards Clicked and is an ArrayList of the same type
 *
 * This Class is used to keep track of the user clicks. It stores the Card, the related ImageView
 * Object and the position of the click on the board.
 *
 * @author Daniel Minami
 */
public class CardsClicked extends ArrayList<CardsClicked> {

    private Card card;
    private ImageView imageView;
    private int position;

    /**
     * Constructs an empty instance of CardsClicked
     */
    public CardsClicked() {}

    /**
     * Constructs an instance of CardsClicked
     *
     * @param card card clicked
     * @param imageView related UI Object
     * @param position position clicked
     */
    public CardsClicked(Card card, ImageView imageView, int position) {
        setCard(card);
        setImageView(imageView);
        setPosition(position);
    }

    /**
     * Gets Object Card
     * @return a Card
     */
    public Card getCard() {
        return card;
    }

    /**
     * Sets a Card
     * @param card object
     */
    public void setCard(Card card) {
        this.card = card;
    }

    /**
     * Gets an ImageView Object
     * @return an ImageView
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Sets an ImageView
     * @param imageView UI object
     */
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     * Gets the clicked position
     * @return the clicked position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the clicked position
     * @param position position reference
     */
    public void setPosition(int position) {
        this.position = position;
    }
}
