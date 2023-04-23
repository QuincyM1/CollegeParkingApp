package com.example.pantherpark.sensorservice;

import android.util.Log;

public class SpotAvailabilityManager {

    private VirtualSensorService vss;

    public SpotAvailabilityManager() {

        vss = new VirtualSensorService();
        Log.i("VSS_SERVICE", "Virtual Sensor Service is now running.");
        Log.i("VSS_SERVICE", "Spot Availability Manager Initialization complete.");

    }



}
