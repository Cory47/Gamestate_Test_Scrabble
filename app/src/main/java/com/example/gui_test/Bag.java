package com.example.gui_test;

import java.util.ArrayList;
import java.util.Random;

public class Bag {
    private ArrayList<Tile> tiles;
    private Random rnd;

    public Bag (){
        tiles = new ArrayList<>();
        rnd = new Random();
    }

    public Bag(Bag bag){
        tiles = new ArrayList<>();
        for (int i = 0; i < bag.tiles.size(); i++) {
            //tile to be added
            Tile temp = new Tile(bag.tiles.get(i));
            //add to new ArrayList
            tiles.add(temp);
        }
        rnd = new Random();
    }

    public void put(Tile newTile){
        tiles.add(newTile);
    }

    public Tile get(){
        int index = rnd.nextInt(tiles.size());
        Tile temp = tiles.get(index);
        tiles.remove(index);
        return temp;
    }
}
