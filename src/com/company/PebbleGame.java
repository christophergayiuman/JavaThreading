package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class PebbleGame {
    private int totalPlayerNumber;
    private ArrayList<Player> playerArrayList;
    private ArrayList<ArrayList<Bag>> allBags;

    //Player class
    static class Player {

        private ArrayList<Bag> playerBag;
        private int playerID;

        //Constructor for player
        public Player(int playerID) {
            this.playerID = playerID;
        }

        //Set player Bag//
        public void setPlayerBag(ArrayList<Bag> playerBag) {
            this.playerBag = playerBag;
        }

        //Get player bag
        public ArrayList<Bag> getPlayerBag(){
            return playerBag;
        }

        //Returns if player bag is empty
        public boolean bagEmpty(){
            return (playerBag.isEmpty());
        }

        //Set player pebbles array
//        public void setPlayerPebbles(ArrayList<Pebble> playerPebbles){this.playerPebbles = playerPebbles;}

        //prints player ID's
        public void printPlayerID() {
            System.out.println(playerID);
        }
    }

    //End of player class

    //Fill player pebble array
    public void fillPlayerBag() {
        try {
            if (!(allBags.isEmpty() && playerArrayList.isEmpty())) {





            }
        } catch (Exception e) {
            System.out.println("There is an error: " + e);
        }

    }

    //Create players arraylist
    public void createPlayerArray() {
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        for (int i = 0; i < totalPlayerNumber; i++) {
            Player player = new Player(i);
            playerArrayList.add(player);
        }
        this.playerArrayList = playerArrayList;
    }

    //Function to generate and return random number
    public Integer generateRandomNum(Integer Upperlimit) {
        //generate random number
        Random rand = new Random();
        int generatedRandomNumber = rand.nextInt(Upperlimit);
        generatedRandomNumber += 1;
        return generatedRandomNumber;
    }

//    //Function to generate and return random bag name
//    public String generateRandomBlackBagName (Integer Upperlimit){
//        //generate random number
//        Random rand = new Random();
//        int generatedRandomNumber = rand.nextInt(Upperlimit);
//        generatedRandomNumber += 1;
//
//        //Switch statement to convert from number to bagname
//        String randomChosenBlackBag;
//        switch (generatedRandomNumber){
//            case 1:
//                randomChosenBlackBag = "X";
//                break;
//            case 2:
//                randomChosenBlackBag = "Y";
//                break;
//            case 3:
//                randomChosenBlackBag = "Z";
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + generatedRandomNumber);
//        }
//
//        return randomChosenBlackBag;
//    }


    //Setter methods
    public void setTotalPlayerNumber(int totalPlayerNumber) {
        this.totalPlayerNumber = totalPlayerNumber;
    }

    public void setAllBags(ArrayList<ArrayList<Bag>> allBags) {
        this.allBags = allBags;
    }

    //Getter methods
    public int getTotalPlayerNumber() {
        return totalPlayerNumber;
    }

    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }

    public ArrayList<ArrayList<Bag>> getAllBags() {
        return allBags;
    }


}
