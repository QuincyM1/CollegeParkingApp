package com.example.pantherpark.sensorservice;

import com.example.pantherpark.dbinterface.DBManager;
import com.example.pantherpark.dbinterface.SpotData;

import java.util.Random;

class VirtualSensorService {

    private DBManager dbmg;

    /**Get list of spots of a deck and find how many are available
     *
     * @param deckName The name/code of a Deck. Can be A Deck, Blue Lot, etc.
     *      *                 Must match the Deck name listed in Database/Spinner on ParkScreen.java
     * @return int[] array - array[0] is the available spots, array[1] is the unavailable spots, and array[2] is the total spots
     */
    int[] howManySpotsAvailable(String deckName){
        dbmg = new DBManager();
        SpotData[] spots = dbmg.getSpotArray(deckName);
        dbmg = null;

        int totalSpots = 0;
        int availableSpots = 0;
        int unavailableSpots = 0;

        for(int i = 0; i < spots.length; i++){
            totalSpots++;

            Random rand = new Random();
            int randomValue = rand.nextInt() % 2;

            if(randomValue == 1){
                availableSpots++;
            }

        }

        unavailableSpots = totalSpots - availableSpots;

        int[] info = {availableSpots, unavailableSpots, totalSpots};
        return info;

    }

    //Get a specific spot and see if available


    //Get list of spots of a deck and find exactly which are available


}
