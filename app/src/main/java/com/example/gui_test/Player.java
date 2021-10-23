package com.example.gui_test;

/*
 * @author Cory Marleau, Harrison Winters, Kamalii Silva, Jason Katayama
 *
 * */
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Tile> deck;
    private int score;

    public Player(String n){
        name = n;
        deck = new ArrayList<Tile>();
        score = 0;
    }

    public Player(Player other){
        name = other.name;
        deck = new ArrayList<>();
        for(int i = other.deck.size() - 1; i >= 0; i--){
            deck.add(new Tile(other.deck.get(i)));
        }
    }

    public void setDeck(Tile t) {
        if (deck.size() >= 7 ) {
            return;
        }
        deck.add(t);
    }

    public Tile removeFromDeck(int idx) {
        Tile toReturn = deck.get(idx);
        deck.remove(idx);
        return toReturn;
    }

    public ArrayList<Tile> getDeck() {
        return deck;
    }

    public Tile getTile(int idx){
        return deck.get(idx);
    }


    @Override
    public String toString() {
        String toReturn = new String("");
        for (int i = 0; i < deck.size(); i++) {
            toReturn =  toReturn +  "-" + deck.get(i).getLetter();
        }
        return toReturn;
    }




}
