package com.company;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Bag {
    //Establishing bag private variables
    private String bagName;
    private AtomicInteger bagSize = new AtomicInteger(0);
    private ArrayList<Pebble> pebbles = new ArrayList<>();

    public ArrayList<Pebble> getPebbles() {
        return pebbles;
    }

    // bag constructor
    public void Bag(String bagName, AtomicInteger bagSize) {
        this.bagName = bagName;
        this.bagSize = bagSize;
    }

    //Set the entire bag
    public void setPebblesArray(ArrayList<Pebble> pebblesArray){
        this.pebbles = pebblesArray;
    }

    //adds a pebble to the bag and increments the size of the atomic variable
    public void addPebble(Pebble pebble) {
        pebbles.add(pebble);
        bagSize.incrementAndGet();
    }

    //Removes pebble from the bag and decrements the atomic variable
    public void removePebble(Pebble pebble){
        pebbles.remove(pebble);
        bagSize.decrementAndGet();
    }

    //Increments the bag size manually
    public void incrementWhiteBagSize() { bagSize.incrementAndGet(); }

    //This function removes all of the pebbles from the bag arraylist
    public void clearBag(){
        pebbles.clear();
    }

    //Return the current bag name
    public String getBagName(){
        return bagName;
    }

    //Returns the bagsize in an integer value
    public int getBagSize() {
        return bagSize.intValue();
    }

    //useful in testing for printing out the current bags contents
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
