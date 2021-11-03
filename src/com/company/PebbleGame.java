package com.company;

import java.util.ArrayList;
import java.util.Random;

public class PebbleGame {
    static class Player{
        private ArrayList<Pebble> playerPebble;
        private Integer randomNumber;

        public Player(Integer randomNumber/**ArrayList<Pebble> playerPebble**/){
            this.randomNumber = randomNumber;
        }
    }

    public Integer generateRandomNum (Integer Upperlimit){
        //generate random number
        Random rand = new Random();
        int generatedRandomNumber = rand.nextInt(Upperlimit);
        generatedRandomNumber += 1;
        return generatedRandomNumber;
    }


}
