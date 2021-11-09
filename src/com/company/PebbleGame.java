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

        private ArrayList<Pebble> playerHand;
        private int playerID;

        //Constructor for player
        public Player(int playerID) {
            this.playerID = playerID;
        }

        //Set player Bag//
        public void setPlayerHand(ArrayList<Pebble> playerHand) {
            this.playerHand = playerHand;
        }

        //Get player bag
        public ArrayList<Pebble> getPlayerHand(){
            return playerHand;
        }

        //Returns if player bag is empty
        public boolean bagEmpty(){
            return (playerHand.isEmpty());
        }

        //Set player pebbles array
//        public void setPlayerPebbles(ArrayList<Pebble> playerPebbles){this.playerPebbles = playerPebbles;}

        //prints player ID's
        public void printPlayerID() {
            System.out.println(playerID);
        }
    }

    //Fill player pebble array
    public void fillPlayerHand(int playerSlot) {
        try {
            {
                //Fill up player hand

                //Generates a random pebble from
                int[] randomPebblepath = {1, generateRandomNum(2)};
                ArrayList<Pebble> tempWeightsHand = new ArrayList<Pebble>();

                //Loops through black bag and appends to temp list
                for (int i = 0; i < 10; i++) {
                    int randomPebbleNum = generateRandomNum(99 - i);

                    //Prints out the pebble object being appened, into the terminal
                    System.out.println("Pebble" + i + " : " +
                            allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(generateRandomNum(randomPebbleNum)));

                    System.out.println("Pebble" + i + " : " +
                            allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(generateRandomNum(randomPebbleNum)).getWeight());

                    //Appends that pebble to the tempWeights Array
                    tempWeightsHand.add(i, allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(randomPebbleNum));
                }



                //Append to playerhand



                //Temp pebble bag that has its contents appended
                ArrayList<Pebble> tempPebbles = new ArrayList<Pebble>();
                for (int i = 0; i < allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().size(); i++) {
                    tempPebbles.add(allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(i));
                }


                //Temp pebble bag has its contents removed(the pebbles that were added to the playerhand)
                for (int i = 0; i < 10; i++) {
                    tempPebbles.remove(tempWeightsHand.get(i));
                }


                //Need to work on this::
                playerArrayList.get(0).setPlayerHand(tempWeightsHand);
                System.out.println(playerArrayList.get(0).getPlayerHand().get(0).getWeight());
//                System.out.println(playerArrayList.get(0).getPlayerHand().get(0).getWeight());

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
        return generatedRandomNumber;
    }

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
