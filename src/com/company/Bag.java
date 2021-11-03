package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Bag {

    private String bagName;
    private int bagSize;
    private boolean isWhite;
    private ArrayList<Pebble> pebbles = new ArrayList<>();

    public ArrayList<Pebble> getPebbles() {
        return pebbles;
    }

    // bag constructor
    public void Bag(String bagName, int bagSize, boolean isWhite) {
        this.bagName = bagName;
        this.bagSize = bagSize;
        this.isWhite = isWhite;
    }

    //adds a pebble to the bag
    public void addPebble(Pebble pebble) {
        pebbles.add(pebble);
    }

    public boolean bagIsEmpty() {
        return bagSize == 0;
    }


    @Override
    public String toString() {
        return "Bag{" +
                "bagName='" + bagName + '\'' +
                ", bagSize=" + bagSize +
                ", isWhite=" + isWhite +
                ", pebbles=" + pebbles +
                '}';
    }

}
