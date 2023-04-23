package com.example.pantherpark.dbinterface;

import android.util.Log;

import java.util.ArrayList;

/**
 * Initialize DB Manager, then use it to get information.
 */
public class DBManager {

    private DeckData deckInfo;
    private String deckID;

    public DBManager() {
        Log.i("DB_MANAGER", "DB Manager Initialization complete.");
    }

    /**
     *
     * @return An array of DeckData objects, i.e. all the Decks in the database
     */
    public DeckData[] getDeckArray() {

        ArrayList<DeckData> decks = this.getDecks();
        return decks.toArray(new DeckData[decks.size()]);

    }

    /**
     * @param deckName The name/code of a Deck. Can be A Deck, Blue Lot, etc.
     *                 Must match the Deck name listed in Database/Spinner on ParkScreen.java
     * @return An array of SpotData objects, for a specific deck.
     */
    public SpotData[] getSpotArray(String deckName) {

        ArrayList<SpotData> spots = getSpotsOfDeck(deckName);
        return spots.toArray(new SpotData[spots.size()]);

    }

    /**
     *
     * @return An array of SpotData objects, for all decks.
     */
    public SpotData[] getAllSpotsArray() {

        ArrayList<SpotData> spots = getSpots();
        return spots.toArray(new SpotData[spots.size()]);

    }


    /**
     * @param deckName The name/code of a Deck. Can be A Deck, Blue Lot, etc.
     *                 *                 Must match the Deck name listed in Database/Spinner on ParkScreen.java
     * @return NULL if deck name is invalid and not found, or DeckData of requested Deck.
     */
    public DeckData getDeckInformation(String deckName) {
        deckName = deckName.trim();
        ArrayList<DeckData> decks = this.getDecks();

        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getDeckName().equals(deckName)) {
                return decks.get(i);
            }
        }

        return null;

        /*
        System.err.println("INSIDE GET DECK INFO METHOD");

        //Get the Deck ID of the Deck to find spots in
        Amplify.DataStore.query(Deck.class, Where.matches(Deck.DECK_NAME.eq("deckName")), decks -> {

            System.err.println("INSIDE AMPLIFY QUERY METHOD");

            while (decks.hasNext()) {
                Deck deck = decks.next();
                DBManager.this.deckInfo = new DeckData(deck.getDeckName(), deck.getLatitude(), deck.getLongitude());
                System.err.println("DECK OBJECT FROM AMPLIFY: " + deck.getDeckName() + deck.getLatitude() + deck.getLongitude());
                System.err.println("DECKDATA OBJECT CONSTRUCTED" + DBManager.this.deckInfo.getDeckName() + DBManager.this.deckInfo.getLatitude() + DBManager.this.deckInfo.getLongitude());
                Log.i("MyAmplifyApp", "Post: " + deck);
            }
        }, (Consumer<DataStoreException>) failure -> {
            Log.e("MyAmplifyApp", "Query failed.", failure);
        });

        System.err.println("DECKDATA OBJECT BEFORE RETURN" + deckInfo.getDeckName() + deckInfo.getLatitude() + deckInfo.getLongitude());
        return null;

         */

    }

    private ArrayList<SpotData> getSpotsOfDeck(String deckName) {

        /*
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
        */

        DeckData deck = getDeckInformation(deckName);
        String deckid = deck.getDeckID();

        ArrayList<SpotData> spots = getSpots();
        ArrayList<SpotData> spotofdeck = new ArrayList<>(0);

        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i).getDeckID().equals(deckid)) {
                spotofdeck.add(spots.get(i));
            }
        }

        return spotofdeck;

    }

    private ArrayList<SpotData> getSpots() {

        ArrayList<SpotData> spots = new ArrayList<>(0);

        spots.add(new SpotData("6380da3a-65b1-45ab-babf-32793950bac1", "75-1-1", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("1aa37290-d1fd-4c3d-9524-07170adbd1cc", "75-1-2", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("5288044b-76ef-4e30-b337-bfd541117498", "75-1-3", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("4cdac00e-e3cc-47df-b2ad-2748957e57a8", "75-1-4", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("eba11436-f766-4205-bf23-4207891ca5df", "75-1-5", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("f2523e0c-dfb1-4e1d-b523-77d9473ccb03", "75-1-6", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("efb2e754-f2ed-4f57-aad6-aa34bb81d5f0", "75-1-7", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("dee9b942-f72d-4be5-8b56-cc716fb5034f", "75-1-8", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("b44270d5-d131-4d5e-9c31-40897c47ec36", "75-1-9", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("49d8daf3-414f-4944-8234-6ff96010c041", "75-1-10", "f9f1484f-b7ff-4bf6-ac32-1e691a1993df"));
        spots.add(new SpotData("9b5629c1-6c38-419d-bbfc-e08211e223f0", "A-1-1", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("db65df17-c8ae-466e-acd7-6493bf56aa0f", "A-1-2", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("cbd4a5fa-8e4b-4877-a88f-2f1273c5a0d5", "A-1-3", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("f0948514-eeba-4600-81d8-5193341519e9", "A-1-4", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("3963a92c-6395-476a-b901-80f27462c113", "A-1-5", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("5f2a0ad2-19e2-4636-bcca-091f78f79bc2", "A-1-6", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("74f498dc-bfb7-4e97-bf11-1c1dbcd58190", "A-1-7", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("b14d0104-f5dd-48fd-98a1-bcb14789e94f", "A-1-8", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("2b6bb156-2087-45d9-93fa-07bbe9b4b588", "A-1-9", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("a474e4e6-e2cc-42bd-aec9-563caa4f1e57", "A-1-10", "9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f"));
        spots.add(new SpotData("b3a225d5-7699-4177-9bc5-cd87b68ed9c2", "B-1-1", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("17ca8901-7f5e-4def-9802-0ac0f5545594", "B-1-2", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("e5c3295e-e5eb-47a2-9ef4-11bbb6ac198e", "B-1-3", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("23a03add-3697-4f32-ad63-711d3b5911d7", "B-1-4", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("769afd1f-6a2a-4f05-8bc9-eb5a3271d3ec", "B-1-5", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("f49a238f-9935-4923-a950-67ea7ce5bde9", "B-1-6", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("dfe4a19b-d9c7-4137-8272-db79a27d143f", "B-1-7", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("83fe2504-0e0d-4b0c-b455-ae47551c7bc9", "B-1-8", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("8cee9524-59ca-47c8-b0ae-9a1dbda353e3", "B-1-9", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("333cc692-f642-4df5-83db-1d04411ce98a", "B-1-10", "1a097866-d27b-4ba1-a92f-a641b7e42cba"));
        spots.add(new SpotData("5a172272-e9db-4bf1-89ad-f0431d735f98", "BL-1-1", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("bb3fedac-e09b-44e8-a2e6-86d9847b0a7e", "BL-1-2", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("f83e2e77-0bc8-4023-a396-b343f5aecc0e", "BL-1-3", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("e40e4170-42eb-4e93-953b-1c3e2315255d", "BL-1-4", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("fc5b4452-780d-42ae-aca2-1913dac8d055", "BL-1-5", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("e30d437d-49e1-4609-afe0-44425ba12609", "BL-1-6", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("887b30be-38fb-447f-aba0-e3a413812892", "BL-1-7", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("79bcdedb-aeeb-4f77-aa79-a407d08234e6", "BL-1-8", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("03254089-00ef-4a70-87cc-bff7f1efc821", "BL-1-9", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("7f58034a-be69-4ac4-8fd0-0625fb29a936", "BL-1-10", "bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4"));
        spots.add(new SpotData("22c688cb-2455-4bb0-a679-eb98474203d9", "C-1-1", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("f2ac4b9a-8eba-4e88-b4da-50a5c76bbd1c", "C-1-2", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("608615c5-9d07-4221-8b77-e2e028f290fe", "C-1-3", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("d692eb71-0ed9-486f-9a36-6ba6faa68095", "C-1-4", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("4894e147-82dd-48de-ada2-b3d30a33e347", "C-1-5", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("4ffe3773-282b-42c2-b309-89739b055b71", "C-1-6", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("f0bdef25-30d2-435a-b691-e657a9657eeb", "C-1-7", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("140475ec-92b7-4688-9c4b-932e2d0b43e6", "C-1-8", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("76946d02-40ad-49f0-98d7-2ec541133861", "C-1-9", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("01bf5ce4-5b1d-4870-928c-dccda5907870", "C-1-10", "37ec32fd-9b81-438d-8de5-4ca57c70709d"));
        spots.add(new SpotData("e455a008-f36c-449b-8122-c73b2f993b3f", "CL-1-1", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("cdff79ad-b5b7-45c7-b072-3c7789bcbe0d", "CL-1-2", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("e2970a33-6a27-4cfc-b38a-d9946267e863", "CL-1-3", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("042915d4-d1e0-4710-b424-5e0f636c39e6", "CL-1-4", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("b7eb878e-3712-4262-a700-faa2e8c88c24", "CL-1-5", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("394b4ef7-2eae-45a2-b7d8-ffe7e536167b", "CL-1-6", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("307353a4-577a-447d-a454-93cfcabe6de7", "CL-1-7", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("dc5b0720-f66c-4881-a581-9e6e26cb9548", "CL-1-8", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("bbd40070-e9e1-4b98-8e57-8cacfbe790df", "CL-1-9", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("6693358d-fb37-4f45-8919-1ddc03f73bdd", "CL-1-10", "986674de-c450-4212-997b-6d482db05d52"));
        spots.add(new SpotData("cfe78397-0923-407a-8c25-31f3402e5391", "G-1-1", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("b0643f1b-fa5e-4a26-87f6-d35b8dbb3969", "G-1-2", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("4c28985c-eb63-4b83-91c6-b7ee380bd0c2", "G-1-3", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("e019d16f-dead-4b90-b132-e707c5297ae7", "G-1-4", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("b4546d21-1954-4f3a-9ee7-1d4ea6c84d52", "G-1-5", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("158b55a7-8ad7-488e-b46a-5c12c8104384", "G-1-6", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("f7659ace-d0a5-405c-ad10-79db70d95af7", "G-1-7", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("9b1c28e3-3c53-40ad-a63b-b63850bff098", "G-1-8", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("b717b763-69b9-4eca-88b0-271a12adad8e", "G-1-9", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("6bb580b1-b63b-4203-87cb-f91367363f94", "G-1-10", "671d8855-fa4a-49b2-a7f2-9bf714f10990"));
        spots.add(new SpotData("66e90738-5f8a-4743-978d-634a85204e4d", "GL-1-1", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("2c82f4e2-73e6-475c-953e-8365c1297122", "GL-1-2", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("0e81e296-0c1c-4b64-8c62-bdd8f4eeed9e", "GL-1-3", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("379fb809-a6ed-4283-83b8-69d947a0d87b", "GL-1-4", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("0beacbb9-89a0-4bca-a901-5959d90b3382", "GL-1-5", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("b799a63b-92ea-4079-8228-2222f90c0747", "GL-1-6", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("5eac31b5-a490-4b8a-a312-94d8c74c275e", "GL-1-7", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("17713e47-7b56-4bca-bbd6-7c0ca9050b4f", "GL-1-8", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("080f923c-23a6-40b2-9126-4b3039348342", "GL-1-9", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("27f5419b-84cb-4de6-a411-9d22c5890ada", "GL-1-10", "2c65e851-d2e1-4f75-9aad-2475882ef5aa"));
        spots.add(new SpotData("cd7e813a-e2f8-4c3e-8007-62cb15692112", "I-1-1", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("3b445029-d620-4ffa-8e85-f857b7c48579", "I-1-2", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("02e75943-c6de-4b9a-85ef-4c75243e927f", "I-1-3", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("c21608a3-68dd-4a3b-800a-e32a4f7442cd", "I-1-4", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("f8f6b83e-f1e9-4e62-86df-596f6b626729", "I-1-5", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("a70c7506-52de-4786-9162-69fd4fa6c264", "I-1-6", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("14ea7711-1da2-491b-9c6f-111961575bb4", "I-1-7", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("07ceb8a8-378c-4695-a180-986e94f28a23", "I-1-8", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("ce2425bd-9507-4434-9153-e15c8995fda4", "I-1-9", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("48f6e6da-25fa-471f-b28c-12c7503ed1ee", "I-1-10", "5f372502-9e7a-477e-bc5a-71e99df4d48c"));
        spots.add(new SpotData("e81307f5-3f78-4582-a986-0fcca46972f3", "K-1-1", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("a790d2ec-587b-4cf1-b298-65fd90424b24", "K-1-2", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("02cba2ef-1ac7-45f7-90dc-51e15984a540", "K-1-3", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("e4f85b2f-5c0d-4fb5-902f-0f886136d34e", "K-1-4", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("8ea2f519-8a58-4331-9136-5fe8e58bab8f", "K-1-5", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("791d7e81-1869-4ac0-9a8d-602ee7f2b2cc", "K-1-6", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("5cde544a-f4ca-49be-8a2b-5604bf0bccc1", "K-1-7", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("8843775c-f3f0-47ec-80a6-5ad06e4e9d18", "K-1-8", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("f761f166-aa1f-495a-ad40-a188d3afbfb3", "K-1-9", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("41c95955-c828-4e76-812f-3743a33c91db", "K-1-10", "fa5cae66-742d-4843-b954-5dfec88f552e"));
        spots.add(new SpotData("936189e4-e144-45f0-93e4-e2ae3623b3a6", "M-1-1", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("c8fdefb6-0eb8-4d98-a3e8-b18569d35499", "M-1-2", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("61ced799-bcc6-4ea7-8360-aa2bca885371", "M-1-3", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("68c79906-f534-4f2c-abca-23968a760481", "M-1-4", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("c50249c2-5796-48db-b27d-57b48dfb1bcf", "M-1-5", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("ab7dfbd0-530b-4869-8b95-970de724585c", "M-1-6", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("64ff4bd6-ebd9-4da9-bef0-2651d2960183", "M-1-7", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("bf95a8bc-7563-44f0-b695-158df2a571d1", "M-1-8", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("0d1951c4-f753-4417-b4c6-50951016621f", "M-1-9", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("dd46a402-af1b-40cd-a01f-384f2d9d1aba", "M-1-10", "6169c1e9-2c6a-4549-8cf5-b2ebd9211356"));
        spots.add(new SpotData("6c6a4c20-2f21-4a67-a4ef-458cc9ca3fd9", "N-1-1", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("aef758a6-263c-45f0-a09b-fede291b920b", "N-1-2", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("6e913751-99a1-4698-a603-1d030aa427b5", "N-1-3", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("05edb9ce-32d3-400e-a41a-24bea34b899b", "N-1-4", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("da0d7dc6-d705-4ed2-9dd6-c9ab554099bc", "N-1-5", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("5861c399-5815-472e-a202-89fb83d3c843", "N-1-6", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("035bad69-2fae-4fa7-af35-1df96001134b", "N-1-7", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("a24817b7-608a-4945-af20-793c5de006eb", "N-1-8", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("a163be9e-52da-419b-9538-25ea71dc32e5", "N-1-9", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("0ad75b25-441f-4698-94dd-362f9a6d2d37", "N-1-10", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("fe50bc19-f614-4cc2-85ae-93ac661a0c75", "S-1-1", "60f4dae0-6d86-4960-a132-7660d2bfbea6"));
        spots.add(new SpotData("435da97c-6f2b-4d09-8bb8-952eee5eb212", "S-1-2", "60f4dae0-6d86-4960-a132-7660d2bfbea6"));
        spots.add(new SpotData("cc707d53-f985-4eda-95f3-fe1c6e240357", "S-1-3", "60f4dae0-6d86-4960-a132-7660d2bfbea6"));
        spots.add(new SpotData("abda97c7-1104-4c6c-a3e0-bd26f49c6b38", "S-1-4", "60f4dae0-6d86-4960-a132-7660d2bfbea6"));
        spots.add(new SpotData("969a7f0a-503a-4ef1-8cb6-fed7476f1b04", "S-1-5", "60f4dae0-6d86-4960-a132-7660d2bfbea6"));
        spots.add(new SpotData("4075878e-87b3-4f8a-9a81-20d725859b25", "S-1-6", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("6342176a-1e24-42bc-8708-62c6265573a1", "S-1-7", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("ed84109e-79c9-4888-b97b-f5d8559f94e5", "S-1-8", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("9b4c30cc-e69a-4cd0-9c6b-21beaab3ac69", "S-1-9", "59bd8113-59bd-4cc4-82f7-77703db8373c"));
        spots.add(new SpotData("6f3cbd16-52ac-4963-8f40-6c36628423e0", "S-1-10", "60f4dae0-6d86-4960-a132-7660d2bfbea6"));
        spots.add(new SpotData("5c9b0be2-65ed-42e0-9313-41e75956b0a8", "T-1-1", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("866dd6db-cf98-4259-a0d3-4da4e14debaf", "T-1-2", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("3da59add-e8af-4199-8ce6-bee33a8ac2a5", "T-1-3", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("aebb1bec-5bac-4e93-abad-5b090abee191", "T-1-4", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("3c19f578-16fb-41c1-aabd-971c09e8bf66", "T-1-5", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("5123d5a1-7cd9-4f98-bd0e-9d0f7cdb9e59", "T-1-6", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("4c26e452-2b3e-4a43-8343-d846226bdf0f", "T-1-7", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("92cf119c-e4cf-4515-a372-2a78d664a12b", "T-1-8", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("71a9d9f5-a1d7-44fc-8abf-78bd01e4d558", "T-1-9", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("be7524f9-aada-4781-8412-d16a89a9e8af", "T-1-10", "703521ef-0f78-4725-83d4-9ee566430257"));
        spots.add(new SpotData("3376d460-317c-4375-ba6d-541a3bac085c", "U-1-1", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("84e05f6d-4478-40e1-8aaf-c963cb2b64fa", "U-1-2", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("57b8f66d-ce1f-4bf4-8f33-a0a97e52a022", "U-1-3", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("6c119dbb-9e45-417c-a0a5-6fa2b4b5490e", "U-1-4", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("c0c479e9-e358-455f-9942-79f3469772d9", "U-1-5", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("8bacef3c-f579-4cf9-889e-54e4ae4eecbb", "U-1-6", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("75072c93-6399-46a3-904b-c2fae40483bd", "U-1-7", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("f4db8611-cd41-42b4-9f4e-1cad766222ea", "U-1-8", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("9e9c328c-6598-4a42-b871-1f6945d9588c", "U-1-9", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("1fd8923c-611a-4fca-9527-cbc1c209ede3", "U-1-10", "2307b634-24a7-497f-8a56-8ac9faa3641e"));
        spots.add(new SpotData("b0d101db-4b75-4058-af6b-256de67f5ef0", "W-1-1", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));
        spots.add(new SpotData("18980cd2-a4c5-43ed-b87c-2dc959e65b19", "W-1-2", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));
        spots.add(new SpotData("d4a4a483-c610-4bf9-9895-84a6b2690164", "W-1-3", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));
        spots.add(new SpotData("6faae5ba-a27a-434a-92b0-54da2e9100e8", "W-1-4", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));
        spots.add(new SpotData("5f52e7d8-0ccc-4a7d-88c5-49afb741f109", "W-1-5", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));
        spots.add(new SpotData("300ca6a6-9f09-4a3b-9c15-36d642fc2383", "W-1-6", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));
        spots.add(new SpotData("7ff50ca5-613b-4d03-9c99-30fea388eff9", "W-1-7", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));
        spots.add(new SpotData("2452785e-f737-4d8b-a3f9-9835fcb63e32", "W-1-8", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));
        spots.add(new SpotData("2145a3a7-96ec-4553-b361-a92aac339cff", "W-1-9", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));
        spots.add(new SpotData("846cd69b-ecc7-4bfb-9475-677d30191f7a", "W-1-10", "1be02d01-cd51-472f-ab19-bfe54fb2f454"));

        return spots;

    }


    private ArrayList<DeckData> getDecks() {

        ArrayList<DeckData> decks = new ArrayList<>(0);

        /*
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
        */


        decks.add(new DeckData("f9f1484f-b7ff-4bf6-ac32-1e691a1993df", "75 Piedmont", 33.7566242, -84.3821152));
        decks.add(new DeckData("9162f4c6-b2be-4ab8-b8e6-ee6fe55ed43f", "A Deck", 33.7559434, -84.3863913));
        decks.add(new DeckData("1a097866-d27b-4ba1-a92f-a641b7e42cba", "B Deck", 33.7521941, -84.3856621));
        decks.add(new DeckData("bd1a5b5e-ab3b-4ae5-ae87-27000fef8ab4", "Blue Lot", 33.7411784, -84.3893642));
        decks.add(new DeckData("37ec32fd-9b81-438d-8de5-4ca57c70709d", "C Deck", 33.8151083, -84.4641607));
        decks.add(new DeckData("986674de-c450-4212-997b-6d482db05d52", "College of Law", 33.7567693, -84.3872065));
        decks.add(new DeckData("671d8855-fa4a-49b2-a7f2-9bf714f10990", "G Deck", 33.755711, -84.3883717));
        decks.add(new DeckData("2c65e851-d2e1-4f75-9aad-2475882ef5aa", "Green Lot", 33.7392246, -84.3911536));
        decks.add(new DeckData("5f372502-9e7a-477e-bc5a-71e99df4d48c", "I Deck", 33.7537332, -84.387109));
        decks.add(new DeckData("fa5cae66-742d-4843-b954-5dfec88f552e", "K Deck", 33.752013, -84.3830275));
        decks.add(new DeckData("6169c1e9-2c6a-4549-8cf5-b2ebd9211356", "M Deck", 33.7532309, -84.3840572));
        decks.add(new DeckData("59bd8113-59bd-4cc4-82f7-77703db8373c", "N Deck", 33.7567378, -84.3824033));
        decks.add(new DeckData("60f4dae0-6d86-4960-a132-7660d2bfbea6", "S Deck", 33.752013, -84.3830275));
        decks.add(new DeckData("703521ef-0f78-4725-83d4-9ee566430257", "T Deck", 33.7552125, -84.3869758));
        decks.add(new DeckData("2307b634-24a7-497f-8a56-8ac9faa3641e", "U Deck", 33.7526653, -84.3873661));
        decks.add(new DeckData("1be02d01-cd51-472f-ab19-bfe54fb2f454", "W Deck", 33.7564253, -84.3822423));

        return decks;

    }


    private void setDeckID(String deckID) {
        this.deckID = deckID;
    }

}
