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
        String path1 = "src\\com\\company\\ex1.csv";
        String path2 = "src\\com\\company\\ex2.txt";
        String path3 = "src\\com\\company\\ex3.csv";
        GameSetup gs = new GameSetup();
        // hardcoded starting game info for easier testing
        //gs.startingGameInfo();
        gs.createBags();

        PebbleGame pg = new PebbleGame();
        PebbleGame.Player players = new PebbleGame.Player(1);
        System.out.println("Randome generated Number: ");
        System.out.print(pg.generateRandomNum(5));


    }
}
