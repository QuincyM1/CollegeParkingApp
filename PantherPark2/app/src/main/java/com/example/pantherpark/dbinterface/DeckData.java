package com.example.pantherpark.dbinterface;

import com.google.android.gms.maps.model.LatLng;

public class DeckData {

    private String deckID;
    private String deckName;
    private Double latitude;
    private Double longitude;

    public DeckData(String deckID, String deckName, Double latitude, Double longitude) {
        this.deckID = deckID;
        this.deckName = deckName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public DeckData(String deckName, Double latitude, Double longitude) {

        this.deckName = deckName;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public DeckData(String deckName, String latitude, String longitude) {

        this.deckName = deckName;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);

    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDeckID() {
        return deckID;
    }

    public void setDeckID(String deckID) {
        this.deckID = deckID;
    }

    public LatLng getLatLng() {

        return new LatLng(this.latitude, this.longitude);

    }




}
