package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

            //Setting up the game
        String path1 = "src\\com\\company\\ex1.csv";
        String path2 = "src\\com\\company\\ex2.txt";
        String path3 = "src\\com\\company\\ex3.csv";
        GameSetup gs = new GameSetup();
        // hardcoded starting game info for easier testing
        //gs.startingGameInfo();


        //Get the weight of the pebble from the bag, arraylist thats returned from createbags
        gs.createBags();
        gs.getAllbags();
        //Use code below to get the pebble from the bag
//        System.out.println(gs.getAllbags()[1][0].getPebbles().get(3).getWeight());


            //Setting up PebbleGame
        PebbleGame pg = new PebbleGame();
        pg.setTotalPlayerNumber(gs.getPlayersNo());
        pg.createPlayerArray();
        pg.fillPlayerBag();



//        System.out.println(pg.getPlayerArrayList().get(0));
//        PebbleGame.Player players = new PebbleGame.Player(1);
//        System.out.println("Random generated Number: ");
//        System.out.print(pg.generateRandomNum(5));


    }
}
