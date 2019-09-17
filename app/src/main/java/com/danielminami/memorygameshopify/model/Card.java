package com.danielminami.memorygameshopify.model;

/**
 * This class model a Card for the memory Game.
 * Card class for formed sole by the id and image reference.
 *
 * @author Daniel Minami
 */
public class Card {

    private int id;
    private String imageSrc;

    /**
     * Constructs an empty Card
     */
    public Card() {}

    /**
     * Constructs a Card Object with data
     *
     * @param id
     * @param imageSrc
     */
    public Card(int id, String imageSrc) {
        this.id = id;
        this.imageSrc = imageSrc;
    }

    /**
     * Get Card ID
     * @return Card's id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets Card ID
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets Card Image Reference
     * @return Card's Image Reference
     */
    public String getImageSrc() {
        return imageSrc;
    }

    /**
     * Sets Card Image Reference
     * @param imageSrc
     */
    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
}
