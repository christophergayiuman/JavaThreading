package com.company;

import com.company.Bag;
import com.company.Pebble;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class BagTest {
    // creates a bag
    Bag bag = new Bag();

    // creates atomic integer
    private final AtomicInteger ai = new AtomicInteger(0);

    // creates pebbles
    Pebble p1 = new Pebble(1);
    Pebble p2 = new Pebble(2);
    Pebble p3 = new Pebble(3);
    Pebble p4 = new Pebble(4);

    @BeforeEach
    void setUp() {
        // sets up bag object to be used by testing
        bag.Bag("A", ai);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetPebbles() {
        // creates a pebble array
        ArrayList<Pebble> pebbles = new ArrayList<>();
        pebbles.add(p1);
        pebbles.add(p2);
        pebbles.add(p3);
        pebbles.add(p4);

        // sets pebble array
        bag.setPebblesArray(pebbles);
        // checks that the pebble array created and pulled are the same
        assertEquals(pebbles, bag.getPebbles());

        // creates a different pebble array
        ArrayList<Pebble> pebbles1 = new ArrayList<>();
        pebbles1.add(p1);

        // checks that the different array are not the same
        assertNotSame(pebbles1, bag.getPebbles());
    }

    @Test
    void testSetPebblesArray() {
        // creates a pebble array
        ArrayList<Pebble> pebbles = new ArrayList<>();
        pebbles.add(p1);
        pebbles.add(p2);
        pebbles.add(p3);

        // creates a pebble array
        ArrayList<Pebble> pebbles1 = new ArrayList<>();
        pebbles1.add(p1);
        pebbles1.add(p2);
        pebbles1.add(p3);
        pebbles1.add(p4);

        // sets pebbles array
        bag.setPebblesArray(pebbles);

        //checks if the pebbles array set and created are the same
        assertEquals(pebbles, bag.getPebbles());
        //checks if the pebbles array set and created are not the same
        assertNotSame(pebbles1, bag.getPebbles());
    }

    @Test
    void testAddPebble() {
        // adds pebble to bag
        bag.addPebble(p1);

        // checks pebble is in bag
        assertTrue(bag.getPebbles().contains(p1));
    }

    @Test
    void testRemovePebble() {
        // tests removing a pebble that's not in the list
        bag.removePebble(p1);
        assertFalse(bag.getPebbles().contains(p1));

        // adds pebble to pebble list
        bag.addPebble(p1);
        assertTrue(bag.getPebbles().contains(p1));
        assertEquals(1, bag.getPebbles().size());

        // tests removing the pebble from pebble list
        bag.removePebble(p1);
        assertFalse(bag.getPebbles().contains(p1));
    }

    @Test
    void testIncrementWhiteBagSize() {
        // checks starting values are the same
        assertEquals(ai.intValue(), bag.getBagSize());

        // increments bag size
        bag.incrementWhiteBagSize();
        // checks that the bag size has incremented
        assertEquals(1, bag.getBagSize());
        // false case
        assertNotEquals(2, bag.getBagSize());
    }

    @Test
    void testClearBag() {
        // tests clear bag when it's empty
        bag.clearBag();
        assertEquals(0, bag.getPebbles().size());

        // creates pebble array
        ArrayList<Pebble> pebbles = new ArrayList<>();
        pebbles.add(p1);
        pebbles.add(p2);
        pebbles.add(p3);

        // fills bag
        bag.setPebblesArray(pebbles);
        assertEquals(3, bag.getPebbles().size());

        // checks bag is cleared
        bag.clearBag();
        assertEquals(0, bag.getPebbles().size());
    }

    @Test
    void testGetBagName() {
        // checks if bag name set and the name from the get method are the same
        assertEquals("A", bag.getBagName());

        // checks if bag name set and the name from the get method are the same
        assertFalse("X".equals(bag.getBagName()));
    }

    @Test
    void testGetBagSize() {
        // increments bag size
        bag.incrementWhiteBagSize();
        bag.incrementWhiteBagSize();

        // checks bag size is correct
        assertEquals(2, bag.getBagSize());
    }
}