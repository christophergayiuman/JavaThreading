package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PebbleGame {
    private int totalPlayerNumber;
    private ArrayList<Player> playerArrayList;

        //Player class
    static class Player{
        private ArrayList<Pebble> playerPebbles;
        private int playerID;

        //Constructor for player
        public Player(int playerID){
            this.playerID = playerID;
        }

        //Set player pebbles array
        public void setPlayerPebbles(ArrayList<Pebble> playerPebbles){this.playerPebbles = playerPebbles;}

        //prints player ID's
        public void printPlayerID (){ System.out.println(playerID);}

    }

        //End of player class

    //Fill player pebble array
    public void fillPlayerBag(){
        for (int i = 0; i < 10; i++) {
//            System.out.println("yo");

        }
    }


    //Create players arraylist
    public void createPlayerArray(){
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        for (int i = 0; i < totalPlayerNumber; i++) {
            Player player = new Player(i);
            playerArrayList.add(player);
        }
        this.playerArrayList = playerArrayList;
    }


    //Function to generate and return random number
    public Integer generateRandomNum (Integer Upperlimit){
        //generate random number
        Random rand = new Random();
        int generatedRandomNumber = rand.nextInt(Upperlimit);
        generatedRandomNumber += 1;
        return generatedRandomNumber;
    }

    //Setter method for total players
    public void setTotalPlayerNumber(int totalPlayerNumber){ this.totalPlayerNumber = totalPlayerNumber; }

    //Getter methods
    public int getTotalPlayerNumber(){return totalPlayerNumber;}
    public ArrayList<Player> getPlayerArrayList(){ return playerArrayList; }


}
