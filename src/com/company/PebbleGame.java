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
//
//    public void removeOldPebbles(ArrayList<Integer> tempWeightsArray, int[] randomPebblePath){
//        ArrayList<ArrayList<Bag>> tempAllBags = new ArrayList<ArrayList<Bag>>();
//        tempAllBags = getAllBags();
//
//        for (int i = 0; i < tempWeightsArray.size(); i++) {
//
//        }
//
//
//    }

    //Fill player pebble array
    public void fillPlayerBag() {
        try {
//            if (!(allBags.isEmpty() && playerArrayList.isEmpty()))
            {
                //Fill up player
//                All bags first array = [0-1] white bag or black bag, [0-2] second array is the 3 bags of that class

                //Generates a random pebble from
                int[] randomPebblepath = {1, generateRandomNum(2)};
                ArrayList<Pebble> tempWeightsArray = new ArrayList<Pebble>();

                //Prints out current bag
//                System.out.println(allBags.get(randomPebblepath[0]).get(randomPebblepath[1]));

                //Loops through black bag and appends to temp list
                for (int i = 0; i < 10; i++) {
                    int randomPebbleNum = generateRandomNum(99 - i);

                    //Prints out the pebble object being appened, into the terminal
                    System.out.println("Pebble" + i + " : " +
                            allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(generateRandomNum(randomPebbleNum)));

                    //Appends that pebble to the tempWeights Array
                    tempWeightsArray.add(i, allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(randomPebbleNum));
                }


                //Append the pebbles to the player hand


                //Temp pebble bag that has its contents appended
                ArrayList<Pebble> tempPebbles = new ArrayList<Pebble>();
                for (int i = 0; i < allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().size(); i++) {
                    tempPebbles.add(allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(i));
                }

                System.out.println(tempPebbles.size());

                //Temp pebble bag has its contents removed(the pebbles that were added to the playerhand)
                for (int i = 0; i < 10; i++) {
                    tempPebbles.remove(tempWeightsArray.get(i));
                }

                System.out.println(tempPebbles.size());




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
