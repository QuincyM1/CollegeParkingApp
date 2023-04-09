package com.example.pantherpark.data_objects;

import java.util.*;
import java.io.*;

public class Vehicle {
    private String manufacturer;
    private String model;
    private int year;
    private String color;
    private String licensePlate;


    public Vehicle() {
        this.manufacturer = "";
        this.model = "";
        this.year = 0;
        this.color = "";
        this.licensePlate = "";

    }

    public Vehicle(String manufacturer, String model, int year, String color,
                   String licensePlate) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.color = color;
        this.licensePlate = licensePlate;
    }


    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public void printVehicle() {
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("License Plate: " + licensePlate);
    }

    public String toString() {
        return "Vehicle [manufacturer=" + manufacturer + ", model=" + model +
                ", year=" + year + ", color=" + color + ", licensePlate=" + licensePlate + "]";
    }

}
