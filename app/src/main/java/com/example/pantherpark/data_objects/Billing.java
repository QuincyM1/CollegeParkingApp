package com.example.pantherpark.data_objects;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Billing {
    private int billingID;
    private int creditCardNumber;
    private int creditCardExpiration;
    private int creditCardCVV;
    private String creditCardName;
    private String creditCardAddress;
    private String creditCardCity;
    private String creditCardState;
    private int creditCardZip;

    public Billing() {
        this.billingID = (int)(Math.random()*1000000);
        this.creditCardNumber = 0;
        this.creditCardExpiration = 0;
        this.creditCardCVV = 0;
        this.creditCardName = "";
        this.creditCardAddress = "";
        this.creditCardCity = "";
        this.creditCardState = "";
        this.creditCardZip = 0;
    }

    public Billing(int creditCardNumber, int creditCardExpiration, int creditCardCVV, String creditCardName, String creditCardAddress, String creditCardCity, String creditCardState, int creditCardZip) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiration = creditCardExpiration;
        this.creditCardCVV = creditCardCVV;
        this.creditCardName = creditCardName;
        this.creditCardAddress = creditCardAddress;
        this.creditCardCity = creditCardCity;
        this.creditCardState = creditCardState;
        this.creditCardZip = creditCardZip;
        this.billingID = (int)(Math.random()*1000000);
    }

    public int getBillingID() {
        return billingID;
    }
    public void setBillingID(int billingID) {
        this.billingID = billingID;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getCreditCardExpiration() {
        return creditCardExpiration;
    }
    public void setCreditCardExpiration(int creditCardExpiration) {
        this.creditCardExpiration = creditCardExpiration;
    }

    public int getCreditCardCVV() {
        return creditCardCVV;
    }
    public void setCreditCardCVV(int creditCardCVV) {
        this.creditCardCVV = creditCardCVV;
    }

    public String getCreditCardName() {
        return creditCardName;
    }
    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getCreditCardAddress() {
        return creditCardAddress;
    }
    public void setCreditCardAddress(String creditCardAddress) {
        this.creditCardAddress = creditCardAddress;
    }

    public String getCreditCardCity() {
        return creditCardCity;
    }
    public void setCreditCardCity(String creditCardCity) {
        this.creditCardCity = creditCardCity;
    }

    public String getCreditCardState() {
        return creditCardState;
    }
    public void setCreditCardState(String creditCardState) {
        this.creditCardState = creditCardState;
    }

    public int getCreditCardZip() {
        return creditCardZip;
    }
    public void setCreditCardZip(int creditCardZip) {
        this.creditCardZip = creditCardZip;
    }

    public void printBilling() {
        System.out.println("Billing ID: " + billingID);
        System.out.println("Credit Card Number: " + creditCardNumber);
        System.out.println("Credit Card Expiration: " + creditCardExpiration);
        System.out.println("Credit Card CVV: " + creditCardCVV);
        System.out.println("Credit Card Name: " + creditCardName);
        System.out.println("Credit Card Address: " + creditCardAddress);
        System.out.println("Credit Card City: " + creditCardCity);
        System.out.println("Credit Card State: " + creditCardState);
        System.out.println("Credit Card Zip: " + creditCardZip);
    }

    public String toString() {
        return "Billing [billingID=" + billingID + ", creditCardNumber=" + creditCardNumber +
                ", creditCardExpiration=" + creditCardExpiration + ", creditCardCVV=" + creditCardCVV +
                ", creditCardName=" + creditCardName + ", creditCardAddress=" + creditCardAddress +
                ", creditCardCity=" + creditCardCity + ", creditCardState=" + creditCardState +
                ", creditCardZip=" + creditCardZip + "]";
    }
}

