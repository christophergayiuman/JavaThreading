package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PebbleGame {
    private int totalPlayerNumber;

    //Player class
    static class Player{
        private ArrayList<Pebble> playerPebbles;
        private int playerID;
        public Player(int playerID){
            this.playerID = playerID;
        }

        public void printPlayerID (){
            System.out.println(playerID);
        }

        public void setPlayerPebbles(ArrayList<Pebble> playerPebbles){
            this.playerPebbles = playerPebbles;
        }

    }

    //Create players arraylist
    public ArrayList<Player> createPlayerArray(){
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        for (int i = 0; i < totalPlayerNumber; i++) {
            Player player = new Player(i);
            playerArrayList.add(player);
        }
        return null;
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
    public void setTotalPlayerNumber(int totalPlayerNumber){
        this.totalPlayerNumber = totalPlayerNumber;
    }

    //Getter method for returning total player numbers
    public int getTotalPlayerNumber(){return totalPlayerNumber;}



}
