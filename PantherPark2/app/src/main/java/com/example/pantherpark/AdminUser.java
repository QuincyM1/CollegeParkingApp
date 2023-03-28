package com.example.pantherpark;

import java.util.*;
import java.io.*;
import java.lang.*;

public class AdminUser extends User {
    private int adminUserID;

    public AdminUser() {
        super();
        this.adminUserID = (int)(Math.random()*1000000);
    }

    public AdminUser(String userName, String userPassword, String userFirstName,
                     String userLastName, String userAddress, String userCity, String userState,
                     int userZip, String userPhone, String userEmail, String userRole, int userStatus) {
        super(userName, userPassword, userFirstName, userLastName, userAddress, userCity,
                userState, userZip, userPhone, userEmail, userRole, userStatus, new ArrayList<ParkingLot>());
        this.adminUserID = (int)(Math.random()*1000000);
    }

    public int getAdminUserID() {
        return adminUserID;
    }
    public void setAdminUserID(int adminUserID) {
        this.adminUserID = adminUserID;
    }

    public void printAdminUser() {
        System.out.println("Admin User ID: " + this.adminUserID);
        System.out.println("User ID: " + this.getUserID());
        System.out.println("User Name: " + this.getUserName());
        System.out.println("User Password: " + this.getUserPassword());
        System.out.println("User First Name: " + this.getUserFirstName());
        System.out.println("User Last Name: " + this.getUserLastName());
        System.out.println("User Address: " + this.getUserAddress());
        System.out.println("User City: " + this.getUserCity());
        System.out.println("User State: " + this.getUserState());
        System.out.println("User Zip: " + this.getUserZip());
        System.out.println("User Phone: " + this.getUserPhone());
        System.out.println("User Email: " + this.getUserEmail());
        System.out.println("User Role: " + this.getUserRole());
        System.out.println("User Status: " + this.getUserStatus());
    }

    public String toString() {
        return "AdminUser [adminUserID=" + adminUserID + ", userID=" + getUserID() +
                ", userName=" + getUserName() + ", userPassword=" + getUserPassword() +
                ", userFirstName=" + getUserFirstName() + ", userLastName=" +
                getUserLastName() + ", userAddress=" + getUserAddress() +
                ", userCity=" + getUserCity() + ", userState=" + getUserState() +
                ", userZip=" + getUserZip() + ", userPhone=" + getUserPhone() + ", userEmail=" +
                getUserEmail() + ", userRole=" + getUserRole() + ", userStatus=" + getUserStatus() + "]";
    }
}