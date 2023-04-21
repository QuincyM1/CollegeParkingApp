package com.example.pantherpark.dbinterface;

import android.util.Log;

import androidx.annotation.NonNull;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.datastore.DataStoreException;
import com.amplifyframework.datastore.generated.model.Deck;

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

    public DBManager() {
        Log.i("DB_MANAGER", "DB Manager Initialization complete.");
    }

    public DeckData[] getDeckArray(){

        ArrayList<DeckData> decks = getDecks();
        return decks.toArray(new DeckData[decks.size()]);

    }


    private static ArrayList<DeckData> getDecks() {

        ArrayList<DeckData> decks = new ArrayList<>();

        Amplify.DataStore.query(
                Deck.class,
                new Consumer<Iterator<Deck>>() {
                    @Override
                    public void accept(@NonNull Iterator<Deck> items) {
                        while (items.hasNext()) {
                            Deck item = items.next();
                            decks.add(new DeckData(item.getDeckName(), item.getLatitude(), item.getLongitude()));
                            Log.i("Amplify", "Id " + item.getId());
                        }
                    }
                },
                new Consumer<DataStoreException>() {
                    @Override
                    public void accept(@NonNull DataStoreException failure) {
                        Log.e("Amplify", "Could not query DataStore", failure);
                    }
                }
        );

        return decks;

    }


}
