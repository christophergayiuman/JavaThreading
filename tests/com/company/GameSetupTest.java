package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class GameSetupTest {
    GameSetup gameSetup = new GameSetup();
    private String bag0FilePath = "src\\com\\company\\ex1.csv";

    @BeforeEach
    void setUp() {

    }

    @Test
    void testCreateBags() {
        // runs the function so that it can be tested
        gameSetup.createBags();

        // checks that 3 black and 3 white bags are created
        // and are in the 'allBag' array
        assertEquals(3, gameSetup.getAllBags().get(0).size());
        assertEquals(3, gameSetup.getAllBags().get(1).size());

        assertEquals("A", gameSetup.getAllBags().get(0).get(0).getBagName());
        assertEquals("B", gameSetup.getAllBags().get(0).get(1).getBagName());
        assertEquals("C", gameSetup.getAllBags().get(0).get(2).getBagName());
        assertEquals("X", gameSetup.getAllBags().get(1).get(0).getBagName());
        assertEquals("Y", gameSetup.getAllBags().get(1).get(1).getBagName());
        assertEquals("Z", gameSetup.getAllBags().get(1).get(2).getBagName());
    }

    @Test
    void testGetAllBags() {
        // creates the bags in the gameSetup
        testCreateBags();

        // fills local allBag array
        Bag A = new Bag();
        A.Bag("A", new AtomicInteger());
        Bag B = new Bag();
        B.Bag("B", new AtomicInteger());
        Bag C = new Bag();
        C.Bag("C", new AtomicInteger());
        Bag X = new Bag();
        X.Bag("X", new AtomicInteger());
        Bag Y = new Bag();
        Y.Bag("Y", new AtomicInteger());
        Bag Z = new Bag();
        Z.Bag("Z", new AtomicInteger());

        ArrayList<ArrayList<Bag>> allBag = new ArrayList<>();
        ArrayList<Bag> whiteBags = new ArrayList<>();
        ArrayList<Bag> blackBags = new ArrayList<>();

        whiteBags.add(A); whiteBags.add(B); whiteBags.add(C);
        blackBags.add(X); blackBags.add(Y); blackBags.add(Z);
        allBag.add(0,whiteBags);
        allBag.add(1,blackBags);

        // checks the allBag are the same
        assertTrue(allBag.get(0).get(0).getBagName().equals(gameSetup.getAllBags().get(0).get(0).getBagName()));
    }

    @Test
    void testGetPlayersNo() {
        // sets player no=umber
        gameSetup.setPlayersNo(3);
        // checks the the method works
        assertEquals(3, gameSetup.getPlayersNo());
    }
}