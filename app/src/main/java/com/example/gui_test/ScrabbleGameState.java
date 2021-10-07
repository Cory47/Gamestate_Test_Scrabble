package com.example.gui_test;

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

    public boolean drawLetter(){
        return false;
    };

    public boolean placeLetter(){
        return false;
    };

    public boolean clear(){
        return false;
    };

    public boolean exchangeLetter() {
        return false;
    }

    public boolean displayRules(){
        return false;
    }

    public boolean endTurn(){
        return false;
    }

    @Override
    public String toString(){
        return null;
    }
}
