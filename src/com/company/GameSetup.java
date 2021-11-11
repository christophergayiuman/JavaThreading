package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
public class GameSetup {
    private int playersNo;// = 3;
    private String bag0FilePath;// = "src\\com\\company\\ex1.csv";
    private String bag1FilePath;// = "src\\com\\company\\ex1.csv";
    private String bag2FilePath;// = "src\\com\\company\\ex1.csv";
    private ArrayList<ArrayList<Bag>> allBags;


    //This functions gets the inputs of the players and starts the game
    public void startingGameInfo() {
        System.out.println("""
                Welcome to the PebbleGame!!
                You will be asked to enter the number of players.
                and then for the location of the three files in turn containing comma separated integer values of the pebble weights.
                The integer values must be strictly positive.
                The game will then be simulated, and output written files in this directory.
                """);

        // get number of players
        while (true) {
            try {
                //Scanner to get number of players
                Scanner inputPlayerNo = new Scanner(System.in);
                System.out.println("Please enter the number of players:");
                String playerNo = inputPlayerNo.nextLine();
                exitGame(playerNo);

                //If the player number is not 0-9 or greater then 0 ask for re input
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
                //Input prompt to get the location of first bag
                Scanner inputCsvFiles = new Scanner(System.in);
                System.out.println("Please enter location of bag number 0 to load:");
                String bag0 = inputCsvFiles.nextLine();
                exitGame(bag0);
                if (checkUserInput(bag0)) continue;

                //Input prompt to get the location of second bag
                System.out.println("Please enter location of bag number 1 to load:");
                String bag1 = inputCsvFiles.nextLine();
                exitGame(bag1);
                if (checkUserInput(bag1)) continue;

                //Input prompt to get the third bag
                System.out.println("Please enter location of bag number 2 to load:");
                String bag2 = inputCsvFiles.nextLine();
                exitGame(bag2);
                if (checkUserInput(bag2)) continue;
                this.bag0FilePath = bag0;
                this.bag1FilePath = bag1;
                this.bag2FilePath = bag2;
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

        //fills black bags with pebbles
        fillBag(X, readPebbleWeightFile(bag0FilePath));
        fillBag(Y, readPebbleWeightFile(bag1FilePath));
        fillBag(Z, readPebbleWeightFile(bag2FilePath));

        //Fill arraylist with bags
        ArrayList<ArrayList<Bag>> allBag = new ArrayList<>();
        ArrayList<Bag> whiteBags = new ArrayList<>();
        ArrayList<Bag> blackBags = new ArrayList<>();

        //Adding the corresponding bags to their araylist slot, either white bag or black
        whiteBags.add(A); whiteBags.add(B); whiteBags.add(C);
        blackBags.add(X); blackBags.add(Y); blackBags.add(Z);
        allBag.add(0,whiteBags);
        allBag.add(1,blackBags);

        this.allBags = allBag;
    }

    //Returns all bags
    public ArrayList<ArrayList<Bag>> getAllBags (){ return allBags; }

    // fills a bag with pebbles
    public void fillBag(Bag bag, String[] weights) {
        for (String w: weights) {
            bag.addPebble(new Pebble(Integer.parseInt(w)));
        }
    }

    // reads pebble weights file and returns the weight of each pebble
    public String[] readPebbleWeightFile(String filePath) {
        String[] pebbleWeightList = null;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) pebbleWeightList = (line.split(","));
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

    //checks correct file
    public boolean checkUserInput(String input) {
        if (!(input.endsWith(".csv") || input.endsWith(".txt"))) {
            System.out.println("Please enter a valid csv file.\n");
            return true;
        } else {
            String[] bagContents = readPebbleWeightFile(input);
            int pebbleAmount=0;
            try {
                for (String b : bagContents) {
                    pebbleAmount++;
                    if (Integer.parseInt(b) < 0) {
                        System.out.println("Files do not strictly contain positive weight.");
                        return true;
                    }
                }
                if (pebbleAmount<11*playersNo) {
                    System.out.println("File does not contain enough pebbles");
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Files do not contain valid values.");
                return true;
            }
        }
            return false;
    }

    //Set the total amount of players
    public void setPlayersNo(int playersNo) {
        this.playersNo = playersNo;
    }

    //Get the total players
    public int getPlayersNo(){return playersNo;}

}
