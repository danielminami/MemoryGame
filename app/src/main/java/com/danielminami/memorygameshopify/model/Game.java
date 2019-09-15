package com.danielminami.memorygameshopify.model;

public class Game {

    int userMove;
    int pairsFound;
    boolean isActive;

    public Game(int userMove, int pairsFound, boolean isActive) {
        this.userMove = userMove;
        this.pairsFound = pairsFound;
        this.isActive = isActive;
    }

    public int getUserMove() {
        return userMove;
    }

    public void setUserMove(int userMove) {
        this.userMove = userMove;
    }

    public int getPairsFound() {
        return pairsFound;
    }

    public void setPairsFound(int pairsFound) {
        this.pairsFound = pairsFound;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }




}
