package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PebbleGame {
    private static int totalPlayerNumber;
    private static ArrayList<Player> playerArrayList;
    private static ArrayList<ArrayList<Bag>> allBags;
    private static boolean gameWinner;


    //Function that clears the log file
    public static void clearLogFile(String strPlayerFileName){
        try{
            File file = new File(strPlayerFileName);
            file.delete();
            if (file.delete()){
                System.out.println("File deleted sucessfully");
            } else {
                System.out.println("Failed to delete file");
            }
            System.out.println("Clear filename");
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e);
            System.out.println(e);

        }

    }

    //Function that builds the playeroutputfiles names
    public ArrayList<String> createPlayerOutputNames(){
        ArrayList<String> playerOutputNames = new ArrayList<>();

        for (int i = 0; i < playerArrayList.size(); i++) {
            //Create the textfile name
            StringBuilder playerFileName = new StringBuilder("player");
            playerFileName.append(Integer.toString(playerArrayList.get(i).getPlayerID()));
            playerFileName.append("_");
            playerFileName.append("output.txt");
            String strPlayerFileName = playerFileName.toString();
            playerOutputNames.add(strPlayerFileName);
            System.out.println(strPlayerFileName);
        }
        return playerOutputNames;
    }

    //Player class
    static class Player implements Runnable {

        private ArrayList<Pebble> playerHand;
        private int playerID;
        private int[] path;
        private String playerFileName;


        //set player filename
        public void setPlayerFileName(String playerFileName){
            this.playerFileName = playerFileName;
        }

        //get player filename
        public String getPlayerFileName(){
            return playerFileName;
        }

        //Append to LogFile
        public void appendLog(String typeOfAction, String pebbleWeight, String bagName){
            //Create the textfile name
            StringBuilder playerFileName = new StringBuilder("player");
            playerFileName.append(Integer.toString(playerID));
            playerFileName.append("_");
            playerFileName.append("output.txt");
            String strPlayerFileName = playerFileName.toString();
            setPlayerFileName(strPlayerFileName);

            //Create the requested output
            StringBuilder playerOutput = new StringBuilder("");
            playerOutput.append("player" + playerID + " has "+ typeOfAction + " a " + pebbleWeight + " from bag " + bagName);

            //Append the data to the existing files
            Writer output;
            try {
                output = new BufferedWriter(new FileWriter(strPlayerFileName, true));
                output.append(playerOutput.toString());
                output.append("\n");
                output.close();
                System.out.println("Appended " + playerOutput.toString() + "Successfully.....");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        //Constructor for player
        public Player(int playerID) {
            this.playerID = playerID;
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
                            synchronized (allBags.get(randomPebblePath[0]).get(randomPebblePath[1])) {
                                //Appends that pebble to the tempWeights Array
                                tempWeightsHand.add(j, allBags.get(randomPebblePath[0]).get(randomPebblePath[1]).getPebbles().get(randomPebbleNum));

                                //Remove the pebble from the origin black blag
                                allBags.get(randomPebblePath[0]).get(randomPebblePath[1]).removePebble(tempWeightsHand.get(j));
                            }

                        }
                        //Set the path of the latest pebble
                        int[] latestPlayerPath = {randomPebblePath[0], randomPebblePath[1]};
                        setPlayerPath(latestPlayerPath);

                        //Apending to playerhand
                        setPlayerHand(tempWeightsHand);
                        winCondition();
                    }
                }
            } catch (Exception e) {
                System.out.println("There is an error: " + e);
            }
        }

        public void discardPebble(){
            //Change from black bag path to white bag path
            int[] whiteBagPebblePath = {0, getPlayerPath()[1]};
            int tempGenerateRandomNum = generateRandomNum(10);

            //Append to log
            appendLog("discard", String.valueOf(getPlayerHand().get(tempGenerateRandomNum).getWeight()),
                    allBags.get(whiteBagPebblePath[0]).get(whiteBagPebblePath[1]).getBagName());



            //Discard pebble from playerHand
            getPlayerHand().remove(tempGenerateRandomNum);

            synchronized (allBags.get(whiteBagPebblePath[0]).get(whiteBagPebblePath[1])) {
                //Adds pebble from playerHand to white bag
                allBags.get(whiteBagPebblePath[0]).get(whiteBagPebblePath[1]).getPebbles().add(getPlayerHand().get(tempGenerateRandomNum));
                allBags.get(whiteBagPebblePath[0]).get(whiteBagPebblePath[1]).incrementWhiteBagSize();
            }
        }


        public void getNewPebble(){
            System.out.println(Thread.currentThread().getName()+" : hand value = " + playerHandValue());
            //Temp newPebblePath
            int[] tempNewPebblePath= {1, generateRandomNum(3)};

            Bag bag = allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]);

            synchronized (bag) {

                try {
                //Random pebble generate number
                int tempGenerateRandomNum = generateRandomNum(allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).getPebbles().size());

                //Append to log

                String pebbleWeight = Integer.toString(allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).getPebbles().get(tempGenerateRandomNum).getWeight());
                appendLog("drawn", pebbleWeight, allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).getBagName());

                //Add to playerhand
                Pebble tempPebble;
                tempPebble = allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).getPebbles().get(tempGenerateRandomNum);

                //Remove pebble from original bag
                allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).removePebble(tempPebble);

                //Append to playerHand
                getPlayerHand().add(tempPebble);
                winCondition();
                } catch (Exception e) {
                    /**System.out.println("empty bag!!!!!!!!!!!!!!!!!!!!!!!!!!!11");
                    System.out.println("BEFORE: ");
                    System.out.println("Empty Black Bag: "+allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).getPebbles().size());
                    System.out.println("Full White Bag: " + allBags.get(0).get(tempNewPebblePath[1]).getPebbles().size());
                     **/
                    ArrayList<Pebble> tempPebbles = new ArrayList<>();
                    tempPebbles = allBags.get(0).get(tempNewPebblePath[1]).getPebbles();


                    //Black bag is set to temp pebbles
                    allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).setPebblesArray(tempPebbles);

                    //Clear the old one ISSUE IS here
                    //System.out.println(allBags.get(0).get(tempNewPebblePath[1]).toString());


                    ArrayList<Pebble> emptyPebbleArrayList = new ArrayList<>();
                    allBags.get(0).get(tempNewPebblePath[1]).setPebblesArray(emptyPebbleArrayList);
                    allBags.get(0).get(tempNewPebblePath[1]).clearBag();

                    /**System.out.println(" ");
                    System.out.println("AFTER: ");
                    System.out.println("Full Black Bag: "+allBags.get(tempNewPebblePath[0]).get(tempNewPebblePath[1]).getPebbles().size());
                    System.out.println("Empty White Bag: " + allBags.get(0).get(tempNewPebblePath[1]).getPebbles().size());**/
                    winCondition();
                }
            }
            setPlayerPath(tempNewPebblePath);
        }

        public synchronized void winCondition (){
            if (playerHandValue() == 300) {
                gameWinner = true;
                System.out.println("WINNER!!!!!!!!!!!!!!!!!!");
            }
        }

        //Set player Bag
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

        //Get playerID
        public int getPlayerID(){
            return playerID;
        }

        //Gets the total value of the players hand
        public int playerHandValue() {
            int totalWeightsValue = 0;
            for (Pebble pebble : playerHand) {
                totalWeightsValue = totalWeightsValue + pebble.getWeight();
            }
            return totalWeightsValue;
        }

        //Returns if player bag is empty
        public boolean bagEmpty(){
            return (playerHand.isEmpty());
        }

        //prints player ID's
        public void printPlayerID() {
            System.out.println(playerID);
        }

        @Override
        public void run() {
            fillPlayerHand();
            for (int i = 0; i < playerArrayList.size(); i++) {
                clearLogFile(playerArrayList.get(i).getPlayerFileName());
            }
            discardPebble();
            getPlayerHand();
            while (!gameWinner) {
                discardPebble();
                getNewPebble();
            }
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
    /**public static Integer generateRandomNum(Integer Upperlimit) {
        try {
            //generate random number
            Random rand = new Random();
            return rand.nextInt(Upperlimit);
        } catch (Exception e) {
            System.out.println(e);
            for (int i = 0; i <3; i++) {
                System.out.println("White bags: "+allBags.get(0).get(i).toString());
                System.out.println("");
            }

            for (int i = 0; i < 3; i++) {
                System.out.println("Balck bags: ");
                System.out.println(allBags.get(1).get(i).toString());
                System.out.println("");
            }
        }
        return  null;
    }**/


    //Genreate random number
    public static Integer generateRandomNum(Integer Upperlimit) {
            //generate random number
            Random rand = new Random();
            return rand.nextInt(Upperlimit);
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

    public static void main(String[] args) {
        GameSetup gs = new GameSetup();
        gs.createBags();
        //gs.startingGameInfo();
        PebbleGame pg = new PebbleGame();
        pg.setTotalPlayerNumber(gs.getPlayersNo());
        pg.setAllBags(gs.getAllbags());
        pg.createPlayerArray();

        for (int i = 0; i < pg.createPlayerOutputNames().size(); i++) {
            clearLogFile(pg.createPlayerOutputNames().get(i));
        }


        // makes the players threads and executes it
        ExecutorService es = Executors.newFixedThreadPool(gs.getPlayersNo());
        for (Player player : pg.getPlayerArrayList()) es.execute(new Thread(player));
        es.shutdown();

        try{
            es.awaitTermination(1, TimeUnit.MINUTES);
        } catch( InterruptedException e ) {
            e.printStackTrace();
        }
        //If the game did not finish after 1 minute, stop the game.
        if(!es.isTerminated()){
            es.shutdownNow();
            System.out.println("Simulation ran for over 1 minute. \nSimulation" +
                    " could be impossible, it has been interrupted for log analysis.");
        }


    }

}
