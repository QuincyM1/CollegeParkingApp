package com.example.pantherpark.data_objects;

import java.util.*;
import java.lang.*;

public class User{
    private int userID;
    private String userName;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private String userAddress;
    private String userCity;
    private String userState;
    private int userZip;
    private String userPhone;
    private String userEmail;
    private String userRole;
    private int userStatus;
    private ArrayList<ParkingLot> favoriteLots = new ArrayList<ParkingLot>();


    public User() {
        this.userID = (int)(Math.random()*1000000);
        this.userName = "";
        this.userPassword = "";
        this.userFirstName = "";
        this.userLastName = "";
        this.userAddress = "";
        this.userCity = "";
        this.userState = "";
        this.userZip = 0;
        this.userPhone = "";
        this.userEmail = "";
        this.userRole = "";
        this.userStatus = 0;

    }

    public User(String userName, String userPassword, String userFirstName, String userLastName,
                String userAddress, String userCity, String userState, int userZip, String userPhone,
                String userEmail, String userRole, int userStatus, ArrayList<ParkingLot> favoriteLots) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAddress = userAddress;
        this.userCity = userCity;
        this.userState = userState;
        this.userZip = userZip;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.userStatus = userStatus;
        this.userID = (int)(Math.random()*1000000);
        this.favoriteLots = favoriteLots;

    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCity() {
        return userCity;
    }
    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }
    public void setUserState(String userState) {
        this.userState = userState;
    }

    public int getUserZip() {
        return userZip;
    }
    public void setUserZip(int userZip) {
        this.userZip = userZip;
    }

    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getUserStatus() {
        return userStatus;
    }
    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public ArrayList<ParkingLot> getFavoriteLots() {
        return favoriteLots;
    }
    public void setFavoriteLots(ArrayList<ParkingLot> favoriteLots) {
        this.favoriteLots = favoriteLots;
    }

    public void addFavoriteLot(ParkingLot lot) {
        this.favoriteLots.add(lot);
    }
    public void removeFavoriteLot(ParkingLot lot) {
        this.favoriteLots.remove(lot);
    }

    public void printUser() {
        System.out.println("User ID: " + this.userID);
        System.out.println("User Name: " + this.userName);
        System.out.println("User Password: " + this.userPassword);
        System.out.println("User First Name: " + this.userFirstName);
        System.out.println("User Last Name: " + this.userLastName);
        System.out.println("User Address: " + this.userAddress);
        System.out.println("User City: " + this.userCity);
        System.out.println("User State: " + this.userState);
        System.out.println("User Zip: " + this.userZip);
        System.out.println("User Phone: " + this.userPhone);
        System.out.println("User Email: " + this.userEmail);
        System.out.println("User Role: " + this.userRole);
        System.out.println("User Status: " + this.userStatus);
        System.out.println("Favorite Lots: " + this.favoriteLots);
    }

    @Override
    public String toString() {
        return "userEmail=" + userEmail + ", userID=" + userID
                + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
                + ", userPassword=" + userPassword + ", userPhone=" + userPhone + ", userRole="
                + userRole + ", userStatus=" + userStatus + ", userAddress=" + userAddress
                + ", userCity=" + userCity + ", userState=" + userState + ", userZip=" + userZip
                + ", userName=" + userName + "]" + ", favoriteLots=" + favoriteLots + "]";
    }


}