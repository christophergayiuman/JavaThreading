package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSetupTest {
    GameSetup gameSetup = new GameSetup();

    @BeforeEach
    void setUp() {
    }

    // Don't need to test startingGameInfo as we are testing the function that test startingGameInfo

    @Test
    void createBags() {
        // runs the function so that it can be tested
        gameSetup.createBags();

        // checks that 3 black and 3 white bags are created
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
    void getAllbags() {
    }

    @Test
    void fillBag() {
    }

    @Test
    void readPebbleWeightFile() {
    }

    @Test
    void exitGame() {
    }

    @Test
    void checkBagContents() {
    }

    @Test
    void checkUserinput() {
    }

    @Test
    void getPlayersNo() {
        // sets player no=umber
        gameSetup.setPlayersNo(3);
        // checks the the method works
        assertEquals(3, gameSetup.getPlayersNo());
    }
}