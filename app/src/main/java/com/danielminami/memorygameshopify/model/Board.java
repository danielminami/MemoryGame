package com.danielminami.memorygameshopify.model;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Board extends ArrayList<Card> {

    public Board() {}

    public Board(ArrayList<Card> cards) {
        this.addAll(cards);
        this.addAll(cards);
    }

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
