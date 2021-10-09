/*
* @author Cory Marleau, Harrison Winters, Kamalii Silva, Jason Katayama
*
* */

package com.example.gui_test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class ScrabbleGameState {
    private Player[] players;
    private int playerTurn; //index for the player whose turn it is
    private Board scrabbleBoard;
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
        scrabbleBoard = new Board();

        //create new scrabble bag
        bag = new Bag();

        //create new Timer
        timer = new Timer();

        //Give players their decks
        for (int i = 0; i < 4; i++) {
            drawLetter(players[i], bag);
            drawLetter(players[i], bag);
            drawLetter(players[i], bag);
            drawLetter(players[i], bag);
            drawLetter(players[i], bag);
            drawLetter(players[i], bag);
            drawLetter(players[i], bag);
        }

    }
    //deep copy constructor
    public ScrabbleGameState(ScrabbleGameState s, int player){

        //create 4 new players for the game
        players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = s.players[i];
        }

        //choose which player's turn it is
        playerTurn = s.playerTurn;

        //create new board
        scrabbleBoard = new Board(s.scrabbleBoard);

        //create new scrabble bag
        bag = new Bag(s.bag);

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

    public boolean placeLetter(Tile tile){
        Random rnd = new Random();
        scrabbleBoard.addToBoard(tile, rnd.nextInt(), rnd.nextInt());
        return true;
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
        String toReturn = new String("Current Player turn is:" + (playerTurn + 1));
        toReturn = toReturn +  "\nLetters in the bag are:" + bag.toString();
        toReturn = toReturn +"\nHere are current player's letters: ";

        for (int i = 0; i < 4; i++ ){
            toReturn = toReturn + "\nPlayer" + (i + 1);

            toReturn = toReturn + players[i].toString();
        }

        return toReturn;
    }
}
