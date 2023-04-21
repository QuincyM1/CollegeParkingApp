package com.example.pantherpark.dbinterface;

public class SpotData {

    private String spotCode;
    private String deckID;

    public SpotData(String spotCode, String deckID) {
        this.spotCode = spotCode;
        this.deckID = deckID;
    }

    public String getSpotCode() {
        return spotCode;
    }

    public void setSpotCode(String spotCode) {
        this.spotCode = spotCode;
    }

    public String getDeckID() {
        return deckID;
    }

    public void setDeckID(String deckID) {
        this.deckID = deckID;
    }
}
