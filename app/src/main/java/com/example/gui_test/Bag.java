/*
 * @author Cory Marleau, Harrison Winters, Kamalii Silva, Jason Katayama
 *
 * */
package com.example.gui_test;

import java.util.ArrayList;
import java.util.Random;

public class Bag {
    private ArrayList<Tile> tiles;
    private Random rnd;

    public Bag (){
        tiles = new ArrayList<>();
        rnd = new Random();
        tiles.add(new Tile("a", 1));
        tiles.add(new Tile("a", 1));
        tiles.add(new Tile("a", 1));
        tiles.add(new Tile("a", 1));
        tiles.add(new Tile("a", 1));
        tiles.add(new Tile("a", 1));

        tiles.add(new Tile("b", 3));
        tiles.add(new Tile("b", 3));
        tiles.add(new Tile("b", 3));
        tiles.add(new Tile("b", 3));
        tiles.add(new Tile("b", 3));
        tiles.add(new Tile("b", 3));
        tiles.add(new Tile("b", 3));

        tiles.add(new Tile("c", 3));
        tiles.add(new Tile("c", 3));
        tiles.add(new Tile("c", 3));
        tiles.add(new Tile("c", 3));
        tiles.add(new Tile("c", 3));
        tiles.add(new Tile("c", 3));

        tiles.add(new Tile("d", 2));
        tiles.add(new Tile("d", 2));
        tiles.add(new Tile("d", 2));
        tiles.add(new Tile("d", 2));
        tiles.add(new Tile("d", 2));
        tiles.add(new Tile("d", 2));

        tiles.add(new Tile("e", 1));
        tiles.add(new Tile("e", 1));
        tiles.add(new Tile("e", 1));
        tiles.add(new Tile("e", 1));
        tiles.add(new Tile("e", 1));
        tiles.add(new Tile("e", 1));



        tiles.add(new Tile("f", 4));
        tiles.add(new Tile("f", 4));
        tiles.add(new Tile("f", 4));
        tiles.add(new Tile("f", 4));
        tiles.add(new Tile("f", 4));
        tiles.add(new Tile("f", 4));
        tiles.add(new Tile("f", 4));
        tiles.add(new Tile("f", 4));

        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));
        tiles.add(new Tile("g", 2));

        tiles.add(new Tile("h", 4));
        tiles.add(new Tile("h", 4));
        tiles.add(new Tile("h", 4));
        tiles.add(new Tile("h", 4));
        tiles.add(new Tile("h", 4));
        tiles.add(new Tile("h", 4));

        tiles.add(new Tile("i", 1));
        tiles.add(new Tile("j", 8));
        tiles.add(new Tile("k", 5));
        tiles.add(new Tile("l", 1));


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


    @Override
    public String toString() {
        String toReturn = new String("");
        for (int i = 0; i < tiles.size(); i++) {
            toReturn = toReturn + "\n" + tiles.get(i).getName();
        }

        return toReturn;
    }

}
