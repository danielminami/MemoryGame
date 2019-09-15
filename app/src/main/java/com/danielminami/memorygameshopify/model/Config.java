package com.danielminami.memorygameshopify.model;


/**
 * This class models the game Configuration.
 * This is a Singleton class that is used to keep track of the users configuration
 *
 */
public class Config {

    public static Config obj;
    private int matchingCards;
    private int numOfMatchesPerGame;

    private Config() {

    }

    public Config getConfig() {
        if (obj == null) {
            return new Config();
        } else {
            return obj;
        }
    }

    public int getMatchingCards() {
        return matchingCards;
    }

    public void setMatchingCards(int matchingCards) {
        this.matchingCards = matchingCards;
    }

    public int getNumOfMatchesPerGame() {
        return numOfMatchesPerGame;
    }

    public void setNumOfMatchesPerGame(int numOfMatchesPerGame) {
        this.numOfMatchesPerGame = numOfMatchesPerGame;
    }
}
