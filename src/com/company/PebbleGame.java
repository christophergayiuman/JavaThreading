package com.company;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
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
        private int[] path;

        //Constructor for player
        public Player(int playerID) {
            this.playerID = playerID;
        }

        //Check if total pebbles is 100

        public boolean winCondition (){
            //Iterate through and add to totalWeights value
            int totalWeightsValue = 0;
            for (int i = 0; i < playerHand.size(); i++) {
                totalWeightsValue = totalWeightsValue + playerHand.get(i).getWeight();
            }

            //Check if 100
            if (totalWeightsValue >= 100){
                return true;
            } else {
                return false;
            }
        }


        //Set player Bag//
        public void setPlayerHand(ArrayList<Pebble> playerHand) {
            this.playerHand = playerHand;
        }

        //Set player path
        public void setPlayerPath(int[] path){this.path = path;}

        //Get player path
        public int[] getPlayerPath(){return path;}

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
    public void fillPlayerHand() {
        try {
            {
                //Fill up player hand

                for (int i  = 0; i < totalPlayerNumber; i++) {
                    //Generates a random pebble from
                    int[] randomPebblePath = {1, generateRandomNum(3)};
                    ArrayList<Pebble> tempWeightsHand = new ArrayList<Pebble>();

                    //Loops through black bag and appends to temp list
                    for (int j = 0; j < 10; j++) {
                        int randomPebbleNum = generateRandomNum(totalPlayerNumber*11 - j);

                        //Appends that pebble to the tempWeights Array
                        tempWeightsHand.add(j, allBags.get(randomPebblePath[0]).get(randomPebblePath[1]).getPebbles().get(randomPebbleNum));

                        //Remove the pebble form the origin black blag
                        allBags.get(randomPebblePath[0]).get(randomPebblePath[1]).removePebble(tempWeightsHand.get(j));

                    }
                    //Set the path of the latest pebble
                    int[] latestPlayerPath = {randomPebblePath[0], randomPebblePath[1]};
                    playerArrayList.get(i).setPlayerPath(latestPlayerPath);


                    //Apending to playerhand
                    playerArrayList.get(i).setPlayerHand(tempWeightsHand);

                    System.out.println("origin pebble" + randomPebblePath[0] + " Black bag: " + randomPebblePath[1]);
                }


            }
        } catch (Exception e) {
            System.out.println("There is an error: " + e);
        }

    }

    public void discardPebble(int playerID){
        //Change from black bag path to white bag path
        int[] whiteBagPebblePath = {0, playerArrayList.get(playerID).getPlayerPath()[1]};
        int tempGenerateRandomNum = generateRandomNum(10);

        //Adds pebble from playerHand to whitebag
        allBags.get(whiteBagPebblePath[0]).get(whiteBagPebblePath[1]).getPebbles().add(playerArrayList.get(playerID).getPlayerHand().get(tempGenerateRandomNum));
        allBags.get(whiteBagPebblePath[0]).get(whiteBagPebblePath[1]).incrementWhiteBagSize();


        //Discard pebble from playerHand
        playerArrayList.get(playerID).getPlayerHand().remove(tempGenerateRandomNum);
    }

    public void getNewPebble(int playerID){
        //Temp newPebblePath
        int[] tempNewPebblePath= {1, generateRandomNum(3)};

        //Random pebble generate number
        int tempGenerateRandomNum = generateRandomNum(allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).getPebbles().size());


        //checks if bag is empty and if true, refill from corresponding white bag
        if (allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).getPebbles().isEmpty()){

            //Make temp bag array and fill it with the array
            ArrayList<Bag> tempBags = new ArrayList<Bag>();
            tempBags.set(0, allBags.get(0).get(tempNewPebblePath[1]));

            //Empty the corresponding whitebag
            allBags.get(0).get(tempNewPebblePath[1]).clearBag();

            //set the temp array to the black bag now
            allBags.get(tempNewPebblePath[0]).set(tempNewPebblePath[1], tempBags.get(0));

        }

        //Add to playerhand
        Pebble tempPebble;
        tempPebble = allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).getPebbles().get(tempGenerateRandomNum);

        //Remove pebble from original bag
        allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).removePebble(tempPebble);

        //Append to playerHand
        playerArrayList.get(playerID).getPlayerHand().add(tempPebble);

        playerArrayList.get(playerID).setPlayerPath(tempNewPebblePath);



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
