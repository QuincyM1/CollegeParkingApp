package com.example.pantherpark.data_objects;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Parking {
    private String parkingStatus;
    private boolean parkingAvailable;
    private int parkingID;
    private String label;
    private String floor;

    public Parking() {
        this.parkingStatus = "";
        this.parkingAvailable = false;
        this.parkingID = (int)(Math.random()*1000000);
        this.label = "";
        this.floor = "";
    }

    public Parking(String parkingStatus, boolean isAvailable, int parkingID, String label, String floor) {
        this.parkingStatus = parkingStatus;
        this.parkingAvailable = isAvailable;
        this.parkingID = (int)(Math.random()*1000000);
        this.label = label;
        this.floor = floor;
    }

    public String getParkingStatus() {
        return parkingStatus;
    }
    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public boolean getParkingAvailable() {
        return parkingAvailable;
    }
    public void setParkingAvailable(boolean parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }

    public int getParkingID() {
        return parkingID;
    }
    public void setParkingID(int parkingID) {
        this.parkingID = parkingID;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public String getFloor() {
        return floor;
    }
    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void reserveParking() {
        this.parkingStatus = "Reserved";
        this.parkingAvailable = false;
    }
    public void cancelParking() {
        this.parkingStatus = "Available";
        this.parkingAvailable = true;
    }
    public void checkInParking() {
        this.parkingStatus = "Occupied";
        this.parkingAvailable = false;
    }
    public void checkOutParking() {
        this.parkingStatus = "Available";
        this.parkingAvailable = true;
    }
    public void closeParking() {
        this.parkingStatus = "Closed";
        this.parkingAvailable = false;
    }
    public void openParking() {
        this.parkingStatus = "Available";
        this.parkingAvailable = true;
    }
    public void parkingMaintenance() {
        this.parkingStatus = "Maintenance";
        this.parkingAvailable = false;
    }

    public void printParking() {
        System.out.println("Parking Status: " + parkingStatus);
        System.out.println("Is Available: " + parkingAvailable);
        System.out.println("Parking ID: " + parkingID);
        System.out.println("Label: " + label);
        System.out.println("Floor: " + floor);
    }

    public String toString() {
        return "**Parking Status: " + parkingStatus + " **Is Available: " +
                parkingAvailable + " **Parking ID: " + parkingID + " **Label: " + label +
                " **Floor: " + floor;
    }

}