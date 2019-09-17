package com.danielminami.memorygameshopify.model;

import java.util.ArrayList;


/**
 * This class models the Game Board.
 * It inherits an ArrayList of Cards.
 * The board is construct in a Loop and users the Config Singleton Class to define the
 * number of Cards the game will be built with
 *
 * @author Daniel Minami
 */
public class Board extends ArrayList<Card> {

    /**
     * Constructs an Empty Board
     */
    public Board() {}

    /**
     * Constructs an board based on users configuration
     * @param cards Number of Matches per game
     */
    public Board(ArrayList<Card> cards) {
        for (int i = 0; i < Config.getNumOfMatchesPerGame(); i++) {
            this.addAll(cards);
        }

    }

    /**
     * This method compares the Cards and returns true if they have the same ID.
     * Returns false otherwise.
     *
     * @param clicks group of cards
     * @return true if they are equal, false otherwise
     */
    public boolean match(CardsClicked clicks) {
        boolean matchFound = true;
        int idCard = clicks.get(0).getCard().getId();
        for (int i = 1; i < clicks.size(); i++) {
            if (idCard != clicks.get(i).getCard().getId()) {
                matchFound = false;
            }
        }
        return matchFound;
    }

}
