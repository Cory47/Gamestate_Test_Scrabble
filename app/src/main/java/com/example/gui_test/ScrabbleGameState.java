/**
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
        for (int i = 0; i < 7; i++) {
            for (int q = 0; q < 4; q++) {
                drawLetter(players[q]);
            }
        }
    }

    //deep copy constructor
    public ScrabbleGameState(ScrabbleGameState s){
        //create 4 new players for the game
        players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player(s.players[i]);
        }
        //choose which player's turn it is
        playerTurn = s.playerTurn;
        //create new board
        scrabbleBoard = new Board(s.scrabbleBoard);
        //create new scrabble bag
        bag = new Bag(s.bag);
        //create new Timer
        timer = new Timer();
    };

    /**
     * drawLetter - Method for drawing random letters
     * @param player
     * @return true if a valid move
     */
    public boolean drawRandLetter(Player player){
        if (scrabbleBoard.isEmpty()) {
            player.setDeck(bag.get());
            return true;
        }
        if (player != players[playerTurn]){
            return false;
        }
        //add a random tile to the player's deck
        player.setDeck(bag.get());
        return true;
    }

    /**
     * drawLetter - Method for drawing specific letters
     * @param player
     * @return true if a valid move
     */
    public boolean drawLetter(Player player){
        if (scrabbleBoard.isEmpty()) {
            player.setDeck(bag.get());
            return true;
        }
        if (player != players[playerTurn]){
            return false;
        }
        //add a random tile to the player's deck
        player.setDeck(bag.get());
        return true;
    }

    /**
     * Action for placing a letter
     * @param playerIdx which player is using this action
     * @param letterIdx which letter from the hand is being placed
     * @return
     */
    public boolean placeLetter(int playerIdx, int letterIdx, int x, int y){
        //Not Players Turn
        if(playerIdx != playerTurn){
            return false;
        }

        //Does not play in the middle on first turn
        else if(scrabbleBoard.isEmpty() && x == 7 && y == 7){
            Tile tile = players[playerIdx].getTile(letterIdx);
            scrabbleBoard.addToBoard(tile, x, y);
            return true;
        }
        else if(scrabbleBoard.isEmpty()){
            return false;
        }
        //Other checks if needed
        Tile tile = players[playerIdx].getDeck().get(letterIdx);
        scrabbleBoard.addToBoard(tile, x, y);
        return true;
    };

    /**
     * action to clear any movement
     * @return valid move
     */
    public boolean clear(){
        return false;
    };

    /**
     * exchange letter action
     * @param playerIdx
     * @param letterIdx
     * @return if it is a valid move
     */
    public boolean exchangeLetter(int playerIdx, int letterIdx) {

        //Check if it's the current player's turn
        if (playerIdx != playerTurn) {
            return false;
        }

        //Remove tiles from player's deck and holds it
        Tile hold = players[playerIdx].removeFromDeck(letterIdx);

        //draw new tiles
        players[playerIdx].setDeck(bag.get());

        //add the tile back to the bag
        bag.put(hold);

        return true;


    }

    public boolean displayRules(){
        return false;
    }

    public boolean endTurn(int playerIdx){
        if (playerIdx != playerTurn) {
            return false;
        }
        playerTurn++;
        if(playerTurn >= players.length){
            playerTurn = 0;
        }
        return true;
    }

    @Override
    public String toString(){
        String toReturn = "Current Player turn is: " + (playerTurn + 1);
        toReturn = toReturn +  "\nLetters in the bag are:" + bag.toString();
        toReturn = toReturn +"\nHere are current player's letters: ";
        for (int i = 0; i < 4; i++ ){
            toReturn = toReturn + "\nPlayer" + (i + 1);

            toReturn = toReturn + players[i].toString();
        }
        toReturn += "\n\nThis is the state of the board: \n" + scrabbleBoard.toString();
        toReturn = toReturn + "\n\n";

        return toReturn;
    }
}
