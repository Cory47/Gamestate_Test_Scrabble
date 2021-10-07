package com.example.gui_test;

import java.util.ArrayList;
import java.util.Timer;

public class ScrabbleGameState {
    private Player[] players;
    private int playerTurn; //index for the player whose turn it is
    private Board board;
    private Bag bag;
    private Timer timer;

    public ScrabbleGameState(){
        //create 4 new players for the game
        players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("Player" + i);
        }
        //choose which player's turn it is
        playerTurn = 0;

        //create new board
        board = new Board();

        //create new scrabble bag
        bag = new Bag();

        //create new Timer
        timer = new Timer();

    }
    //deep copy constructor
    public ScrabbleGameState(ScrabbleGameState s){

        //create 4 new players for the game
        players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = s.players[i];
        }

        //choose which player's turn it is
        playerTurn = s.playerTurn;

        //create new board
        board = new Board();
        board = s.board;

        //create new scrabble bag
        bag = new Bag();
        bag = s.bag;

        //create new Timer
        timer = new Timer();
        timer = s.timer;
    };

    public boolean drawLetter(Player player, Bag b){
        if (player != players[playerTurn]) {
            return false;
        }

        //add a random tile to the player's deck
        player.setDeck(b.get());
        return true;
    }

    public boolean placeLetter(){
        return false;
    };

    public boolean clear(){
        return false;
    };

    public boolean exchangeLetter(Player player, Bag b, Tile[] selectedTiles) {

        //Check if it's the current player's turn
        if (player != players[playerTurn]) {
            return false;
        }



        //Remove tiles from player's deck
        //add tiles back to bag
        for (Tile tile: selectedTiles){
            player.removeFromDeck(tile);
            b.put(tile);
        }

        //end player's turn

        endTurn(player);

        return true;


    }

    public boolean displayRules(){
        return false;
    }

    public boolean endTurn(Player player){
        if (player != players[playerTurn]) {
            return false;
        }
        if (player == players[0])
        {
        return true;
        }
        return true;
    }

    @Override
    public String toString(){
        return null;
    }
}
