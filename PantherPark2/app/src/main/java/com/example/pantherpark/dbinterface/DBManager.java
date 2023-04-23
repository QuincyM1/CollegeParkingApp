package com.example.pantherpark.dbinterface;

import android.util.Log;

import androidx.annotation.NonNull;

import com.amplifyframework.core.Action;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.model.query.Where;
import com.amplifyframework.datastore.DataStoreException;
import com.amplifyframework.datastore.generated.model.Deck;
import com.amplifyframework.datastore.generated.model.Spot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Initialize DB Manager, then use it to get information.
 * List of methods:
 * getDeckArray() - returns DeckData objects which contain deck name, latitude, longitude
 */
public class DBManager {

    private String deckID;
    private DeckData deckInfo;

    public DBManager() {
        Log.i("DB_MANAGER", "DB Manager Initialization complete.");
    }

    public DeckData[] getDeckArray() {

        ArrayList<DeckData> decks = getDecks();
        return decks.toArray(new DeckData[decks.size()]);

    }

    /**
     * @param deckName The name/code of a Deck. Can be A Deck, Blue Lot, etc.
     *                 *                 Must match the Deck name listed in Database/Spinner on ParkScreen.java
     * @return NULL if deck name is invalid and not found, or DeckData of requested Deck.
     */
    public DeckData getDeckInformation(String deckName) {

        //Get the Deck ID of the Deck to find spots in
        Amplify.DataStore.query(Deck.class, Where.matches(Deck.DECK_NAME.eq(deckName)), decks -> {
            while (decks.hasNext()) {
                Deck deck = decks.next();
                DBManager.this.deckInfo = new DeckData(deck.getDeckName(), deck.getLatitude(), deck.getLongitude());
                Log.i("MyAmplifyApp", "Post: " + deck);
            }
        }, (Consumer<DataStoreException>) failure -> {
            Log.e("MyAmplifyApp", "Query failed.", failure);
        });

        return deckInfo;

    }

    /**
     * @param deckName The name/code of a Deck. Can be A Deck, Blue Lot, etc.
     *                 Must match the Deck name listed in Database/Spinner on ParkScreen.java
     * @return An array of SpotData objects.
     */
    public SpotData[] getSpotArray(String deckName) {

        ArrayList<SpotData> spots = getSpots(deckName);
        return spots.toArray(new SpotData[spots.size()]);

    }


    private ArrayList<SpotData> getSpots(String deckName) {

        deckName = deckName.trim();
        ArrayList<SpotData> spots = new ArrayList<>();

        //Get the Deck ID of the Deck to find spots in
        Amplify.DataStore.query(Deck.class, Where.matches(Deck.DECK_NAME.eq(deckName)), decks -> {
            while (decks.hasNext()) {
                Deck deck = decks.next();
                DBManager.this.setDeckID(deck.getId());
                Log.i("MyAmplifyApp", "Post: " + deck);
            }
        }, failure -> Log.e("MyAmplifyApp", "Query failed.", failure));

        //Now using the Deck ID obtained above, find all the spots and add them to the arraylist for return
        Amplify.DataStore.query(Spot.class, Where.matches(Spot.DECK_ID.eq(deckID)), spotss -> {
                    while (spotss.hasNext()) {
                        Spot spot = spotss.next();
                        spots.add(new SpotData(spot.getId(), spot.getCode(), spot.getDeckId()));
                    }
                },

                failure -> Log.e("Amplify", "Could not query DataStore", failure)

        );

        return spots;

    }


    private ArrayList<DeckData> getDecks() {

        ArrayList<DeckData> decks = new ArrayList<>();

        Amplify.DataStore.query(Deck.class, new Consumer<Iterator<Deck>>() {
            @Override
            public void accept(@NonNull Iterator<Deck> items) {
                while (items.hasNext()) {
                    Deck item = items.next();
                    decks.add(new DeckData(item.getDeckName(), item.getLatitude(), item.getLongitude()));
                    Log.i("Amplify", "Id " + item.getId());
                }
            }
        }, new Consumer<DataStoreException>() {
            @Override
            public void accept(@NonNull DataStoreException failure) {
                Log.e("Amplify", "Could not query DataStore", failure);
            }
        });

        return decks;

    }


    private void setDeckID(String deckID) {
        this.deckID = deckID;
    }

}
