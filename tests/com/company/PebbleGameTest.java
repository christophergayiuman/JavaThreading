package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PebbleGameTest {
    PebbleGame pebbleGame = new PebbleGame();

    //Create Players
    PebbleGame.Player player0 = new PebbleGame.Player(0);
    PebbleGame.Player player1 = new PebbleGame.Player(1);
    PebbleGame.Player player2 = new PebbleGame.Player(2);


    @BeforeEach
    void setUp() {
    }

    @Test
    void clearLogFile() {
    }

    @Test
    void createPlayerOutputNames() {
    }

    @Test
    void testCreatePlayerArray() {
        //Create Arraylist of players
        ArrayList<PebbleGame.Player> playerArrayList = new ArrayList<>();

        //Append the players to the list
        playerArrayList.add(player0);
        playerArrayList.add(player1);
        playerArrayList.add(player2);

        //Creates player array
        pebbleGame.createPlayerArray();

    }

    @Test
    void generateRandomNum() {
    }

    @Test
    void testSetTotalPlayerNumber() {
        //Set totalPlayerNumbers
        pebbleGame.setTotalPlayerNumber(3);

        //Checks if the set totalPlayerNumber is the same as getting the player number
        assertEquals(3, pebbleGame.getTotalPlayerNumber());

        //Checks if the set totalPlayerNumber is the not the same as getting the player number
        assertNotEquals(4, pebbleGame.getTotalPlayerNumber());
    }

    @Test
    void discardPebble() {
        // create
        Pebble p1 = new Pebble(1);
        Pebble p2 = new Pebble(2);
        Pebble p3 = new Pebble(3);
        Pebble p4 = new Pebble(4);
        ArrayList<Pebble> pebbles = new ArrayList<>();
        pebbles.add(p1);
        pebbles.add(p2);
        pebbles.add(p3);
        pebbles.add(p4);

        player0.setPLayerHand(pebbles);

        assertEquals(pebbles, player0.getPlayerHand());

    }


    @Test
    void setAllBags() {

    }

    @Test
    void getTotalPlayerNumber() {
        //Set total player numbers
        pebbleGame.setTotalPlayerNumber(3);
        assertEquals(3, pebbleGame.getTotalPlayerNumber());
    }

    @Test
    void getPlayerArrayList() {
    }

    @Test
    void getAllBags() {
    }

    @Test
    void main() {
    }
}