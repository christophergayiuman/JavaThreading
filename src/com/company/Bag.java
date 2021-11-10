package com.company;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Bag {

    private String bagName;
    //private int bagSize;
    private AtomicInteger bagSize = new AtomicInteger(0);
    private boolean isWhite;
    private ArrayList<Pebble> pebbles = new ArrayList<>();

    public ArrayList<Pebble> getPebbles() {
        return pebbles;
    }

    // bag constructor
    public void Bag(String bagName, AtomicInteger bagSize, boolean isWhite) {
        this.bagName = bagName;
        this.bagSize = bagSize;
        this.isWhite = isWhite;
    }

    //adds a pebble to the bag
    //Update bag size.
    public void addPebble(Pebble pebble) {
        pebbles.add(pebble);
        bagSize.incrementAndGet();
    }

    public void removePebble(Pebble pebble){
        pebbles.remove(pebble);
        bagSize.decrementAndGet();
    }

    public void incrementWhiteBagSize() { bagSize.incrementAndGet(); }


    public void clearBag(){
        pebbles.clear();
    }

    @Override
    public String toString() {
        return "Bag{" +
                "bagName='" + bagName + '\'' +
                ", bagSize=" + bagSize +
//                ", isWhite=" + isWhite +
//                ", pebbles=" + pebbles +
                '}';
    }

}
