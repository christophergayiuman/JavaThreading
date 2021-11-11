package com.company;

import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {

            //Setting up the game
        String path1 = "src\\com\\company\\ex1.csv";
        String path2 = "src\\com\\company\\ex2.txt";
        String path3 = "src\\com\\company\\ex3.csv";
        GameSetup gs = new GameSetup();
        gs.createBags();
        //gs.startingGameInfo();

        //Setting up PebbleGame
        //PebbleGame pg = new PebbleGame();
        //pg.setTotalPlayerNumber(gs.getPlayersNo());
        //pg.createPlayerArray();


        // Player hand changing
        //pg.fillPlayerHand();

    }

}
