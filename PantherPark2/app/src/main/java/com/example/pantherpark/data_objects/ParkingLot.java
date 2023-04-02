package com.example.pantherpark.data_objects;

import java.util.*;
import java.lang.*;

public class ParkingLot {
    private int parkingLotID;
    private ArrayList<Parking> parkings = new ArrayList<Parking>();
    private String name;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String lotStatus;
    private boolean lotAvailable;

    public ParkingLot() {
        this.parkingLotID = (int)(Math.random()*1000000);
        this.name = "";
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = 0;
        this.lotStatus = "";
        this.lotAvailable = false;
    }

    public ParkingLot(String name, String address, String city, String state, int zip,
                      String lotStatus, boolean lotAvailable) {
        this.parkingLotID = (int)(Math.random()*1000000);
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.lotStatus = lotStatus;
        this.lotAvailable = lotAvailable;
    }

    public int getParkingLotID() {
        return parkingLotID;
    }
    public void setParkingLotID(int parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public ArrayList<Parking> getParkings() {
        return parkings;
    }
    public void setParkings(ArrayList<Parking> parkings) {
        this.parkings = parkings;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getLotStatus() {
        return lotStatus;
    }
    public void setLotStatus(String lotStatus) {
        this.lotStatus = lotStatus;
    }

    public boolean getLotAvailable() {
        return lotAvailable;
    }
    public void setLotAvailable(boolean lotAvailable) {
        this.lotAvailable = lotAvailable;
    }

    public void addParking(Parking parking) {
        parkings.add(parking);
    }
    public void removeParking(Parking parking) {
        parkings.remove(parking);
    }

    public void closeLot() {
        lotStatus = "Closed";
        lotAvailable = false;
    }
    public void openLot() {
        lotStatus = "Open";
        lotAvailable = true;
    }

    //Sedy is still working on this downwards
    //closing or opening a parking spot through the parking lot class
    public void closeParking(Parking parking) {
        if(parkings.contains(parking) == false) {
            System.out.println("Parking spot does not exist in this parking lot.");
            return;
        }
        else{
            for (int i = 0; i < parkings.size(); i++) {
                if(parkings.get(i).getParkingID() == parking.getParkingID()) {
                    parkings.get(i).setParkingStatus("Closed");
                    parkings.get(i).setParkingAvailable(false);
                }
            }

            parking.setParkingStatus("Closed");
            parking.setParkingAvailable(false);
        }
    }
    public void openParking(Parking parking) {
        if(parkings.contains(parking) == false) {
            System.out.println("Parking spot does not exist in this parking lot.");
            return;
        }
        else{
            for (int i = 0; i < parkings.size(); i++) {
                if(parkings.get(i).getParkingID() == parking.getParkingID()) {
                    parkings.get(i).setParkingStatus("Open");
                    parkings.get(i).setParkingAvailable(true);
                }
            }

            parking.setParkingStatus("Open");
            parking.setParkingAvailable(true);
        }
    }
    //Sedy is still working on this upwards

    public void printParkingLot() {
        System.out.println("Parking Lot ID: " + parkingLotID);
        System.out.println("Parking Lot Name: " + name);
        System.out.println("Parking Lot Address: " + address);
        System.out.println("Parking Lot City: " + city);
        System.out.println("Parking Lot State: " + state);
        System.out.println("Parking Lot Zip: " + zip);
        System.out.println("Parking Lot Status: " + lotStatus);
        System.out.println("Parking Lot Available: " + lotAvailable);
        System.out.println("Parking Lot Parkings: " + parkings);
    }

    public String toString() {
        return "ParkingLot [parkingLotID=" + parkingLotID + ", parkings=" + parkings + ", name=" + name + ", address="
                + address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", lotStatus=" + lotStatus
                + ", lotAvailable=" + lotAvailable + "]";
    }


}
