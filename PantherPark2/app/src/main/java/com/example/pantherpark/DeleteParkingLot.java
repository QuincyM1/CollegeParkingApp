package com.example.pantherpark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pantherpark.data_objects.AdminUser;


public class DeleteParkingLot extends AppCompatActivity {
    private EditText etParkingLotID;

    // Use the same adminUser instance created in AddParkingLotActivity or retrieve it from a shared location
    private AdminUser adminUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_parking_lot);

        etParkingLotID = findViewById(R.id.etParkingLotID);
        Button btnDeleteParkingLot = findViewById(R.id.btnDeleteParkingLot);
        btnDeleteParkingLot.setOnClickListener(v -> {
            int parkingLotID = Integer.parseInt(etParkingLotID.getText().toString());

            // Call the deleteParkingLot method on the adminUser instance
            adminUser.deleteParkingLot(parkingLotID);
        });
    }
}
