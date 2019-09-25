package com.danielminami.memorygame.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * This class models the game Configuration.
 * This is a Singleton class that is used to keep track of the users configuration and is used as
 * a single instance all over the game
 *
 * @author Daniel Minami
 */
public class Config {

    private static Config obj = new Config();
    private static int pairsToMatch = 10;
    private static int numOfMatchesPerGame = 2;
    private static int columnSize = 50;
    private static String endPoint = "https://shopicruit.myshopify.com/";

    /**
     * Private constructor avoids creation of new instances
     */
    private Config() {}

    /**
     * This method constructs a Config object and returns it. If the object already exists,
     * the existing instance is returned instead.
     *
     * @return the single instance of Config
     */
    public static Config getConfig() {
        if (obj == null) {
            return new Config();
        } else {
            return obj;
        }
    }

    /**
     * Gets the number of cards to form a match
     *
     * @return number of cards to form a match
     */
    public static int getPairsToMatch() {
        return pairsToMatch;
    }

    /**
     * Sets the number of cards to form a match
     *
     * @param pairsToMatch number
     */
    public void setPairsToMatch(int pairsToMatch) {
        this.pairsToMatch = pairsToMatch;
    }

    /**
     * Gets number of pairs to match
     *
     * @return number of pairs to match
     */
    public static int getNumOfMatchesPerGame() {
        return numOfMatchesPerGame;
    }

    /**
     * Sets number of pairs to match
     *
     * @param numOfMatchesPerGame number
     */
    public void setNumOfMatchesPerGame(int numOfMatchesPerGame) {
        this.numOfMatchesPerGame = numOfMatchesPerGame;
    }

    /**
     * Gets the View Column Size
     * @return the size
     */
    public static int getColumnSize() {
        return columnSize;
    }

    /**
     * Gets the application EndPoint
     * @return the EndPoint
     */
    public static String getEndPoint() {
        return endPoint;
    }


    /**
     * This method is used to dynamically decide how many cards will be placed
     * for screen line.
     *
     * Credits: https://stackoverflow.com/a/38472370
     */
    public static int calculateNoOfColumns(Context context) {

        float columnWidthDp = 85 - (((pairsToMatch * 2) + (numOfMatchesPerGame)/2));

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        return (int)(screenWidthDp / columnWidthDp + 0.5);
    }

}
