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
//            if (!(allBags.isEmpty() && playerArrayList.isEmpty()))
            {
                //Fill up player
//                All bags first array = [0-1] white bag or black bag, [0-2] second array is the 3 bags of that class

                //Generates a random pebble from
                int[] randomPebblepath = {1, generateRandomNum(2)};
                ArrayList<Integer> tempWeightsArray = new ArrayList<Integer>();

                //Prints out current bag
                System.out.println(allBags.get(randomPebblepath[0]).get(randomPebblepath[1]));

                //Loops through black bag and appends to temp list
                for (int i = 0; i < 10; i++) {
                    int randomPebbleNum = generateRandomNum(99 - i);

                    //Prints out the pebble being appended to the terminal
                    System.out.println("Pebble" + i + " : " +
                            allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(generateRandomNum(randomPebbleNum)).getWeight());

                    //Appends that pebble to the tempWeights Array
                    tempWeightsArray.add(i, allBags.get(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(randomPebbleNum).getWeight());

                    //Removes the pebble from that bags pebble array doesnt work
//                    allBags.remove(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(generateRandomNum(randomPebbleNum));

//                    allBags.remove(randomPebblepath[0]).get(randomPebblepath[1]).getPebbles().get(randomPebbleNum);
                }
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
