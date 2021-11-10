package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class GameSetup {
    // hardcoded starting game info for easier testing
    private int playersNo = 3;
    private String bag0FilePath = "src\\com\\company\\ex1.csv";
    private String bag1FilePath = "src\\com\\company\\ex1.csv";
    private String bag2FilePath = "src\\com\\company\\ex1.csv";
    private ArrayList<ArrayList<Bag>> allbags;


    public void startingGameInfo() {
        System.out.println("Welcome to the PebbleGame!!\n" +
                "You will be asked to enter the number of players.\n" +
                "and then for the location of the three files in turn containing comma separated integer values of the pebble weights.\n" +
                "The integer values must be strictly positive.\n" +
                "The game will then be simulated, and output written files in this directory.\n");

        // get number of players
        while (true) {
            try {
                Scanner inputPlayerNo = new Scanner(System.in);
                System.out.println("Please enter the number of players:");
                String playerNo = inputPlayerNo.nextLine();
                exitGame(playerNo);
                if (!playerNo.matches("[0-9]+") || Integer.parseInt(playerNo) < 1) {
                    System.out.println("Please enter a valid number of players.\n");
                    continue;
                }
                this.playersNo = Integer.parseInt(playerNo);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.\n");
            }
        }
        // get pebble weight file paths
        while (true) {
            try {
                Scanner inputCsvFiles = new Scanner(System.in);
                System.out.println("Please enter location of bag number 0 to load:");
                String bag0 = inputCsvFiles.nextLine();
                exitGame(bag0);
                if (checkUserinput(bag0)) continue;

                System.out.println("Please enter location of bag number 1 to load:");
                String bag1 = inputCsvFiles.nextLine();
                exitGame(bag1);
                if (checkUserinput(bag1)) continue;

                System.out.println("Please enter location of bag number 2 to load:");
                String bag2 = inputCsvFiles.nextLine();
                exitGame(bag2);
                if (checkUserinput(bag2)) continue;
                this.bag0FilePath = bag0;
                this.bag1FilePath = bag1;
                this.bag2FilePath = bag2;
                //checkBagContents(bag0);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid file location.");
            }
        }
    }

    // creates bags
    public void createBags() {

        //creates bags
        Bag A = new Bag();
        A.Bag("A", new AtomicInteger(), true);
        Bag B = new Bag();
        B.Bag("B", new AtomicInteger(), true);
        Bag C = new Bag();
        C.Bag("C", new AtomicInteger(), true);
        Bag X = new Bag();
        X.Bag("X", new AtomicInteger(), false);
        Bag Y = new Bag();
        Y.Bag("Y", new AtomicInteger(), false);
        Bag Z = new Bag();
        Z.Bag("Z", new AtomicInteger(), false);

        //fills black bags with pebbles
        fillBag(X, readPebbleWeightFile(bag0FilePath));
        fillBag(Y, readPebbleWeightFile(bag1FilePath));
        fillBag(Z, readPebbleWeightFile(bag2FilePath));

        //Fill arraylist with bags
        ArrayList<ArrayList<Bag>> allBags = new ArrayList<ArrayList<Bag>>();
        ArrayList<Bag> whiteBags = new ArrayList<Bag>();
        ArrayList<Bag> blackBags = new ArrayList<Bag>();

        whiteBags.add(A); whiteBags.add(B); whiteBags.add(C);
        blackBags.add(X); blackBags.add(Y); blackBags.add(Z);
        allBags.add(0,whiteBags);
        allBags.add(1,blackBags);

        this.allbags = allBags;
    }

    public ArrayList<ArrayList<Bag>> getAllbags (){ return allbags; }

    // fills a bag with pebbles
    public void fillBag(Bag bag, String[] weights) {
        for (String w: weights) {
            bag.addPebble(new Pebble(Integer.parseInt(w)));
        }
    }

    // reads pebble weights file
    public String[] readPebbleWeightFile(String filePath) {
        String[] pebbleWeightList = null;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                pebbleWeightList = (line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pebbleWeightList;
    }

    //exit game when user wants
    public void exitGame(String input) {
        if (input.equals("E")) {
            System.out.println("Thanks for playing...Goodbye!!");
            System.exit(0);
        }
    }

    /**public void checkBagContents(String bagLocation) {
        String[] bagContents = readPebbleWeightFile(bagLocation);
        for (String b : bagContents ) {
            if (Integer.parseInt(b.))

        }
        System.out.println(bagContents[14]);

    }**/

    //checks correct file
    public boolean checkUserinput(String input) {
       if (!(input.endsWith(".csv") || input.endsWith(".txt"))) {
            System.out.println("Please enter a valid csv file.\n");
            return true;
       }
        return false;
    }

    public int getPlayersNo(){return playersNo;}

}
