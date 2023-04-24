package com.example.pantherpark.data_objects;
import java.util.*;
import com.google.android.gms.maps.model.LatLng;
import com.example.pantherpark.dbinterface.*;
public class FindingMinDistance {


    public  void printCoordinates(LatLng coordinates, String name) {
        System.out.println("Name: " + name);
        System.out.println("Longitude: " + coordinates.longitude);
        System.out.println("Latitude: " + coordinates.latitude);
    }
    public double distance(LatLng deck, LatLng destination) {
        double lat1 = deck.latitude;
        double lat2 = destination.latitude;
        double lon1 = deck.longitude;
        double lon2 = destination.longitude;
        //We are ignoring height difference when calculating distance for distance using lat and long
        double height = 0;
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters


        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    public LatLng minDistance(ArrayList<LatLng> decks, LatLng destination, ArrayList<String> name) {
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < decks.size(); i++) {
            double temp = distance(decks.get(i), destination);
            if (temp < min) {
                min = temp;
            }
        }

        for(int i = 0; i < decks.size(); i++) {
            double temp = distance(decks.get(i), destination);
            if (temp == min) {
                return decks.get(i);
            }
        }

        return destination;
    }
}
