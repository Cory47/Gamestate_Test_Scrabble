package com.example.gui_test;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Tile> deck = new ArrayList<Tile>();
    private int score;

    public Player(String n){
        name = n;
    }

    public void setDeck(Tile t) {
        if (deck.size() >= 7 ) {
            return;
        }
        deck.add(t);
    }

    public void removeFromDeck(Tile t) {
        deck.remove(t);

    }

    public ArrayList<Tile> getDeck() {
        return deck;
    }



}
