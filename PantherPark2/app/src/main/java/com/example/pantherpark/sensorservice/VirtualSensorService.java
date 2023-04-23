package com.example.pantherpark.sensorservice;

import android.util.Log;

import com.example.pantherpark.dbinterface.DBManager;
import com.example.pantherpark.dbinterface.SpotData;

import java.util.ArrayList;
import java.util.Random;

public class VirtualSensorService {

    private DBManager dbmg;

    public VirtualSensorService() {
        Log.i("VSS_SERVICE", "Virtual Sensor Service is now running.");
    }

    /**
     * Get list of spots of a deck and find how many are available
     *
     * @param deckName The name/code of a Deck. Can be A Deck, Blue Lot, etc.
     *                 *                 Must match the Deck name listed in Database/Spinner on ParkScreen.java
     * @return int[] array - array[0] is the available spots, array[1] is the unavailable spots, and array[2] is the total spots
     */
    public int[] howManySpotsAvailable(String deckName) {
        dbmg = new DBManager();
        SpotData[] spots = dbmg.getSpotArray(deckName);
        dbmg = null;

        int totalSpots = 0;
        int availableSpots = 0;
        int unavailableSpots = 0;

        for (int i = 0; i < spots.length; i++) {
            totalSpots++;

            Random rand = new Random();
            int randomValue = rand.nextInt() % 2;

            if (randomValue == 1) {
                availableSpots++;
            }

        }

        unavailableSpots = totalSpots - availableSpots;

        int[] info = {availableSpots, unavailableSpots, totalSpots};
        return info;

    }

    /**
     * Get a specific spot and see if available
     * Retrieves all spots from Database.
     *
     * @param spotCode A deck spot code, in the form of X-#-$, where X is the deck code, # is the level, and $ is the spot number. E.g A-1-1 is spot 1 in deck A, level 1.
     * @return false if unavailable or spot does not exist, true if available
     */
    public boolean isSpotAvailable(String spotCode) {

        boolean isAvailable = false;

        dbmg = new DBManager();
        SpotData[] spots = dbmg.getAllSpotsArray();
        dbmg = null;

        for (SpotData spot : spots) {
            if (spot.getSpotCode().equals(spotCode)) {
                Random rand = new Random();
                int randomValue = rand.nextInt() % 2;

                if (randomValue == 1) {
                    isAvailable = true;
                    return isAvailable;
                }
            }
        }

        return isAvailable;

    }


    /**
     * Get a specific spot of a specific deck and see if available
     *
     * @param spotCode A deck spot code, in the form of X-#-$, where X is the deck code, # is the level, and $ is the spot number. E.g A-1-1 is spot 1 in deck A, level 1.
     * @param deckName The deck to look which the spot code is in
     * @return false if unavailable or spot does not exist in said deck, true if available
     */
    public boolean isSpotAvailable(String deckName, String spotCode) {

        boolean isAvailable = false;

        dbmg = new DBManager();
        SpotData[] spots = dbmg.getSpotArray(deckName);
        dbmg = null;

        for (SpotData spot : spots) {
            if (spot.getSpotCode().equals(spotCode)) {
                Random rand = new Random();
                int randomValue = rand.nextInt() % 2;

                if (randomValue == 1) {
                    isAvailable = true;
                    return isAvailable;
                }
            }
        }

        return isAvailable;

    }


    /** Get list of spots of a deck and find exactly which are available
     * @param deckName Name of deck to see which spots are available
     * @return String array of spot codes of available parking spots
     */
    public String[] whichSpotsAvailable(String deckName) {

        ArrayList<String> spotsAvailable = new ArrayList<>(0);

        dbmg = new DBManager();
        SpotData[] spots = dbmg.getSpotArray(deckName);
        dbmg = null;

        for (int i = 0; i < spots.length; i++) {

            Random rand = new Random();
            int randomValue = rand.nextInt() % 2;

            if (randomValue == 1) {
                spotsAvailable.add(spots[i].getSpotCode());
            }

        }

        return spotsAvailable.toArray(new String[spotsAvailable.size()]);

    }


}
